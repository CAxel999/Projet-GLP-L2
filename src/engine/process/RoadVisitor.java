package engine.process;

import data.MistakeMessage;

import engine.map.roads.*;
import engine.mobile.MainCar;


/**
 *
 */
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
        mainCar.setPriority(true);
        for(Road occupied : road.getRoads()){
            if(occupied.hasCar()){
                mainCar.setPriority(false);
            }
        }
        if(road.getPriorityzone().intersectsLine(mainCar.getLeftSide()) || road.getPriorityzone().intersectsLine(mainCar.getRightSide())){
            if(!mainCar.isPriority()){
                //Car not supposed to go through
            }
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

        if(!manager.directionVerif(road.getDirection(),mainCar)){
            MistakeMessage.setMessage("Car direction incorrect");
        }
        if(mainCar.getPosition().equals(road.getPosition())){
            mainCar.setAngleMortDroitPriority(false);
            if(mainCar.isAngleMortGauche()){
                mainCar.setAngleMortGauchePriority(true);
            }
        } else {
            mainCar.setAngleMortGauchePriority(false);
            if(mainCar.isAngleMortDroit()){
                mainCar.setAngleMortDroitPriority(true);
            }
        }
        if(road.getCrossingSection().intersectsLine(mainCar.getLeftSide()) || road.getCrossingSection().intersectsLine(mainCar.getRightSide()) || road.getCrossingSection().intersectsLine(mainCar.getFrontSide()) || road.getCrossingSection().intersectsLine(mainCar.getBackSide())){
            if(!(mainCar.isAngleMortGauchePriority() || mainCar.isAngleMortDroitPriority())){
                //Car not supposed to go through
            }
        }

    }

    @Override
    public void visit(TrafficLightRoad road) {
        if(!manager.directionVerif(road.getDirection(),mainCar)){
            MistakeMessage.setMessage("Car direction incorrect");
        }
        if(road.getLight().compareTo(TrafficLight.RED) == 0){
            mainCar.setPriority(false);
        }
        if(road.getPriorityzone().intersectsLine(mainCar.getLeftSide()) || road.getPriorityzone().intersectsLine(mainCar.getRightSide())){
            if(!mainCar.isPriority()){
                //Car not supposed to go through
            }
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
        if(!manager.directionVerif(road.getDirection(),mainCar)){
            MistakeMessage.setMessage("Car direction incorrect");
        }
        if(mainCar.getSpeed() == 0){
            road.incrementTimeStoped();
        } else if(!(road.getTimeStoped() == Stop.STOPTIME)){
            road.resetTimeStoped();
        }
        if(road.getTimeStoped() == Stop.STOPTIME){
            mainCar.setPriority(true);
            for(Road occupied : road.getRoads()){
                if(occupied.hasCar()){
                    mainCar.setPriority(false);
                }
            }
            if(road.getPriorityzone().intersectsLine(mainCar.getLeftSide()) || road.getPriorityzone().intersectsLine(mainCar.getRightSide())){
                if(!mainCar.isPriority()){
                    //Car not supposed to go through
                }
            }
        }
    }

    @Override
    public void visit(StopExit road) {
        road.getStopRoad().resetTimeStoped();
        mainCar.setPriority(false);
    }

    @Override
    public void visit(ScenarioRoad road) {
        if(!manager.directionVerif(road.getDirection(),mainCar)){
            MistakeMessage.setMessage("Car direction incorrect");
        }
    }

    @Override
    public void visit(ResolveRoad road) {
        if(!manager.directionVerif(road.getDirection(),mainCar)){
            MistakeMessage.setMessage("Car direction incorrect");
        }
    }
}
