package engine.map.roads;

import engine.map.Block;
import engine.process.TypeVisitor;

/**
 *
 */
public abstract class Road {
    private Block position;
    private double direction;
    private double speedLimit;

    public Road(Block position, double direction, double speedLimit) {
        this.position = position;
        this.direction = direction;
        this.speedLimit = speedLimit;
    }

    public Block getPosition() {
        return position;
    }

    public double getDirection() {
        return direction;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public abstract <T> void accept(TypeVisitor<T> visitor);



}
