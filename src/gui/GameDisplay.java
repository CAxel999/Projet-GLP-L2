package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import config.GameConfiguration;
import data.Scenario;
import engine.map.City;
import engine.mobile.MainCar;
import engine.mobile.NPCCar;
import engine.process.MobileInterface;


/**
 * This panel is a dashboard on which is painted the map and the mobile elements such as {@link NPCCar} and {@link MainCar}..
 */
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
		if(GameConfiguration.END){
			System.err.println("FIN");
			paintStrategy.paintEND("Vous avez terminé l'entraînement.", g);
			return;
		}
		if(!GameConfiguration.CRASH) {
			paintStrategy.paint(city, g);

			MainCar mainCar = manager.getA();
			Scenario scenario = mainCar.getScenario();
			if (!GameConfiguration.EXAM) {
				if (manager.getCurrentMistake() != null) {
					paintStrategy.paintMistake(manager.getCurrentMistake().getMessage(), g);
				}
			}
			if (scenario != null) {
				if (!(scenario.isSuccessful() || scenario.isFailed())) {
					paintStrategy.paintScenario(mainCar.getScenario().getText(), g);
				}
			}
			paintStrategy.paint(mainCar, g);
			for (NPCCar car : manager.getNPCCars()) {
				paintStrategy.paint(car, g);
			}
			return;
		}
		MainCar mainCar = manager.getA();
		paintStrategy.paint(mainCar, g);
		for (NPCCar car : manager.getNPCCars()) {
			paintStrategy.paint(car, g);
		}
		paintStrategy.paintCrash("Vous avez eu un accident !", g);


	}

}
