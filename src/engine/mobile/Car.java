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
	private double direction;

	public Car(Block position) {
		super(position);
		this.speed = 0;
		this.direction = Math.PI/2;
	}

	public int getSpeed() {
		return speed;
	}

	public double getDirection() {
		return direction;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}
}
