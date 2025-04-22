package data;

public class Mistake {
    private static String message ="";
    private int id;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        Mistake.message = message;
    }
}
