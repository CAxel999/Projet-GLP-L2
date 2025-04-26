package engine.mobile;

import data.Instruction;
import engine.map.positions.Block;

/**
 * Class of a MobileElement object
 *
 * Has a {@link Block} position
 */
public abstract class MobileElement {
	private Block position;

	public MobileElement(Block position) {
		this.position = position;
	}

	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}

}
