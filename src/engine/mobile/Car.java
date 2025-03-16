package engine.mobile;

import engine.map.positions.Block;
import engine.map.positions.CarPosition;
import engine.map.positions.PixelPosition;

public abstract class Car extends MobileElement{
    private double speed;
    private CarPosition realPosition;
    private PixelPosition pixelPosition;
    private boolean priority;

    public Car(Block position) {
        super(position);
        this.priority = false;
    }
    public double getSpeed() {
        return speed;
    }

    public CarPosition getRealPosition() {
        return realPosition;
    }

    public PixelPosition getPixelPosition() {
        return pixelPosition;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setRealPosition(CarPosition realPosition) {
        this.realPosition = realPosition;
    }

    public void setPixelPosition(PixelPosition pixelPosition) {
        this.pixelPosition = pixelPosition;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}
