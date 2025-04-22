package data;

public class ScoreDescription {
    private String scenario;
    private String mistake;
    private String eliminated;

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
