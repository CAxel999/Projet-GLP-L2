package engine.process;

import engine.map.roads.*;

public interface TypeVisitor<T> {
    void visit(SimpleRoad road);
    void visit(CrossroadEntry road);
    void visit(Crosswalk road);
    void visit(Highway road);
    void visit(TrafficLightRoad road);
    void visit(ContinueLineRoad road);
    void visit(Crossroad road);
    void visit(Stop road);
    void visit(StopExit road);
    void visit(ScenarioRoad road);
    void visit(ResolveRoad road);

}
