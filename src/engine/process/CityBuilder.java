package engine.process;

import config.GameConfiguration;
import engine.map.positions.Block;
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
        Line2D highwayTopLimit = new Line2D.Double(0,2*GameConfiguration.BLOCK_SIZE,1800,2*GameConfiguration.BLOCK_SIZE);
        Line2D highwayBottomLimit = new Line2D.Double(244,4*GameConfiguration.BLOCK_SIZE,1584,4*GameConfiguration.BLOCK_SIZE);
        Line2D highwayBottomLimit1 = new Line2D.Double(0,4*GameConfiguration.BLOCK_SIZE,80,4*GameConfiguration.BLOCK_SIZE);
        Line2D highwayBottomLimit2 = new Line2D.Double(1720,4*GameConfiguration.BLOCK_SIZE,1800,4*GameConfiguration.BLOCK_SIZE);
        for(int columnIndex = 0; columnIndex < columnCount; columnIndex++){
            ArrayList<Line2D> limits = new ArrayList<Line2D>();
            limits.add(highwayTopLimit);
            if(columnIndex <= 2){
                limits.add(highwayBottomLimit1);
            } else if(columnIndex <= 39){
                limits.add(highwayBottomLimit);
            }else if(columnIndex >= 43){
                limits.add(highwayBottomLimit2);
            }
            Highway highway = new Highway(blocks[3][columnIndex],0,4,limits,blocks[2][columnIndex], new Line2D.Double(columnIndex*GameConfiguration.BLOCK_SIZE,3*GameConfiguration.BLOCK_SIZE,columnIndex*GameConfiguration.BLOCK_SIZE+GameConfiguration.BLOCK_SIZE,3*GameConfiguration.BLOCK_SIZE));
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

        //Crossroad crossroad15 = new Crossroad(blocks[5][21],limit50,new ArrayList<Line2D>());
        //roads.put(crossroad15.getPosition(),crossroad15);

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
        //CrossroadEntry crossroadEntry19 = new CrossroadEntry(blocks[5][22],left,limit50,new ArrayList<Line2D>(),new Line2D.Double());
        roads.put(crossroadEntry17.getPosition(),crossroadEntry17);
        roads.put(crossroadEntry18.getPosition(),crossroadEntry18);
        //roads.put(crossroadEntry19.getPosition(),crossroadEntry19);

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

        Stop stop1 = new Stop(blocks[5][22], left, limit50, new ArrayList<Line2D>(), new Line2D.Double());
        roads.put(stop1.getPosition(),stop1);
        StopExit stopExit1 = new StopExit(blocks[5][21], limit50, new ArrayList<Line2D>(), stop1);
        roads.put(stopExit1.getPosition(),stopExit1);

        //SimpleRoad
        ArrayList<Line2D> sprLimits1 = new ArrayList<>();
        sprLimits1.add(new Line2D.Double(42*40, 21*40, 42*40, 23*40)); //Bord de la route
        sprLimits1.add(new Line2D.Double(43*40, 21*40, 43*40, 23*40)); //Ligne continue
        SimpleRoad spr1= new SimpleRoad(blocks[21][42], down,limit50 ,sprLimits1);
        SimpleRoad spr2 = new SimpleRoad(blocks[22][42], down, limit50 ,sprLimits1);

        ArrayList<Line2D> spr2Limits = new ArrayList<>();
        spr2Limits.add(new Line2D.Double(44*40, 21*40, 44*40, 23*40)); //Bord de la route
        spr2Limits.add(new Line2D.Double(43*40, 21*40, 43*40, 23*40)); //Ligne continue
        SimpleRoad spr3 = new SimpleRoad(blocks[22][43], up, limit50 ,spr2Limits);
        roads.put(spr1.getPosition(), spr1);
        roads.put(spr2.getPosition(), spr2);
        roads.put(spr3.getPosition(), spr3);

        Line2D l1 = new Line2D.Double(33*40, 19*40, 42*40, 19*40);
        Line2D l2 = new Line2D.Double(33*40, 20*40, 42*40, 20*40);
        for(int col= 33 ; col <= 41; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l1); // Bord de la route
            sprLimits.add(l2); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[19][col], left,limit50,sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l3 = new Line2D.Double(32*40, 21*40, 41*40, 21*40);
        Line2D l4 = new Line2D.Double(32*40, 20*40, 41*40, 20*40);
        for(int col= 32 ; col <= 40; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l3); // Bord de la route
            sprLimits.add(l4); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[20][col], right, limit50 ,sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l5 =new Line2D.Double(42*40, 15*40, 42*40, 18*40);
        Line2D l6 =	new Line2D.Double(43*40, 15*40, 43*40, 18*40);
        for(int line= 15 ; line <= 17; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l5); // Bord de la route
            sprLimits.add(l6); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][42], down, limit50 ,sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l7 =new Line2D.Double(44*40, 16*40, 44*40, 19*40);
        Line2D l8 =new Line2D.Double(43*40, 16*40, 43*40, 19*40);
        for(int line= 16 ; line <= 18; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l7); // Bord de la route
            sprLimits.add(l8); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][43], up, limit50 ,sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l9 =new Line2D.Double(30*40, 17*40, 30*40, 19*40);
        Line2D l10 =new Line2D.Double(31*40, 17*40, 31*40, 19*40);
        for(int line= 17 ; line <= 18; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l9); // Bord de la route
            sprLimits.add(l10); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][30], down,limit50 ,sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l11 =new Line2D.Double(32*40, 17*40, 32*40, 19*40);
        Line2D l12 =new Line2D.Double(31*40, 17*40, 31*40, 19*40);
        ArrayList<Line2D> sprLimits2 = new ArrayList<>();
        sprLimits2.add(l11); // Bord de la route
        sprLimits2.add(l12); // Ligne continue
        SimpleRoad spr4 = new SimpleRoad(blocks[18][31], up, limit50 ,sprLimits2);
        roads.put(spr4.getPosition(), spr4);

        Line2D l13 =new Line2D.Double(44*40, 14*40, 45*40, 14*40);
        Line2D l14 =new Line2D.Double(44*40, 13*40, 45*40, 13*40);
        ArrayList<Line2D> sprLimits3 = new ArrayList<>();
        sprLimits3.add(l13); // Bord de la route
        sprLimits3.add(l14); // Ligne continue
        SimpleRoad spr5 = new SimpleRoad(blocks[13][44], right, limit50 ,sprLimits3);
        roads.put(spr5.getPosition(), spr5);

        Line2D l15 =new Line2D.Double(36*40, 12*40, 41*40, 12*40);
        Line2D l16 =new Line2D.Double(36*40, 13*40, 41*40, 13*40);
        for(int col= 36 ; col <= 40; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l15); // Bord de la route
            sprLimits.add(l16); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[12][col], left,limit50 ,sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l17 =new Line2D.Double(35*40, 14*40, 40*40, 14*40);
        Line2D l18 =new Line2D.Double(35*40, 13*40, 40*40, 13*40);
        for(int col= 35 ; col <= 39; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l17); // Bord de la route
            sprLimits.add(l18); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[13][col], right,limit50 ,sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l19 =new Line2D.Double(32*40, 8*40, 32*40, 9*40);
        Line2D l20 =new Line2D.Double(31*40, 8*40, 31*40, 9*40);
        ArrayList<Line2D> sprLimits4 = new ArrayList<>();
        sprLimits4.add(l19); // Bord de la route
        sprLimits4.add(l20); // Ligne continue
        SimpleRoad spr6= new SimpleRoad(blocks[8][31], up,limit50 ,sprLimits4);
        roads.put(spr6.getPosition(), spr6);

        Line2D l21 =new Line2D.Double(30*40, 7*40, 30*40, 8*40);
        Line2D l22 =new Line2D.Double(31*40, 7*40, 31*40, 8*40);
        ArrayList<Line2D> sprLimits5 = new ArrayList<>();
        sprLimits5.add(l21); // Bord de la route
        sprLimits5.add(l22); // Ligne continue
        SimpleRoad spr7= new SimpleRoad(blocks[7][30], down,limit50 ,sprLimits5);
        roads.put(spr7.getPosition(), spr7);

        Line2D l23 =new Line2D.Double(23*40, 5*40, 30*40, 5*40);
        Line2D l24 =new Line2D.Double(23*40, 6*40, 30*40, 6*40);
        for(int col=23; col <= 29; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l23); // Bord de la route
            sprLimits.add(l24); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[5][col], left, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l25 =new Line2D.Double(22*40, 7*40, 30*40, 7*40);
        Line2D l26 =new Line2D.Double(22*40, 6*40, 30*40, 6*40);
        for(int col=22; col<= 28; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l25); // Bord de la route
            sprLimits.add(l26); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[6][col], right, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l27 =new Line2D.Double(22*40, 7*40, 22*40, 12*40);
        Line2D l28 =new Line2D.Double(21*40, 7*40, 21*40, 12*40);
        for(int line=8 ; line<=11; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l27); // Bord de la route
            sprLimits.add(l28); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][21], up, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l29 =new Line2D.Double(20*40, 7*40, 20*40, 12*40);
        Line2D l30 =new Line2D.Double(21*40, 7*40, 21*40, 12*40);
        for(int line=7 ; line<=10; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l29); // Bord de la route
            sprLimits.add(l30); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][20], down, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l31 =new Line2D.Double(23*40, 12*40, 27*40, 12*40);
        Line2D l32 =new Line2D.Double(23*40, 13*40, 27*40, 13*40);
        for(int col=23; col<= 26; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l31); // Bord de la route
            sprLimits.add(l32); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[12][col], left, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l33 =new Line2D.Double(22*40, 14*40, 27*40, 14*40);
        Line2D l34 =new Line2D.Double(22*40, 13*40, 27*40, 13*40);
        for(int col=22; col<= 25; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l33); // Bord de la route
            sprLimits.add(l34); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[13][col], right, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l35 =new Line2D.Double(22*40, 15*40, 22*40, 23*40);
        Line2D l36 =new Line2D.Double(21*40, 15*40, 21*40, 23*40);
        for(int line=15; line<= 22; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l35); // Bord de la route
            sprLimits.add(l36); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][21], up, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l37 =new Line2D.Double(20*40, 14*40, 20*40, 23*40);
        Line2D l38 =new Line2D.Double(21*40, 14*40, 21*40, 23*40);
        for(int line=14; line<= 22; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l37); // Bord de la route
            sprLimits.add(l38); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][20], down, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l39 =new Line2D.Double(15*40, 12*40, 20*40, 12*40);
        Line2D l40 =new Line2D.Double(15*40, 13*40, 20*40, 13*40);
        for(int col=15; col<= 19; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l39); // Bord de la route
            sprLimits.add(l40); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[12][col], left, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l41 =new Line2D.Double(14*40, 14*40, 20*40, 14*40);
        Line2D l42 =new Line2D.Double(14*40, 13*40, 20*40, 13*40);
        for(int col=14; col<= 18; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l41); // Bord de la route
            sprLimits.add(l42); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[13][col], right, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l43 =new Line2D.Double(10*40, 7*40, 10*40, 10*40);
        Line2D l44 =new Line2D.Double(11*40, 7*40, 11*40,10*40);
        for(int line=7; line<= 8; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l43); // Bord de la route
            sprLimits.add(l44); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][10], down, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l45 =new Line2D.Double(12*40, 7*40, 12*40, 10*40);
        Line2D l46 =new Line2D.Double(11*40, 7*40, 11*40, 10*40);
        for(int line=8; line<= 9; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l45); // Bord de la route
            sprLimits.add(l46); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][11], up, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l47 =new Line2D.Double(2*40, 12*40, 8*40, 12*40);
        Line2D l48 =new Line2D.Double(2*40, 13*40, 8*40, 13*40);
        for(int col=2; col<= 7; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l47); // Bord de la route
            sprLimits.add(l48); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[12][col], left, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l49 =new Line2D.Double(2*40, 14*40, 8*40, 14*40);
        Line2D l50 =new Line2D.Double(2*40, 13*40, 8*40, 13*40);
        for(int col=2; col<= 6; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l49); // Bord de la route
            sprLimits.add(l50); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[13][col], right, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l51 =new Line2D.Double(10*40, 16*40, 10*40, 18*40);
        Line2D l52 =new Line2D.Double(11*40, 16*40, 11*40, 18*40);
        for(int line=16; line<= 17; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l51); // Bord de la route
            sprLimits.add(l52); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][10], down, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l53 =new Line2D.Double(12*40, 16*40, 12*40, 19*40);
        Line2D l54 =new Line2D.Double(11*40, 16*40, 11*40, 19*40);
        for(int line=17; line<= 18; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l53); // Bord de la route
            sprLimits.add(l54); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][11], up, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l55=new Line2D.Double(3*40, 19*40, 10*40, 19*40); // Bord de la route
        Line2D l56=new Line2D.Double(3*40, 20*40, 10*40, 20*40); // Ligne continue
        for(int col=3; col<= 9; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l55); // Bord de la route
            sprLimits.add(l56); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[19][col], left, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l57 =new Line2D.Double(2*40, 21*40, 10*40, 21*40);
        Line2D l58 =new Line2D.Double(2*40, 20*40, 10*40, 20*40);
        for(int col=2; col<= 8; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l57); // Bord de la route
            sprLimits.add(l58); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[20][col], right, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }


        ArrayList<Line2D> sprLimits6 = new ArrayList<>();
        sprLimits6.add(new Line2D.Double(44*40, 14*40, 45*40, 14*40)); // Bord de la route
        sprLimits6.add(new Line2D.Double(44*40, 13*40, 45*40, 13*40)); // Ligne continue
        SimpleRoad spr9 = new SimpleRoad(blocks[13][44], right, limit50, sprLimits6);
        roads.put(spr9.getPosition(), spr9);

        Line2D l59 =new Line2D.Double(13*40, 5*40, 20*40, 5*40);
        Line2D l60 =new Line2D.Double(13*40, 6*40, 20*40, 6*40);
        for(int col=13; col<= 19; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l59); // Bord dela route
            sprLimits.add(l60); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[5][col], left, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l61 =new Line2D.Double(13*40, 7*40, 20*40, 7*40);
        Line2D l62 =new Line2D.Double(12*40, 6*40, 20*40, 6*40);
        for(int col=12; col<= 18; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l61); // Bord de la route
            sprLimits.add(l62); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[6][col], right, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l63 =new Line2D.Double(43*40, 5*40, 43*40, 11*40);
        Line2D l64 =new Line2D.Double(44*40, 5*40, 44*40, 11*40);
        for(int line=5; line<= 10; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l63); // Bord de la route
            sprLimits.add(l64); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][43], down, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l65 =new Line2D.Double(1*40, 14*40, 1*40, 18*40);
        Line2D l66 =new Line2D.Double(2*40, 14*40, 2*40, 18*40);
        for(int line=14; line<= 17; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l65); // Bord de la route
            sprLimits.add(l66); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][1], down, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l67 =new Line2D.Double(1*40, 5*40, 1*40, 12*40);
        Line2D l68 =new Line2D.Double(2*40, 5*40, 2*40, 12*40);
        for(int line=5; line<= 11; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l67); // Bord de la route
            sprLimits.add(l68); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][1], up, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }


        /*SimpleRoad spr1= new SimpleRoad(blocks[21][42], down,limit50 ,new ArrayList<Line2D>());
        SimpleRoad spr2 = new SimpleRoad(blocks[22][42], down, limit50 ,new ArrayList<Line2D>());
        SimpleRoad spr3 = new SimpleRoad(blocks[22][43], up, limit50 ,new ArrayList<Line2D>());
        roads.put(spr1.getPosition(), spr1);
        roads.put(spr2.getPosition(), spr2);
        roads.put(spr2.getPosition(), spr3);

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
            SimpleRoad spr = new SimpleRoad(blocks[line][42], up, limit50 ,new ArrayList<Line2D>());
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
        }*/

        //Construct the roads

    }

    public void Crossroad(HashMap<Block,Road> roads, Block block){

    }
}
