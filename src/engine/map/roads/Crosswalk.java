package engine.map.roads;

import engine.map.Block;
import engine.process.TypeVisitor;

public class Crosswalk extends Road {

    public Crosswalk(Block position, double direction, double speedLimit) {
        super(position, direction, speedLimit);
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
