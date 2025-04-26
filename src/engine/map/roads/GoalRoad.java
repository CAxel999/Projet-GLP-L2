package engine.map.roads;

import data.Scenario;
import engine.map.positions.Block;
import engine.process.TypeVisitor;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Class of a GoalRoad object
 *
 * Is the road on which the car must be to reach the end of the scenarios, is used to put an end to the training or the exam
 */
public class GoalRoad extends ResolveRoad{

    public GoalRoad(Block position, double direction, double speedLimit, ArrayList<Line2D> limits, Scenario scenario) {
        super(position, direction, speedLimit, limits, scenario);

    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
