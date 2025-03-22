package engine.map;

import engine.map.positions.Block;
import engine.map.roads.Road;
import engine.map.roads.TrafficLight;
import engine.process.CityBuilder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class City {
	private Block[][] blocks;
	private HashMap<Block, Road> roads;
	private ArrayList<TrafficLight> lights1 = new ArrayList<TrafficLight>();
	private final BufferedImage map = ImageIO.read(new File("src/images/ville.png"));

	private int lineCount;
	private int columnCount;

	public City(int lineCount, int columnCount) throws IOException {

		init(lineCount, columnCount);

		CityBuilder cityBuilder = new CityBuilder();
		cityBuilder.buildRoads(roads, blocks, lineCount, columnCount);

	}

	private void init(int lineCount, int columnCount) {
		this.lineCount = lineCount;	
		this.columnCount = columnCount;

		blocks = new Block[lineCount][columnCount];
		roads = new HashMap<Block,Road>();
	}

	public BufferedImage getMap() {
		return map;
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Block getBlock(int line, int column) {
		return blocks[line][column];
	}

	public HashMap<Block, Road> getRoads() {
		return roads;
	}

	public ArrayList<TrafficLight> getLights1() {
		return lights1;
	}
}
