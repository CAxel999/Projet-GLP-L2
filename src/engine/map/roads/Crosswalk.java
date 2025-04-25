package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Class of a StopExit object
 *
 * Is used to make room for people to cross the road by penalizing {@link engine.mobile.MainCar} that stops on it
 * Has a direction in double
 */
public class Crosswalk extends Road {
    private double direction;
    public Crosswalk(Block position, double direction, double speedLimit, ArrayList<Line2D> limits) {
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

    @Override
    public String toString() {
        return "un passage piéton de position" + getPosition().toString();
    }
}
