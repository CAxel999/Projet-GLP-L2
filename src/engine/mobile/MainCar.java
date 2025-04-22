package engine.mobile;

import config.CarConfiguration;
import config.GameConfiguration;
import data.Mistake;
import data.Scenario;
import engine.counters.CyclicCounter;
import engine.map.positions.Block;
import engine.map.positions.PixelPosition;
import engine.map.positions.CarPosition;

import java.awt.geom.Line2D;


public class MainCar extends Car{

	private CyclicCounter direction;
	private boolean angleMortGauche;
	private boolean angleMortDroit;
	private boolean angleMortGauchePriority;
	private boolean angleMortDroitPriority;
	private Scenario scenario;
	private Mistake currentMistake;
	private boolean mistakesWereNotMade;

	public MainCar(Block position) {
		super(position);
		setPixelPosition(new PixelPosition(position.getColumn() * GameConfiguration.BLOCK_SIZE + 20,position.getLine() * GameConfiguration.BLOCK_SIZE + 20));
		setRealPosition(new CarPosition(getPixelPosition().getX(),getPixelPosition().getY()));
		setSpeed(0);
		int x = position.getColumn();
		int y = position.getLine();

		this.direction = new CyclicCounter(Math.PI/2,Math.PI*2);
		double frontLeftCornerX = (x + Math.cos(this.getDirection().getValue() + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontLeftCornerY = (y - Math.sin(this.getDirection().getValue() + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontRightCornerX = (x + Math.cos(this.getDirection().getValue() - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double frontRightCornerY = (y - Math.sin(this.getDirection().getValue() - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backLeftCornerX = (x + Math.cos(this.getDirection().getValue() + Math.PI - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backLeftCornerY = (y - Math.sin(this.getDirection().getValue() + Math.PI - 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double bachRightCornerX = (x + Math.cos(this.getDirection().getValue() + Math.PI + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		double backRightCornerY = (y - Math.sin(this.getDirection().getValue() + Math.PI + 0.62) * CarConfiguration.CAR_INNERDIAGONAL/2);
		super.setFrontSide(new Line2D.Double(frontLeftCornerX,frontLeftCornerY,frontRightCornerX,frontRightCornerY));
		super.setBackSide(new Line2D.Double(backLeftCornerX,backLeftCornerY,bachRightCornerX,backRightCornerY));
		super.setLeftSide(new Line2D.Double(frontLeftCornerX,frontLeftCornerY,backLeftCornerX,backLeftCornerY));
		super.setRightSide(new Line2D.Double(frontRightCornerX,frontRightCornerY,bachRightCornerX,backRightCornerY));
	}


	public CyclicCounter getDirection() {
		return direction;
	}

	public Scenario getScenario() {
		return scenario;
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

	public boolean isAngleMortGauchePriority() {
		return angleMortGauchePriority;
	}

	public void setAngleMortGauchePriority(boolean angleMortGauchePriority) {
		this.angleMortGauchePriority = angleMortGauchePriority;
	}

	public boolean isAngleMortDroitPriority() {
		return angleMortDroitPriority;
	}

	public void setAngleMortDroitPriority(boolean angleMortDroitPriority) {
		this.angleMortDroitPriority = angleMortDroitPriority;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public Mistake getCurrentMistake() {
		return currentMistake;
	}

	public void setCurrentMistake(Mistake currentMistake) {
		this.currentMistake = currentMistake;
	}

	public void resetCurrentMistake() {
		this.currentMistake = null;
	}

	public boolean isMistakesWereNotMade() {
		return mistakesWereNotMade;
	}

	public void setMistakesWereNotMade(boolean mistakesWereNotMade) {
		this.mistakesWereNotMade = mistakesWereNotMade;
	}
}