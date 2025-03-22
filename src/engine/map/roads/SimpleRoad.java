package engine.map.roads;

import engine.map.positions.Block;
import engine.map.positions.Zone;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class SimpleRoad extends Road{
    private double direction;
    public SimpleRoad(Block position, double direction, double speedLimit, ArrayList<Line2D> limits) {
        super(position, speedLimit, limits);
        this.direction = direction;
    }

    public double getDirection() {
        return direction;
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
