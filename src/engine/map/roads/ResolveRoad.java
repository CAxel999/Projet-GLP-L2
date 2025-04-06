package engine.map.roads;

import data.Scenario;
import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class ResolveRoad extends SimpleRoad{
    private Scenario scenario;

    public ResolveRoad(Block position, double direction, double speedLimit, ArrayList<Line2D> limits, Scenario scenario) {
        super(position, direction, speedLimit, limits);
        this.scenario = scenario;
    }

    public Scenario getScenario() {
        return scenario;
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
