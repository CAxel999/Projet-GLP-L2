package engine.map.roads;

import engine.map.positions.Block;
import engine.map.positions.CarPosition;
import engine.map.positions.PixelPosition;
import engine.process.TypeVisitor;
import org.apache.log4j.Logger;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Class of a Road object
 *
 * Has a {@link Block} position in block coordinates, a speedlimit in double, a boolean for if it has car and an ArrayList of {@link Line2D}
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
