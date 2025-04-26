package gui;

import config.GameConfiguration;
import engine.map.roads.*;
import engine.process.TypeVisitor;

import java.awt.*;

/**
 *This visitor paints each {@link Road} differently when the program is in debug mode.
 */
public class RoadPaintVisitor implements TypeVisitor<Void> {
    private Graphics g;
    private PaintStrategy strategy;

    public RoadPaintVisitor(PaintStrategy strategy,Graphics g) {
        this.strategy = strategy;
        this.g = g;
    }

    @Override
    public void visit(SimpleRoad road) {
        int x = road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE;
        int y = road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE;
        double direction = road.getDirection();

        g.setColor(Color.GRAY);
        g.fillRect(x,y,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);

        strategy.paintArrow(direction,x,y,g);
    }

    @Override
    public void visit(CrossroadEntry road) {
        g.setColor(Color.GRAY);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);
    }

    @Override
    public void visit(Crosswalk road) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);
    }

    @Override
    public void visit(Highway road) {
        g.setColor(Color.BLACK);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);
    }

    @Override
    public void visit(TrafficLightRoad road) {
        TrafficLight trafficLight = road.getLight();
        if(trafficLight.getColor().equals(TrafficLightEnum.GREEN)){
            g.setColor(Color.GREEN);
        } else if(trafficLight.getColor().equals(TrafficLightEnum.ORANGE)){
            g.setColor(Color.ORANGE);
        } else {
            g.setColor(Color.RED);
        }
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);
    }

    @Override
    public void visit(Crossroad road) {
        g.setColor(Color.BLACK);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);
        g.setColor(Color.WHITE);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE + 19, GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE - 38);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE + 19,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE - 38,GameConfiguration.BLOCK_SIZE);
    }

    @Override
    public void visit(Stop road) {
        g.setColor(Color.RED);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);
        g.setColor(Color.WHITE);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE + 10,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE + 15,GameConfiguration.BLOCK_SIZE - 20 ,GameConfiguration.BLOCK_SIZE - 30);
    }

    @Override
    public void visit(StopExit road) {
        g.setColor(Color.GRAY);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);
    }

    @Override
    public void visit(ScenarioRoad road) {
        int x = road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE;
        int y = road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE;
        double direction = road.getDirection();

        g.setColor(Color.GREEN);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);

        strategy.paintArrow(direction,x,y,g);
    }

    @Override
    public void visit(ResolveRoad road) {
        int x = road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE;
        int y = road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE;
        double direction = road.getDirection();

        g.setColor(Color.BLUE);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);

        strategy.paintArrow(direction,x,y,g);
    }

    @Override
    public void visit(GoalRoad road) {
        g.setColor(Color.MAGENTA);
        g.fillRect(road.getPosition().getColumn() * GameConfiguration.BLOCK_SIZE,road.getPosition().getLine() * GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE,GameConfiguration.BLOCK_SIZE);
    }
}
