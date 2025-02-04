package engine.mobile;

import engine.map.Block;

/**
 * Copyright SEDAMOP - Software Engineering
 *
 * @author tianxiao.liu@cyu.fr
 *
 */
public class Car extends MobileElement{
	private int speed;
	private int direction;

	public Car(Block position) {
		super(position);
		this.speed = 0;
		this.direction = 90;
	}

	public int getSpeed() {
		return speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}
