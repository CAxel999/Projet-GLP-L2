package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Class of a TrafficLightRoad object
 *
 * Has a {@link TrafficLight} that can change color, a direction in double and a {@link Line2D} as a priority zone
 */
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

    public Line2D getPriorityzone() {
        return priorityzone;
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "une route possédant un feu de position" + getPosition().toString();
    }
}
