package engine.process;

import engine.map.roads.*;

public interface TypeVisitor<T> {
    void visit(SimpleRoad road);
    void visit(CrossroadEntry road);
    void visit(Crosswalk road);
    void visit(Highway road);
    void visit(TrafficLightRoad road);
}
