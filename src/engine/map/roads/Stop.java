package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Stop extends Road{
    private int timeStoped;
    private double direction;
    private ArrayList<Road> roads;
    private Line2D priorityzone;

    public Stop(Block position, double direction, double speedLimit, ArrayList<Line2D> limits, Line2D priorityzone) {
        super(position, speedLimit, limits);
        this.direction = direction;
        this.roads = new ArrayList<Road>();
        this.priorityzone = priorityzone;
        this.timeStoped = 0;
    }

    public double getDirection() {
        return direction;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public void addRoads(Road road){
        roads.add(road);
    }

    public int getTimeStoped() {
        return timeStoped;
    }

    public Line2D getPriorityzone() {
        return priorityzone;
    }

    public void incrementTimeStoped() {
        this.timeStoped++;
    }

    public void resetTimeStoped() {
        this.timeStoped = 0;
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
