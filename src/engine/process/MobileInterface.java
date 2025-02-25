package engine.process;

import engine.counters.LimitReachedException;
import engine.mobile.Car;

public interface MobileInterface {

	void set(Car car);

	void turnLeft() throws LimitReachedException;

	void turnRight() throws LimitReachedException;

	void accelerate();

	void slow();

	void moveMainCar();

	void nextRound();

	Car getA();


}