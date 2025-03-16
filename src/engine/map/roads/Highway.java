package engine.map.roads;

import engine.map.Block;
import engine.map.Zone;
import engine.process.TypeVisitor;

public class Highway extends Road {
    private Block secondPosition;
    private Zone crossingSection;
    public Highway(Block position, Block secondPosition, double direction, double speedLimit) {
        super(position, direction, speedLimit);
        this.secondPosition = secondPosition;
    }

    public Block getSecondPosition() {
        return secondPosition;
    }

    public Zone getCrossingSection() {
        return crossingSection;
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
