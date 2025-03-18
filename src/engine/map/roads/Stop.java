package engine.map.roads;

import engine.map.positions.Block;
import engine.map.positions.Zone;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;

public class Stop extends Road{
    public static final int STOPTIME = 120;
    private double direction;
    private HashMap<Block,Road> roads = new HashMap<Block,Road>();;
    private Line2D priorityzone;

    public Stop(Block position, double direction, double speedLimit, HashMap<Block,Road> roads, ArrayList<Line2D> limits, Line2D priorityzone) {
        super(position, speedLimit, limits);
        this.direction = direction;
        this.roads = roads;
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
