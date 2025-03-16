package engine.process;

import java.awt.geom.Line2D;

import config.CarConfiguration;
import config.GameConfiguration;
import engine.counters.LimitReachedException;
import data.MistakeMessage;
import engine.map.Block;
import engine.map.City;
import engine.map.roads.Road;
import engine.map.roads.RoadBoundary;
import engine.mobile.Car;
import engine.mobile.CarPixelPosition;
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

		Block newPosition = city.getBlock((int) y / GameConfiguration.BLOCK_SIZE,(int) x / GameConfiguration.BLOCK_SIZE);
		car.setPosition(newPosition);
		//System.out.println(car.getPixelPosition().getX());
	}

	public void roadVerif(Block block){
		if(city.getRoads().containsKey(block)){
			MistakeMessage.setMessage("");
			Road road = city.getRoads().get(block);
			if(road.getSpeedLimit() < car.getSpeed()){
				MistakeMessage.setMessage("Car exceeding speed limit");
			} else if(road.getDirection()-Math.PI/4 > car.getDirection().getValue() || road.getDirection()+Math.PI/4 < car.getDirection().getValue()){
				MistakeMessage.setMessage("Car direction incorrect");
			} else {
				city.getRoads().get(block).accept(roadVisitor);
			}
		} else{
			MistakeMessage.setMessage("Car out of road");
			//System.err.println(car.getRealPosition().getX() +","+car.getRealPosition().getY());
		}
	}
	
	@Override
	public void checkCollision( City city) {
		//CarPixelPosition carPixelPosition = car.getPixelPosition();
		CarPosition carPosition = car.getRealPosition();


		/*
		Line2D staticLine = new Line2D.Double(600, 600, 40, 600);
		if(isColliding(staticLine)){
			//carPixelPosition.setY(carPixelPosition.getY() + 20);
			carPosition.setY(carPosition.getY() + 20);
			System.out.print("COLLISION");
		}
		 */
		if(isColliding(RoadBoundary.highwayLimit1) || isColliding(RoadBoundary.highwayLimit2) || isColliding(RoadBoundary.highwayLimit3) || isColliding(RoadBoundary.highwayLimit4)) {
			//carPixelPosition.setY(carPixelPosition.getY() + 5);
			carPosition.setY(carPosition.getY() + 10);
			System.out.print("COLLISION");
		}

	}

	public boolean isColliding(Line2D line){
		/*
		CarPixelPosition pixelCarPosition = car.getPixelPosition();

		Line2D top = new Line2D.Double(pixelCarPosition.getX(), pixelCarPosition.getY(), pixelCarPosition.getX() + CarConfiguration.CAR_WIDTH, pixelCarPosition.getY());
		Line2D  bottom= new Line2D.Double(pixelCarPosition.getX(), pixelCarPosition.getY() + CarConfiguration.CAR_LENGTH, pixelCarPosition.getX() + CarConfiguration.CAR_WIDTH, pixelCarPosition.getY() + CarConfiguration.CAR_LENGTH);
		Line2D left = new Line2D.Double(pixelCarPosition.getX(), pixelCarPosition.getY(), pixelCarPosition.getX(), pixelCarPosition.getY() + CarConfiguration.CAR_LENGTH);
		Line2D right = new Line2D.Double(pixelCarPosition.getX() + CarConfiguration.CAR_WIDTH, pixelCarPosition.getY(), pixelCarPosition.getX() + CarConfiguration.CAR_WIDTH, pixelCarPosition.getY() + CarConfiguration.CAR_LENGTH);
		*/

		/*
		Line2D top = car.getTopSide();
		Line2D bottom = car.getBottomSide();
		Line2D left = car.getLeftSide();
		Line2D right = car.getRightSide();
		 */

		CarPosition carPosition = car.getRealPosition();
		//CarPixelPosition carPosition = car.getPixelPosition();


		Line2D top = new Line2D.Double(carPosition.getX() + 20, carPosition.getY() - 20, carPosition.getX() + 20, carPosition.getY() + 20);
		Line2D  bottom= new Line2D.Double(carPosition.getX(), carPosition.getY() + CarConfiguration.CAR_LENGTH, carPosition.getX() + CarConfiguration.CAR_WIDTH, carPosition.getY() + CarConfiguration.CAR_LENGTH);
		Line2D left = new Line2D.Double(carPosition.getX(), carPosition.getY(), carPosition.getX(), carPosition.getY() + CarConfiguration.CAR_LENGTH);
		Line2D right = new Line2D.Double(carPosition.getX() + CarConfiguration.CAR_WIDTH, carPosition.getY(), carPosition.getX() + CarConfiguration.CAR_WIDTH, carPosition.getY() + CarConfiguration.CAR_LENGTH);

		return line.intersectsLine(top) || line.intersectsLine(bottom) ||
				line.intersectsLine(left) || line.intersectsLine(right);
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
		if(speed > 0) {
			car.setSpeed(car.getSpeed() - 0.125);
		}
	}

	public void brake() {
		double speed = car.getSpeed();
		if(speed > 0.5) {
			car.setSpeed(car.getSpeed() - 0.5);
		} else if (speed > 0) {
			car.setSpeed(0);
		}
		car.setBraking(true);
	}

	@Override
	public void nextRound() {
		moveMainCar();
		roadVerif(car.getPosition());
		checkCollision(city);
		//System.out.println("GameRunning");

	}

	@Override
	public Car getA() {
		return car;
	}

	/*private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}*/

}
