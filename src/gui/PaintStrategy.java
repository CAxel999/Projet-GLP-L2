package gui;

import java.awt.*;

import config.CarConfiguration;
import config.GameConfiguration;
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
		/*for(Road road : city.getRoads().values()){
			graphics.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);
		}*/
	}

	public void paint(MainCar mainCar, Graphics graphics) {
		PixelPosition position = mainCar.getPixelPosition();
		int y = position.getY();
		int x = position.getX();

		double direction = mainCar.getDirection().getValue();
//		if(direction != Math.PI/2){
			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics2D.rotate(-direction,x,y);
			if(mainCar.isClignoGauche()){
				graphics.drawImage(CarConfiguration.CAR_LEFTLIGHT,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2,null);
			} else if(mainCar.isClignoDroit()){
				graphics.drawImage(CarConfiguration.CAR_RIGHTLIGHT,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2,null);
			} else if(mainCar.isAngleMortGauche()){
				graphics.drawImage(CarConfiguration.CAR_LEFTDEAD,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2 - 25,null);
			} else if(mainCar.isAngleMortDroit()){
				graphics.drawImage(CarConfiguration.CAR_RIGHTDEAD,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2,null);
			} else if(mainCar.getBraking()){
				graphics.drawImage(CarConfiguration.CAR_BRAKING,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2,null);
			} else {
				graphics.drawImage(CarConfiguration.CAR,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2,null);
			}


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
