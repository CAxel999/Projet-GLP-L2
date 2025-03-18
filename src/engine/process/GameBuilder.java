package engine.process;

import config.GameConfiguration;
import data.Instruction;
import engine.map.positions.Block;
import engine.map.City;
import engine.map.positions.PixelPosition;
import engine.mobile.MainCar;
import engine.mobile.NPCCar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameBuilder {

	public static City buildMap() throws IOException {
		return new City(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static MobileInterface buildInitMobile(City city) {
		MobileInterface manager = new MobileElementManager(city);
		
		intializeCar(city, manager);
		intializeNPCCar(city,manager);
		return manager;
	}

	private static void intializeCar(City city, MobileInterface manager) {
		Block block = city.getBlock(GameConfiguration.LINE_COUNT - 1, (GameConfiguration.COLUMN_COUNT - 1) / 2 -1);
		MainCar mainCar = new MainCar(block);
		manager.set(mainCar);
	}

	private static void intializeNPCCar(City city, MobileInterface manager) {
		ArrayList<NPCCar> npcCars = new ArrayList<NPCCar>();
		addNPCCar1(city, npcCars);
		addNPCCar2(city, npcCars);
		//add other npcCars

		manager.set(npcCars);
	}

	public static void addNPCCar1(City city, ArrayList<NPCCar> npcCars) {
		Block block = city.getBlock(20, 0);
		ArrayList<Instruction> instructionList = new ArrayList<Instruction>();

		PixelPosition pixelPosition1 = new PixelPosition(430,820);
		Instruction instruction1 = new Instruction(2.125,0,pixelPosition1);
		instructionList.add(instruction1);

		PixelPosition pixelPosition2 = new PixelPosition(401,820);
		Instruction instruction2 = new Instruction(2.125,Math.PI/8,pixelPosition2);
		instructionList.add(instruction2);

		PixelPosition pixelPosition3 = new PixelPosition(401,820);
		Instruction instruction3 = new Instruction(2.125,Math.PI/4,pixelPosition3);
		instructionList.add(instruction3);

		PixelPosition pixelPosition4 = new PixelPosition(460,790);
		Instruction instruction4 = new Instruction(2.125,Math.PI*6/8,pixelPosition4);
		instructionList.add(instruction4);

		NPCCar npcCar = new NPCCar(block,instructionList,instructionList.iterator(),instruction1);
		npcCars.add(npcCar);
	}

	public static void addNPCCar2(City city, ArrayList<NPCCar> npcCars) {
		Block block = city.getBlock(3, 0);
		ArrayList<Instruction> instructionHashMap = new ArrayList<Instruction>();
		PixelPosition pixelPosition1 = new PixelPosition(1800,140);
		Instruction instruction1 = new Instruction(4.5,0,pixelPosition1);
		instructionHashMap.add(instruction1);
		NPCCar npcCar = new NPCCar(block,instructionHashMap,instructionHashMap.iterator(),instruction1);
		npcCars.add(npcCar);
	}

}
