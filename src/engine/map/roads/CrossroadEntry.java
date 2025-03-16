package engine.map.roads;

import engine.map.Block;
import engine.map.Zone;
import engine.process.TypeVisitor;

import java.util.HashMap;

/**
 *Road at the entries of a "giratoire"
 *
 *
 */
public class CrossroadEntry extends Road {
    private HashMap<Block,Road>roads;
    private Zone priorityzone;

    public CrossroadEntry(Block position, double direction, double speedLimit) {
        super(position, direction, speedLimit);
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
