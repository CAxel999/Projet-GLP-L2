package engine.process;

import config.CarConfiguration;
import config.GameConfiguration;
import data.Instruction;
import engine.counters.LimitReachedException;
import data.MistakeMessage;
import engine.map.positions.Block;
import engine.map.City;
import engine.map.positions.PixelPosition;
import engine.map.roads.Road;
import engine.mobile.Car;
import engine.mobile.MainCar;
import engine.map.positions.CarPosition;
import engine.mobile.NPCCar;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manages mobile elements, like player car and npc.
 *
 */
public class MobileElementManager implements MobileInterface {
	private City city;

	private MainCar mainCar;
	private ArrayList<NPCCar> npcCars = new ArrayList<NPCCar>();

	public MobileElementManager(City city) {
		this.city = city;
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
		mainCar.getPixelPosition().setX((int) x);
		mainCar.getPixelPosition().setY((int) y);
		Block newPosition = city.getBlock((int) y / GameConfiguration.BLOCK_SIZE,(int) x / GameConfiguration.BLOCK_SIZE);
		mainCar.setPosition(newPosition);

	}

	@Override
	public void moveNPCCars() {
		ArrayList<NPCCar> removeCar = new ArrayList<NPCCar>();
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
					if(speed != instruction.getSpeed()){
						car.setSpeed(instruction.getSpeed());
						car.setCurrentIterator(iterator);
						car.setDirection(instruction.getDirection());

						car.getRealPosition().setX(pixelPosition.getX());
						car.getRealPosition().setY(pixelPosition.getY());

						newPosition = city.getBlock(pixelPosition.getX() / GameConfiguration.BLOCK_SIZE,pixelPosition.getY() / GameConfiguration.BLOCK_SIZE);
						car.setPosition(newPosition);
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
		RoadVisitor roadVisitor = new RoadVisitor(mainCar,this);
		Block block = mainCar.getPosition();
		if(city.getRoads().containsKey(block)){

			MistakeMessage.setMessage("");
			Road road = city.getRoads().get(block);

			if(road.getSpeedLimit() < mainCar.getSpeed()){
				MistakeMessage.setMessage("Car exceeding speed limit");
			}

			road.accept(roadVisitor);

		} else{
			MistakeMessage.setMessage("Car out of road");
			System.err.println(mainCar.getRealPosition().getX() +","+ mainCar.getRealPosition().getY());
		}
	}
	public boolean directionVerif(double direction, MainCar car){
		if(direction == 0){
            return !(car.getDirection().getValue() > 2 * CarConfiguration.CAR_ROTATION) || !(car.getDirection().getValue() < (2 * Math.PI) - (2 * CarConfiguration.CAR_ROTATION));
		}
		else return !(direction - CarConfiguration.CAR_ROTATION > car.getDirection().getValue()) && !(direction + CarConfiguration.CAR_ROTATION < car.getDirection().getValue());
    }

	@Override
	public void turnLeft() throws LimitReachedException {
		if(mainCar.getSpeed() != 0){
			mainCar.getDirection().increment();
		}
	}

	@Override
	public void turnRight() throws LimitReachedException {
		if(mainCar.getSpeed() != 0){
			mainCar.getDirection().decrement();
		}
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
