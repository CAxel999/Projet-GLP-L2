package data;

public class Mistake {
    private String name;
    private String message;
    private boolean eliminatory;
    private int number;


    public Mistake(String name,String message, boolean eliminatory) {
        this.message = message;
        this.name = name;
        this.eliminatory = eliminatory;
        this.number = 0;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public boolean isEliminatory() {
        return eliminatory;
    }

    public void incrementNumber() {
        this.number++;
    }

    public int getNumber() {
        return number;
    }
}
