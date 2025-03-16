package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

/**
 *
 */
public abstract class Road {
    private Block position;
    private double direction;
    private double speedLimit;
    private boolean hasCar;

    public Road(Block position, double direction, double speedLimit) {
        this.position = position;
        this.direction = direction;
        this.speedLimit = speedLimit;
        this.hasCar = false;
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

    public boolean isHasCar() {
        return hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

    public abstract <T> void accept(TypeVisitor<T> visitor);


}
