package engine.process;

import config.CarConfiguration;
import config.GameConfiguration;
import data.Instruction;
import engine.counters.LimitReachedException;
import data.Mistake;
import engine.map.positions.Block;
import engine.map.City;
import engine.map.positions.PixelPosition;
import engine.map.roads.Road;
import engine.mobile.Car;
import engine.mobile.MainCar;
import engine.map.positions.CarPosition;
import engine.mobile.NPCCar;
import exception.CarCrashException;
import log.LoggerUtility;
import org.apache.log4j.Logger;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manages mobile elements.
 *
 * This class is used to move a {@link MainCar} and multiple {@link NPCCar}, it also verifies th {@link Road} these cars roll on.
 */
public class MobileElementManager implements MobileInterface {
	private City city;
	private ScoreManager scoreManager;
	private MainCar mainCar;
	private ArrayList<NPCCar> npcCars = new ArrayList<NPCCar>();
	private Mistake lastMistake;
	private Mistake currentMistake;
	private boolean mistakesWereNotMade;


	/**
	 * Retrieves the logger for writing logs in
	 *
	 * 1) a text file ("text" for the logger name) 2) or in a html file ("html" for the logger name);
	 */
	private static Logger logger = LoggerUtility.getLogger(MobileElementManager.class, "html");

	public MobileElementManager(City city, ScoreManager scoreManager) {
		this.city = city;
		this.scoreManager = scoreManager;
	}

	@Override
	public void set(MainCar mainCar) {
		this.mainCar = mainCar;
	}

	@Override
	public void set(ArrayList<NPCCar> npcCars) {
		this.npcCars = npcCars;
	}

	/**
	 * Uses the {@link MainCar} {@link CarPosition}, its speed and its direction in float number to calculate the position of the car, then adapt its {@link Block} position and its {@link PixelPosition}
	 */
	@Override
	public void moveMainCar() {
		CarPosition position = mainCar.getRealPosition();
		double y = ((position.getY() - Math.sin(mainCar.getDirection().getValue()) * mainCar.getSpeed()));
		double x = ((position.getX() + Math.cos(mainCar.getDirection().getValue()) * mainCar.getSpeed()));
		position.setX(x);
		position.setY(y);

		constructMainCarEdges(x,y);

		mainCar.getPixelPosition().setX((int) x);
		mainCar.getPixelPosition().setY((int) y);
		Block newPosition = city.getBlock((int) y / GameConfiguration.BLOCK_SIZE,(int) x / GameConfiguration.BLOCK_SIZE);

		Road road = city.getRoads().get(newPosition);
		if(road != null){
			road.setHasCar(true);
			city.getHasCar().add(road);
		}
		mainCar.setPosition(newPosition);

	}
	/**
	 * Uses the {@link NPCCar} {@link CarPosition}, their speed and their direction in float number to calculate the position of the car, then adapt their {@link Block} position and their {@link PixelPosition} until the current {@link Instruction} {@link PixelPosition}. When at this position the NPCCar takes the next instruction and gets its speed and direction.
	 */
	@Override
	public void moveNPCCars() {
		ArrayList<NPCCar> removeCar = new ArrayList<NPCCar>();
		Road road;
		for(NPCCar car : npcCars){

			PixelPosition pixelPosition = car.getPixelPosition();
			Instruction instruction = car.getCurrentInstruction();



			Iterator<Instruction> iterator = car.getCurrentIterator();

			double speed = car.getSpeed();
			Block newPosition;

			if(pixelPosition.getX() < instruction.getPixelPosition().getX() + speed && pixelPosition.getX() > instruction.getPixelPosition().getX() - speed && pixelPosition.getY() < instruction.getPixelPosition().getY() + speed && pixelPosition.getY() > instruction.getPixelPosition().getY() - speed){
				pixelPosition = instruction.getPixelPosition();
				if(iterator.hasNext()){
					instruction = iterator.next();
					if(speed != instruction.getSpeed()) {
						car.setSpeed(instruction.getSpeed());
					}
						car.setCurrentIterator(iterator);
						car.setCurrentInstruction(instruction);
						car.setDirection(instruction.getDirection());
						car.setPixelPosition(pixelPosition);

						CarPosition position = car.getRealPosition();
						position.setX(pixelPosition.getX());
						position.setY(pixelPosition.getY());

						double x = ((position.getX() + Math.cos(car.getDirection()) * car.getSpeed()));
						double y = ((position.getY() - Math.sin(car.getDirection()) * car.getSpeed()));

						constructNPCCarEdges(car,x,y);

						newPosition = city.getBlock( pixelPosition.getY() / GameConfiguration.BLOCK_SIZE,pixelPosition.getX() / GameConfiguration.BLOCK_SIZE);
						car.setPosition(newPosition);
						road = city.getRoads().get(newPosition);

						car.setClignoGauche(instruction.isTurningLeft());
						car.setClignoDroit(instruction.isTurningRight());

						if(road != null){
							road.setHasCar(true);
							city.getHasCar().add(road);
						}

				} else {
					removeCar.add(car);
				}

			} else {
				CarPosition position = car.getRealPosition();
				double y = ((position.getY() - Math.sin(car.getDirection()) * car.getSpeed()));
				double x = ((position.getX() + Math.cos(car.getDirection()) * car.getSpeed()));

				constructNPCCarEdges(car,x,y);

				position.setX(x);
				position.setY(y);
				pixelPosition.setX((int) x);
				pixelPosition.setY((int) y);
				newPosition = city.getBlock((int) y / GameConfiguration.BLOCK_SIZE,(int) x / GameConfiguration.BLOCK_SIZE);
				car.setPosition(newPosition);
				road = city.getRoads().get(newPosition);
				if(road != null){
					road.setHasCar(true);
					city.getHasCar().add(road);
				}

				if(car.getSpeed() < instruction.getSpeed()){
					car.setSpeed(car.getSpeed() + CarConfiguration.CAR_ACCERLERATION);
				}
			}

		}


		for(NPCCar car : removeCar){
			npcCars.remove(car);
		}
	}

	/**
	 * Verifies the {@link Road} which the {@link MainCar} is on with its {@link Block} position.
	 * It creates a log each new road encountered, calls for {@link RoadVisitor} apply the correct execution depending on the road and for {@link #setCurrentMistake(int)} to set a mistake.
	 */
	@Override
	public void mainCarRoadVerif(){
		RoadVisitor roadVisitor = new RoadVisitor(mainCar,this);
		Block block = mainCar.getPosition();
		mistakesWereNotMade = true;
		currentMistake = null;
		if(city.getRoads().containsKey(block)){


			Road road = city.getRoads().get(block);

			if(mainCar.getCurrentRoad() == null || !mainCar.getCurrentRoad().equals(road)){
				mainCar.setCurrentRoad(road);
				logger.info("La voiture de l'utilisateur est rentrée dans " + road.toString());
			}

			if(!road.getLimits().isEmpty()){
				for(Line2D limit : road.getLimits()){
					if(limit.intersectsLine(mainCar.getLeftSide()) || limit.intersectsLine(mainCar.getRightSide()) || limit.intersectsLine(mainCar.getFrontSide()) || limit.intersectsLine(mainCar.getBackSide())){
						setCurrentMistake(1);
					}
				}
			}
			if(road.getSpeedLimit() < mainCar.getSpeed()){
				setCurrentMistake(3);
			}
			road.accept(roadVisitor);

		} else{
			setCurrentMistake(1);
		}
        if(currentMistake != null) {
            if(lastMistake == null || (currentMistake.getId() != lastMistake.getId())) {
                currentMistake.incrementNumber();
            }
        }
        if(mistakesWereNotMade){
			lastMistake = null;
		} else {
			lastMistake = currentMistake;
		}
	}

	/**
	 * Increment a {@link Mistake} number in the case of the car making a new mistake or another mistake with a more important id in the same round and saves it for the next round
	 * @param id id of the mistake currently made
	 */
	public void setCurrentMistake(int id){
		mistakesWereNotMade = false;
		if(currentMistake == null || (currentMistake.getId() >= id)){
			currentMistake = scoreManager.getMistakes().get(id);
		}
	}

	/**
	 * Verifies the {@link Road} which the {@link NPCCar} is on with its {@link Block} position.
	 * It creates a log each new road encountered, calls for {@link NPCRoadVisitor}
	 */
	public void npcCarsRoadVerif(){
		NPCRoadVisitor visitor = new NPCRoadVisitor();
		for(NPCCar car : npcCars){
			visitor.setCar(car);
			Road road = city.getRoads().get(car.getPosition());
			if(car.getCurrentRoad() == null || !car.getCurrentRoad().equals(road)){
				car.setCurrentRoad(road);
				logger.debug("Une voiture npc est rentrée dans " + road.toString());
			}
		}
	}

	/**
	 * Verifies the intersection between the edges of the {@link MainCar} and those of each {@link NPCCar} then throw a {@link CarCrashException}
	 * @throws CarCrashException Exception thrown in the case of a {@link MainCar} crash
	 */
	public void mainCarCollision() throws CarCrashException {
		for(Car car : npcCars){
			if(car.getFrontSide().intersectsLine(mainCar.getLeftSide()) || car.getBackSide().intersectsLine(mainCar.getLeftSide()) || car.getLeftSide().intersectsLine(mainCar.getLeftSide()) || car.getRightSide().intersectsLine(mainCar.getLeftSide()) || car.getFrontSide().intersectsLine(mainCar.getRightSide()) || car.getBackSide().intersectsLine(mainCar.getRightSide()) || car.getLeftSide().intersectsLine(mainCar.getRightSide()) || car.getRightSide().intersectsLine(mainCar.getRightSide())){
				throw new CarCrashException("Vous avez eu un accident");
			}
		}

	}

	/**
	 * Constructs the car edges with its corner coordinates.
	 * @param car The {@link Car} which edges will be constructed
	 * @param frontLeftCornerX The x coordinate of the front left corner of the car
	 * @param frontLeftCornerY The y coordinate of the front left corner of the car
	 * @param frontRightCornerX The x coordinate of the front right corner of the car
	 * @param frontRightCornerY The y coordinate of the front right corner of the car
	 * @param backLeftCornerX The x coordinate of the back left corner of the car
	 * @param backLeftCornerY The y coordinate of the back left corner of the car
	 * @param bachRightCornerX The x coordinate of the back right corner of the car
	 * @param backRightCornerY The y coordinate of the back right corner of the car
	 */
	public void constructCarEdges(Car car, double frontLeftCornerX, double frontLeftCornerY, double frontRightCornerX, double frontRightCornerY, double backLeftCornerX, double backLeftCornerY, double bachRightCornerX, double backRightCornerY){
		car.getFrontSide().setLine(frontLeftCornerX,frontLeftCornerY,frontRightCornerX,frontRightCornerY);
		car.getBackSide().setLine(backLeftCornerX,backLeftCornerY,bachRightCornerX,backRightCornerY);
		car.getLeftSide().setLine(frontLeftCornerX,frontLeftCornerY,backLeftCornerX,backLeftCornerY);
		car.getRightSide().setLine(frontRightCornerX,frontRightCornerY,bachRightCornerX,backRightCornerY);
	}

	/**
	 * Constructs the {@link MainCar} corner coordinates then calls for {@link #constructCarEdges(Car, double, double, double, double, double, double, double, double)}.
	 * @param x A double coordinate for the center of the car
	 * @param y A double coordinate for the center of the car
	 */
	public void constructMainCarEdges(double x, double y){
		double frontLeftCornerX = (x + Math.cos(mainCar.getDirection().getValue() + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontLeftCornerY = (y - Math.sin(mainCar.getDirection().getValue() + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontRightCornerX = (x + Math.cos(mainCar.getDirection().getValue() - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontRightCornerY = (y - Math.sin(mainCar.getDirection().getValue() - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backLeftCornerX = (x + Math.cos(mainCar.getDirection().getValue() + Math.PI - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backLeftCornerY = (y - Math.sin(mainCar.getDirection().getValue() + Math.PI - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double bachRightCornerX = (x + Math.cos(mainCar.getDirection().getValue() + Math.PI + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backRightCornerY = (y - Math.sin(mainCar.getDirection().getValue() + Math.PI + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		constructCarEdges(mainCar, frontLeftCornerX, frontLeftCornerY, frontRightCornerX, frontRightCornerY, backLeftCornerX, backLeftCornerY, bachRightCornerX, backRightCornerY);
	}

	/**
	 * Constructs an {@link NPCCar} corner coordinates then calls for {@link #constructCarEdges(Car, double, double, double, double, double, double, double, double)}.
	 * @param car An {@link NPCCar}
	 * @param x A double coordinate for the center of the car
	 * @param y A double coordinate for the center of the car
	 */
	public void constructNPCCarEdges(NPCCar car,double x, double y){
		double frontLeftCornerX = (x + Math.cos(car.getDirection() + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontLeftCornerY = (y - Math.sin(car.getDirection() + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontRightCornerX = (x + Math.cos(car.getDirection() - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontRightCornerY = (y - Math.sin(car.getDirection() - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backLeftCornerX = (x + Math.cos(car.getDirection() + Math.PI - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backLeftCornerY = (y - Math.sin(car.getDirection() + Math.PI - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double bachRightCornerX = (x + Math.cos(car.getDirection() + Math.PI + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backRightCornerY = (y - Math.sin(car.getDirection() + Math.PI + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		constructCarEdges(car, frontLeftCornerX, frontLeftCornerY, frontRightCornerX, frontRightCornerY, backLeftCornerX, backLeftCornerY, bachRightCornerX, backRightCornerY);
	}

	/**
	 * Put the boolean hasCar from a {@link Road} to false at the end of a round then clear the ArrayList of Road which had cars
	 */
	public void clearHasCar(){
		ArrayList<Road> roads = city.getHasCar();
		for(Road road : roads){
			road.setHasCar(false);
		}
		city.getHasCar().clear();
	}

	/**
	 * Test the correspondance of the direction of a {@link MainCar} with the direction of a {@link Road}
	 * @param direction The direction of a {@link Road}
	 * @param car The {@link MainCar} which direction will be tested
	 * @return A boolean indicating whether the car is in the correct direction
	 */
	public boolean directionVerif(double direction, MainCar car){
		if(direction == 0){
            return car.getDirection().getValue() > 5 * CarConfiguration.CAR_ROTATION && car.getDirection().getValue() < (2 * Math.PI) - (4 * CarConfiguration.CAR_ROTATION);
		}
		else return direction - 5 * CarConfiguration.CAR_ROTATION > car.getDirection().getValue() || direction + 5 * CarConfiguration.CAR_ROTATION < car.getDirection().getValue();
    }

	/**
	 * Increment the value of the {@link engine.counters.CyclicCounter} used for the direction of the {@link MainCar}
	 * @throws LimitReachedException When the {@link engine.counters.CyclicCounter} reaches its limits, here 0 and pi/2
	 */
	@Override
	public void turnLeft() throws LimitReachedException {
		mainCar.getDirection().increment();
	}

	/**
	 * Increment the value of the {@link engine.counters.CyclicCounter} used for the direction of the {@link MainCar}
	 * @throws LimitReachedException When the {@link engine.counters.CyclicCounter} reaches its limits, here 0 and pi/2
	 */
	@Override
	public void turnRight() throws LimitReachedException {
		mainCar.getDirection().decrement();
	}

	/**
	 * Increments the speed of the {@link MainCar} with the CAR_ACCERLERATION
	 */
	public void accelerate() {
		mainCar.setSpeed(mainCar.getSpeed() + CarConfiguration.CAR_ACCERLERATION);
	}

	/**
	 * Decrements the speed of the {@link MainCar} with the CAR_ACCERLERATION
	 */
	public void slow() {
		double speed = mainCar.getSpeed();
		if(speed > 0) {
			mainCar.setSpeed(mainCar.getSpeed() - CarConfiguration.CAR_ACCERLERATION);
		}
	}

	/**
	 * Decrements the speed of the {@link MainCar} with the CAR_ACCERLERATION times 4
	 */
	public void brake() {
		double speed = mainCar.getSpeed();
		mainCar.setBraking(true);
		if(speed > 0.5) {
			mainCar.setSpeed(mainCar.getSpeed() - CarConfiguration.CAR_ACCERLERATION*4);
		} else if (speed > 0) {
			mainCar.setSpeed(0);
		}
	}

	/**
	 * Calls the method for a round
	 * @throws CarCrashException Exception thrown in the case of a {@link MainCar} crash
	 */
	@Override
	public void nextRound() throws CarCrashException {
		moveMainCar();
		moveNPCCars();
		mainCarCollision();
		mainCarRoadVerif();
		npcCarsRoadVerif();
		clearHasCar();
	}

	@Override
	public MainCar getA() {
		return mainCar;
	}

	@Override
	public ArrayList<NPCCar> getNPCCars() {
		return npcCars;
	}

	public Mistake getCurrentMistake() {
		return currentMistake;
	}
}
