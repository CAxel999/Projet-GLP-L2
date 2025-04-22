package engine.map.roads;

import engine.map.positions.PixelPosition;

public class TrafficLight {
    private PixelPosition position;
    private TrafficLightEnum color;

    public TrafficLight(PixelPosition position, TrafficLightEnum color) {
        this.position = position;
        this.color = color;
    }

    public PixelPosition getPosition() {
        return position;
    }

    public TrafficLightEnum getColor() {
        return color;
    }

    public void setColor(TrafficLightEnum color) {
        this.color = color;
    }
}
