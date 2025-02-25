package engine.map;

public class Road {
    private double direction;
    private double speedLimit;

    public Road(double direction, double speedLimit) {
        this.direction = direction;
        this.speedLimit = speedLimit;
    }

    public double getDirection() {
        return direction;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }
}
