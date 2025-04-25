package data;


import engine.map.positions.PixelPosition;


/**
 * Class of an Instruction object
 *
 * Has double for speed and direction, a {@link PixelPosition} for its end point and two boolean for the display of turn signal
 */
public class Instruction {
    private double speed;
    private double direction;
    private PixelPosition pixelPosition;
    private boolean turningLeft;
    private boolean turningRight;

    public Instruction(double speed, double direction, PixelPosition pixelPosition, boolean turningLeft, boolean turningRight) {
        this.speed = speed;
        this.direction = direction;
        this.pixelPosition = pixelPosition;
        this.turningLeft = turningLeft;
        this.turningRight = turningRight;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public PixelPosition getPixelPosition() {
        return pixelPosition;
    }

    public boolean isTurningLeft() {
        return turningLeft;
    }

    public boolean isTurningRight() {
        return turningRight;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "speed=" + speed +
                ", direction=" + direction +
                ", pixelPosition=" + pixelPosition +
                '}';
    }
}
