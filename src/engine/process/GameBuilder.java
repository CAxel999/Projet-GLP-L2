package engine.process;

import config.GameConfiguration;
import data.Instruction;
import data.Scenario;
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
		intializeScenario(city);
		intializeCar(city, manager);
		intializeNPCCar(city, manager);
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

	private static void intializeScenario(City city) {
		HashMap<Integer,Scenario> scenarioHashMap = city.getScenarioHashMap();

		Scenario scenario1 = new Scenario(1,"Au croisement, tournez à gauche.");
		scenarioHashMap.put(scenario1.getId(), scenario1);

		Scenario scenario2 = new Scenario(2,"Au giratoire, prenez la deuxième sortie.");
		scenarioHashMap.put(scenario2.getId(), scenario2);

		Scenario scenario3 = new Scenario(3,"Au croisement, tournez à droite.");
		scenarioHashMap.put(scenario3.getId(), scenario3);

		Scenario scenario4 = new Scenario(4,"Engagez vous sur l'autoroute puis prenez la première sortie.");
		scenarioHashMap.put(scenario4.getId(), scenario4);

		Scenario scenario5 = new Scenario(5,"Au feu, tournez à droite.");
		scenarioHashMap.put(scenario5.getId(), scenario5);

		Scenario scenario6 = new Scenario(6,"Au rond-point, prenez la première sortie.");
		scenarioHashMap.put(scenario6.getId(), scenario6);

		Scenario scenario7 = new Scenario(7,"Après le stop, allez tout droit.");
		scenarioHashMap.put(scenario7.getId(), scenario7);

		Scenario scenario8 = new Scenario(8,"Au giratoire, prenez la troisième sortie.");
		scenarioHashMap.put(scenario8.getId(), scenario8);

		Scenario scenario9 = new Scenario(9,"Au croisement, allez tout droit.");
		scenarioHashMap.put(scenario9.getId(), scenario9);

		Scenario scenario10 = new Scenario(10,"Au rond-point, prenez la première sortie.");
		scenarioHashMap.put(scenario10.getId(), scenario10);

		Scenario scenario11 = new Scenario(11,"Au croisement, tournez à gauche.");
		scenarioHashMap.put(scenario11.getId(), scenario11);

		Scenario scenario12 = new Scenario(12,"Au feu, tournez à droite.");
		scenarioHashMap.put(scenario12.getId(), scenario12);

	}

	public static void addNPCCar1(City city, ArrayList<NPCCar> npcCars) {
		Block block = city.getBlock(20, 0);
		ArrayList<Instruction> instructionList = new ArrayList<Instruction>();

		PixelPosition pixelPosition1 = new PixelPosition(430,820);
		Instruction instruction1 = new Instruction(2.125,0,pixelPosition1, false, false);
		instructionList.add(instruction1);

		PixelPosition pixelPosition2 = new PixelPosition(445,815);
		Instruction instruction2 = new Instruction(1.9,Math.PI/8,pixelPosition2, true, false);

		instructionList.add(instruction2);

		PixelPosition pixelPosition3 = new PixelPosition(455,805);
		Instruction instruction3 = new Instruction(1.75,Math.PI/4,pixelPosition3, true, false);
		instructionList.add(instruction3);

		PixelPosition pixelPosition4 = new PixelPosition(460,790);
		Instruction instruction4 = new Instruction(1.9,Math.PI*3/8,pixelPosition4,true, false);
		instructionList.add(instruction4);

		PixelPosition pixelPosition5 = new PixelPosition(460,635);
		Instruction instruction5 = new Instruction(2.125,Math.PI/2,pixelPosition5,false,false);
		instructionList.add(instruction5);

		PixelPosition pixelPosition6 = new PixelPosition(465,620);
		Instruction instruction6 = new Instruction(1.9,Math.PI*3/8,pixelPosition6,false, false);
		instructionList.add(instruction6);

		PixelPosition pixelPosition7 = new PixelPosition(475,610);
		Instruction instruction7 = new Instruction(1.75,Math.PI/4,pixelPosition7,true, false);
		instructionList.add(instruction7);

		PixelPosition pixelPosition8 = new PixelPosition(500,600);
		Instruction instruction8 = new Instruction(1.75,Math.PI/8,pixelPosition8,true, false);
		instructionList.add(instruction8);

		PixelPosition pixelPosition9 = new PixelPosition(525,575);
		Instruction instruction9 = new Instruction(1.75,Math.PI/4,pixelPosition9,true, false);
		instructionList.add(instruction9);

		PixelPosition pixelPosition10 = new PixelPosition(530,560);
		Instruction instruction10 = new Instruction(1.75,Math.PI*3/8,pixelPosition10,true, false);
		instructionList.add(instruction10);

		PixelPosition pixelPosition11 = new PixelPosition(530,480);
		Instruction instruction11 = new Instruction(1.75,Math.PI/2,pixelPosition11,true, false);
		instructionList.add(instruction11);

		PixelPosition pixelPosition12 = new PixelPosition(525,470);
		Instruction instruction12 = new Instruction(1.75,Math.PI*5/8,pixelPosition12,true, false);
		instructionList.add(instruction12);

		PixelPosition pixelPosition13 = new PixelPosition(500,445);
		Instruction instruction13 = new Instruction(1.75,Math.PI*3/4,pixelPosition13,true, false);
		instructionList.add(instruction13);

		PixelPosition pixelPosition14 = new PixelPosition(480,435);
		Instruction instruction14 = new Instruction(1.75,Math.PI*7/8,pixelPosition14,true, false);
		instructionList.add(instruction14);

		PixelPosition pixelPosition15 = new PixelPosition(400,435);
		Instruction instruction15 = new Instruction(1.75,Math.PI,pixelPosition15,true, false);
		instructionList.add(instruction15);

		PixelPosition pixelPosition16 = new PixelPosition(390,440);
		Instruction instruction16 = new Instruction(1.75,Math.PI*9/8,pixelPosition16,false, true);
		instructionList.add(instruction16);

		PixelPosition pixelPosition17 = new PixelPosition(350,480);
		Instruction instruction17 = new Instruction(1.75,Math.PI*5/4,pixelPosition17,false, true);
		instructionList.add(instruction17);

		PixelPosition pixelPosition18 = new PixelPosition(345,490);
		Instruction instruction18 = new Instruction(1.75,Math.PI*11/8,pixelPosition18,false,true);
		instructionList.add(instruction18);

		PixelPosition pixelPosition19 = new PixelPosition(340,495);
		Instruction instruction19 = new Instruction(1.75,Math.PI*5/4,pixelPosition19,false,true);
		instructionList.add(instruction19);

		PixelPosition pixelPosition20 = new PixelPosition(330,500);
		Instruction instruction20 = new Instruction(1.9,Math.PI*9/8,pixelPosition20,false,true);
		instructionList.add(instruction20);

		PixelPosition pixelPosition21 = new PixelPosition(90,500);
		Instruction instruction21 = new Instruction(2.125,Math.PI,pixelPosition21,false,false);
		instructionList.add(instruction21);

		PixelPosition pixelPosition22 = new PixelPosition(75,505);
		Instruction instruction22 = new Instruction(1.9,Math.PI*9/8,pixelPosition22,true,false);
		instructionList.add(instruction22);

		PixelPosition pixelPosition23 = new PixelPosition(65,515);
		Instruction instruction23 = new Instruction(1.75,Math.PI*5/4,pixelPosition23,true,false);
		instructionList.add(instruction23);

		PixelPosition pixelPosition24 = new PixelPosition(60,530);
		Instruction instruction24 = new Instruction(1.9,Math.PI*11/8,pixelPosition24,true,false);
		instructionList.add(instruction24);

		PixelPosition pixelPosition25 = new PixelPosition(60,750);
		Instruction instruction25 = new Instruction(2.125,Math.PI*3/2,pixelPosition25,false,false);
		instructionList.add(instruction25);

		PixelPosition pixelPosition26 = new PixelPosition(55,765);
		Instruction instruction26 = new Instruction(1.9,Math.PI*11/8,pixelPosition26,true,false);
		instructionList.add(instruction26);

		PixelPosition pixelPosition27 = new PixelPosition(45,775);
		Instruction instruction27 = new Instruction(1.75,Math.PI*5/4,pixelPosition27,true,false);
		instructionList.add(instruction27);

		PixelPosition pixelPosition28 = new PixelPosition(30,780);
		Instruction instruction28 = new Instruction(1.9,Math.PI*9/8,pixelPosition28,true,false);
		instructionList.add(instruction28);

		PixelPosition pixelPosition29 = new PixelPosition(0,780);
		Instruction instruction29 = new Instruction(2.125,Math.PI,pixelPosition29,false,false);
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
		Instruction instruction1 = new Instruction(4.5,0,pixelPosition1,false, false);
		instructionList.add(instruction1);

		Iterator<Instruction> iterator = instructionList.iterator();
		iterator.next();
		NPCCar npcCar = new NPCCar(block,instructionList,iterator,instruction1);
		npcCars.add(npcCar);
	}

}
