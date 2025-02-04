package engine.process;

import engine.mobile.Car;

public interface MobileInterface {

	void set(Car car);

	void turnLeft();

	void turnRight();

	void accelerate();

	void slow();

	void moveMainCar();

	void nextRound();

	Car getA();


}