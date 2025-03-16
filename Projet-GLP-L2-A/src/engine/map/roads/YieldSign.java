package engine.map.roads;


import data.MistakeMessage;
import engine.map.Block;
import engine.map.Zone;
import engine.mobile.Car;

public class YieldSign extends Block {

    public YieldSign(int x, int y) {
        super(x, y);
    }


    public boolean mustYield(Car car, Zone zone) {
        if (zone.contains(car) && !car.isPriority()) {
            MistakeMessage.setMessage("La voiture doit céder le passage ");
            return true;
        }
        return false;
    }
}

