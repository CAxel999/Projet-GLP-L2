package engine.process;

import engine.map.roads.*;

public interface TypeVisitor<T> {
    void visit(CrossroadEntry road);
    void visit(Crosswalk road);
    void visit(Highway road);
    void visit(TrafficLightRoad road);
    void visit(Stop road);
    void visit(RoadVisitor road);

    default void visit(YieldSign road) {

    }
}
