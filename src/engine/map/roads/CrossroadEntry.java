package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 *Road at the entries of a cross road
 *
 *Is placed at the entries of a crossroad. It can be a cross, a roundabout or a "giratoire".
 *Has a zone that permits to check wether the car is autorized to cross the crossroad or not depending on its priority
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
}
