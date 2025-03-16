package engine.process;

import config.GameConfiguration;
import engine.counters.LimitReachedException;
import data.MistakeMessage;
import engine.map.Block;
import engine.map.City;
import engine.map.Zone;
import engine.map.roads.Road;
import engine.mobile.Car;
import engine.mobile.CarPosition;

/**
 * Manages mobile elements, like player car and npc.
 *
 */
public class MobileElementManager implements MobileInterface {
	private City city;


	private Car car;
	private RoadVisitor roadVisitor;

	public MobileElementManager(City city) {
		this.city = city;
		this.roadVisitor = new RoadVisitor();
	}

	@Override
	public void set(Car car) {
		this.car = car;
	}

	@Override
	public void moveMainCar() {
		CarPosition position = car.getRealPosition();
		double y = ((position.getY() - Math.sin(car.getDirection().getValue()) * car.getSpeed()));
		double x = ((position.getX() + Math.cos(car.getDirection().getValue()) * car.getSpeed()));
		car.getRealPosition().setX(x);
		car.getRealPosition().setY(y);
		car.getPixelPosition().setX((int) x);
		car.getPixelPosition().setY((int) y);
		Block newPosition = city.getBlock((int) y / GameConfiguration.BLOCK_SIZE, (int) x / GameConfiguration.BLOCK_SIZE);
		car.setPosition(newPosition);

	}

	public void roadVerif(Block block) {
		if (city.getRoads().containsKey(block)) {
			MistakeMessage.setMessage("");
			Road road = city.getRoads().get(block);
			if (road.getSpeedLimit() < car.getSpeed()) {
				MistakeMessage.setMessage("Car exceeding speed limit");
			} else if (road.getDirection() - Math.PI / 4 > car.getDirection().getValue() || road.getDirection() + Math.PI / 4 < car.getDirection().getValue()) {
				MistakeMessage.setMessage("Car direction incorrect");
			} else {
				city.getRoads().get(block).accept(roadVisitor);
			}
		} else {
			MistakeMessage.setMessage("Car out of road");
			System.err.println(car.getRealPosition().getX() + "," + car.getRealPosition().getY());
		}
	}

	@Override
	public void turnLeft() throws LimitReachedException {
		car.getDirection().increment();
	}

	@Override
	public void turnRight() throws LimitReachedException {
		car.getDirection().decrement();
	}

	public void accelerate() {
		car.setSpeed(car.getSpeed() + 0.125);
	}

	public void slow() {
		double speed = car.getSpeed();
		if (speed > 0) {
			car.setSpeed(car.getSpeed() - 0.125);
		}
	}

	public void brake() {
		double speed = car.getSpeed();
		if (speed > 0.5) {
			car.setSpeed(car.getSpeed() - 0.5);
		} else if (speed > 0) {
			car.setSpeed(0);
		}
	}

	@Override
	public void nextRound() {
		moveMainCar();
		roadVerif(car.getPosition());
	}

	@Override
	public Car getA() {
		return car;
	}

	public boolean isPriorityViolation(Car car, Zone zone) {
		if (zone.contains(car) && !car.isPriority()) {
			MistakeMessage.setMessage("");
			return true;
		}
		return false;
	}

	public void onCarArrival(Car car,Zone zone) {
		if (car.hasStopped()) {
			if (isPriorityViolation(car, zone)) {
				car.applyPenalty();}
			else if (zone.contains(car)) {
				MistakeMessage.setMessage("");
			} else {
				MistakeMessage.setMessage("");
			}
		}
		else {
			MistakeMessage.setMessage("");
			car.applyPenalty();
			}
		}


	/*private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}*/
	}
