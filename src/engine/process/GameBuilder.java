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
import java.util.Iterator;

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

		PixelPosition pixelPosition2 = new PixelPosition(445,815);
		Instruction instruction2 = new Instruction(1.9,Math.PI/8,pixelPosition2);
		instructionList.add(instruction2);

		PixelPosition pixelPosition3 = new PixelPosition(455,805);
		Instruction instruction3 = new Instruction(1.75,Math.PI/4,pixelPosition3);
		instructionList.add(instruction3);

		PixelPosition pixelPosition4 = new PixelPosition(460,790);
		Instruction instruction4 = new Instruction(1.9,Math.PI*3/8,pixelPosition4);
		instructionList.add(instruction4);

		PixelPosition pixelPosition5 = new PixelPosition(460,635);
		Instruction instruction5 = new Instruction(2.125,Math.PI/2,pixelPosition5);
		instructionList.add(instruction5);

		PixelPosition pixelPosition6 = new PixelPosition(465,620);
		Instruction instruction6 = new Instruction(1.9,Math.PI*3/8,pixelPosition6);
		instructionList.add(instruction6);

		PixelPosition pixelPosition7 = new PixelPosition(475,610);
		Instruction instruction7 = new Instruction(1.75,Math.PI/4,pixelPosition7);
		instructionList.add(instruction7);

		PixelPosition pixelPosition8 = new PixelPosition(500,600);
		Instruction instruction8 = new Instruction(1.75,Math.PI/8,pixelPosition8);
		instructionList.add(instruction8);

		PixelPosition pixelPosition9 = new PixelPosition(525,575);
		Instruction instruction9 = new Instruction(1.75,Math.PI/4,pixelPosition9);
		instructionList.add(instruction9);

		PixelPosition pixelPosition10 = new PixelPosition(530,560);
		Instruction instruction10 = new Instruction(1.75,Math.PI*3/8,pixelPosition10);
		instructionList.add(instruction10);

		PixelPosition pixelPosition11 = new PixelPosition(530,480);
		Instruction instruction11 = new Instruction(1.75,Math.PI/2,pixelPosition11);
		instructionList.add(instruction11);

		PixelPosition pixelPosition12 = new PixelPosition(525,470);
		Instruction instruction12 = new Instruction(1.75,Math.PI*5/8,pixelPosition12);
		instructionList.add(instruction12);

		PixelPosition pixelPosition13 = new PixelPosition(500,445);
		Instruction instruction13 = new Instruction(1.75,Math.PI*3/4,pixelPosition13);
		instructionList.add(instruction13);

		PixelPosition pixelPosition14 = new PixelPosition(480,435);
		Instruction instruction14 = new Instruction(1.75,Math.PI*7/8,pixelPosition14);
		instructionList.add(instruction14);

		PixelPosition pixelPosition15 = new PixelPosition(400,435);
		Instruction instruction15 = new Instruction(1.75,Math.PI,pixelPosition15);
		instructionList.add(instruction15);

		PixelPosition pixelPosition16 = new PixelPosition(390,440);
		Instruction instruction16 = new Instruction(1.75,Math.PI*9/8,pixelPosition16);
		instructionList.add(instruction16);

		PixelPosition pixelPosition17 = new PixelPosition(350,480);
		Instruction instruction17 = new Instruction(1.75,Math.PI*5/4,pixelPosition17);
		instructionList.add(instruction17);

		PixelPosition pixelPosition18 = new PixelPosition(345,490);
		Instruction instruction18 = new Instruction(1.75,Math.PI*11/8,pixelPosition18);
		instructionList.add(instruction18);

		PixelPosition pixelPosition19 = new PixelPosition(340,495);
		Instruction instruction19 = new Instruction(1.75,Math.PI*5/4,pixelPosition19);
		instructionList.add(instruction19);

		PixelPosition pixelPosition20 = new PixelPosition(330,500);
		Instruction instruction20 = new Instruction(1.9,Math.PI*9/8,pixelPosition20);
		instructionList.add(instruction20);

		PixelPosition pixelPosition21 = new PixelPosition(90,500);
		Instruction instruction21 = new Instruction(2.125,Math.PI,pixelPosition21);
		instructionList.add(instruction21);

		PixelPosition pixelPosition22 = new PixelPosition(75,505);
		Instruction instruction22 = new Instruction(1.9,Math.PI*9/8,pixelPosition22);
		instructionList.add(instruction22);

		PixelPosition pixelPosition23 = new PixelPosition(65,515);
		Instruction instruction23 = new Instruction(1.75,Math.PI*5/4,pixelPosition23);
		instructionList.add(instruction23);

		PixelPosition pixelPosition24 = new PixelPosition(60,530);
		Instruction instruction24 = new Instruction(1.9,Math.PI*11/8,pixelPosition24);
		instructionList.add(instruction24);

		PixelPosition pixelPosition25 = new PixelPosition(60,750);
		Instruction instruction25 = new Instruction(2.125,Math.PI*3/2,pixelPosition25);
		instructionList.add(instruction25);

		PixelPosition pixelPosition26 = new PixelPosition(55,765);
		Instruction instruction26 = new Instruction(1.9,Math.PI*11/8,pixelPosition26);
		instructionList.add(instruction26);

		PixelPosition pixelPosition27 = new PixelPosition(45,775);
		Instruction instruction27 = new Instruction(1.75,Math.PI*5/4,pixelPosition27);
		instructionList.add(instruction27);

		PixelPosition pixelPosition28 = new PixelPosition(30,780);
		Instruction instruction28 = new Instruction(1.9,Math.PI*9/8,pixelPosition28);
		instructionList.add(instruction28);

		PixelPosition pixelPosition29 = new PixelPosition(0,780);
		Instruction instruction29 = new Instruction(2.125,Math.PI,pixelPosition29);
		instructionList.add(instruction29);

		Iterator<Instruction> iterator = instructionList.iterator();
		iterator.next();
		NPCCar npcCar = new NPCCar(block,instructionList,iterator,instruction1);
		npcCars.add(npcCar);
	}

	public static void addNPCCar2(City city, ArrayList<NPCCar> npcCars) {
		Block block = city.getBlock(3, 0);
		ArrayList<Instruction> instructionList = new ArrayList<Instruction>();

		PixelPosition pixelPosition1 = new PixelPosition(1800,140);
		Instruction instruction1 = new Instruction(4.5,0,pixelPosition1);
		instructionList.add(instruction1);

		Iterator<Instruction> iterator = instructionList.iterator();
		iterator.next();
		NPCCar npcCar = new NPCCar(block,instructionList,iterator,instruction1);
		npcCars.add(npcCar);
	}

}
