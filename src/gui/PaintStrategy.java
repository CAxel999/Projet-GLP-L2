package gui;

import java.awt.*;

import config.CarConfiguration;
import engine.map.City;
import engine.map.roads.Highway;
import engine.map.roads.Road;
import engine.mobile.MainCar;
import engine.map.positions.PixelPosition;
import engine.mobile.NPCCar;

/**
 *Strategy for painting graphic elements.
 */
public class PaintStrategy {
	public void paint(City city, Graphics graphics) {
		graphics.drawImage(city.getMap(),0,0,null);
		for(Road road : city.getRoads().values()){
			graphics.setColor(Color.PINK);
			Highway highway = (Highway) road;
			graphics.drawLine(highway.getCrossingSection().getTopLeft().getX(),highway.getCrossingSection().getTopLeft().getY(),highway.getCrossingSection().getBottomRight().getX(),highway.getCrossingSection().getBottomRight().getY());
		}
	}

	public void paint(MainCar mainCar, Graphics graphics) {
		PixelPosition position = mainCar.getPixelPosition();
		int y = position.getY();
		int x = position.getX();

		double direction = mainCar.getDirection().getValue();
//		if(direction != Math.PI/2){
			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics2D.rotate(-direction,x,y);
			graphics2D.setColor(Color.RED);

			graphics2D.fillRect(x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2, CarConfiguration.CAR_LENGTH,CarConfiguration.CAR_WIDTH);

			graphics2D.rotate(direction,x,y);
//		} else {
//			graphics.setColor(Color.RED);
//
//			graphics.fillRect(x-8,y-22,16,45);
//			//graphics.drawImage(SimulationUtility.readImage("src/images/carUp.png"),x+12,y+12,x+28,y+28,16,0,0,16,null);
//		}



	}
	public void paint(NPCCar car, Graphics graphics) {
		PixelPosition position = car.getPixelPosition();
		int y = position.getY();
		int x = position.getX();

		double direction = car.getDirection();
		System.err.println(x +" "+ y);
//		if(direction != Math.PI/2){
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.rotate(-direction,x,y);
		graphics2D.setColor(Color.BLUE);

		graphics2D.fillRect(x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2, CarConfiguration.CAR_LENGTH,CarConfiguration.CAR_WIDTH);
		graphics2D.rotate(direction,x,y);
//		} else {
//			graphics.setColor(Color.RED);
//
//			graphics.fillRect(x-8,y-22,16,45);
//			//graphics.drawImage(SimulationUtility.readImage("src/images/carUp.png"),x+12,y+12,x+28,y+28,16,0,0,16,null);
//		}



	}

	public void paint(double speed, Graphics graphics){
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Dialog", Font.PLAIN, 50));
		graphics.drawString(Double.toString(speed),1600,800);
	}

	public void paint(String message, Graphics graphics){
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Dialog", Font.PLAIN, 20));
		graphics.drawString(message,300,100);
	}

}
