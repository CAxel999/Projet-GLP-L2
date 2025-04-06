package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 *Roads on a highway
 *
 *Is a chunk of a highway
 *Has a zone that permits to check wether the car is autorized to cross between lines or not
 */
public class Highway extends Road {
    private double direction;
    private Block secondPosition;
    private Line2D crossingSection;

    public Highway(Block position, double direction, double speedLimit, ArrayList<Line2D> limits, Block secondPosition, Line2D crossingSection) {
        super(position, speedLimit, limits);
        this.direction = direction;
        this.secondPosition = secondPosition;
        this.crossingSection = crossingSection;
    }

    public double getDirection() {
        return direction;
    }

    public Block getSecondPosition() {
        return secondPosition;
    }

    public Line2D getCrossingSection() {
        return crossingSection;
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
