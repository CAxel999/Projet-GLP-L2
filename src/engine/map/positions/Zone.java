package engine.map.positions;

public class Zone {
    private PixelPosition topLeft;
    private PixelPosition bottomRight;

    public Zone(PixelPosition topLeft, PixelPosition bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public PixelPosition getTopLeft() {
        return topLeft;
    }

    public PixelPosition getBottomRight() {
        return bottomRight;
    }
}
