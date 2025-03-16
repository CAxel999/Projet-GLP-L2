package gui;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

import data.MistakeMessage;
import engine.map.City;
import engine.mobile.Car;
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

		try {
			paintStrategy.paint(city, g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Car car = manager.getA();
		if(!MistakeMessage.getMessage().isEmpty()){
			paintStrategy.paint(MistakeMessage.getMessage(), g);
		}
		paintStrategy.paint(car.getSpeed(),g);
		try {
			paintStrategy.paint(car, g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
