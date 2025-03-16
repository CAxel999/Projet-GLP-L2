package gui;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import javax.imageio.ImageIO;

import config.CarConfiguration;
import config.GameConfiguration;
import engine.map.Block;
import engine.map.City;
import engine.map.roads.Road;
import engine.mobile.Car;
import engine.mobile.CarPixelPosition;

/**
 *Strategy for painting graphic elements.
 */
public class PaintStrategy {
	public void paint(City city, Graphics graphics) throws IOException {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		HashMap<Block, Road> roads = city.getRoads();

		/*
		for (Block block : roads.keySet()){
					graphics.setColor(Color.GRAY);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);

		}
		*/
		
		
		graphics.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/Ville.png"))), 0, 0, GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT, null );


		graphics.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i <= GameConfiguration.COLUMN_COUNT; i++) {
			graphics.drawLine(i * GameConfiguration.BLOCK_SIZE, 0, i * GameConfiguration.BLOCK_SIZE, GameConfiguration.LINE_COUNT * GameConfiguration.BLOCK_SIZE);
		}
		for (int i = 0; i <= GameConfiguration.LINE_COUNT; i++) {
			graphics.drawLine(0, i * GameConfiguration.BLOCK_SIZE, GameConfiguration.COLUMN_COUNT * GameConfiguration.BLOCK_SIZE, i * GameConfiguration.BLOCK_SIZE);
		}
	}

	public void paint(Car car, Graphics graphics) throws IOException {
		CarPixelPosition position = car.getPixelPosition();
		int y = position.getY();
		int x = position.getX();

		double direction = car.getDirection().getValue();
//		if(direction != Math.PI/2){
			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics2D.rotate(-direction,x,y);
			//setColor for car
			graphics2D.setColor(Color.BLUE);

			//Temp
			//graphics2D.fillRect(x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2, CarConfiguration.CAR_LENGTH,CarConfiguration.CAR_WIDTH);
			//graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/car.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );

			// Position des différents points qui compose l'angle mort gauche
			int[] xTriangleGauche = {car.getPixelPosition().getX() + 10, car.getPixelPosition().getX()  , car.getPixelPosition().getX() - 20 };
			int[] yTriangleGauche = {car.getPixelPosition().getY() - 15, car.getPixelPosition().getY() - 30 , car.getPixelPosition().getY() - 20};

			// Position des différents points qui compose l'angle mort droit
			int[] xTriangleDroit = {car.getPixelPosition().getX() + 10, car.getPixelPosition().getX()  , car.getPixelPosition().getX() - 20 };
			int[] yTriangleDroit = {car.getPixelPosition().getY() + 15, car.getPixelPosition().getY() + 30 , car.getPixelPosition().getY() + 20};

			//Nombre de points du triangle qui représente l'angle mort de la voiture
			int numberOfPoints = 3;
			//setColor for angle mort
			graphics2D.setColor(Color.RED);


			if(car.isAngleMortGauche()) {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/angle_mort_gauche.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
				graphics2D.fillPolygon(xTriangleGauche, yTriangleGauche, numberOfPoints);

			}
			else if(car.isAngleMortDroit()) {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/angle_mort_droit.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
				graphics2D.fillPolygon(xTriangleDroit, yTriangleDroit, numberOfPoints);
			}

			else if(car.isClignoDroit()) {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/cligno_droit_2.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
			}
			else if(car.isClignoGauche()) {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/cligno_gauche_2.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
			}
			else {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/car.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
			}




			//
			/*
			//graphics2D.fillRect(x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2, CarConfiguration.CAR_LENGTH,CarConfiguration.CAR_WIDTH);
			if(car.isClignoDroit()) {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/clignotant_droit.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
			}
			else if(car.isClignoGauche()) {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/clignotant_gauche.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
			}
			else if(car.isAngleMortDroit()) {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/angle_mort_droit.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
			}
			else if(car.isAngle_mortGauche()) {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/angle_mort_gauche.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
			}
			else if(car.getBraking()) {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/warning.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
			}
			else {
				graphics2D.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/car.png"))), x-CarConfiguration.CAR_LENGTH/2, y-CarConfiguration.CAR_WIDTH/2, null );
			}
			*/
			
			//raphics2D.rotate(direction,x,y);
//		} else {
//			graphics.setColor(Color.RED);
//
//			graphics.fillRect(x-8,y-22,16,45);
//			//graphics.drawImage(SimulationUtility.readImage("src/images/carUp.png"),x+12,y+12,x+28,y+28,16,0,0,16,null);
//		}



	}

	// Dessine les angles morts de la voiture. L'implémenter dans paint(car,graphics) dessiner que si le booleén est true sinon le dessin n'est pas déssiné.
	/*
	public void paint(Car car, Graphics graphics){
		int[] x = {car.getPixelPosition().getX() - 20, car.getPixelPosition().getX() -20, car.getPixelPosition().getX() - 40};
		int[] y = {car.getPixelPosition().getY(), car.getPixelPosition().getY() - 20, car.getPixelPosition().getY() - 20};
		int numberOfPoints = 3;

		Graphics2D g2 = (Graphics2D) graphics;
		g2.setColor(Color.RED);
		g2.drawPolygon(x, y, numberOfPoints);

	}

	 */

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
