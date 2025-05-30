package engine.map.positions;

/**
 * Position with Block coordinates has a column and a line in an Array of Block
 */
public class Block {
	private int line;
	private int column;

	public Block(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "Block [line=" + line + ", column=" + column + "]";
	}

}
