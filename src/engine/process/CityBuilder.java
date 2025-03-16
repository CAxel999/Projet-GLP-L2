package engine.process;

import config.GameConfiguration;
import engine.map.positions.Block;
import engine.map.positions.PixelPosition;
import engine.map.positions.Zone;
import engine.map.roads.Crosswalk;
import engine.map.roads.Highway;
import engine.map.roads.Road;

import java.util.HashMap;

public class CityBuilder {
    public void buildRoads(HashMap<Block,Road> roads, Block[][] blocks, int lineCount, int columnCount){

        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
            }
        }

        //Highways
        for(int columnIndex = 0; columnIndex < columnCount; columnIndex++){
            PixelPosition topLeft = new PixelPosition(columnIndex*GameConfiguration.BLOCK_SIZE,3*GameConfiguration.BLOCK_SIZE+1);
            PixelPosition bottomRight = new PixelPosition(columnIndex*GameConfiguration.BLOCK_SIZE+GameConfiguration.BLOCK_SIZE,3*GameConfiguration.BLOCK_SIZE+4);
            Zone zone = new Zone(topLeft, bottomRight);
            Highway highway = new Highway(blocks[3][columnIndex],blocks[2][columnIndex],0,4, zone);
            roads.put(highway.getPosition(),highway);
            roads.put(highway.getSecondPosition(),highway);
        }

        //Construct the roads

    }

    public void highways(HashMap<Block,Road> roads){

    }
}
