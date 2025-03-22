package engine.map.roads;

import engine.map.positions.Block;
import engine.map.positions.Zone;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;

public class TrafficLightRoad extends Road {
    private double direction;
    private TrafficLight light;

    private Line2D priorityzone;

    public TrafficLightRoad(Block position, double direction, double speedLimit, ArrayList<Line2D> limits, TrafficLight light, Line2D priorityzone) {
        super(position, speedLimit, limits);
        this.direction = direction;
        this.light = light;
        this.priorityzone = priorityzone;
    }

    public double getDirection() {
        return direction;
    }

    public TrafficLight getLight() {
        return light;
    }



    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
