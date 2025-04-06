package data;

import engine.counters.CyclicCounter;
import engine.map.positions.PixelPosition;

public class Instruction {
    private double speed;
    private double direction;
    private PixelPosition pixelPosition;

    public Instruction(double speed, double direction, PixelPosition pixelPosition) {
        this.speed = speed;
        this.direction = direction;
        this.pixelPosition = pixelPosition;
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

    @Override
    public String toString() {
        return "Instruction{" +
                "speed=" + speed +
                ", direction=" + direction +
                ", pixelPosition=" + pixelPosition +
                '}';
    }
}
