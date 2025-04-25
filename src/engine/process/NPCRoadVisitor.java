package engine.process;

import config.CarConfiguration;
import engine.map.roads.*;
import engine.mobile.MainCar;
import engine.mobile.NPCCar;

/**
 * This visitor handles each {@link Road} an {@link NPCCar} goes on with a different execution.
 */
public class NPCRoadVisitor implements TypeVisitor<Void>{
    private NPCCar car;

    public void setCar(NPCCar car) {
        this.car = car;
    }

    @Override
    public void visit(SimpleRoad road) {

    }

    @Override
    public void visit(CrossroadEntry road) {
        car.setPriority(true);
        for(Road occupied : road.getRoads()){
            if(occupied.hasCar()){
                car.setPriority(false);
            }
        }
        if(!car.isPriority()){
            double speed = car.getSpeed();
            if(speed >= CarConfiguration.CAR_ACCERLERATION * 4) {
                car.setSpeed(speed - (CarConfiguration.CAR_ACCERLERATION * 4));
            } else {
                car.setSpeed(0);
            }
        }
    }

    @Override
    public void visit(Crosswalk road) {

    }

    @Override
    public void visit(Highway road) {

    }

    @Override
    public void visit(TrafficLightRoad road) {

    }

    @Override
    public void visit(Crossroad road) {

    }

    @Override
    public void visit(Stop road) {

    }

    @Override
    public void visit(StopExit road) {

    }

    @Override
    public void visit(ScenarioRoad road) {

    }

    @Override
    public void visit(ResolveRoad road) {

    }

    @Override
    public void visit(GoalRoad road) {

    }
}
