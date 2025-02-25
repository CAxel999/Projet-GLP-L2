package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.City;
import engine.mobile.Car;

public class GameBuilder {

	public static City buildMap() {
		return new City(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static MobileInterface buildInitMobile(City city) {
		MobileInterface manager = new MobileElementManager(city);
		
		intializeCar(city, manager);
		
		return manager;
	}

	private static void intializeCar(City city, MobileInterface manager) {
		Block block = city.getBlock(GameConfiguration.LINE_COUNT - 1, (GameConfiguration.COLUMN_COUNT - 1) / 2);
		Car car = new Car(block);
		manager.set(car);
	}

}
