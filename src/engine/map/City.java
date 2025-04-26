package engine.map;

import engine.map.positions.Block;
import engine.map.roads.Road;
import engine.map.roads.TrafficLight;
import engine.process.CityBuilder;
import engine.process.ScoreManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Class of City object
 *
 * Has an Array of {@link Block}, a HashMap of {@link Road}, an ArrayList of road that has a car, an ArrayList of {@link TrafficLight}
 */
public class City {
	private Block[][] blocks;
	private HashMap<Block, Road> roads;
	private ArrayList<Road> hasCar;
	private ArrayList<TrafficLight> lights = new ArrayList<TrafficLight>();
	private final BufferedImage map = ImageIO.read(new File("src/images/ville.png"));


	private int lineCount;
	private int columnCount;

	public City(int lineCount, int columnCount, ScoreManager manager) throws IOException {

		init(lineCount, columnCount);

		CityBuilder cityBuilder = new CityBuilder();
		cityBuilder.buildRoads(roads, blocks, lineCount, columnCount, lights, manager.getScenarioHashMap());

	}

	private void init(int lineCount, int columnCount) {
		this.lineCount = lineCount;	
		this.columnCount = columnCount;

		blocks = new Block[lineCount][columnCount];
		roads = new HashMap<Block,Road>();
		hasCar = new ArrayList<Road>();
	}

	public BufferedImage getMap() {
		return map;
	}

	public Block getBlock(int line, int column) {
		return blocks[line][column];
	}

	public HashMap<Block, Road> getRoads() {
		return roads;
	}

	public ArrayList<Road> getHasCar() {
		return hasCar;
	}

	public ArrayList<TrafficLight> getLights() {
		return lights;
	}
}
