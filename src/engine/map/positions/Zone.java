package engine.map.positions;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Zone  extends Line2D {
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

    @Override
    public double getX1() {
        return 0;
    }

    @Override
    public double getY1() {
        return 0;
    }

    @Override
    public Point2D getP1() {
        return null;
    }

    @Override
    public double getX2() {
        return 0;
    }

    @Override
    public double getY2() {
        return 0;
    }

    @Override
    public Point2D getP2() {
        return null;
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {

    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}
