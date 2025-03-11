package data;

public class MistakeMessage {
    private static String message ="";

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        MistakeMessage.message = message;
    }
}
