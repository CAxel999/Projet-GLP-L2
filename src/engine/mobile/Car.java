package engine.mobile;

import config.GameConfiguration;
import engine.counters.CyclicCounter;
import engine.map.Block;

public class Car extends MobileElement{
	private int speed;
	private CyclicCounter direction;
	private CarPosition realPosition;

	public Car(Block position) {
		super(position);
		this.realPosition = new CarPosition(position.getColumn() * GameConfiguration.BLOCK_SIZE + 20,position.getLine() * GameConfiguration.BLOCK_SIZE + 20);
		this.speed = 0;
		this.direction = new CyclicCounter(Math.PI/2,Math.PI*2);
	}
	public void move(){

	}
	public int getSpeed() {
		return speed;
	}

	public CyclicCounter getDirection() {
		return direction;
	}

	public CarPosition getRealPosition() {
		return realPosition;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setRealPosition(CarPosition realPosition) {
		this.realPosition = realPosition;
	}
}
