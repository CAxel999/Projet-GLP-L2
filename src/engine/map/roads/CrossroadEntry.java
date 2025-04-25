package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Class of a CrossroadEntry object
 *
 * Is placed at the entries of a {@link Crossroad}. It can be a cross, a roundabout or a "giratoire".
 * Has an ArrayList {@link Road} to check for incoming cars, a direction in double and a {@link Line2D} as a priority zone
 */
public class CrossroadEntry extends Road {
    private double direction;
    private ArrayList<Road> roads;
    private Line2D priorityzone;

    public CrossroadEntry(Block position, double direction, double speedLimit, ArrayList<Line2D> limits, Line2D priorityzone) {
        super(position, speedLimit, limits);
        this.direction = direction;
        this.roads = new ArrayList<Road>();
        this.priorityzone = priorityzone;
    }
    public double getDirection() {
        return direction;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public Line2D getPriorityzone() {
        return priorityzone;
    }

    public void addRoads(Road road){
        roads.add(road);
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "une entrée de croisement de position" + getPosition().toString();
    }
}
