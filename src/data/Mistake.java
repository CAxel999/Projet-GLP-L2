package data;

/**
 * Class of a Mistake object
 *
 * Has an int as an id, a name, a description a boolean for its eliminatory status and a int for the number of time the mistake was made
 */
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
        System.err.println(number);
    }

    public int getNumber() {
        return number;
    }
}
