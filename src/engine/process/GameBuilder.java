package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Car;

public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static MobileInterface buildInitMobile(Map map) {
		MobileInterface manager = new MobileElementManager(map);
		
		intializeCar(map, manager);
		
		return manager;
	}

	private static void intializeCar(Map map, MobileInterface manager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 1, (GameConfiguration.COLUMN_COUNT - 1) / 2);
		Car car = new Car(block);
		manager.set(car);
	}

}
