package engine.process;

import config.GameConfiguration;
import engine.map.positions.Block;
import engine.map.positions.PixelPosition;
import engine.map.positions.Zone;
import engine.map.roads.*;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;

public class CityBuilder {
    public void buildRoads(HashMap<Block,Road> roads, Block[][] blocks, int lineCount, int columnCount){
        double up = Math.PI/2;
        double down = 3*Math.PI/2;
        double left = Math.PI;
        double right = 0;

        double limit50 = 2.3;
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
            ArrayList<Line2D> limits = new ArrayList<Line2D>();
            limits.add(new Line2D.Double(columnIndex*GameConfiguration.BLOCK_SIZE,2*GameConfiguration.BLOCK_SIZE+1,(columnIndex+1)*GameConfiguration.BLOCK_SIZE,2*GameConfiguration.BLOCK_SIZE+1));
            limits.add(new Line2D.Double(columnIndex*GameConfiguration.BLOCK_SIZE,4*GameConfiguration.BLOCK_SIZE,(columnIndex+1)*GameConfiguration.BLOCK_SIZE,4*GameConfiguration.BLOCK_SIZE));
            Highway highway = new Highway(blocks[3][columnIndex],0,4,limits,blocks[2][columnIndex], zone);
            roads.put(highway.getPosition(),highway);
            roads.put(highway.getSecondPosition(),highway);
        }

        //Crossroads
        Crossroad crossroad1 = new Crossroad(blocks[19][1],limit50,new ArrayList<Line2D>());
        roads.put(crossroad1.getPosition(),crossroad1);

        Crossroad crossroad2 = new Crossroad(blocks[20][1],limit50,new ArrayList<Line2D>());
        roads.put(crossroad2.getPosition(),crossroad2);

        Crossroad crossroad3 = new Crossroad(blocks[12][1],limit50,new ArrayList<Line2D>());
        roads.put(crossroad3.getPosition(),crossroad3);

        Crossroad crossroad4 = new Crossroad(blocks[13][1],limit50,new ArrayList<Line2D>());
        roads.put(crossroad4.getPosition(),crossroad4);

        Crossroad crossroad5 = new Crossroad(blocks[19][10],limit50,new ArrayList<Line2D>());
        roads.put(crossroad5.getPosition(),crossroad5);

        Crossroad crossroad6 = new Crossroad(blocks[19][11],limit50,new ArrayList<Line2D>());
        roads.put(crossroad6.getPosition(),crossroad6);

        Crossroad crossroad7 = new Crossroad(blocks[20][10],limit50,new ArrayList<Line2D>());
        roads.put(crossroad7.getPosition(),crossroad7);

        Crossroad crossroad8 = new Crossroad(blocks[20][11],limit50,new ArrayList<Line2D>());
        roads.put(crossroad8.getPosition(),crossroad8);

        Crossroad crossroad9 = new Crossroad(blocks[5][10],limit50,new ArrayList<Line2D>());
        roads.put(crossroad9.getPosition(),crossroad9);

        Crossroad crossroad10 = new Crossroad(blocks[5][11],limit50,new ArrayList<Line2D>());
        roads.put(crossroad10.getPosition(),crossroad10);

        Crossroad crossroad11 = new Crossroad(blocks[6][10],limit50,new ArrayList<Line2D>());
        roads.put(crossroad11.getPosition(),crossroad11);

        Crossroad crossroad12 = new Crossroad(blocks[6][11],limit50,new ArrayList<Line2D>());
        roads.put(crossroad12.getPosition(),crossroad12);

        Crossroad crossroad13 = new Crossroad(blocks[5][20],limit50,new ArrayList<Line2D>());
        roads.put(crossroad13.getPosition(),crossroad13);

        Crossroad crossroad14 = new Crossroad(blocks[6][20],limit50,new ArrayList<Line2D>());
        roads.put(crossroad14.getPosition(),crossroad14);

        Crossroad crossroad15 = new Crossroad(blocks[5][21],limit50,new ArrayList<Line2D>());
        roads.put(crossroad15.getPosition(),crossroad15);

        Crossroad crossroad16 = new Crossroad(blocks[6][21],limit50,new ArrayList<Line2D>());
        roads.put(crossroad16.getPosition(),crossroad16);

        Crossroad crossroad17 = new Crossroad(blocks[12][20],limit50,new ArrayList<Line2D>());
        roads.put(crossroad17.getPosition(),crossroad17);

        Crossroad crossroad18 = new Crossroad(blocks[13][20],limit50,new ArrayList<Line2D>());
        roads.put(crossroad18.getPosition(),crossroad18);

        Crossroad crossroad19 = new Crossroad(blocks[12][21],limit50,new ArrayList<Line2D>());
        roads.put(crossroad19.getPosition(),crossroad19);

        Crossroad crossroad20 = new Crossroad(blocks[13][21],limit50,new ArrayList<Line2D>());
        roads.put(crossroad20.getPosition(),crossroad20);

        Crossroad crossroad21 = new Crossroad(blocks[5][30],limit50,new ArrayList<Line2D>());
        roads.put(crossroad21.getPosition(),crossroad21);

        Crossroad crossroad22 = new Crossroad(blocks[5][31],limit50,new ArrayList<Line2D>());
        roads.put(crossroad22.getPosition(),crossroad22);

        Crossroad crossroad23 = new Crossroad(blocks[6][30],limit50,new ArrayList<Line2D>());
        roads.put(crossroad23.getPosition(),crossroad23);

        Crossroad crossroad24 = new Crossroad(blocks[6][31],limit50,new ArrayList<Line2D>());
        roads.put(crossroad24.getPosition(),crossroad24);

        Crossroad crossroad25= new Crossroad(blocks[19][43],limit50,new ArrayList<Line2D>());
        roads.put(crossroad25.getPosition(),crossroad25);

        Crossroad crossroad26 = new Crossroad(blocks[19][42],limit50,new ArrayList<Line2D>());
        roads.put(crossroad26.getPosition(),crossroad26);

        Crossroad crossroad27 = new Crossroad(blocks[20][43],limit50,new ArrayList<Line2D>());
        roads.put(crossroad27.getPosition(),crossroad27);

        Crossroad crossroad28 = new Crossroad(blocks[20][42],limit50,new ArrayList<Line2D>());
        roads.put(crossroad28.getPosition(),crossroad28);

        Crossroad crossroad29 = new Crossroad(blocks[19][30],limit50,new ArrayList<Line2D>());
        roads.put(crossroad29.getPosition(),crossroad29);

        Crossroad crossroad30 = new Crossroad(blocks[19][31],limit50,new ArrayList<Line2D>());
        roads.put(crossroad30.getPosition(),crossroad30);

        Crossroad crossroad31 = new Crossroad(blocks[20][30],limit50,new ArrayList<Line2D>());
        roads.put(crossroad31.getPosition(),crossroad31);

        Crossroad crossroad32 = new Crossroad(blocks[20][31],limit50,new ArrayList<Line2D>());
        roads.put(crossroad32.getPosition(),crossroad32);

        Crossroad crossroad33 = new Crossroad(blocks[12][42],limit50,new ArrayList<Line2D>());
        roads.put(crossroad33.getPosition(),crossroad33);

        Crossroad crossroad34 = new Crossroad(blocks[12][43],limit50,new ArrayList<Line2D>());
        roads.put(crossroad34.getPosition(),crossroad34);

        Crossroad crossroad35 = new Crossroad(blocks[13][42],limit50,new ArrayList<Line2D>());
        roads.put(crossroad35.getPosition(),crossroad35);

        Crossroad crossroad36 = new Crossroad(blocks[13][43],limit50,new ArrayList<Line2D>());
        roads.put(crossroad36.getPosition(),crossroad36);

        //Entry of Crossroads
        CrossroadEntry crossroadEntry1 = new CrossroadEntry(blocks[20][0],right,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry2 = new CrossroadEntry(blocks[21][1],up,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry3 = new CrossroadEntry(blocks[19][2],left,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry4 = new CrossroadEntry(blocks[18][1],down,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry1.getPosition(),crossroadEntry1);
        roads.put(crossroadEntry2.getPosition(),crossroadEntry2);
        roads.put(crossroadEntry3.getPosition(),crossroadEntry3);
        roads.put(crossroadEntry4.getPosition(),crossroadEntry4);

        CrossroadEntry crossroadEntry5 = new CrossroadEntry(blocks[20][9],right,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry6 = new CrossroadEntry(blocks[18][10],right,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry5.getPosition(),crossroadEntry5);
        roads.put(crossroadEntry6.getPosition(),crossroadEntry6);

        CrossroadEntry crossroadEntry7 = new CrossroadEntry(blocks[13][7],right,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry8 = new CrossroadEntry(blocks[16][11],up,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry9 = new CrossroadEntry(blocks[12][14],left,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry10 = new CrossroadEntry(blocks[9][10],down,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry7.getPosition(),crossroadEntry7);
        roads.put(crossroadEntry8.getPosition(),crossroadEntry8);
        roads.put(crossroadEntry9.getPosition(),crossroadEntry9);
        roads.put(crossroadEntry10.getPosition(),crossroadEntry10);

        CrossroadEntry crossroadEntry11 = new CrossroadEntry(blocks[7][11],up,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry12 = new CrossroadEntry(blocks[5][12],left,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry11.getPosition(),crossroadEntry11);
        roads.put(crossroadEntry12.getPosition(),crossroadEntry12);

        CrossroadEntry crossroadEntry13 = new CrossroadEntry(blocks[13][19],right,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry14 = new CrossroadEntry(blocks[14][21],up,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry15 = new CrossroadEntry(blocks[12][22],left,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry16 = new CrossroadEntry(blocks[11][20],down,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry13.getPosition(),crossroadEntry13);
        roads.put(crossroadEntry14.getPosition(),crossroadEntry14);
        roads.put(crossroadEntry15.getPosition(),crossroadEntry15);
        roads.put(crossroadEntry16.getPosition(),crossroadEntry16);

        CrossroadEntry crossroadEntry17 = new CrossroadEntry(blocks[6][19],right,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry18 = new CrossroadEntry(blocks[7][21],up,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry19 = new CrossroadEntry(blocks[5][22],left,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry17.getPosition(),crossroadEntry17);
        roads.put(crossroadEntry18.getPosition(),crossroadEntry18);
        roads.put(crossroadEntry19.getPosition(),crossroadEntry19);

        CrossroadEntry crossroadEntry20 = new CrossroadEntry(blocks[19][32],left,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry21 = new CrossroadEntry(blocks[18][30],down,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry20.getPosition(),crossroadEntry20);
        roads.put(crossroadEntry21.getPosition(),crossroadEntry21);

        CrossroadEntry crossroadEntry22 = new CrossroadEntry(blocks[13][26],right,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry23 = new CrossroadEntry(blocks[17][31],up,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry24 = new CrossroadEntry(blocks[12][35],left,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry25 = new CrossroadEntry(blocks[8][30],down,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry22.getPosition(),crossroadEntry22);
        roads.put(crossroadEntry23.getPosition(),crossroadEntry23);
        roads.put(crossroadEntry24.getPosition(),crossroadEntry24);
        roads.put(crossroadEntry25.getPosition(),crossroadEntry25);

        CrossroadEntry crossroadEntry26 = new CrossroadEntry(blocks[6][29],right,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry27 = new CrossroadEntry(blocks[7][31],up,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry26.getPosition(),crossroadEntry26);
        roads.put(crossroadEntry27.getPosition(),crossroadEntry27);

        CrossroadEntry crossroadEntry28 = new CrossroadEntry(blocks[20][41],right,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry29 = new CrossroadEntry(blocks[21][43],up,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        CrossroadEntry crossroadEntry30 = new CrossroadEntry(blocks[18][42],down,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry28.getPosition(),crossroadEntry28);
        roads.put(crossroadEntry29.getPosition(),crossroadEntry29);
        roads.put(crossroadEntry30.getPosition(),crossroadEntry30);

        //Crosswalks
        Crosswalk crosswalk1 = new Crosswalk(blocks[13][27],right,limit50,new ArrayList<Line2D>());
        Crosswalk crosswalk2 = new Crosswalk(blocks[12][27],left,limit50,new ArrayList<Line2D>());
        roads.put(crosswalk1.getPosition(),crosswalk1);
        roads.put(crosswalk2.getPosition(),crosswalk2);

        Crosswalk crosswalk3 = new Crosswalk(blocks[16][30],down,limit50,new ArrayList<Line2D>());
        Crosswalk crosswalk4 = new Crosswalk(blocks[16][31],up,limit50,new ArrayList<Line2D>());
        roads.put(crosswalk3.getPosition(),crosswalk3);
        roads.put(crosswalk4.getPosition(),crosswalk4);

        Crosswalk crosswalk5 = new Crosswalk(blocks[13][34],right,limit50,new ArrayList<Line2D>());
        Crosswalk crosswalk6 = new Crosswalk(blocks[12][34],left,limit50,new ArrayList<Line2D>());
        roads.put(crosswalk5.getPosition(),crosswalk5);
        roads.put(crosswalk6.getPosition(),crosswalk6);

        Crosswalk crosswalk7 = new Crosswalk(blocks[9][30],down,limit50,new ArrayList<Line2D>());
        Crosswalk crosswalk8 = new Crosswalk(blocks[9][31],up,limit50,new ArrayList<Line2D>());
        roads.put(crosswalk7.getPosition(),crosswalk7);
        roads.put(crosswalk8.getPosition(),crosswalk8);

        Crosswalk crosswalk9 = new Crosswalk(blocks[13][41],right,limit50,new ArrayList<Line2D>());
        Crosswalk crosswalk10 = new Crosswalk(blocks[12][41],left,limit50,new ArrayList<Line2D>());
        roads.put(crosswalk9.getPosition(),crosswalk9);
        roads.put(crosswalk10.getPosition(),crosswalk10);

        Crosswalk crosswalk11 = new Crosswalk(blocks[14][42],right,limit50,new ArrayList<Line2D>());
        Crosswalk crosswalk12 = new Crosswalk(blocks[14][43],right,limit50,new ArrayList<Line2D>());
        roads.put(crosswalk11.getPosition(),crosswalk11);
        roads.put(crosswalk12.getPosition(),crosswalk12);

        //Stop
        Stop stop1 = new Stop(blocks[5][22], left, limit50,new HashMap<Block, Road>(), new ArrayList<Line2D>(), new Line2D.Double());

        //SimpleRoad
        SimpleRoad spr1= new SimpleRoad(blocks[21][42], down,limit50 ,new ArrayList<Line2D>());
        SimpleRoad spr2 = new SimpleRoad(blocks[22][42], down, limit50 ,new ArrayList<Line2D>());
        SimpleRoad spr3 = new SimpleRoad(blocks[22][43], up, limit50 ,new ArrayList<Line2D>());
        roads.put(spr1.getPosition(), spr1);
        roads.put(spr2.getPosition(), spr2);
        roads.put(spr3.getPosition(), spr3);

        for(int col= 33 ; col <= 41; col++){
            SimpleRoad spr = new SimpleRoad(blocks[19][col], left,limit50,new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col= 32 ; col <= 40; col++){
            SimpleRoad spr = new SimpleRoad(blocks[20][col], right, limit50 ,new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int line= 15 ; line <= 17; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][42], down, limit50 ,new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int line= 16 ; line <= 18; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][43], up, limit50 ,new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }
        for(int line= 17 ; line <= 18; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][30], down,limit50 ,new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        SimpleRoad spr4 = new SimpleRoad(blocks[18][31], up, limit50 ,new ArrayList<Line2D>());
        roads.put(spr4.getPosition(), spr4);

        SimpleRoad spr5 = new SimpleRoad(blocks[13][43], right, limit50 ,new ArrayList<Line2D>());
        roads.put(spr5.getPosition(), spr5);

        for(int col= 36 ; col <= 40; col++){
            SimpleRoad spr = new SimpleRoad(blocks[12][col], left,limit50 ,new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col= 35 ; col <= 39; col++){
            SimpleRoad spr = new SimpleRoad(blocks[13][col], right,limit50 ,new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        SimpleRoad spr6= new SimpleRoad(blocks[8][31], up,limit50 ,new ArrayList<Line2D>());
        roads.put(spr6.getPosition(), spr6);

        SimpleRoad spr7= new SimpleRoad(blocks[7][30], down,limit50 ,new ArrayList<Line2D>());
        roads.put(spr7.getPosition(), spr7);

        for(int col=23; col <= 29; col++){
            SimpleRoad spr = new SimpleRoad(blocks[5][col], left, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col=22; col<= 28; col++){
            SimpleRoad spr = new SimpleRoad(blocks[6][col], right, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int line=8 ; line<=11; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][21], up, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int line=7 ; line<=10; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][20], down, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col=23; col<= 26; col++){
            SimpleRoad spr = new SimpleRoad(blocks[12][col], left, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col=22; col<= 25; col++){
            SimpleRoad spr = new SimpleRoad(blocks[13][col], right, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int line=15; line<= 22; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][21], up, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int line=14; line<= 22; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][20], down, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col=15; col<= 19; col++){
            SimpleRoad spr = new SimpleRoad(blocks[12][col], left, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col=14; col<= 18; col++){
            SimpleRoad spr = new SimpleRoad(blocks[13][col], right, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int line=7; line<= 8; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][10], down, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int line=8; line<= 9; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][11], up, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col=2; col<= 7; col++){
            SimpleRoad spr = new SimpleRoad(blocks[12][col], left, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col=2; col<= 6; col++){
            SimpleRoad spr = new SimpleRoad(blocks[13][col], right, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int line=16; line<= 17; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][10], down, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int line=17; line<= 18; line++){
            SimpleRoad spr = new SimpleRoad(blocks[line][11], up, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col=3; col<= 9; col++){
            SimpleRoad spr = new SimpleRoad(blocks[19][col], left, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col=2; col<= 8; col++){
            SimpleRoad spr = new SimpleRoad(blocks[20][col], right, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        SimpleRoad spr9 = new SimpleRoad(blocks[13][44], right, limit50, new ArrayList<Line2D>());
        roads.put(spr9.getPosition(), spr9);

        for(int col=13; col<= 19; col++){
            SimpleRoad spr = new SimpleRoad(blocks[5][col], right, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        for(int col=12; col<= 18; col++){
            SimpleRoad spr = new SimpleRoad(blocks[6][col], right, limit50, new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }

        //Construct the roads

    }

    public void Crossroad(HashMap<Block,Road> roads, Block block){

    }
}
