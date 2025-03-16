package engine.map.roads;

import engine.map.positions.Block;
import engine.map.positions.Zone;
import engine.process.TypeVisitor;

import java.util.HashMap;

/**
 *Road at the entries of a cross road
 *
 *Is placed at the entries of a crossroad. It can be a cross, a roundabout or a "giratoire".
 *Has a zone that permits to check wether the car is autorized to cross the crossroad or not depending on its priority
 */
public class CrossroadEntry extends Road {
    private HashMap<Block,Road>roads;
    private Zone priorityzone;

    public CrossroadEntry(Block position, double direction, double speedLimit) {
        super(position, direction, speedLimit);
    }

    @Override
    public <T> void accept(TypeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
