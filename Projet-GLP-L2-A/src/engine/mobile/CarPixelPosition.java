package engine.mobile;


/**
 * Position of the car in pixel
 */
public class CarPixelPosition {
    private int x;
    private int y;

    public CarPixelPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
