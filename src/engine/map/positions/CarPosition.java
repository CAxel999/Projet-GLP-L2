package engine.map.positions;

/**
 * Position of the car with floating point number
 */
public class CarPosition {
    private double x;
    private double y;

    public CarPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
