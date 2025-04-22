package engine.map.roads;

import data.Scenario;
import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class FailedRoad extends SimpleRoad{

    private Scenario scenario;

    public FailedRoad(Block position, double direction, double speedLimit, ArrayList<Line2D> limits) {
        super(position, direction, speedLimit, limits);
    }

    public Scenario getScenario() {
        return scenario;
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        super.accept(visitor);
    }
}
