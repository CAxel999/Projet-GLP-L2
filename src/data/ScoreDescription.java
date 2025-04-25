package data;

/**
 * Class of a ScoreDescription object
 *
 * Has three strings for the description of the {@link Scenario}, {@link Mistake} and of eliminatory mistake
 */
public class ScoreDescription {
    private String scenario = "Les scénarios : \n";
    private String mistake = "Vos erreurs : \n";
    private String eliminated = "Eliminatoire : \n";

    public String getScenario() {
        return scenario;
    }

    public String getMistake() {
        return mistake;
    }

    public String getEliminated() {
        return eliminated;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public void setMistake(String mistake) {
        this.mistake = mistake;
    }

    public void setEliminated(String eliminated) {
        this.eliminated = eliminated;
    }
}
