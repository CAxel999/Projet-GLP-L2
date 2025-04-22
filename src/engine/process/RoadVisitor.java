package engine.process;

import config.GameConfiguration;
import data.Mistake;

import data.Scenario;
import data.ScenarioMessage;
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
        if(manager.directionVerif(road.getDirection(), mainCar)){
            Mistake.setMessage("Vous êtes dans la mauvaise direction !");
        }

    }

    @Override
    public void visit(CrossroadEntry road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            Mistake.setMessage("Vous êtes dans la mauvaise direction !");
        }
        mainCar.setPriority(true);
        for(Road occupied : road.getRoads()){
            if(occupied.hasCar()){
                mainCar.setPriority(false);
            }
        }
        if(road.getPriorityzone().intersectsLine(mainCar.getLeftSide()) || road.getPriorityzone().intersectsLine(mainCar.getRightSide())){
            if(!mainCar.isPriority()){
                Mistake.setMessage("Vous n'avez pas la priorité !");
                //Car not supposed to go through
            }
        }
    }

    @Override
    public void visit(Crosswalk road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            Mistake.setMessage("Vous êtes dans la mauvaise direction !");
        }
    }

    @Override
    public void visit(Highway road) {

        if(manager.directionVerif(road.getDirection(), mainCar)){
            Mistake.setMessage("Vous êtes dans la mauvaise direction !");
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
                Mistake.setMessage("Vous n'avez pas regardé votre angle mort !");
            }
        }

    }

    @Override
    public void visit(TrafficLightRoad road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            Mistake.setMessage("Vous êtes dans la mauvaise direction !");
        }
        mainCar.setPriority(true);
        if(road.getLight().getColor().equals(TrafficLightEnum.RED)){
            mainCar.setPriority(false);
        }
        if(road.getPriorityzone().intersectsLine(mainCar.getLeftSide()) || road.getPriorityzone().intersectsLine(mainCar.getRightSide())){
            if(!mainCar.isPriority()){
                Mistake.setMessage("Vous n'avez pas la priorité !");
                //Car not supposed to go through
            }
        }
    }



    @Override
    public void visit(Crossroad road) {

    }

    @Override
    public void visit(Stop road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            Mistake.setMessage("Vous êtes dans la mauvaise direction !");
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
                    Mistake.setMessage("Vous n'avez pas la priorité !");
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
        if(manager.directionVerif(road.getDirection(), mainCar)){
            Mistake.setMessage("Vous êtes dans la mauvaise direction !");
        } else if(mainCar.getScenario() == null){
            mainCar.setScenario(road.getScenario());
            ScenarioMessage.setMessage(road.getScenario().getText());
        }

    }

    @Override
    public void visit(ResolveRoad road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            Mistake.setMessage("Vous êtes dans la mauvaise direction !");
        } else if(mainCar.getScenario() != null){
            Scenario scenario = mainCar.getScenario();
            if(scenario.getId() == road.getScenario().getId()){
                ScenarioMessage.setMessage("");
                scenario.setSuccessful();
            } else {
                Mistake.setMessage("Vous avez raté l'instruction !");
                ScenarioMessage.setMessage("");
                scenario.setFailed();
            }
        }
    }
}
