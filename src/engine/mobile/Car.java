package engine.mobile;

import engine.map.positions.Block;
import engine.map.positions.CarPosition;
import engine.map.positions.PixelPosition;

import java.awt.geom.Line2D;

public abstract class Car extends MobileElement{
    private double speed;
    private CarPosition realPosition;
    private PixelPosition pixelPosition;
    private boolean priority;
    private boolean braking;

    private Line2D topSide;
    private Line2D  bottomSide;
    private Line2D leftSide;
    private Line2D rightSide;


    private boolean clignoGauche;
    private boolean clignoDroit;

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

    public Line2D getTopSide() {
        return topSide;
    }

    public Line2D getBottomSide() {
        return bottomSide;
    }

    public Line2D getLeftSide() {
        return leftSide;
    }

    public Line2D getRightSide() {
        return rightSide;
    }
    /*public Line2D getFront() {
        return front;
    }

    public Line2D getBack() {
        return back;
    }

    public Line2D getLeft() {
        return left;
    }

    public Line2D getRight() {
        return right;
    }*/
    public boolean isClignoDroit() {
        return clignoDroit;
    }
    public boolean isClignoGauche() {
        return clignoGauche;
    }
    public boolean getBraking() {
        return braking;
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



    public void setBraking(Boolean braking) {
        this.braking = braking;
    }

    public void setClignoDroit(boolean clignoDroit) {
        this.clignoDroit = clignoDroit;
    }


    public void setClignoGauche(boolean clignoGauche) {
        this.clignoGauche = clignoGauche;
    }
}