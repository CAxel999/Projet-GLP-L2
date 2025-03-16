package engine.map;

import engine.map.roads.Road;
import engine.process.CityBuilder;

import java.util.HashMap;

public class City {
	private Block[][] blocks;
	private HashMap<Block, Road> roads;


	private int lineCount;
	private int columnCount;

	public City(int lineCount, int columnCount) {

		init(lineCount, columnCount);

		CityBuilder cityBuilder = new CityBuilder();
		roads = cityBuilder.buildRoads(blocks, lineCount, columnCount);

	}

	private void init(int lineCount, int columnCount) {
		this.lineCount = lineCount;	
		this.columnCount = columnCount;

		blocks = new Block[lineCount][columnCount];
		roads = new HashMap<Block,Road>();
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
}
