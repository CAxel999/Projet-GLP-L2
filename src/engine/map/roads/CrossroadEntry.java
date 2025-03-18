package engine.map.roads;

import engine.map.positions.Block;
import engine.map.positions.Zone;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *Road at the entries of a cross road
 *
 *Is placed at the entries of a crossroad. It can be a cross, a roundabout or a "giratoire".
 *Has a zone that permits to check wether the car is autorized to cross the crossroad or not depending on its priority
 */
public class CrossroadEntry extends Road {
    private double direction;
    private HashMap<Block,Road>roads = new HashMap<Block,Road>();
    private Line2D priorityzone;

    public CrossroadEntry(Block position, double direction, double speedLimit, ArrayList<Line2D> limits, Line2D priorityzone) {
        super(position, speedLimit, limits);
        this.direction = direction;

        this.priorityzone = priorityzone;
    }
    public double getDirection() {
        return direction;
    }

    public HashMap<Block, Road> getRoads() {
        return roads;
    }

    public void addRoads(Road road){
        roads.put(road.getPosition(),road);
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
