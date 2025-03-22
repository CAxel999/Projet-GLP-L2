package engine.process;

import config.CarConfiguration;
import data.MistakeMessage;

import engine.map.positions.Zone;
import engine.map.roads.*;
import engine.mobile.MainCar;

public class RoadVisitor implements TypeVisitor<Void> {
    private MainCar mainCar;
    private MobileElementManager manager;

    public RoadVisitor(MainCar mainCar,MobileElementManager manager) {
        this.mainCar = mainCar;
        this.manager = manager;
    }

    @Override
    public void visit(SimpleRoad road) {
        if(!manager.directionVerif(road.getDirection(),mainCar)){
            MistakeMessage.setMessage("Car direction incorrect");
        }
    }

    @Override
    public void visit(CrossroadEntry road) {
        if(!manager.directionVerif(road.getDirection(),mainCar)){
            MistakeMessage.setMessage("Car direction incorrect");
        }
    }

    @Override
    public void visit(Crosswalk road) {
        if(!manager.directionVerif(road.getDirection(),mainCar)){
            MistakeMessage.setMessage("Car direction incorrect");
        }
    }

    @Override
    public void visit(Highway road) {
        Zone zone = road.getCrossingSection();
        if(!manager.directionVerif(road.getDirection(),mainCar)){
            MistakeMessage.setMessage("Car direction incorrect");
        }

        if(mainCar.getPixelPosition().getX() > zone.getTopLeft().getX() && mainCar.getPixelPosition().getY() > zone.getTopLeft().getY() && mainCar.getPixelPosition().getY() < zone.getBottomRight().getY() && mainCar.getPixelPosition().getX() < zone.getBottomRight().getX()){
            MistakeMessage.setMessage("Car in zone");
        }
    }

    @Override
    public void visit(TrafficLightRoad road) {
        if(!manager.directionVerif(road.getDirection(),mainCar)){
            MistakeMessage.setMessage("Car direction incorrect");
        }

    }

    @Override
    public void visit(ContinueLineRoad road) {

    }

    @Override
    public void visit(Crossroad road) {

    }

    @Override
    public void visit(Stop road) {

    }
}
