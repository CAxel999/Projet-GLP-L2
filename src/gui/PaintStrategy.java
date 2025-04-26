package gui;

import java.awt.*;

import config.CarConfiguration;
import config.GameConfiguration;
import engine.map.City;
import engine.map.roads.Road;
import engine.map.roads.TrafficLight;
import engine.map.roads.TrafficLightEnum;
import engine.mobile.Car;
import engine.mobile.MainCar;
import engine.map.positions.PixelPosition;
import engine.mobile.NPCCar;

/**
 *Strategy for painting graphic elements.
 */
public class PaintStrategy {
	int timedPaint1;
	int timedPaint2;

	public PaintStrategy() {
		this.timedPaint1 = 0;
		this.timedPaint2 = 0;
	}

	public void paint(City city, Graphics graphics) {
        if (GameConfiguration.DEBUG) {
			RoadPaintVisitor visitor = new RoadPaintVisitor(this,graphics);
            for(Road road : city.getRoads().values()){
                road.accept(visitor);
            }
        } else {
			graphics.drawImage(city.getMap(),0,0,null);
		}

        for(TrafficLight trafficLight : city.getLights()){
			int x = trafficLight.getPosition().getX();
			int y = trafficLight.getPosition().getY();
			if(trafficLight.getColor().equals(TrafficLightEnum.GREEN)){
				graphics.drawImage(GameConfiguration.GREEN_LIGHT,x,y,null);
			} else if(trafficLight.getColor().equals(TrafficLightEnum.ORANGE)){
				graphics.drawImage(GameConfiguration.ORANGE_LIGHT,x,y,null);
			} else {
				graphics.drawImage(GameConfiguration.RED_LIGHT,x,y,null);
			}

		}
	}

	public void paint(MainCar mainCar, Graphics graphics) {
		PixelPosition position = mainCar.getPixelPosition();
		int y = position.getY();
		int x = position.getX();
		timedPaint1++;
		double direction = mainCar.getDirection().getValue();
		Graphics2D graphics2D = (Graphics2D) graphics;

		graphics2D.rotate(-direction,x,y);
		if(mainCar.isClignoGauche() && timedPaint1 > 45){
			graphics.drawImage(CarConfiguration.CAR_LEFTLIGHT,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2,null);
			if(timedPaint1 > 90){
				timedPaint1 = 0;
			}
		} else if(mainCar.isClignoDroit() && timedPaint1 > 45){
			graphics.drawImage(CarConfiguration.CAR_RIGHTLIGHT,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2,null);
			if(timedPaint1 > 90){
				timedPaint1 = 0;
			}
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

		paintCarDebug(graphics2D,mainCar);
	}

	private void paintCarDebug(Graphics2D graphics2D, Car car){
		if(GameConfiguration.DEBUG){
			graphics2D.setColor(Color.RED);
			graphics2D.draw(car.getFrontSide());
			graphics2D.draw(car.getLeftSide());
			graphics2D.draw(car.getRightSide());
			graphics2D.draw(car.getBackSide());
		}
	}

	public void paint(NPCCar car, Graphics graphics) {
		PixelPosition position = car.getPixelPosition();
		int y = position.getY();
		int x = position.getX();
		timedPaint2++;
		double direction = car.getDirection();
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.rotate(-direction,x,y);
		graphics2D.setColor(Color.RED);
		if(car.isClignoGauche() && timedPaint2 > 45){
			graphics.drawImage(CarConfiguration.NPCCAR_LEFTLIGHT,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2,null);
			if(timedPaint2 > 90){
				timedPaint2 = 0;
			}
		} else if(car.isClignoDroit() && timedPaint2 > 45) {
			graphics.drawImage(CarConfiguration.NPCCAR_RIGHTLIGHT, x - CarConfiguration.CAR_LENGTH / 2, y - CarConfiguration.CAR_WIDTH / 2, null);
			if(timedPaint2 > 90){
				timedPaint2 = 0;
			}
		} else if(car.getBraking()){
			graphics.drawImage(CarConfiguration.NPCCAR_BRAKING,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2,null);
		} else {
			graphics.drawImage(CarConfiguration.NPCCAR,x-CarConfiguration.CAR_LENGTH/2,y-CarConfiguration.CAR_WIDTH/2,null);
		}
		graphics2D.rotate(direction,x,y);

		paintCarDebug(graphics2D,car);
	}

	public void paint(double speed, Graphics graphics, int x, int y){
		speed = speed*10*3.6;
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Dialog", Font.PLAIN, 30));
		graphics.drawString(Double.toString(speed),x,y);
		graphics.drawString("km/h",x,y + 30);
	}

	public void paintMistake(String message, Graphics graphics){
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Dialog", Font.PLAIN, 30));
		graphics.drawString(message,900,900);
	}

	public void paintScenario(String message, Graphics graphics){
		graphics.setColor(Color.GREEN);
		graphics.setFont(new Font("Dialog", Font.PLAIN, 30));
		graphics.drawString(message,200,900);
	}

	public void paintCrash(String message, Graphics graphics){
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Dialog", Font.PLAIN, 60));
		graphics.drawString(message,500,400);
	}

	public void paintEND(String message, Graphics graphics){
		graphics.setColor(Color.BLUE);
		graphics.setFont(new Font("Dialog", Font.PLAIN, 60));
		graphics.drawString(message,500,400);
	}

	public void paintArrow(double direction, int x, int y,Graphics g){
		g.setColor(Color.WHITE);
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.rotate(-direction + Math.PI/2,x+20,y+20);
		graphics2D.drawLine(x + 20,y,x+40,y+40);
		graphics2D.drawLine(x + 20,y,x,y+40);
		graphics2D.rotate(direction - Math.PI/2,x+20,y+20);
	}
}
