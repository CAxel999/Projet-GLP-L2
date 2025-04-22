package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import config.GameConfiguration;
import data.Mistake;
import data.Scenario;
import data.ScenarioMessage;
import engine.map.City;
import engine.mobile.MainCar;
import engine.mobile.NPCCar;
import engine.process.MobileInterface;

public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private City city;
	private MobileInterface manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(City city, MobileInterface manager) {
		this.city = city;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(city, g);

		MainCar mainCar = manager.getA();
		Scenario scenario = mainCar.getScenario();
        if (!GameConfiguration.EXAM) {
            if(mainCar.getCurrentMistake() != null){
                paintStrategy.paintMistake(mainCar.getCurrentMistake().getMessage(), g);
            }
        }
        if(!(scenario.isSuccessful() || scenario.isFailed())){
			paintStrategy.paintScenario(mainCar.getScenario().getText(), g);
		}
		paintStrategy.paint(mainCar, g);
		for(NPCCar car : manager.getNPCCars()){
			paintStrategy.paint(car,g);
		}

	}

}
