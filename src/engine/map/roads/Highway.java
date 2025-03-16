package engine.map.roads;

import engine.map.positions.Block;
import engine.map.positions.Zone;
import engine.process.TypeVisitor;

/**
 *Roads on a highway
 *
 *Is a chunk of a highway
 *Has a zone that permits to check wether the car is autorized to cross between lines or not
 */
public class Highway extends Road {
    private Block secondPosition;
    private Zone crossingSection;
    public Highway(Block position, Block secondPosition, double direction, double speedLimit, Zone crossingSection) {
        super(position, direction, speedLimit);
        this.secondPosition = secondPosition;
        this.crossingSection = crossingSection;
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
