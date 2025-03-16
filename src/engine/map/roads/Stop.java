package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

public class Stop extends Road{
    public Stop(Block position, double direction, double speedLimit) {
        super(position, direction, speedLimit);
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {

    }
}
