package engine.mobile;

import config.GameConfiguration;
import engine.counters.CyclicCounter;
import engine.map.positions.Block;
import engine.map.positions.PixelPosition;
import engine.map.positions.CarPosition;

public class MainCar extends Car{

	private CyclicCounter direction;
	private boolean angleMortGauche;
	private boolean angleMortDroit;


	public MainCar(Block position) {
		super(position);
		setPixelPosition(new PixelPosition(position.getColumn() * GameConfiguration.BLOCK_SIZE + 20,position.getLine() * GameConfiguration.BLOCK_SIZE + 20));
		setRealPosition(new CarPosition(getPixelPosition().getX(),getPixelPosition().getY()));
		setSpeed(0);
		this.direction = new CyclicCounter(Math.PI/2,Math.PI*2);
	}


	public CyclicCounter getDirection() {
		return direction;
	}


    public boolean isAngleMortGauche() {
        return angleMortGauche;
    }

    public void setAngleMortGauche(boolean angleMortGauche) {
        this.angleMortGauche = angleMortGauche;
    }

    public boolean isAngleMortDroit() {
        return angleMortDroit;
    }

    public void setAngleMortDroit(boolean angleMortDroit) {
        this.angleMortDroit = angleMortDroit;
    }

}