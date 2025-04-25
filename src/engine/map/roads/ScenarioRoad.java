package engine.map.roads;

import data.Scenario;
import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Class of a ScenarioRoad object
 *
 * Has a {@link Scenario}
 * Is the road on which the car must be to start a Scenario
 */
public class ScenarioRoad extends SimpleRoad{
    private Scenario scenario;

    public ScenarioRoad(Block position, double direction, double speedLimit, ArrayList<Line2D> limits, Scenario scenario) {
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

    @Override
    public String toString() {
        return "une route de scenario de position" + getPosition().toString();
    }
}
