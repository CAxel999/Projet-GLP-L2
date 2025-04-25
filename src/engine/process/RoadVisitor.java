package engine.process;

import config.GameConfiguration;
import data.Mistake;

import data.Scenario;
import engine.map.roads.*;
import engine.mobile.MainCar;


/**
 *This visitor handles each {@link Road} the {@link MainCar} goes on with a different execution.
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
        if(manager.directionVerif(road.getDirection(), mainCar)){
            manager.setCurrentMistake(2);
        }

    }

    @Override
    public void visit(CrossroadEntry road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            manager.setCurrentMistake(2);

        }
        mainCar.setPriority(true);
        for(Road occupied : road.getRoads()){
            if(occupied.hasCar()){
                mainCar.setPriority(false);
            }
        }
        if(road.getPriorityzone().intersectsLine(mainCar.getLeftSide()) || road.getPriorityzone().intersectsLine(mainCar.getRightSide())){
            if(!mainCar.isPriority()){
                manager.setCurrentMistake(8);
            }
        }
    }

    @Override
    public void visit(Crosswalk road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            manager.setCurrentMistake(2);
        }
    }

    @Override
    public void visit(Highway road) {

        if(manager.directionVerif(road.getDirection(), mainCar)){
            manager.setCurrentMistake(2);
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
                manager.setCurrentMistake(9);
            }

            if(!(mainCar.isClignoGauche() || mainCar.isClignoDroit())){
                manager.setCurrentMistake(10);
            }
        }

    }

    @Override
    public void visit(TrafficLightRoad road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            manager.setCurrentMistake(2);
        }
        mainCar.setPriority(true);
        if(road.getLight().getColor().equals(TrafficLightEnum.RED)){
            mainCar.setPriority(false);
        }
        if(road.getPriorityzone().intersectsLine(mainCar.getLeftSide()) || road.getPriorityzone().intersectsLine(mainCar.getRightSide())){
            if(!mainCar.isPriority()){
                manager.setCurrentMistake(4);
            }
        }
    }



    @Override
    public void visit(Crossroad road) {

    }

    @Override
    public void visit(Stop road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            manager.setCurrentMistake(2);
        }
        if(mainCar.getSpeed() == 0){
            road.incrementTimeStoped();
        } else if(!(road.getTimeStoped() == GameConfiguration.STOPTIME)){
            road.resetTimeStoped();
        }
        if(road.getTimeStoped() == GameConfiguration.STOPTIME){
            mainCar.setPriority(true);
            for(Road occupied : road.getRoads()){
                if(occupied.hasCar()){
                    mainCar.setPriority(false);
                }
            }
            if(road.getPriorityzone().intersectsLine(mainCar.getLeftSide()) || road.getPriorityzone().intersectsLine(mainCar.getRightSide())){
                if(!mainCar.isPriority()){
                    manager.setCurrentMistake(5);
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
        Scenario scenario = mainCar.getScenario();
        if(manager.directionVerif(road.getDirection(), mainCar)){
            manager.setCurrentMistake(2);
        } else if(scenario == null || scenario.isSuccessful() || scenario.isFailed()){
            mainCar.setScenario(road.getScenario());
        }

    }

    @Override
    public void visit(ResolveRoad road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            manager.setCurrentMistake(2);
        } else if(mainCar.getScenario() != null){
            Scenario scenario = mainCar.getScenario();
            if(scenario.getId() == road.getScenario().getId()){
                scenario.setSuccessful();
            } else {
                scenario.setFailed();
            }
        }
    }

    @Override
    public void visit(GoalRoad road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            manager.setCurrentMistake(2);
        } else if(mainCar.getScenario() != null){
            Scenario scenario = mainCar.getScenario();
            if(scenario.getId() == road.getScenario().getId()){
                scenario.setSuccessful();
            } else {
                scenario.setFailed();
            }
        }
        GameConfiguration.END = true;
    }
}
