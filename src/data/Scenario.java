package data;


/**
 * Class of a Scenario object
 *
 * Has an int as an id, a description and two boolean fo the successful and failed status of the scenario
 */
public class Scenario {
    private int id;
    private String text;
    private boolean successful;
    private boolean failed;

    public Scenario(int id, String text) {
        this.id = id;
        this.text = text;
        this.successful = false;
        this.failed = false;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setSuccessful() {
        if(!failed){
            this.successful = true;
        }
    }

    public void setFailed() {
        if(!successful) {
            this.failed = true;
        }
    }
}
