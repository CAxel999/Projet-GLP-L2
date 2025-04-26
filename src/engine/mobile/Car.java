package engine.mobile;

import engine.map.positions.Block;
import engine.map.positions.CarPosition;
import engine.map.positions.PixelPosition;
import engine.map.roads.Road;
import engine.process.ScoreManager;

import java.awt.geom.Line2D;

/**
 * Class of a car object
 *
 * Has a double for speed, a current {@link Road} to log new road encountered, a {@link CarPosition} in double coordinates, a {@link PixelPosition} in int coordinates, a {@link Block} position in block coordinates, 4 edges of {@link Line2D}, 4 boolean for priority, being in braking state, left turn signal and right turn signal
 */
public abstract class Car extends MobileElement{
    private Road currentRoad;
    private double speed;
    private CarPosition realPosition;
    private PixelPosition pixelPosition;
    private boolean priority;
    private boolean braking;

    private Line2D frontSide;
    private Line2D backSide;
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

    public Line2D getFrontSide() {
        return frontSide;
    }

    public Line2D getBackSide() {
        return backSide;
    }

    public Line2D getLeftSide() {
        return leftSide;
    }

    public Line2D getRightSide() {
        return rightSide;
    }

    public void setFrontSide(Line2D frontSide) {
        this.frontSide = frontSide;
    }

    public void setBackSide(Line2D backSide) {
        this.backSide = backSide;
    }

    public void setLeftSide(Line2D leftSide) {
        this.leftSide = leftSide;
    }

    public void setRightSide(Line2D rightSide) {
        this.rightSide = rightSide;
    }

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

    public Road getCurrentRoad() {
        return currentRoad;
    }

    public void setCurrentRoad(Road currentRoad) {
        this.currentRoad = currentRoad;
    }
}