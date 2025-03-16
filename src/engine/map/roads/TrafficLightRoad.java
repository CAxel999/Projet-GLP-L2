package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

public class TrafficLightRoad extends Road {
    private TrafficLight light;
    public TrafficLightRoad(Block position, double direction, double speedLimit) {
        super(position, direction, speedLimit);
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
