package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Car;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
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
		if (position.getColumn() > -1 && position.getColumn() < GameConfiguration.COLUMN_COUNT && position.getLine() > -1 && position.getLine() < GameConfiguration.LINE_COUNT) {
			Block newPosition = map.getBlock(((int) (position.getLine() + Math.cos(car.getDirection()) * car.getSpeed())), ((int)(position.getColumn() + Math.sin(car.getDirection()) * car.getSpeed())));
			car.setPosition(newPosition);
		}
	}

	@Override
	public void turnLeft() {
		car.setDirection(car.getDirection() + 1);
	}

	@Override
	public void turnRight() {
		car.setDirection(car.getDirection() - 1);
	}

	public void accelerate() {
		car.setSpeed(car.getSpeed() + 2);
	}

	public void slow() {
		int speed = car.getSpeed();
		if(speed > 0) {
			car.setSpeed(car.getSpeed() - 2);
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
