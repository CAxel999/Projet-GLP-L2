package engine.process;

import config.GameConfiguration;
import data.Mistake;

import data.Scenario;
import engine.map.roads.*;
import engine.mobile.MainCar;


/**
 *
 */
public class RoadVisitor implements TypeVisitor<Void> {
    private MainCar mainCar;
    private MobileElementManager manager;
    private ScoreManager scoreManager;

    public RoadVisitor(MainCar mainCar,MobileElementManager manager, ScoreManager scoreManager) {
        this.mainCar = mainCar;
        this.manager = manager;
        this.scoreManager = scoreManager;
    }

    @Override
    public void visit(SimpleRoad road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            mainCar.setMistakesWereNotMade(false);
            if(mainCar.getCurrentMistake() != null) {
                if(mainCar.getCurrentMistake().getId() >= 2){
                    Mistake mistake = scoreManager.getMistakes().get(2);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            } else{
                Mistake mistake = scoreManager.getMistakes().get(2);
                mistake.incrementNumber();
                mainCar.setCurrentMistake(mistake);
            }
        }

    }

    @Override
    public void visit(CrossroadEntry road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            mainCar.setMistakesWereNotMade(false);
            if(mainCar.getCurrentMistake() != null) {
                if(mainCar.getCurrentMistake().getId() >= 2){
                    Mistake mistake = scoreManager.getMistakes().get(2);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            } else{
                Mistake mistake = scoreManager.getMistakes().get(2);
                mistake.incrementNumber();
                mainCar.setCurrentMistake(mistake);
            }
        }
        mainCar.setPriority(true);
        for(Road occupied : road.getRoads()){
            if(occupied.hasCar()){
                mainCar.setPriority(false);
            }
        }
        if(road.getPriorityzone().intersectsLine(mainCar.getLeftSide()) || road.getPriorityzone().intersectsLine(mainCar.getRightSide())){
            if(!mainCar.isPriority()){
                mainCar.setMistakesWereNotMade(false);
                if(mainCar.getCurrentMistake() != null) {
                    if(mainCar.getCurrentMistake().getId() >= 8){
                        Mistake mistake = scoreManager.getMistakes().get(8);
                        mistake.incrementNumber();
                        mainCar.setCurrentMistake(mistake);
                    }
                } else{
                    Mistake mistake = scoreManager.getMistakes().get(8);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            }
        }
    }

    @Override
    public void visit(Crosswalk road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            mainCar.setMistakesWereNotMade(false);
            if(mainCar.getCurrentMistake() != null) {
                if(mainCar.getCurrentMistake().getId() >= 2){
                    Mistake mistake = scoreManager.getMistakes().get(2);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            } else{
                Mistake mistake = scoreManager.getMistakes().get(2);
                mistake.incrementNumber();
                mainCar.setCurrentMistake(mistake);
            }
        }
    }

    @Override
    public void visit(Highway road) {

        if(manager.directionVerif(road.getDirection(), mainCar)){
            mainCar.setMistakesWereNotMade(false);
            if(mainCar.getCurrentMistake() != null) {
                if(mainCar.getCurrentMistake().getId() >= 2){
                    Mistake mistake = scoreManager.getMistakes().get(2);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            } else{
                Mistake mistake = scoreManager.getMistakes().get(2);
                mistake.incrementNumber();
                mainCar.setCurrentMistake(mistake);
            }
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
                mainCar.setMistakesWereNotMade(false);
                if(mainCar.getCurrentMistake() != null) {
                    if(mainCar.getCurrentMistake().getId() >= 9){
                        Mistake mistake = scoreManager.getMistakes().get(9);
                        mistake.incrementNumber();
                        mainCar.setCurrentMistake(mistake);
                    }
                } else{
                    Mistake mistake = scoreManager.getMistakes().get(9);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            }

            if(!(mainCar.isClignoGauche() || mainCar.isClignoDroit())){
                mainCar.setMistakesWereNotMade(false);
                if(mainCar.getCurrentMistake() != null) {
                    if(mainCar.getCurrentMistake().getId() >= 10){
                        Mistake mistake = scoreManager.getMistakes().get(10);
                        mistake.incrementNumber();
                        mainCar.setCurrentMistake(mistake);
                    }
                } else{
                    Mistake mistake = scoreManager.getMistakes().get(10);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            }
        }

    }

    @Override
    public void visit(TrafficLightRoad road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            mainCar.setMistakesWereNotMade(false);
            if(mainCar.getCurrentMistake() != null) {
                if(mainCar.getCurrentMistake().getId() >= 2){
                    Mistake mistake = scoreManager.getMistakes().get(2);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            } else{
                Mistake mistake = scoreManager.getMistakes().get(2);
                mistake.incrementNumber();
                mainCar.setCurrentMistake(mistake);
            }
        }
        mainCar.setPriority(true);
        if(road.getLight().getColor().equals(TrafficLightEnum.RED)){
            mainCar.setPriority(false);
        }
        if(road.getPriorityzone().intersectsLine(mainCar.getLeftSide()) || road.getPriorityzone().intersectsLine(mainCar.getRightSide())){
            if(!mainCar.isPriority()){
                mainCar.setMistakesWereNotMade(false);
                if(mainCar.getCurrentMistake() != null) {
                    if(mainCar.getCurrentMistake().getId() >= 4){
                        Mistake mistake = scoreManager.getMistakes().get(4);
                        mistake.incrementNumber();
                        mainCar.setCurrentMistake(mistake);
                    }
                } else{
                    Mistake mistake = scoreManager.getMistakes().get(4);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            }
        }
    }



    @Override
    public void visit(Crossroad road) {

    }

    @Override
    public void visit(Stop road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            mainCar.setMistakesWereNotMade(false);
            if(mainCar.getCurrentMistake() != null) {
                if(mainCar.getCurrentMistake().getId() >= 2){
                    Mistake mistake = scoreManager.getMistakes().get(2);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            } else{
                Mistake mistake = scoreManager.getMistakes().get(2);
                mistake.incrementNumber();
                mainCar.setCurrentMistake(mistake);
            }
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
                    mainCar.setMistakesWereNotMade(false);
                    if(mainCar.getCurrentMistake() != null) {
                        if(mainCar.getCurrentMistake().getId() >= 5){
                            Mistake mistake = scoreManager.getMistakes().get(5);
                            mistake.incrementNumber();
                            mainCar.setCurrentMistake(mistake);
                        }
                    } else{
                        Mistake mistake = scoreManager.getMistakes().get(5);
                        mistake.incrementNumber();
                        mainCar.setCurrentMistake(mistake);
                    }
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
            mainCar.setMistakesWereNotMade(false);
            if(mainCar.getCurrentMistake() != null) {
                if(mainCar.getCurrentMistake().getId() >= 2){
                    Mistake mistake = scoreManager.getMistakes().get(2);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            } else{
                Mistake mistake = scoreManager.getMistakes().get(2);
                mistake.incrementNumber();
                mainCar.setCurrentMistake(mistake);
            }
        } else if(mainCar.getScenario() == null){
            mainCar.setScenario(road.getScenario());
        }

    }

    @Override
    public void visit(ResolveRoad road) {
        if(manager.directionVerif(road.getDirection(), mainCar)){
            mainCar.setMistakesWereNotMade(false);
            if(mainCar.getCurrentMistake() != null) {
                if(mainCar.getCurrentMistake().getId() >= 2){
                    Mistake mistake = scoreManager.getMistakes().get(2);
                    mistake.incrementNumber();
                    mainCar.setCurrentMistake(mistake);
                }
            } else{
                Mistake mistake = scoreManager.getMistakes().get(2);
                mistake.incrementNumber();
                mainCar.setCurrentMistake(mistake);
            }
        } else if(mainCar.getScenario() != null){
            Scenario scenario = mainCar.getScenario();
            if(scenario.getId() == road.getScenario().getId()){
                scenario.setSuccessful();
            } else {
                scenario.setFailed();
            }
        }
    }
}
