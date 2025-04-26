package data;

public class ScenarioMessage {
    private static String message ="";

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        ScenarioMessage.message = message;
    }
}
