package exception;

/**
 * Exception to thrown in the event of a {@link engine.mobile.MainCar} crashing.
 */
public class CarCrashException extends Exception {
    public CarCrashException(String message) {
        super(message);
    }
}
