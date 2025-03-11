package engine.mobile;

import config.GameConfiguration;
import engine.counters.CyclicCounter;
import engine.map.Block;

public class Car extends MobileElement{
	private double speed;
	private CyclicCounter direction;
	private CarPosition realPosition;
	private CarPixelPosition pixelPosition;
	private boolean priority;

	public Car(Block position) {
		super(position);
		this.pixelPosition = new CarPixelPosition(position.getColumn() * GameConfiguration.BLOCK_SIZE + 20,position.getLine() * GameConfiguration.BLOCK_SIZE + 20);
		this.realPosition = new CarPosition(pixelPosition.getX(),pixelPosition.getY());
		this.speed = 0;
		this.direction = new CyclicCounter(Math.PI/2,Math.PI*2);
		this.priority = false;
	}
	public void move(){

	}
	public double getSpeed() {
		return speed;
	}

	public CyclicCounter getDirection() {
		return direction;
	}

	public CarPosition getRealPosition() {
		return realPosition;
	}

	public CarPixelPosition getPixelPosition() {
		return pixelPosition;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setRealPosition(CarPosition realPosition) {
		this.realPosition = realPosition;
	}

	public void setPixelPosition(CarPixelPosition pixelPosition) {
		this.pixelPosition = pixelPosition;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}
}
