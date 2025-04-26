package engine.mobile;

import config.CarConfiguration;
import config.GameConfiguration;
import data.Instruction;
import data.Scenario;
import engine.counters.CyclicCounter;
import engine.map.positions.Block;
import engine.map.positions.CarPosition;
import engine.map.positions.PixelPosition;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class of a NPCCar object
 *
 * Has a double for direction, an ArrayList {@link Instruction}, a current Instruction and an iterator to iterate on the list
 */
public class NPCCar extends Car {
    private double direction;
    private ArrayList<Instruction> instructions;
    private Iterator<Instruction> currentIterator;
    private Instruction currentInstruction;

    public NPCCar(Block position, ArrayList<Instruction> instructions, Iterator<Instruction> currentInterator, Instruction currentInstruction) {
        super(position);
        double x = position.getColumn() * GameConfiguration.BLOCK_SIZE + 20;
        double y = position.getLine() * GameConfiguration.BLOCK_SIZE + 20;
        setPixelPosition(new PixelPosition((int) x, (int) y));
        setRealPosition(new CarPosition(getPixelPosition().getX(),getPixelPosition().getY()));

        this.instructions = instructions;
        setSpeed(currentInstruction.getSpeed());
        this.currentIterator = currentInterator;
        this.currentInstruction = currentInstruction;

        double frontLeftCornerX = (x + Math.cos(this.getDirection() + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
        double frontLeftCornerY = (y - Math.sin(this.getDirection() + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
        double frontRightCornerX = (x + Math.cos(this.getDirection() - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
        double frontRightCornerY = (y - Math.sin(this.getDirection() - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
        double backLeftCornerX = (x + Math.cos(this.getDirection() + Math.PI - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
        double backLeftCornerY = (y - Math.sin(this.getDirection() + Math.PI - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
        double bachRightCornerX = (x + Math.cos(this.getDirection() + Math.PI + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
        double backRightCornerY = (y - Math.sin(this.getDirection() + Math.PI + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
        super.setFrontSide(new Line2D.Double(frontLeftCornerX,frontLeftCornerY,frontRightCornerX,frontRightCornerY));
        super.setBackSide(new Line2D.Double(backLeftCornerX,backLeftCornerY,bachRightCornerX,backRightCornerY));
        super.setLeftSide(new Line2D.Double(frontLeftCornerX,frontLeftCornerY,backLeftCornerX,backLeftCornerY));
        super.setRightSide(new Line2D.Double(frontRightCornerX,frontRightCornerY,bachRightCornerX,backRightCornerY));
    }

    public double getDirection() {
        return direction;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public Iterator<Instruction> getCurrentIterator() {
        return currentIterator;
    }

    public Instruction getCurrentInstruction() {
        return currentInstruction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void setCurrentIterator(Iterator<Instruction> currentIterator) {
        this.currentIterator = currentIterator;
    }

    public void setCurrentInstruction(Instruction currentInstruction) {
        this.currentInstruction = currentInstruction;
    }
}
