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

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manages mobile elements, like player car and npc.
 *
 */
public class MobileElementManager implements MobileInterface {
	private City city;
	private ScoreManager scoreManager;
	private MainCar mainCar;
	private ArrayList<NPCCar> npcCars = new ArrayList<NPCCar>();

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

	@Override
	public void moveMainCar() {
		CarPosition position = mainCar.getRealPosition();
		double y = ((position.getY() - Math.sin(mainCar.getDirection().getValue()) * mainCar.getSpeed()));
		double x = ((position.getX() + Math.cos(mainCar.getDirection().getValue()) * mainCar.getSpeed()));
		position.setX(x);
		position.setY(y);

		double frontLeftCornerX = (x + Math.cos(mainCar.getDirection().getValue() + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontLeftCornerY = (y - Math.sin(mainCar.getDirection().getValue() + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontRightCornerX = (x + Math.cos(mainCar.getDirection().getValue() - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontRightCornerY = (y - Math.sin(mainCar.getDirection().getValue() - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backLeftCornerX = (x + Math.cos(mainCar.getDirection().getValue() + Math.PI - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backLeftCornerY = (y - Math.sin(mainCar.getDirection().getValue() + Math.PI - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double bachRightCornerX = (x + Math.cos(mainCar.getDirection().getValue() + Math.PI + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backRightCornerY = (y - Math.sin(mainCar.getDirection().getValue() + Math.PI + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		constructCarEdges(mainCar, frontLeftCornerX, frontLeftCornerY, frontRightCornerX, frontRightCornerY, backLeftCornerX, backLeftCornerY, bachRightCornerX, backRightCornerY);

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

	@Override
	public void moveNPCCars() {
		ArrayList<NPCCar> removeCar = new ArrayList<NPCCar>();
		Road road;
		for(NPCCar car : npcCars){

			PixelPosition pixelPosition = car.getPixelPosition();
			System.err.println(pixelPosition.getX() +" "+ pixelPosition.getY());
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
						car.getRealPosition().setX(pixelPosition.getX());
						car.getRealPosition().setY(pixelPosition.getY());

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

	@Override
	public void mainCarRoadroadVerif(MainCar mainCar){
		RoadVisitor roadVisitor = new RoadVisitor(mainCar,this,scoreManager);
		Block block = mainCar.getPosition();
		mainCar.setMistakesWereNotMade(true);
		if(city.getRoads().containsKey(block)){


			Road road = city.getRoads().get(block);

			if(!road.getLimits().isEmpty()){
				for(Line2D limit : road.getLimits()){
					if(limit.intersectsLine(mainCar.getLeftSide()) || limit.intersectsLine(mainCar.getRightSide()) || limit.intersectsLine(mainCar.getFrontSide()) || limit.intersectsLine(mainCar.getBackSide())){
						mainCar.setMistakesWereNotMade(false);
                        if(mainCar.getCurrentMistake() != null) {
                            if(!(mainCar.getCurrentMistake().getId() == 1)){
                                Mistake mistake = scoreManager.getMistakes().get(1);
                                mistake.incrementNumber();
                                mainCar.setCurrentMistake(mistake);
                            }
                        } else{
							Mistake mistake = scoreManager.getMistakes().get(1);
							mistake.incrementNumber();
							mainCar.setCurrentMistake(mistake);
						}

                        //Car out road
					}
				}
			}
			if(road.getSpeedLimit() < mainCar.getSpeed()){
				mainCar.setMistakesWereNotMade(false);
				if (mainCar.getCurrentMistake() != null) {
					if (mainCar.getCurrentMistake().getId() >= 3) {
						Mistake mistake = scoreManager.getMistakes().get(3);
						mistake.incrementNumber();
						mainCar.setCurrentMistake(mistake);
					}
				} else {
					Mistake mistake = scoreManager.getMistakes().get(3);
					mistake.incrementNumber();
					mainCar.setCurrentMistake(mistake);
				}
			}
			road.accept(roadVisitor);

		} else{
			mainCar.setMistakesWereNotMade(false);
			if(mainCar.getCurrentMistake() != null) {
				if(!(mainCar.getCurrentMistake().getId() == 1)){
					Mistake mistake = scoreManager.getMistakes().get(1);
					mistake.incrementNumber();
					mainCar.setCurrentMistake(mistake);
				}
			} else{
				Mistake mistake = scoreManager.getMistakes().get(1);
				mistake.incrementNumber();
				mainCar.setCurrentMistake(mistake);
			}
		}
		if(mainCar.isMistakesWereNotMade()){
			mainCar.resetCurrentMistake();
		}
	}

	public void constructCarEdges(Car car, double frontLeftCornerX, double frontLeftCornerY, double frontRightCornerX, double frontRightCornerY, double backLeftCornerX, double backLeftCornerY, double bachRightCornerX, double backRightCornerY){
		car.getFrontSide().setLine(frontLeftCornerX,frontLeftCornerY,frontRightCornerX,frontRightCornerY);
		car.getBackSide().setLine(backLeftCornerX,backLeftCornerY,bachRightCornerX,backRightCornerY);
		car.getLeftSide().setLine(frontLeftCornerX,frontLeftCornerY,backLeftCornerX,backLeftCornerY);
		car.getRightSide().setLine(frontRightCornerX,frontRightCornerY,bachRightCornerX,backRightCornerY);
	}

	public void clearHasCar(){
		ArrayList<Road> roads = city.getHasCar();
		for(Road road : roads){
			road.setHasCar(false);
		}
		city.getHasCar().clear();
	}

	public boolean directionVerif(double direction, MainCar car){
		if(direction == 0){
            return car.getDirection().getValue() > 5 * CarConfiguration.CAR_ROTATION && car.getDirection().getValue() < (2 * Math.PI) - (4 * CarConfiguration.CAR_ROTATION);
		}
		else return direction - 5 * CarConfiguration.CAR_ROTATION > car.getDirection().getValue() || direction + 5 * CarConfiguration.CAR_ROTATION < car.getDirection().getValue();
    }

	@Override
	public void turnLeft() throws LimitReachedException {
		mainCar.getDirection().increment();
	}

	@Override
	public void turnRight() throws LimitReachedException {
		mainCar.getDirection().decrement();
	}

	public void accelerate() {
		mainCar.setSpeed(mainCar.getSpeed() + 0.125);
	}

	public void slow() {
		double speed = mainCar.getSpeed();
		if(speed > 0) {
			mainCar.setSpeed(mainCar.getSpeed() - 0.125);
		}
	}

	public void brake() {
		double speed = mainCar.getSpeed();
		mainCar.setBraking(true);
		if(speed > 0.5) {
			mainCar.setSpeed(mainCar.getSpeed() - 0.5);
		} else if (speed > 0) {
			mainCar.setSpeed(0);
		}
	}

	@Override
	public void nextRound() {
		moveMainCar();
		moveNPCCars();
		mainCarRoadroadVerif(mainCar);
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
/*private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}*/
}
