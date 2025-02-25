package engine.map;

import java.util.HashMap;

public class City {
	private Block[][] blocks;
	private HashMap<Block,Road> roads;


	private int lineCount;
	private int columnCount;

	public City(int lineCount, int columnCount) {
		init(lineCount, columnCount);

		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
			}
		}
		for(int i = 5; i < 25; i++){
			roads.put(blocks[i][15],new Road(Math.PI/2,10));
		}

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
