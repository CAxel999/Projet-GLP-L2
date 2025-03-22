package engine.map.roads;

import engine.map.positions.Block;
import engine.map.positions.Zone;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;

public class ContinueLineRoad extends Road{
    private double direction;
    private double secondDirection;
    private Line2D midLimit;

    public ContinueLineRoad(Block position, double direction, double speedLimit, ArrayList<Line2D> limits, Line2D midLimit) {
        super(position, speedLimit, limits);

        this.direction = direction;
        this.midLimit = midLimit;
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
