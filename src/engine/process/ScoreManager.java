package engine.process;

import data.Mistake;
import data.Scenario;
import data.ScoreDescription;

import java.util.HashMap;

public class ScoreManager {
    private HashMap<Integer, Scenario> scenarioHashMap;
    private HashMap<String, Mistake> mistakes;
    private ScoreDescription scoreDescription;
    private boolean eliminated;

    public ScoreManager() {

        this.eliminated = false;
    }

    public int getScore() {
        int score = 30;
        for(Scenario scenario : scenarioHashMap.values()){
            if(scenario.isFailed() || !scenario.isSuccessful()){
                scoreDescription.setScenario(scoreDescription.getScenario() + "\nVous avez echoué le scénario "+ scenario.getId() + " = -1 point.");
                score--;
            }
        }
        for(Mistake mistake : mistakes.values()){
            int number = mistake.getNumber();
            if(mistake.isEliminatory()){
                if(number > 0){
                    scoreDescription.setMistake(scoreDescription.getMistake() + "\nVous avez réalisé l'erreur : "+ mistake.getName() + ", qui est une faute éliminatoire, " + number + " fois.");
                    eliminated = true;
                }
            } else if(mistake.getName().equals("Priorité non respectée")) {
                if(number > 0) {
                    if (number >= 3) {
                        scoreDescription.setMistake(scoreDescription.getMistake() + "\nVous avez réalisé l'erreur : "+ mistake.getName() + " " + number + " fois, ce qui est éliminatoire.");
                        eliminated = true;
                    } else {
                        scoreDescription.setMistake(scoreDescription.getMistake() + "\nVous avez réalisé l'erreur : "+ mistake.getName() + " " + number + " fois = -" + number + " point.");
                    }
                    score = score - number;
                }
            } else {
                if(number > 0) {
                    scoreDescription.setMistake(scoreDescription.getMistake() + "\nVous avez réalisé l'erreur : "+ mistake.getName() + " " + number + " fois= -" + number + " point.");
                    score = score - number;
                }

            }
        }
        if(eliminated){
            scoreDescription.setEliminated("Vous avez commis une faute éliminatoire.");
        }
        return score;
    }

    public HashMap<Integer, Scenario> getScenarioHashMap() {
        return scenarioHashMap;
    }

    public HashMap<String, Mistake> getMistakes() {
        return mistakes;
    }

    public void setScenarioHashMap(HashMap<Integer, Scenario> scenarioHashMap) {
        this.scenarioHashMap = scenarioHashMap;
    }

    public void setMistakes(HashMap<String, Mistake> mistakes) {
        this.mistakes = mistakes;
    }

    public ScoreDescription getScoreDescription() {
        return scoreDescription;
    }
}
