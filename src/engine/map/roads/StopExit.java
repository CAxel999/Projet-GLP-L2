package engine.map.roads;

import engine.map.positions.Block;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Class of a StopExit object
 *
 * Is placed at the exit of a {@link Stop} to which it is linked.
 */
public class StopExit extends Crossroad{
    private Stop stopRoad;
    public StopExit(Block position, double speedLimit, ArrayList<Line2D> limits, Stop stopRoad) {
        super(position, speedLimit, limits);
        this.stopRoad = stopRoad;
    }

    public Stop getStopRoad() {
        return stopRoad;
    }

    @Override
    public String toString() {
        return "un croisement suivant un stop de position" + getPosition().toString();
    }
}
