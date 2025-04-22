package data;

public class Mistake {
    private int id;
    private String name;
    private String message;
    private boolean eliminatory;
    private int number;


    public Mistake(int id, String name,String message, boolean eliminatory) {
        this.id = id;
        this.message = message;
        this.name = name;
        this.eliminatory = eliminatory;
        this.number = 0;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
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
