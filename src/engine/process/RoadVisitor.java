package engine.process;

import data.MistakeMessage;

import engine.map.positions.Zone;
import engine.map.roads.*;
import engine.mobile.MainCar;

public class RoadVisitor implements TypeVisitor<Void> {
    private MainCar mainCar;

    public RoadVisitor(MainCar mainCar) {
        this.mainCar = mainCar;
    }

    @Override
    public void visit(SimpleRoad road) {

    }

    @Override
    public void visit(CrossroadEntry road) {


    }

    @Override
    public void visit(Crosswalk road) {

    }

    @Override
    public void visit(Highway road) {
        Zone zone = road.getCrossingSection();

        if(mainCar.getPixelPosition().getX() > zone.getTopLeft().getX() && mainCar.getPixelPosition().getY() > zone.getTopLeft().getY() && mainCar.getPixelPosition().getY() < zone.getBottomRight().getY() && mainCar.getPixelPosition().getX() < zone.getBottomRight().getX()){
            MistakeMessage.setMessage("Car in zone");
        }
    }

    @Override
    public void visit(TrafficLightRoad road) {

    }
}
