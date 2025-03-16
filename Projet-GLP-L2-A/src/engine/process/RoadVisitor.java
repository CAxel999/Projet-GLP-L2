package engine.process;

import engine.map.*;
import engine.map.roads.*;

public  class RoadVisitor implements TypeVisitor<Void> {
    private City city;

    @Override
    public void visit(CrossroadEntry road) {

    }

    @Override
    public void visit(Crosswalk road) {
        System.err.println("ça marche");
    }

    @Override
    public void visit(Highway road) {

    }

    @Override
    public void visit(TrafficLightRoad road) {

    }

    @Override
    public void visit(Stop road) {

    }

    @Override
    public void visit(RoadVisitor road) {

    }

    @Override
    public void visit(YieldSign road) {

    }

}
