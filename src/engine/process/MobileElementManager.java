package engine.process;

import config.GameConfiguration;
import engine.counters.LimitReachedException;
import data.MistakeMessage;
import engine.map.Block;
import engine.map.City;
import engine.map.Road;
import engine.mobile.Car;
import engine.mobile.CarPosition;

public class MobileElementManager implements MobileInterface {
	private City city;

	private Car car;

	public MobileElementManager(City city) {
		this.city = city;
	}

	@Override
	public void set(Car car) {
		this.car = car;
	}

	@Override
	public void moveMainCar() {
		CarPosition position = car.getRealPosition();
		int y = (((int) (position.getY() - Math.sin(car.getDirection().getValue()) * car.getSpeed())));
		int x = ((int) (position.getX() + Math.cos(car.getDirection().getValue()) * car.getSpeed()));
		car.getRealPosition().setX(x);
		car.getRealPosition().setY(y);
		Block newPosition = city.getBlock(y / GameConfiguration.BLOCK_SIZE,x / GameConfiguration.BLOCK_SIZE);
		car.setPosition(newPosition);

	}

	public void roadVerif(Block block){
		if(city.getRoads().containsKey(block)){
			MistakeMessage.setMessage("");
			Road road = city.getRoads().get(block);
			if(road.getSpeedLimit() < car.getSpeed()){
				MistakeMessage.setMessage("Car exceeding speed limit");
			}
			if(road.getDirection()-Math.PI/4 > car.getDirection().getValue() || road.getDirection()+Math.PI/4 < car.getDirection().getValue()){
				MistakeMessage.setMessage("Car direction incorrect");
			}
		} else{
			MistakeMessage.setMessage("Car out of road");
			System.err.println(car.getRealPosition().getX() +","+car.getRealPosition().getY());
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
		car.setSpeed(car.getSpeed() + 1);
	}

	public void slow() {
		int speed = car.getSpeed();
		if(speed > 0) {
			car.setSpeed(car.getSpeed() - 1);
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

	/*private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}*/
}
