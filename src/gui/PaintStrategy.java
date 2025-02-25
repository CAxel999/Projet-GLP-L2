package gui;

import java.awt.*;
import java.util.HashMap;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.City;
import engine.map.Road;
import engine.mobile.Car;
import engine.mobile.CarPosition;

public class PaintStrategy {
	public void paint(City city, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		HashMap<Block, Road> roads = city.getRoads();

		for (Block block : roads.keySet()){
					graphics.setColor(Color.GRAY);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);

		}
	}

	public void paint(Car car, Graphics graphics) {
		CarPosition position = car.getRealPosition();


		int y = position.getY();
		int x = position.getX();
		double direction = car.getDirection().getValue();
//		if(direction != Math.PI/2){
			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics2D.rotate(-direction,x,y);
			graphics2D.setColor(Color.RED);

			graphics2D.fillRect(x-22,y-8,45,16);
			//raphics2D.rotate(direction,x,y);
//		} else {
//			graphics.setColor(Color.RED);
//
//			graphics.fillRect(x-8,y-22,16,45);
//			//graphics.drawImage(SimulationUtility.readImage("src/images/carUp.png"),x+12,y+12,x+28,y+28,16,0,0,16,null);
//		}



	}

	public void paint(String message, Graphics graphics){
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Dialog", Font.PLAIN, 20));
		graphics.drawString(message,300,100);
	}

}
