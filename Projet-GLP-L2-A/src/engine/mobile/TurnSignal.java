package engine.mobile;

import engine.map.Block;
public class TurnSignal {
    private boolean turnLeft;
    private boolean turnRight;



    public TurnSignal() {
        this.turnLeft = false;
        this.turnRight = false;
    }


    public void setTurnLeft(boolean state) {
        if (state) {
            turnRight = false;
        }
        this.turnLeft = state;
    }


    public void setTurnRight(boolean state) {
        if (state) {
            turnLeft = false;
        }
        this.turnRight = state;
    }

    public boolean isTurningLeft() {
        return turnLeft;
    }


    public boolean isTurningRight() {
        return turnRight;
    }
}

