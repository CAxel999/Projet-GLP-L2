package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Car;

public class MobileElementManager implements MobileInterface {
	private Map map;

	private Car car;

	public MobileElementManager(Map map) {
		this.map = map;
	}

	@Override
	public void set(Car car) {
		this.car = car;
	}

	@Override
	public void moveMainCar() {
		Block position = car.getPosition();
		int x = (((int) (position.getLine()*10 - Math.sin(car.getDirection()) * car.getSpeed())));
		int y = ((int) (position.getColumn()*10 + Math.cos(car.getDirection()) * car.getSpeed()));
		Block newPosition = map.getBlock(x/10, y/10);
		car.setPosition(newPosition);

	}

	@Override
	public void turnLeft() {
		car.setDirection(car.getDirection() + Math.PI/4);
	}

	@Override
	public void turnRight() {
		car.setDirection(car.getDirection() - Math.PI/4);
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
	}

	@Override
	public Car getA() {
		return car;
	}

	/*private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}*/
}
