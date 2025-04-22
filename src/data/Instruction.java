package data;

import engine.counters.CyclicCounter;
import engine.map.positions.PixelPosition;

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
