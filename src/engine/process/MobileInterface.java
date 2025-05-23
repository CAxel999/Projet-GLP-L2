package engine.process;

import data.Mistake;
import engine.counters.LimitReachedException;
import engine.mobile.Car;
import engine.mobile.MainCar;
import engine.mobile.NPCCar;
import exception.CarCrashException;

import java.util.ArrayList;
import java.util.HashMap;

public interface MobileInterface {

	void set(MainCar mainCar);

	void set(ArrayList<NPCCar> npcCars);

	void mainCarRoadVerif();

	void turnLeft() throws LimitReachedException;

	void turnRight() throws LimitReachedException;

	void accelerate();

	void slow();

	void brake();

	void moveMainCar();

	void moveNPCCars();

	void nextRound() throws CarCrashException;

	MainCar getA();

	ArrayList<NPCCar> getNPCCars();

	Mistake getCurrentMistake();


}