package engine.mobile;

import config.CarConfiguration;
import config.GameConfiguration;
import engine.counters.CyclicCounter;
import engine.map.Block;

import java.awt.geom.Line2D;

public class Car extends MobileElement{
	private double speed;
	private CyclicCounter direction;
	private CarPosition realPosition;
	private CarPixelPosition pixelPosition;

	private boolean priority;
	private boolean braking;

	private Line2D topSide;
	private Line2D  bottomSide;
	private Line2D leftSide;
	private Line2D rightSide;

	private boolean angleMortGauche;
	private boolean angleMortDroit;

	private boolean clignoGauche;
	private boolean clignoDroit;
	
	public Car(Block position) {
		super(position);
		this.pixelPosition = new CarPixelPosition(position.getColumn() * GameConfiguration.BLOCK_SIZE + 20,position.getLine() * GameConfiguration.BLOCK_SIZE + 20);
		this.realPosition = new CarPosition(pixelPosition.getX(),pixelPosition.getY());
		this.speed = 0;
		this.direction = new CyclicCounter(Math.PI/2,Math.PI*2);
		/*
		this.topSide = new Line2D.Double(pixelPosition.getX(), pixelPosition.getY(), pixelPosition.getX() + CarConfiguration.CAR_WIDTH, pixelPosition.getY());
		this.bottomSide = new Line2D.Double(pixelPosition.getX(), pixelPosition.getY() + CarConfiguration.CAR_LENGTH, pixelPosition.getX() + CarConfiguration.CAR_WIDTH, pixelPosition.getY() + CarConfiguration.CAR_LENGTH);
		this.leftSide = new Line2D.Double(pixelPosition.getX(), pixelPosition.getY(), pixelPosition.getX(), pixelPosition.getY() + CarConfiguration.CAR_LENGTH);
		this.rightSide = new Line2D.Double(pixelPosition.getX() + CarConfiguration.CAR_WIDTH, pixelPosition.getY(), pixelPosition.getX() + CarConfiguration.CAR_WIDTH, pixelPosition.getY() + CarConfiguration.CAR_LENGTH);
		*/
		this.priority = false;
		this.braking = false;

		this.angleMortGauche = false;
		this.angleMortDroit = false;

		this.clignoGauche =  false;
		this.clignoDroit = false;
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
	
	public boolean getBraking() {
		return braking;
	}
	
	public void setBraking(Boolean braking) {
		this.braking = braking;
	}

	public boolean isAngleMortGauche() {
		return angleMortGauche;
	}

	public void setAngleMortGauche(boolean angleMortGauche) {
		this.angleMortGauche = angleMortGauche;
	}

	public boolean isAngleMortDroit() {
		return angleMortDroit;
	}

	public void setAngleMortDroit(boolean angleMortDroit) {
		this.angleMortDroit = angleMortDroit;
	}

	public Line2D getTopSide() {
		return topSide;
	}

	public Line2D getBottomSide() {
		return bottomSide;
	}

	public Line2D getLeftSide() {
		return leftSide;
	}

	public Line2D getRightSide() {
		return rightSide;
	}

	public boolean isClignoDroit() {
		return clignoDroit;
	}

	public void setClignoDroit(boolean clignoDroit) {
		this.clignoDroit = clignoDroit;
	}

	public boolean isClignoGauche() {
		return clignoGauche;
	}

	public void setClignoGauche(boolean clignoGauche) {
		this.clignoGauche = clignoGauche;
	}
}
