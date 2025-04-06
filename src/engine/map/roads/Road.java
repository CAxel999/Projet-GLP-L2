package engine.map.roads;

import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 *
 */
public abstract class Road {
    private Block position;

    private double speedLimit;
    private boolean hasCar;
    private ArrayList<Line2D> limits;

    public Road(Block position,  double speedLimit, ArrayList<Line2D> limits) {
        this.position = position;
        this.speedLimit = speedLimit;
        this.hasCar = false;
        this.limits = limits;
    }

    public Block getPosition() {
        return position;
    }

    public ArrayList<Line2D> getLimits() {
        return limits;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public boolean hasCar() {
        return hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

    public abstract <T> void accept(TypeVisitor<T> visitor);


}
