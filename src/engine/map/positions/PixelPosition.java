package engine.map.positions;


/**
 * Position with int coordinate
 */
public class PixelPosition {
    private int x;
    private int y;

    public PixelPosition(int x, int y) {
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
