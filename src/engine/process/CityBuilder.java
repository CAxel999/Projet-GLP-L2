package engine.process;

import engine.map.Block;
import engine.map.roads.Crosswalk;
import engine.map.roads.Road;

import java.util.HashMap;

public class CityBuilder {
	
    public HashMap<Block, Road> buildRoads(Block[][] blocks, int lineCount, int columnCount){
        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
            }
        }
        //Construct the roads
        HashMap<Block,Road> roads = new HashMap<Block,Road>();
        roads.put(blocks[lineCount/2][columnCount/2],new Crosswalk(blocks[lineCount/2][columnCount/2],Math.PI/2,2.5));
        return roads;
    }
    
}
