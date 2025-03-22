package engine.mobile;

import config.GameConfiguration;
import data.Instruction;
import engine.map.positions.Block;
import engine.map.positions.CarPosition;
import engine.map.positions.PixelPosition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class NPCCar extends Car {
    private double direction;
    private ArrayList<Instruction> instructions;
    private Iterator<Instruction> currentIterator;
    private Instruction currentInstruction;

    public NPCCar(Block position, ArrayList<Instruction> instructions, Iterator<Instruction> currentInterator, Instruction currentInstruction) {
        super(position);
        setPixelPosition(new PixelPosition(position.getColumn() * GameConfiguration.BLOCK_SIZE + 20,position.getLine() * GameConfiguration.BLOCK_SIZE + 20));
        setRealPosition(new CarPosition(getPixelPosition().getX(),getPixelPosition().getY()));
        this.instructions = instructions;
        setSpeed(currentInstruction.getSpeed());
        this.currentIterator = currentInterator;
        this.currentInstruction = currentInstruction;
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
