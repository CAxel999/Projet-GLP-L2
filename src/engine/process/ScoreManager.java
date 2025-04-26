package engine.process;

import data.Mistake;
import data.Scenario;
import data.ScoreDescription;

import java.util.HashMap;

/**
 * Manager used to calculate the score of the user.
 */
public class ScoreManager {
    private HashMap<Integer, Scenario> scenarioHashMap;
    private HashMap<Integer, Mistake> mistakes;
    private ScoreDescription scoreDescription;
    private boolean eliminated;

    public ScoreManager() {
        this.scoreDescription = new ScoreDescription();
        this.eliminated = false;
    }

    /**
     * This method calculate the score of the user based on the number of {@link Scenario} he succeeded and on the number of mistakes he made. It writes the description of those scenario and mistakes in the scoreDescription.
     * @return The final score of the user
     */
    public int getScore() {
        int score = 30;
        for(Scenario scenario : scenarioHashMap.values()){
            if (scenario.getId() != 0) {
                if(scenario.isSuccessful()){
                    scoreDescription.setScenario(scoreDescription.getScenario() + "\nVous avez réussi le scénario " + scenario.getId() + ".");
                }
                else {
                    scoreDescription.setScenario(scoreDescription.getScenario() + "\nVous avez echoué le scénario " + scenario.getId() + " = -1 point.");
                    score--;
                }
            }
        }
        for(Mistake mistake : mistakes.values()){
            int number = mistake.getNumber();

            if(mistake.isEliminatory()){
                if(number > 0){
                    scoreDescription.setMistake(scoreDescription.getMistake() + "\nVous avez réalisé l'erreur : "+ mistake.getName() + ", qui est une faute éliminatoire, " + number + " fois.");
                    eliminated = true;
                }
            } else if(mistake.getId() == 8) {
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
            scoreDescription.setEliminated(scoreDescription.getEliminated() + " \nVous avez commis une faute éliminatoire." + " \nNON FAVORABLE");
        } else if (score < 20) {
            scoreDescription.setEliminated(scoreDescription.getEliminated() +  " \nVous n'avez commis aucune faute éliminatoire." + " \nNON FAVORABLE");
        } else {
            scoreDescription.setEliminated(scoreDescription.getEliminated() +  " \nVous n'avez commis aucune faute éliminatoire." + " \nFAVORABLE");
        }
        return score;
    }

    public HashMap<Integer, Scenario> getScenarioHashMap() {
        return scenarioHashMap;
    }

    public HashMap<Integer, Mistake> getMistakes() {
        return mistakes;
    }

    public void setScenarioHashMap(HashMap<Integer, Scenario> scenarioHashMap) {
        this.scenarioHashMap = scenarioHashMap;
    }

    public void setMistakes(HashMap<Integer, Mistake> mistakes) {
        this.mistakes = mistakes;
    }

    public ScoreDescription getScoreDescription() {
        return scoreDescription;
    }
}
