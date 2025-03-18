package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Crossroad extends Road{

    public Crossroad(Block position, double speedLimit, ArrayList<Line2D> limits) {
        super(position, speedLimit, limits);
    }



    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
