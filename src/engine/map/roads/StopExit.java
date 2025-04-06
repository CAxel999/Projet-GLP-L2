package engine.map.roads;

import engine.map.positions.Block;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class StopExit extends Crossroad{
    private Stop stopRoad;
    public StopExit(Block position, double speedLimit, ArrayList<Line2D> limits, Stop stopRoad) {
        super(position, speedLimit, limits);
        this.stopRoad = stopRoad;
    }

    public Stop getStopRoad() {
        return stopRoad;
    }
}
