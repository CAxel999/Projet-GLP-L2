package engine.process;

import config.GameConfiguration;
import data.Scenario;
import engine.map.positions.Block;
import engine.map.positions.PixelPosition;
import engine.map.roads.*;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class used to build the {@link Road} of the city
 */
public class CityBuilder {
    public void buildRoads(HashMap<Block,Road> roads, Block[][] blocks, int lineCount, int columnCount, ArrayList<TrafficLight> trafficLights, HashMap<Integer, Scenario> scenarios){
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
        Line2D priority1 = new Line2D.Double(40, 20*40, 40, 21*40);
        Line2D entry1Line1 = new Line2D.Double(0, 760, 40, 760);
        Line2D entry1Line2 = new Line2D.Double(0, 800, 40, 800);
        ArrayList<Line2D> entry_1Limits = new ArrayList<>();
        entry_1Limits.add(entry1Line1);
        entry_1Limits.add(entry1Line2);
        CrossroadEntry crossroadEntry1 = new CrossroadEntry(blocks[20][0],right,limit50,entry_1Limits,priority1);

        Line2D priority2 = new Line2D.Double(40, 21*40, 2*40, 21*40);
        Line2D entry2Line1 = new Line2D.Double(40, 840, 40, 880);
        Line2D entry2Line2 = new Line2D.Double(80, 840, 80, 880);
        ArrayList<Line2D> entry_2Limits = new ArrayList<>();
        entry_2Limits.add(entry2Line1);
        entry_2Limits.add(entry2Line2);
        CrossroadEntry crossroadEntry2 = new CrossroadEntry(blocks[21][1],up,limit50,entry_2Limits, priority2);

        Line2D priority3 = new Line2D.Double(2*40, 19*40, 2*40, 20*40);
        Line2D entry3Line1 = new Line2D.Double(80, 760, 120, 760);
        Line2D entry3Line2 = new Line2D.Double(80, 800, 120, 800);
        ArrayList<Line2D> entry_3Limits = new ArrayList<>();
        entry_3Limits.add(entry3Line1);
        entry_3Limits.add(entry3Line2);
        CrossroadEntry crossroadEntry3 = new CrossroadEntry(blocks[19][2],left,limit50,entry_3Limits, priority3);

        Line2D priority4 = new Line2D.Double(40, 18*40, 2*40, 18*40);
        Line2D entry4Line1 = new Line2D.Double(40, 720, 40, 760);
        Line2D entry4Line2 = new Line2D.Double(80, 720, 80, 760);
        ArrayList<Line2D> entry_4Limits = new ArrayList<>();
        entry_4Limits.add(entry4Line1);
        entry_4Limits.add(entry4Line2);
        CrossroadEntry crossroadEntry4 = new CrossroadEntry(blocks[18][1],down,limit50,entry_4Limits, priority4);

        roads.put(crossroadEntry1.getPosition(),crossroadEntry1);
        roads.put(crossroadEntry2.getPosition(),crossroadEntry2);
        roads.put(crossroadEntry3.getPosition(),crossroadEntry3);
        roads.put(crossroadEntry4.getPosition(),crossroadEntry4);

        Line2D priority5 = new Line2D.Double(10*40, 20*40, 10*40, 21*40);
        Line2D entry5Line1 = new Line2D.Double(360, 800, 400, 800);
        Line2D entry5Line2 = new Line2D.Double(360, 840, 400, 840);
        ArrayList<Line2D> entry_5Limits = new ArrayList<>();
        entry_5Limits.add(entry5Line1);
        entry_5Limits.add(entry5Line2);
        CrossroadEntry crossroadEntry5 = new CrossroadEntry(blocks[20][9],right,limit50,entry_5Limits, priority5);

        Line2D priority6 = new Line2D.Double(10*40, 19*40, 11*40, 19*40);
        Line2D entry6Line1 = new Line2D.Double(400, 720, 400, 760);
        Line2D entry6Line2 = new Line2D.Double(440, 720, 440, 760);
        ArrayList<Line2D> entry_6Limits = new ArrayList<>();
        entry_6Limits.add(entry6Line1);
        entry_6Limits.add(entry6Line2);
        CrossroadEntry crossroadEntry6 = new CrossroadEntry(blocks[18][10],right,limit50,entry_6Limits, priority6);

        roads.put(crossroadEntry5.getPosition(),crossroadEntry5);
        roads.put(crossroadEntry6.getPosition(),crossroadEntry6);

        Line2D priority7 = new Line2D.Double(8*40, 13*40, 8*40, 14*40);
        Line2D entry7Line1 = new Line2D.Double(280, 520, 320, 520);
        Line2D entry7Line2 = new Line2D.Double(280, 560, 320, 560);
        ArrayList<Line2D> entry_7Limits = new ArrayList<>();
        entry_7Limits.add(entry7Line1);
        entry_7Limits.add(entry7Line2);
        CrossroadEntry crossroadEntry7 = new CrossroadEntry(blocks[13][7],right,limit50,entry_7Limits, priority7);

        Line2D priority8 = new Line2D.Double(11*40, 16*40, 12*40, 16*40);
        Line2D entry8Line1 = new Line2D.Double(440, 640, 440, 680);
        Line2D entry8Line2 = new Line2D.Double(480, 640, 480, 680);
        ArrayList<Line2D> entry_8Limits = new ArrayList<>();
        entry_8Limits.add(entry8Line1);
        entry_8Limits.add(entry8Line2);
        CrossroadEntry crossroadEntry8 = new CrossroadEntry(blocks[16][11],up,limit50,entry_8Limits, priority8);

        Line2D priority9 = new Line2D.Double(14*40, 12*40, 14*40, 13*40);
        Line2D entry9Line1 = new Line2D.Double(550, 480, 600, 480);
        Line2D entry9Line2 = new Line2D.Double(550, 520, 600, 520);
        ArrayList<Line2D> entry_9Limits = new ArrayList<>();
        entry_9Limits.add(entry9Line1);
        entry_9Limits.add(entry9Line2);
        CrossroadEntry crossroadEntry9 = new CrossroadEntry(blocks[12][14],left,limit50,entry_9Limits, priority9);

        Line2D priority10 = new Line2D.Double(10*40, 10*40, 11*40, 10*40);
        Line2D entry10Line1 = new Line2D.Double(400, 360, 400, 400);
        Line2D entry10Line2 = new Line2D.Double(440, 360, 440, 400);
        ArrayList<Line2D> entry_10Limits = new ArrayList<>();
        entry_10Limits.add(entry10Line1);
        entry_10Limits.add(entry10Line2);
        CrossroadEntry crossroadEntry10 = new CrossroadEntry(blocks[9][10],down,limit50,entry_10Limits, priority10);

        roads.put(crossroadEntry7.getPosition(),crossroadEntry7);
        roads.put(crossroadEntry8.getPosition(),crossroadEntry8);
        roads.put(crossroadEntry9.getPosition(),crossroadEntry9);
        roads.put(crossroadEntry10.getPosition(),crossroadEntry10);

        Line2D priority11 = new Line2D.Double(11*40, 7*40, 12*40, 7*40);
        Line2D entry11Line1 = new Line2D.Double(440, 280, 440, 320);
        Line2D entry11Line2 = new Line2D.Double(480, 280, 480, 320);
        ArrayList<Line2D> entry_11Limits = new ArrayList<>();
        entry_11Limits.add(entry11Line1);
        entry_11Limits.add(entry11Line2);
        CrossroadEntry crossroadEntry11 = new CrossroadEntry(blocks[7][11],up,limit50,entry_11Limits, priority11);

        Line2D priority12 = new Line2D.Double(12*40, 5*40, 12*40, 6*40);
        Line2D entry12Line1 = new Line2D.Double(480, 200, 520, 200);
        Line2D entry12Line2 = new Line2D.Double(480, 240, 520, 240);
        ArrayList<Line2D> entry_12Limits = new ArrayList<>();
        entry_12Limits.add(entry12Line1);
        entry_12Limits.add(entry12Line2);
        CrossroadEntry crossroadEntry12 = new CrossroadEntry(blocks[5][12],left,limit50,entry_12Limits, priority12);

        roads.put(crossroadEntry11.getPosition(),crossroadEntry11);
        roads.put(crossroadEntry12.getPosition(),crossroadEntry12);

        Line2D priority13 = new Line2D.Double(20*40, 13*40, 20*40, 14*40);
        Line2D entry13Line1 = new Line2D.Double(760, 520, 800, 520);
        Line2D entry13Line2 = new Line2D.Double(760, 560, 800, 560);
        ArrayList<Line2D> entry_13Limits = new ArrayList<>();
        entry_13Limits.add(entry13Line1);
        entry_13Limits.add(entry13Line2);
        CrossroadEntry crossroadEntry13 = new CrossroadEntry(blocks[13][19],right,limit50,entry_13Limits, priority13);

        Line2D priority14 = new Line2D.Double(21*40, 14*40, 22*40, 14*40);
        Line2D entry14Line1 = new Line2D.Double(840, 560, 840, 600);
        Line2D entry14Line2 = new Line2D.Double(880, 560, 880, 600);
        ArrayList<Line2D> entry_14Limits = new ArrayList<>();
        entry_14Limits.add(entry14Line1);
        entry_14Limits.add(entry14Line2);
        CrossroadEntry crossroadEntry14 = new CrossroadEntry(blocks[14][21],up,limit50,entry_14Limits, priority14);

        Line2D priority15 = new Line2D.Double(22*40, 12*40, 22*40, 13*40);
        Line2D entry15Line1 = new Line2D.Double(880, 480, 920, 480);
        Line2D entry15Line2 = new Line2D.Double(880, 520, 920, 520);
        ArrayList<Line2D> entry_15Limits = new ArrayList<>();
        entry_15Limits.add(entry15Line1);
        entry_15Limits.add(entry15Line2);
        CrossroadEntry crossroadEntry15 = new CrossroadEntry(blocks[12][22],left,limit50,entry_15Limits, priority15);

        Line2D priority16 = new Line2D.Double(20*40, 12*40, 21*40, 12*40);
        Line2D entry16Line1 = new Line2D.Double(800, 440, 800, 480);
        Line2D entry16Line2 = new Line2D.Double(840, 440, 840, 480);
        ArrayList<Line2D> entry_16Limits = new ArrayList<>();
        entry_16Limits.add(entry16Line1);
        entry_16Limits.add(entry16Line2);
        CrossroadEntry crossroadEntry16 = new CrossroadEntry(blocks[11][20],down,limit50,entry_16Limits, priority16);

        roads.put(crossroadEntry13.getPosition(),crossroadEntry13);
        roads.put(crossroadEntry14.getPosition(),crossroadEntry14);
        roads.put(crossroadEntry15.getPosition(),crossroadEntry15);
        roads.put(crossroadEntry16.getPosition(),crossroadEntry16);

        Line2D priority17 = new Line2D.Double(20*40, 6*40, 20*40, 7*40);
        Line2D entry17Line1 = new Line2D.Double(760, 240, 800, 240);
        Line2D entry17Line2 = new Line2D.Double(760, 280, 800, 280);
        ArrayList<Line2D> entry_17Limits = new ArrayList<>();
        entry_17Limits.add(entry17Line1);
        entry_17Limits.add(entry17Line2);
        CrossroadEntry crossroadEntry17 = new CrossroadEntry(blocks[6][19],right,limit50,entry_17Limits, priority17);

        Line2D priority18 = new Line2D.Double(21*40, 7*40, 22*40, 7*40);
        Line2D entry18Line1 = new Line2D.Double(840, 280, 840, 320);
        Line2D entry18Line2 = new Line2D.Double(880, 280, 880, 320);
        ArrayList<Line2D> entry_18Limits = new ArrayList<>();
        entry_18Limits.add(entry18Line1);
        entry_18Limits.add(entry18Line2);
        CrossroadEntry crossroadEntry18 = new CrossroadEntry(blocks[7][21],up,limit50,entry_18Limits, priority18);

        roads.put(crossroadEntry17.getPosition(),crossroadEntry17);
        roads.put(crossroadEntry18.getPosition(),crossroadEntry18);
        //roads.put(crossroadEntry19.getPosition(),crossroadEntry19);

        Line2D priority20 = new Line2D.Double(32*40, 19*40, 32*40, 20*40);
        Line2D entry20Line1 = new Line2D.Double(1280, 760, 1320, 760);
        Line2D entry20Line2 = new Line2D.Double(1280, 800, 1320, 800);
        ArrayList<Line2D> entry_20Limits = new ArrayList<>();
        entry_20Limits.add(entry20Line1);
        entry_20Limits.add(entry20Line2);
        CrossroadEntry crossroadEntry20 = new CrossroadEntry(blocks[19][32],left,limit50,entry_20Limits, priority20);

        Line2D priority21 = new Line2D.Double(30*40, 19*40, 31*40, 19*40);
        Line2D entry21Line1 = new Line2D.Double(1200, 720, 1200, 760);
        Line2D entry21Line2 = new Line2D.Double(1240, 720, 1240, 760);
        ArrayList<Line2D> entry_21Limits = new ArrayList<>();
        entry_21Limits.add(entry21Line1);
        entry_21Limits.add(entry21Line2);
        CrossroadEntry crossroadEntry21 = new CrossroadEntry(blocks[18][30],down,limit50,entry_21Limits, priority21);

        roads.put(crossroadEntry20.getPosition(),crossroadEntry20);
        roads.put(crossroadEntry21.getPosition(),crossroadEntry21);

        Line2D priority22 = new Line2D.Double(27*40, 13*40, 27*40, 14*40);
        Line2D entry22Line1 = new Line2D.Double(1040, 520, 1080, 520);
        Line2D entry22Line2 = new Line2D.Double(1040, 560, 1080, 560);
        ArrayList<Line2D> entry_22Limits = new ArrayList<>();
        entry_22Limits.add(entry22Line1);
        entry_22Limits.add(entry22Line2);
        CrossroadEntry crossroadEntry22 = new CrossroadEntry(blocks[13][26],right,limit50,entry_22Limits, priority22);

        Line2D priority23 = new Line2D.Double(31*40, 17*40, 32*40, 17*40);
        Line2D entry23Line1 = new Line2D.Double(1240, 680, 1240, 720);
        Line2D entry23Line2 = new Line2D.Double(1280, 680, 1280, 720);
        ArrayList<Line2D> entry_23Limits = new ArrayList<>();
        entry_23Limits.add(entry23Line1);
        entry_23Limits.add(entry23Line2);
        CrossroadEntry crossroadEntry23 = new CrossroadEntry(blocks[17][31],up,limit50,entry_23Limits, priority23);

        Line2D priority24 = new Line2D.Double(35*40, 12*40, 35*40, 13*40);
        Line2D entry24Line1 = new Line2D.Double(1400, 480, 1440, 480);
        Line2D entry24Line2 = new Line2D.Double(1400, 520, 1440, 520);
        ArrayList<Line2D> entry_24Limits = new ArrayList<>();
        entry_24Limits.add(entry24Line1);
        entry_24Limits.add(entry24Line2);
        CrossroadEntry crossroadEntry24 = new CrossroadEntry(blocks[12][35],left,limit50,entry_24Limits, priority24);

        Line2D priority25 = new Line2D.Double(30*40, 9*40, 31*40, 9*40);
        Line2D entry25Line1 = new Line2D.Double(1200, 320, 1200, 360);
        Line2D entry25Line2 = new Line2D.Double(1240, 320, 1240, 360);
        ArrayList<Line2D> entry_25Limits = new ArrayList<>();
        entry_25Limits.add(entry25Line1);
        entry_25Limits.add(entry25Line2);
        CrossroadEntry crossroadEntry25 = new CrossroadEntry(blocks[8][30],down,limit50,entry_25Limits, priority25);

        roads.put(crossroadEntry22.getPosition(),crossroadEntry22);
        roads.put(crossroadEntry23.getPosition(),crossroadEntry23);
        roads.put(crossroadEntry24.getPosition(),crossroadEntry24);
        roads.put(crossroadEntry25.getPosition(),crossroadEntry25);

        Line2D priority26 = new Line2D.Double(30*40, 6*40, 30*40, 7*40);
        Line2D entry26Line1 = new Line2D.Double(1160, 240, 1200, 240);
        Line2D entry26Line2 = new Line2D.Double(1160, 280, 1200, 280);
        ArrayList<Line2D> entry_26Limits = new ArrayList<>();
        entry_26Limits.add(entry26Line1);
        entry_26Limits.add(entry26Line2);
        CrossroadEntry crossroadEntry26 = new CrossroadEntry(blocks[6][29],right,limit50,entry_26Limits, priority26);

        Line2D priority27 = new Line2D.Double(31*40, 7*40, 32*40, 7*40);
        Line2D entry27Line1 = new Line2D.Double(1240, 280, 1240, 320);
        Line2D entry27Line2 = new Line2D.Double(1280, 280, 1280, 320);
        ArrayList<Line2D> entry_27Limits = new ArrayList<>();
        entry_27Limits.add(entry27Line1);
        entry_27Limits.add(entry27Line2);
        CrossroadEntry crossroadEntry27 = new CrossroadEntry(blocks[7][31],up,limit50,entry_27Limits, priority27);

        roads.put(crossroadEntry26.getPosition(),crossroadEntry26);
        roads.put(crossroadEntry27.getPosition(),crossroadEntry27);

        Line2D priority28 = new Line2D.Double(42*40, 20*40, 42*40, 21*40);
        Line2D entry28Line1 = new Line2D.Double(1640, 800, 1680, 800);
        Line2D entry28Line2 = new Line2D.Double(1640, 840, 1680, 840);
        ArrayList<Line2D> entry_28Limits = new ArrayList<>();
        entry_28Limits.add(entry28Line1);
        entry_28Limits.add(entry28Line2);
        CrossroadEntry crossroadEntry28 = new CrossroadEntry(blocks[20][41],right,limit50,entry_28Limits, priority28);

        Line2D priority29 = new Line2D.Double(43*40, 21*40, 44*40, 21*40);
        Line2D entry29Line1 = new Line2D.Double(1720, 840, 1720, 880);
        Line2D entry29Line2 = new Line2D.Double(1760, 840, 1760, 880);
        ArrayList<Line2D> entry_29Limits = new ArrayList<>();
        entry_29Limits.add(entry29Line1);
        entry_29Limits.add(entry29Line2);
        CrossroadEntry crossroadEntry29 = new CrossroadEntry(blocks[21][43],up,limit50,entry_29Limits, priority29);

        Line2D priority30 = new Line2D.Double(42*40, 19*40, 43*40, 19*40);
        Line2D entry30Line1 = new Line2D.Double(1680, 720, 1680, 760);
        Line2D entry30Line2 = new Line2D.Double(1720, 720, 1720, 760);
        ArrayList<Line2D> entry_30Limits = new ArrayList<>();
        entry_30Limits.add(entry30Line1);
        entry_30Limits.add(entry30Line2);
        CrossroadEntry crossroadEntry30 = new CrossroadEntry(blocks[18][42],down,limit50,entry_30Limits, priority30);

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

        Crosswalk crosswalk11 = new Crosswalk(blocks[14][42],down,limit50,new ArrayList<Line2D>());
        Crosswalk crosswalk12 = new Crosswalk(blocks[14][43],up,limit50,new ArrayList<Line2D>());
        roads.put(crosswalk11.getPosition(),crosswalk11);
        roads.put(crosswalk12.getPosition(),crosswalk12);

        Line2D stopPriority = new Line2D.Double(22*40, 5*40, 22*40, 6*40);
        Stop stop1 = new Stop(blocks[5][22], left, limit50, new ArrayList<Line2D>(), stopPriority);
        roads.put(stop1.getPosition(),stop1);
        StopExit stopExit1 = new StopExit(blocks[5][21], limit50, new ArrayList<Line2D>(), stop1);
        roads.put(stopExit1.getPosition(),stopExit1);

        //SimpleRoad
        ArrayList<Line2D> sprLimits1 = new ArrayList<>();
        sprLimits1.add(new Line2D.Double(42*40, 21*40, 42*40, 23*40)); //Bord de la route
        sprLimits1.add(new Line2D.Double(43*40, 21*40, 43*40, 23*40)); //Ligne continue
        //SimpleRoad spr1= new SimpleRoad(blocks[21][42], down,limit50 ,sprLimits1);
        SimpleRoad spr2 = new SimpleRoad(blocks[22][42], down, limit50 ,sprLimits1);

        ArrayList<Line2D> spr2Limits = new ArrayList<>();
        spr2Limits.add(new Line2D.Double(44*40, 19*40, 44*40, 23*40)); //Bord de la route
        spr2Limits.add(new Line2D.Double(43*40, 21*40, 43*40, 23*40)); //Ligne continue
        SimpleRoad spr3 = new SimpleRoad(blocks[22][43], up, limit50 ,spr2Limits);
        //roads.put(spr1.getPosition(), spr1);
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

        Line2D l3 = new Line2D.Double(30*40, 21*40, 41*40, 21*40);
        Line2D l4 = new Line2D.Double(32*40, 20*40, 41*40, 20*40);
        for(int col= 32 ; col <= 40; col++){
            if(col != 38) {
                ArrayList<Line2D> sprLimits = new ArrayList<>();
                sprLimits.add(l3); // Bord de la route
                sprLimits.add(l4); // Ligne continue
                SimpleRoad spr = new SimpleRoad(blocks[20][col], right, limit50, sprLimits);
                roads.put(spr.getPosition(), spr);
            }
        }

        Line2D l5 =new Line2D.Double(42*40, 15*40, 42*40, 18*40);
        Line2D l6 =	new Line2D.Double(43*40, 15*40, 43*40, 18*40);
        for(int line= 16 ; line <= 17; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l5); // Bord de la route
            sprLimits.add(l6); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][42], down, limit50 ,sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l7 =new Line2D.Double(44*40, 16*40, 44*40, 19*40);
        Line2D l8 =new Line2D.Double(43*40, 16*40, 43*40, 19*40);

        ArrayList<Line2D> sprLimitsCorrige1 = new ArrayList<>();
        sprLimitsCorrige1.add(l7); // Bord de la route
        sprLimitsCorrige1.add(l8); // Ligne continue
        SimpleRoad sprCorrige1 = new SimpleRoad(blocks[16][43], up, limit50, sprLimitsCorrige1);
        roads.put(sprCorrige1.getPosition(), sprCorrige1);


        Line2D l11 =new Line2D.Double(32*40, 17*40, 32*40, 19*40);
        Line2D l12 =new Line2D.Double(31*40, 17*40, 31*40, 19*40);
        ArrayList<Line2D> sprLimits2 = new ArrayList<>();
        sprLimits2.add(l11); // Bord de la route
        sprLimits2.add(l12); // Ligne continue
        SimpleRoad spr4 = new SimpleRoad(blocks[18][31], up, limit50 ,sprLimits2);
        roads.put(spr4.getPosition(), spr4);


        Line2D l15 =new Line2D.Double(36*40, 12*40, 41*40, 12*40);
        Line2D l16 =new Line2D.Double(36*40, 13*40, 41*40, 13*40);
        for(int col= 37 ; col <= 39; col++){
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


        Line2D l21 =new Line2D.Double(30*40, 7*40, 30*40, 8*40);
        Line2D l22 =new Line2D.Double(31*40, 7*40, 31*40, 8*40);
        ArrayList<Line2D> sprLimits5 = new ArrayList<>();
        sprLimits5.add(l21); // Bord de la route
        sprLimits5.add(l22); // Ligne continue
        SimpleRoad spr7= new SimpleRoad(blocks[7][30], down,limit50 ,sprLimits5);
        roads.put(spr7.getPosition(), spr7);

        Line2D l23 =new Line2D.Double(20*40, 5*40, 32*40, 5*40);
        Line2D l24 =new Line2D.Double(23*40, 6*40, 30*40, 6*40);
        for(int col=23; col <= 29; col++){
            if(col != 24) {
                ArrayList<Line2D> sprLimits = new ArrayList<>();
                sprLimits.add(l23); // Bord de la route
                sprLimits.add(l24); // Ligne continue
                SimpleRoad spr = new SimpleRoad(blocks[5][col], left, limit50, sprLimits);
                roads.put(spr.getPosition(), spr);
            }
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
        for(int line=8 ; line<=10; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l27); // Bord de la route
            sprLimits.add(l28); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][21], up, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l29 =new Line2D.Double(20*40, 7*40, 20*40, 12*40);
        Line2D l30 =new Line2D.Double(21*40, 7*40, 21*40, 12*40);
        for(int line=8 ; line<=10; line++){
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
        for(int col=23; col<= 25; col++){
            if(col !=24) {
                ArrayList<Line2D> sprLimits = new ArrayList<>();
                sprLimits.add(l33); // Bord de la route
                sprLimits.add(l34); // Ligne continue
                SimpleRoad spr = new SimpleRoad(blocks[13][col], right, limit50, sprLimits);
                roads.put(spr.getPosition(), spr);
            }
        }

        Line2D l35 =new Line2D.Double(22*40, 16*40, 22*40, 23*40);
        Line2D l36 =new Line2D.Double(21*40, 16*40, 21*40, 23*40);
        for(int line=16; line<= 22; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l35); // Bord de la route
            sprLimits.add(l36); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][21], up, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l37 =new Line2D.Double(20*40, 14*40, 20*40, 23*40);
        Line2D l38 =new Line2D.Double(21*40, 14*40, 21*40, 23*40);
        for(int line=15; line<= 22; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l37); // Bord de la route
            sprLimits.add(l38); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][20], down, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l39 =new Line2D.Double(15*40, 12*40, 20*40, 12*40);
        Line2D l40 =new Line2D.Double(15*40, 13*40, 20*40, 13*40);
        for(int col=15; col<= 18; col++){
            if(col !=16) {
                ArrayList<Line2D> sprLimits = new ArrayList<>();
                sprLimits.add(l39); // Bord de la route
                sprLimits.add(l40); // Ligne continue
                SimpleRoad spr = new SimpleRoad(blocks[12][col], left, limit50, sprLimits);
                roads.put(spr.getPosition(), spr);
            }
        }

        Line2D l41 =new Line2D.Double(14*40, 14*40, 20*40, 14*40);
        Line2D l42 =new Line2D.Double(14*40, 13*40, 20*40, 13*40);
        for(int col=15; col<= 18; col++){
            if(col != 17) {
                ArrayList<Line2D> sprLimits = new ArrayList<>();
                sprLimits.add(l41); // Bord de la route
                sprLimits.add(l42); // Ligne continue
                SimpleRoad spr = new SimpleRoad(blocks[13][col], right, limit50, sprLimits);
                roads.put(spr.getPosition(), spr);
            }
        }

        Line2D l43 =new Line2D.Double(10*40, 5*40, 10*40, 10*40);
        Line2D l44 =new Line2D.Double(11*40, 7*40, 11*40,10*40);
        for(int line=7; line<= 7; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l43); // Bord de la route
            sprLimits.add(l44); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][10], down, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l45 =new Line2D.Double(12*40, 7*40, 12*40, 10*40);
        Line2D l46 =new Line2D.Double(11*40, 7*40, 11*40, 10*40);
        for(int line=8; line<= 8; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l45); // Bord de la route
            sprLimits.add(l46); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][11], up, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l47 =new Line2D.Double(2*40, 12*40, 8*40, 12*40);
        Line2D l48 =new Line2D.Double(2*40, 13*40, 8*40, 13*40);
        for(int col=2; col<= 6; col++){
            if(col !=4) {
                ArrayList<Line2D> sprLimits = new ArrayList<>();
                sprLimits.add(l47); // Bord de la route
                sprLimits.add(l48); // Ligne continue
                SimpleRoad spr = new SimpleRoad(blocks[12][col], left, limit50, sprLimits);
                roads.put(spr.getPosition(), spr);
            }
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

            ArrayList<Line2D> sprLimitsCorrige2 = new ArrayList<>();
            sprLimitsCorrige2.add(l51); // Bord de la route
            sprLimitsCorrige2.add(l52); // Ligne continue
            SimpleRoad sprCorrige2 = new SimpleRoad(blocks[17][10], down, limit50, sprLimitsCorrige2);
            roads.put(sprCorrige2.getPosition(), sprCorrige2);


        Line2D l53 =new Line2D.Double(12*40, 16*40, 12*40, 21*40);
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

        Line2D l57 =new Line2D.Double(2*40, 21*40, 12*40, 21*40);
        Line2D l58 =new Line2D.Double(2*40, 20*40, 10*40, 20*40);
        for(int col=2; col<= 8; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l57); // Bord de la route
            sprLimits.add(l58); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[20][col], right, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }


        Line2D l59 =new Line2D.Double(10*40, 5*40, 20*40, 5*40);
        Line2D l60 =new Line2D.Double(13*40, 6*40, 20*40, 6*40);
        for(int col=13; col<= 18; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l59); // Bord dela route
            sprLimits.add(l60); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[5][col], left, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l61 =new Line2D.Double(12*40, 7*40, 19*40, 7*40);
        Line2D l62 =new Line2D.Double(12*40, 6*40, 19*40, 6*40);
        for(int col=12; col<= 18; col++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l61); // Bord de la route
            sprLimits.add(l62); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[6][col], right, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l63 =new Line2D.Double(43*40, 6*40, 43*40, 11*40);
        Line2D l64 =new Line2D.Double(44*40, 5*40, 44*40, 11*40);
        for(int line=6; line<= 10; line++){
            if(line != 9) {
                ArrayList<Line2D> sprLimits = new ArrayList<>();
                sprLimits.add(l63); // Bord de la route
                sprLimits.add(l64); // Ligne continue
                SimpleRoad spr = new SimpleRoad(blocks[line][43], down, limit50, sprLimits);
                roads.put(spr.getPosition(), spr);
            }
        }

        Line2D l65 =new Line2D.Double(40, 14*40, 40, 18*40);
        Line2D l66 =new Line2D.Double(2*40, 14*40, 2*40, 18*40);
        for(int line=15; line<= 17; line++){
            ArrayList<Line2D> sprLimits = new ArrayList<>();
            sprLimits.add(l65); // Bord de la route
            sprLimits.add(l66); // Ligne continue
            SimpleRoad spr = new SimpleRoad(blocks[line][1], down, limit50, sprLimits);
            roads.put(spr.getPosition(), spr);
        }

        Line2D l67 =new Line2D.Double(40, 5*40, 40, 14*40);
        Line2D l68 =new Line2D.Double(2*40, 6*40, 2*40, 12*40);
        for(int line=5; line<= 10; line++){
            if(line != 6) {
                ArrayList<Line2D> sprLimits = new ArrayList<>();
                sprLimits.add(l67); // Bord de la route
                sprLimits.add(l68); // Ligne continue
                SimpleRoad spr = new SimpleRoad(blocks[line][1], up, limit50, sprLimits);
                roads.put(spr.getPosition(), spr);
            }
        }
        ArrayList<Line2D> spr10Limits = new ArrayList<>();
        spr10Limits.add(new Line2D.Double(40, 22*40, 40, 23*40));
        spr10Limits.add(new Line2D.Double(80, 22*40, 80, 23*40));
        SimpleRoad spr10 = new SimpleRoad(blocks[22][1], up, limit50, spr10Limits);
        roads.put(spr10.getPosition(), spr10);

        ArrayList<Line2D> lastSimpleRoadLimits = new ArrayList<>();
        lastSimpleRoadLimits.add(new Line2D.Double(0,720,40,720));
        lastSimpleRoadLimits.add(entry1Line1);
        SimpleRoad lastSimpleRoad = new SimpleRoad(blocks[19][0],left,limit50,lastSimpleRoadLimits);
        roads.put(lastSimpleRoad.getPosition(),lastSimpleRoad);


        //Entrée d'autoroute
        Line2D hwe1_line1 = new Line2D.Double(86, 161, 66, 173);
        Line2D hwe1_line2 = new Line2D.Double(66, 173, 50, 188);
        Line2D hwe1_line3 = new Line2D.Double(50, 188, 40, 205);
        ArrayList<Line2D> hwe1_limits = new ArrayList<>();
        hwe1_limits.add(hwe1_line1);
        hwe1_limits.add(hwe1_line2);
        hwe1_limits.add(hwe1_line3);
        Crossroad highwayEntry1 = new Crossroad(blocks[4][1],limit50,hwe1_limits);
        roads.put(highwayEntry1.getPosition(), highwayEntry1);

        Line2D hwe2_line = new Line2D.Double(120, 190, 104, 201);
        ArrayList<Line2D> hwe2_limits = new ArrayList<>();
        hwe2_limits.add(hwe2_line);
        Crossroad highwayEntry2 = new Crossroad(blocks[4][2],limit50,hwe2_limits);
        roads.put(highwayEntry2.getPosition(), highwayEntry2);

        Line2D hwe3_line = new Line2D.Double(160, 171, 120, 190);
        ArrayList<Line2D> hwe3_limits = new ArrayList<>();
        hwe3_limits.add(hwe3_line);
        Crossroad highwayEntry3 = new Crossroad(blocks[4][3],limit50,hwe3_limits);
        roads.put(highwayEntry3.getPosition(), highwayEntry3);

        Line2D hwe4_line = new Line2D.Double(200, 164, 160, 171);
        ArrayList<Line2D> hwe4_limits = new ArrayList<>();
        hwe4_limits.add(hwe4_line);
        Crossroad highwayEntry4 = new Crossroad(blocks[4][4],limit50,hwe4_limits);
        roads.put(highwayEntry4.getPosition(), highwayEntry4);

        Line2D hwe5_line = new Line2D.Double(226, 161, 200, 164);
        ArrayList<Line2D> hwe5_limits = new ArrayList<>();
        hwe5_limits.add(hwe5_line);
        Crossroad highwayEntry5 = new Crossroad(blocks[4][5],limit50,hwe5_limits);
        roads.put(highwayEntry5.getPosition(), highwayEntry5);

        Line2D hwe6_line = new Line2D.Double(104, 201, 80, 241);
        ArrayList<Line2D> hwe6_limits = new ArrayList<>();
        hwe6_limits.add(hwe6_line);
        Crossroad highwayEntry6 = new Crossroad(blocks[5][2],limit50,hwe6_limits);
        roads.put(highwayEntry6.getPosition(), highwayEntry6);

        Line2D hwe7_line = new Line2D.Double(1600, 160, 1640, 170);
        ArrayList<Line2D> hwe7_limits = new ArrayList<>();
        hwe7_limits.add(hwe7_line);
        Crossroad highwayEntry7 = new Crossroad(blocks[4][40],limit50,hwe7_limits);
        roads.put(highwayEntry7.getPosition(), highwayEntry7);

        Line2D hwe8_line = new Line2D.Double(1640, 170, 1680, 188);
        ArrayList<Line2D> hwe8_limits = new ArrayList<>();
        hwe8_limits.add(hwe8_line);
        Crossroad highwayEntry8 = new Crossroad(blocks[4][41],limit50,hwe8_limits);
        roads.put(highwayEntry8.getPosition(), highwayEntry8);

        Line2D hwe9_line = new Line2D.Double(1680, 188, 1695, 201);
        ArrayList<Line2D> hwe9_limits = new ArrayList<>();
        hwe9_limits.add(hwe9_line);
        Crossroad highwayEntry9 = new Crossroad(blocks[4][42],limit50,hwe9_limits);
        roads.put(highwayEntry9.getPosition(), highwayEntry9);

        Line2D hwe10_line1 = new Line2D.Double(1720, 160, 1740, 178);
        Line2D hwe10_line2 = new Line2D.Double(1740, 178, 1760, 200);
        ArrayList<Line2D> hwe10_limits = new ArrayList<>();
        hwe10_limits.add(hwe10_line1);
        hwe10_limits.add(hwe10_line2);
        Crossroad highwayEntry10 = new Crossroad(blocks[4][43],limit50,hwe10_limits);
        roads.put(highwayEntry10.getPosition(), highwayEntry10);

        Line2D hwe11_line1 = new Line2D.Double(1695, 201, 1708, 217);
        Line2D hwe11_line2 = new Line2D.Double(1708, 217, 1719, 241);
        ArrayList<Line2D> hwe11_limits = new ArrayList<>();
        hwe10_limits.add(hwe11_line1);
        hwe10_limits.add(hwe11_line2);
        Crossroad highwayEntry11 = new Crossroad(blocks[5][42],limit50,hwe11_limits);
        roads.put(highwayEntry11.getPosition(), highwayEntry11);

        for(int col= 35 ; col <= 39; col++){
            SimpleRoad spr = new SimpleRoad(blocks[13][col], right,limit50 ,new ArrayList<Line2D>());
            roads.put(spr.getPosition(), spr);
        }


        //TrafficLightRoad
        TrafficLight trafficLight1 = new TrafficLight(new PixelPosition(1615,561),TrafficLightEnum.RED);
        Line2D trafficLightRoadEdge1 = new Line2D.Double(1600,520,1640,520);
        Line2D trafficLightRoadEdge2 = new Line2D.Double(1600,560,1640,560);
        Line2D trafficLigthPriorityZone1 = new Line2D.Double(1640,520,1640,560);
        ArrayList<Line2D> trafficLightRoadEdgeList1 = new ArrayList<Line2D>();
        trafficLightRoadEdgeList1.add(trafficLightRoadEdge1);
        trafficLightRoadEdgeList1.add(trafficLightRoadEdge2);
        TrafficLightRoad trafficLightRoad1 = new TrafficLightRoad(blocks[13][40],right,limit50,trafficLightRoadEdgeList1,trafficLight1,trafficLigthPriorityZone1);

        TrafficLight trafficLight2 = new TrafficLight(new PixelPosition(1764,450),TrafficLightEnum.RED);
        Line2D trafficLightRoadEdge3 = new Line2D.Double(1760,480,1800,480);
        Line2D trafficLightRoadEdge4 = new Line2D.Double(1760,480,1800,480);
        Line2D trafficLigthPriorityZone2 = new Line2D.Double(1760,520,1800,520);
        ArrayList<Line2D> trafficLightRoadEdgeList2 = new ArrayList<Line2D>();
        trafficLightRoadEdgeList2.add(trafficLightRoadEdge3);
        trafficLightRoadEdgeList2.add(trafficLightRoadEdge4);
        TrafficLightRoad trafficLightRoad2 = new TrafficLightRoad(blocks[12][44],left,limit50,trafficLightRoadEdgeList2,trafficLight2,trafficLigthPriorityZone2);

        TrafficLight trafficLight3 = new TrafficLight(new PixelPosition(1690,450),TrafficLightEnum.GREEN);
        Line2D trafficLightRoadEdge5 = new Line2D.Double(1720,440,1720,480);
        Line2D trafficLightRoadEdge6 = new Line2D.Double(1760,440,1760,480);
        Line2D trafficLigthPriorityZone3 = new Line2D.Double(1720,480,1760,480);
        ArrayList<Line2D> trafficLightRoadEdgeList3 = new ArrayList<Line2D>();
        trafficLightRoadEdgeList3.add(trafficLightRoadEdge5);
        trafficLightRoadEdgeList3.add(trafficLightRoadEdge6);
        TrafficLightRoad trafficLightRoad3 = new TrafficLightRoad(blocks[11][43],down,limit50,trafficLightRoadEdgeList3,trafficLight3,trafficLigthPriorityZone3);

        TrafficLight trafficLight4 = new TrafficLight(new PixelPosition(1764,595),TrafficLightEnum.GREEN);
        Line2D trafficLightRoadEdge7 = new Line2D.Double(1720,600,1720,640);
        Line2D trafficLightRoadEdge8 = new Line2D.Double(1760,600,1760,640);
        Line2D trafficLigthPriorityZone4 = new Line2D.Double(1720,600,1760,600);
        ArrayList<Line2D> trafficLightRoadEdgeList4 = new ArrayList<Line2D>();
        trafficLightRoadEdgeList4.add(trafficLightRoadEdge7);
        trafficLightRoadEdgeList4.add(trafficLightRoadEdge8);
        TrafficLightRoad trafficLightRoad4 = new TrafficLightRoad(blocks[15][43],up,limit50,trafficLightRoadEdgeList4,trafficLight4,trafficLigthPriorityZone4);
        //Construct the roads

        trafficLights.add(trafficLight1);
        trafficLights.add(trafficLight2);
        trafficLights.add(trafficLight3);
        trafficLights.add(trafficLight4);
        roads.put(trafficLightRoad1.getPosition(),trafficLightRoad1);
        roads.put(trafficLightRoad2.getPosition(),trafficLightRoad2);
        roads.put(trafficLightRoad3.getPosition(),trafficLightRoad3);
        roads.put(trafficLightRoad4.getPosition(),trafficLightRoad4);


        //Giratoire
        Line2D gira1Line = new Line2D.Double(1160, 425, 1144, 440);
        ArrayList<Line2D> gira1Limits = new ArrayList<>();
        gira1Limits.add(gira1Line);
        Crossroad gira1 = new Crossroad(blocks[10][28],limit50, gira1Limits);
        roads.put(gira1.getPosition(), gira1);

        Line2D gira2Line = new Line2D.Double(1198, 403, 1160, 423);
        ArrayList<Line2D> gira2Limits = new ArrayList<>();
        gira2Limits.add(gira2Line);
        Crossroad gira2 = new Crossroad(blocks[10][29],limit50, gira2Limits);
        roads.put(gira2.getPosition(), gira2);

        Crossroad gira3 = new Crossroad(blocks[10][30],limit50, new ArrayList<Line2D>());
        roads.put(gira3.getPosition(), gira3);

        Crossroad gira4 = new Crossroad(blocks[10][31],limit50, new ArrayList<Line2D>());
        roads.put(gira4.getPosition(), gira4);

        Line2D gira5Line = new Line2D.Double(1280, 405, 1320, 430);
        ArrayList<Line2D> gira5Limits = new ArrayList<>();
        gira5Limits.add(gira5Line);
        Crossroad gira5 = new Crossroad(blocks[10][32],limit50, gira5Limits);
        roads.put(gira5.getPosition(), gira5);

        Line2D gira6Line = new Line2D.Double(1320, 430, 1330, 440);
        ArrayList<Line2D> gira6Limits = new ArrayList<>();
        gira6Limits.add(gira6Line);
        Crossroad gira6 = new Crossroad(blocks[10][33],limit50, gira6Limits);
        roads.put(gira6.getPosition(), gira6);

        Line2D gira7Line = new Line2D.Double(1143, 440, 1120, 480);
        ArrayList<Line2D> gira7Limits = new ArrayList<>();
        gira7Limits.add(gira7Line);
        Crossroad gira7 = new Crossroad(blocks[11][28],limit50, gira7Limits);
        roads.put(gira7.getPosition(), gira7);

        Crossroad gira8 = new Crossroad(blocks[11][29],limit50, new ArrayList<Line2D>());
        roads.put(gira8.getPosition(), gira8);

        Line2D gira9Line1 = new Line2D.Double(1220, 480, 1260, 480);
        ArrayList<Line2D> gira9Limits = new ArrayList<>();
        gira9Limits.add(gira9Line1);
        Crossroad gira9 = new Crossroad(blocks[11][30],limit50, gira9Limits);
        roads.put(gira9.getPosition(), gira9);

        Line2D gira10Line1 = new Line2D.Double(1240, 480, 1260, 480);
        ArrayList<Line2D> gira10Limits = new ArrayList<>();
        gira10Limits.add(gira10Line1);
        Crossroad gira10 = new Crossroad(blocks[11][31], limit50, gira10Limits);
        roads.put(gira10.getPosition(), gira10);

        Crossroad gira11 = new Crossroad(blocks[11][32], limit50, new ArrayList<Line2D>());
        roads.put(gira11.getPosition(), gira11);

        Line2D gira12Line = new Line2D.Double(1330, 440, 1354, 480);
        ArrayList<Line2D> gira12Limits = new ArrayList<>();
        gira12Limits.add(gira12Line);
        Crossroad gira12 = new Crossroad(blocks[11][33], limit50, gira12Limits);
        roads.put(gira12.getPosition(), gira12);

        Crossroad gira13 = new Crossroad(blocks[12][28], limit50, new ArrayList<Line2D>());
        roads.put(gira13.getPosition(), gira13);

        Line2D gira14Line1 = new Line2D.Double(1200, 500, 1200, 535);
        ArrayList<Line2D> gira14Limits = new ArrayList<>();
        gira14Limits.add(gira14Line1);
        Crossroad gira14 = new Crossroad(blocks[12][29], limit50, gira14Limits);
        roads.put(gira14.getPosition(), gira14);

        Line2D gira15Line1 = new Line2D.Double(1220, 480, 1260, 480);
        Line2D gira15Line2 = new Line2D.Double(1220, 480, 1200, 500);
        Line2D gira15Line3 = new Line2D.Double(1200, 500, 1200, 535);
        ArrayList<Line2D>  gira15Limits = new ArrayList<>();
        gira15Limits.add(gira15Line1);
        gira15Limits.add(gira15Line2);
        gira15Limits.add(gira15Line3);
        Crossroad gira15 = new Crossroad(blocks[12][30], limit50, gira15Limits);
        roads.put(gira15.getPosition(), gira15);

        Line2D gira16Line1 = new Line2D.Double(1240, 480, 1260, 480);
        Line2D gira16Line2 = new Line2D.Double(1260, 480, 1280, 500);
        Line2D gira16Line3 = new Line2D.Double(1280, 500, 1280, 535);
        ArrayList<Line2D> gira16Limits = new ArrayList<>();
        gira16Limits.add(gira16Line1);
        gira16Limits.add(gira16Line2);
        gira16Limits.add(gira16Line3);
        Crossroad gira16 = new Crossroad(blocks[12][31], limit50, gira16Limits);
        roads.put(gira16.getPosition(), gira16);

        Line2D gira17Line1 = new Line2D.Double(1280, 500, 1280, 535);
        ArrayList<Line2D> gira17Limits = new ArrayList<>();
        gira17Limits.add(gira17Line1);
        Crossroad gira17 = new Crossroad(blocks[12][32], limit50, gira17Limits);
        roads.put(gira17.getPosition(), gira17);

        Crossroad gira18 = new Crossroad(blocks[12][33], limit50, new ArrayList<Line2D>());
        roads.put(gira18.getPosition(), gira18);

        Crossroad gira19 = new Crossroad(blocks[13][28], limit50, new ArrayList<Line2D>());
        roads.put(gira19.getPosition(), gira19);

        Line2D gira20Line1 = new Line2D.Double(1200, 500, 1200, 535);
        ArrayList<Line2D> gira20Limits = new ArrayList<>();
        gira20Limits.add(gira20Line1);
        Crossroad gira20 = new Crossroad(blocks[13][29], limit50, gira20Limits);
        roads.put(gira20.getPosition(), gira20);

        Line2D gira21Line1 = new Line2D.Double(1200, 500, 1200, 535);
        Line2D gira21Line2 = new Line2D.Double(1200, 535, 1220, 560);
        Line2D gira21Line3 = new Line2D.Double(1220, 560, 1260, 560);
        ArrayList<Line2D>  gira21Limits = new ArrayList<>();
        gira21Limits.add(gira21Line1);
        gira21Limits.add(gira21Line2);
        gira21Limits.add(gira21Line3);
        Crossroad gira21 = new Crossroad(blocks[13][30], limit50, gira21Limits);
        roads.put(gira21.getPosition(), gira21);

        Line2D gira22Line1 = new Line2D.Double(1280, 500, 1280, 535);
        Line2D gira22Line2 = new Line2D.Double(1280, 535, 1260, 560);
        Line2D gira22Line3 = new Line2D.Double(1220, 560, 1260, 560);
        ArrayList<Line2D>  gira22Limits = new ArrayList<>();
        gira22Limits.add(gira22Line1);
        gira22Limits.add(gira22Line2);
        gira22Limits.add(gira22Line3);
        Crossroad gira22 = new Crossroad(blocks[13][31], limit50, gira22Limits);
        roads.put(gira22.getPosition(), gira22);

        Line2D gira23Line1 = new Line2D.Double(1280, 500, 1280, 535);
        ArrayList<Line2D> gira23Limits = new ArrayList<>();
        gira23Limits.add(gira23Line1);
        Crossroad gira23 = new Crossroad(blocks[13][32], limit50, gira23Limits);
        roads.put(gira23.getPosition(), gira23);

        Crossroad gira24 = new Crossroad(blocks[13][33], limit50, new ArrayList<Line2D>());
        roads.put(gira24.getPosition(), gira24);

        Line2D gira25Line = new Line2D.Double(1120, 560, 1146, 600);
        ArrayList<Line2D> gira25Limits = new ArrayList<>();
        gira25Limits.add(gira25Line);
        Crossroad gira25 = new Crossroad(blocks[14][28], limit50, gira25Limits);
        roads.put(gira25.getPosition(), gira25);

        Crossroad gira26 = new Crossroad(blocks[14][29], limit50, new ArrayList<Line2D>());
        roads.put(gira26.getPosition(), gira26);

        Line2D gira27Line1 = new Line2D.Double(1220, 560, 1260, 560);
        ArrayList<Line2D> gira27Limits = new ArrayList<>();
        gira27Limits.add(gira27Line1);
        Crossroad gira27 = new Crossroad(blocks[14][30], limit50, gira27Limits);
        roads.put(gira27.getPosition(), gira27);

        Line2D gira28Line1 = new Line2D.Double(1220, 560, 1260, 560);
        ArrayList<Line2D> gira28Limits = new ArrayList<>();
        gira28Limits.add(gira28Line1);
        Crossroad gira28 = new Crossroad(blocks[14][31], limit50, gira28Limits);
        roads.put(gira28.getPosition(), gira28);

        Crossroad gira29 = new Crossroad(blocks[14][32], limit50, new ArrayList<Line2D>());
        roads.put(gira29.getPosition(), gira29);

        Line2D gira30Line = new Line2D.Double(1352, 560, 1328, 600);
        ArrayList<Line2D> gira30Limits = new ArrayList<>();
        gira30Limits.add(gira30Line);
        Crossroad gira30 = new Crossroad(blocks[14][33], limit50, gira30Limits);
        roads.put(gira30.getPosition(), gira30);

        Line2D gira31Line = new Line2D.Double(1146, 600, 1160, 614);
        ArrayList<Line2D> gira31Limits = new ArrayList<>();
        gira31Limits.add(gira31Line);
        Crossroad gira31 = new Crossroad(blocks[15][28], limit50, gira31Limits);
        roads.put(gira31.getPosition(), gira31);

        Line2D gira32Line = new Line2D.Double(1160, 614, 1198, 636);
        ArrayList<Line2D> gira32Limits = new ArrayList<>();
        gira32Limits.add(gira32Line);
        Crossroad gira32 = new Crossroad(blocks[15][29], limit50, gira32Limits);
        roads.put(gira32.getPosition(), gira32);

        Crossroad gira33 = new Crossroad(blocks[15][30], limit50, new ArrayList<Line2D>());
        roads.put(gira33.getPosition(), gira33);

        Crossroad gira34 = new Crossroad(blocks[15][31], limit50, new ArrayList<Line2D>());
        roads.put(gira34.getPosition(), gira34);

        Line2D gira35Line = new Line2D.Double(1320, 609, 1280, 633);
        ArrayList<Line2D> gira35Limits = new ArrayList<>();
        gira35Limits.add(gira35Line);
        Crossroad gira35 = new Crossroad(blocks[15][32], limit50, gira35Limits);
        roads.put(gira35.getPosition(), gira35);

        Line2D gira36Line = new Line2D.Double(1328, 600, 1320, 609);
        ArrayList<Line2D> gira36Limits = new ArrayList<>();
        gira36Limits.add(gira36Line);
        Crossroad gira36 = new Crossroad(blocks[15][33], limit50, gira36Limits);
        roads.put(gira36.getPosition(), gira36);

        //Rond poind
        Line2D rp1Line = new Line2D.Double(360, 425, 344, 440);
        ArrayList<Line2D> rp1Limits = new ArrayList<>();
        rp1Limits.add(rp1Line);
        Crossroad rp1 = new Crossroad(blocks[10][8], limit50, rp1Limits);
        roads.put(rp1.getPosition(), rp1);

        Line2D rp2Line = new Line2D.Double(398, 403, 360, 423);
        ArrayList<Line2D> rp2Limits = new ArrayList<>();
        rp2Limits.add(rp2Line);
        Crossroad rp2 = new Crossroad(blocks[10][9], limit50, rp2Limits);
        roads.put(rp2.getPosition(), rp2);

        Crossroad rp3 = new Crossroad(blocks[10][10], limit50, new ArrayList<Line2D>());
        roads.put(rp3.getPosition(), rp3);

        Crossroad rp4 = new Crossroad(blocks[10][11], limit50, new ArrayList<Line2D>());
        roads.put(rp4.getPosition(), rp4);

        Line2D rp5Line = new Line2D.Double(480, 405, 520, 430);
        ArrayList<Line2D> rp5Limits = new ArrayList<>();
        rp5Limits.add(rp5Line);
        Crossroad rp5 = new Crossroad(blocks[10][12], limit50, rp5Limits);
        roads.put(rp5.getPosition(), rp5);

        Line2D rp6Line = new Line2D.Double(520, 430, 530, 440);
        ArrayList<Line2D>  rp6Limits = new ArrayList<>();
        rp6Limits.add(rp6Line);
        Crossroad rp6 = new Crossroad(blocks[10][13], limit50, rp6Limits);
        roads.put(rp6.getPosition(), rp6);

        Line2D rp7Line = new Line2D.Double(343, 440, 320, 480);
        ArrayList<Line2D> rp7Limits = new ArrayList<>();
        rp7Limits.add(rp7Line);
        Crossroad rp7 = new Crossroad(blocks[11][8], limit50, rp7Limits);
        roads.put(rp7.getPosition(), rp7);

        Crossroad rp8 = new Crossroad(blocks[11][9], limit50, new ArrayList<Line2D>());
        roads.put(rp8.getPosition(), rp8);

        Line2D rp9Line1 = new Line2D.Double(420, 480, 440, 480);
        ArrayList<Line2D> rp9Limits = new ArrayList<>();
        rp9Limits.add(rp9Line1);
        Crossroad rp9 = new Crossroad(blocks[11][10], limit50, rp9Limits);
        roads.put(rp9.getPosition(), rp9);

        Line2D rp10Line1 = new Line2D.Double(440, 480, 460, 480);
        ArrayList<Line2D> rp10Limits = new ArrayList<>();
        rp10Limits.add(rp10Line1);
        Crossroad rp10 = new Crossroad(blocks[11][11], limit50, rp10Limits);
        roads.put(rp10.getPosition(), rp10);

        Crossroad rp11 = new Crossroad(blocks[11][12], limit50, new ArrayList<Line2D>());
        roads.put(rp11.getPosition(), rp11);

        Line2D rp12Line = new Line2D.Double(530, 440, 554, 480);
        ArrayList<Line2D> rp12Limits = new ArrayList<>();
        rp12Limits.add(rp12Line);
        Crossroad rp12 = new Crossroad(blocks[11][13], limit50, rp12Limits);
        roads.put(rp12.getPosition(), rp12);

        Crossroad rp13 = new Crossroad(blocks[12][8], limit50, new ArrayList<Line2D>());
        roads.put(rp13.getPosition(), rp13);

        Line2D rp14Line1 = new Line2D.Double(400, 500, 400, 520);
        ArrayList<Line2D> rp14Limits = new ArrayList<>();
        rp14Limits.add(rp14Line1);
        Crossroad rp14 = new Crossroad(blocks[12][9], limit50, rp14Limits);
        roads.put(rp14.getPosition(), rp14);

        Line2D rp15Line1 = new Line2D.Double(420, 480, 440, 480);
        Line2D rp15Line2 = new Line2D.Double(420, 480, 400, 500);
        Line2D rp15Line3 = new Line2D.Double(400, 500, 400, 520);
        ArrayList<Line2D> rp15Limits = new ArrayList<>();
        rp15Limits.add(rp15Line1);
        rp15Limits.add(rp15Line2);
        rp15Limits.add(rp15Line3);
        Crossroad rp15 = new Crossroad(blocks[12][10], limit50, rp15Limits);
        roads.put(rp15.getPosition(), rp15);

        Line2D rp16Line1 = new Line2D.Double(440, 480, 460, 480);
        Line2D rp16Line2 = new Line2D.Double(460, 480, 480, 500);
        Line2D rp16Line3 = new Line2D.Double(480, 500, 480, 520);
        ArrayList<Line2D> rp16Limits = new ArrayList<>();
        rp16Limits.add(rp16Line1);
        rp16Limits.add(rp16Line2);
        rp16Limits.add(rp16Line3);
        Crossroad rp16 = new Crossroad(blocks[12][11], limit50, rp16Limits);
        roads.put(rp16.getPosition(), rp16);

        Line2D rp17Line1 = new Line2D.Double(480, 500, 480, 520);
        ArrayList<Line2D> rp17Limits = new ArrayList<>();
        rp17Limits.add(rp17Line1);
        Crossroad rp17 = new Crossroad(blocks[12][12], limit50, rp17Limits);
        roads.put(rp17.getPosition(), rp17);

        Crossroad rp18 = new Crossroad(blocks[12][13], limit50, new ArrayList<Line2D>());
        roads.put(rp18.getPosition(), rp18);

        Crossroad rp19 = new Crossroad(blocks[13][8], limit50, new ArrayList<Line2D>());
        roads.put(rp19.getPosition(), rp19);

        Line2D rp20Line1 = new Line2D.Double(400, 500, 400, 535);
        ArrayList<Line2D> rp20Limits = new ArrayList<>();
        rp20Limits.add(rp20Line1);
        Crossroad rp20 = new Crossroad(blocks[13][9], limit50, rp20Limits);
        roads.put(rp20.getPosition(), rp20);

        Line2D rp21Line1 = new Line2D.Double(400, 500, 400, 535);
        Line2D rp21Line2 = new Line2D.Double(400, 535, 420, 560);
        Line2D rp21Line3 = new Line2D.Double(420, 560, 440, 560);
        ArrayList<Line2D> rp21Limits = new ArrayList<>();
        rp21Limits.add(rp21Line1);
        rp21Limits.add(rp21Line2);
        rp21Limits.add(rp21Line3);
        Crossroad rp21 = new Crossroad(blocks[13][10], limit50, rp21Limits);
        roads.put(rp21.getPosition(), rp21);

        Line2D rp22Line1 = new Line2D.Double(480, 520, 480, 535);
        Line2D rp22Line2 = new Line2D.Double(480, 535, 460, 560);
        Line2D rp22Line3 = new Line2D.Double(440, 560, 460, 560);
        ArrayList<Line2D> rp22Limits = new ArrayList<>();
        rp22Limits.add(rp22Line1);
        rp22Limits.add(rp22Line2);
        rp22Limits.add(rp22Line3);
        Crossroad rp22 = new Crossroad(blocks[13][11], limit50, rp22Limits);
        roads.put(rp22.getPosition(), rp22);

        Line2D rp23Line1 = new Line2D.Double(480, 520, 480, 535);
        ArrayList<Line2D> rp23Limits = new ArrayList<>();
        rp23Limits.add(rp23Line1);
        Crossroad rp23 = new Crossroad(blocks[13][12], limit50, rp23Limits);
        roads.put(rp23.getPosition(), rp23);

        Crossroad rp24 = new Crossroad(blocks[13][13], limit50, new ArrayList<Line2D>());
        roads.put(rp24.getPosition(), rp24);

        Line2D rp25Line = new Line2D.Double(320, 560, 346, 600);
        ArrayList<Line2D> rp25Limits = new ArrayList<>();
        rp25Limits.add(rp25Line);
        Crossroad rp25 = new Crossroad(blocks[14][8], limit50, rp25Limits);
        roads.put(rp25.getPosition(), rp25);

        Crossroad rp26 = new Crossroad(blocks[14][9], limit50, new ArrayList<Line2D>());
        roads.put(rp26.getPosition(), rp26);

        Line2D rp27Line1 = new Line2D.Double(420, 560, 440, 560);
        ArrayList<Line2D> rp27Limits = new ArrayList<>();
        rp27Limits.add(rp27Line1);
        Crossroad rp27 = new Crossroad(blocks[14][10], limit50, rp2Limits);
        roads.put(rp27.getPosition(), rp27);

        Line2D rp28Line1 = new Line2D.Double(440, 560, 460, 560);
        ArrayList<Line2D> rp28Limits = new ArrayList<>();
        rp28Limits.add(rp28Line1);
        Crossroad rp28 = new Crossroad(blocks[14][11], limit50, rp28Limits);
        roads.put(rp28.getPosition(), rp28);

        Crossroad rp29 = new Crossroad(blocks[14][12], limit50, new ArrayList<Line2D>());
        roads.put(rp29.getPosition(), rp29);

        Line2D rp30Line = new Line2D.Double(552, 560, 528, 600);
        ArrayList<Line2D> rp30Limits = new ArrayList<>();
        rp30Limits.add(rp30Line);
        Crossroad rp30 = new Crossroad(blocks[14][13], limit50, rp30Limits);
        roads.put(rp30.getPosition(), rp30);

        Line2D rp31Line = new Line2D.Double(346, 600, 360, 614);
        ArrayList<Line2D> rp31Limits = new ArrayList<>();
        rp31Limits.add(rp31Line);
        Crossroad rp31 = new Crossroad(blocks[15][8], limit50, rp31Limits);
        roads.put(rp31.getPosition(), rp31);

        Line2D rp32Line = new Line2D.Double(360, 614, 398, 636);
        ArrayList<Line2D> rp32Limits = new ArrayList<>();
        rp32Limits.add(rp32Line);
        Crossroad rp32 = new Crossroad(blocks[15][9], limit50, rp32Limits);
        roads.put(rp32.getPosition(), rp32);

        Crossroad rp33 = new Crossroad(blocks[15][10], limit50, new ArrayList<Line2D>());
        roads.put(rp33.getPosition(), rp33);

        Crossroad rp34 = new Crossroad(blocks[15][11], limit50, new ArrayList<Line2D>());
        roads.put(rp34.getPosition(), rp34);

        Line2D rp35Line = new Line2D.Double(520, 609, 480, 633);
        ArrayList<Line2D> rp35Limits = new ArrayList<>();
        rp35Limits.add(rp35Line);
        Crossroad rp35 = new Crossroad(blocks[15][12], limit50, rp35Limits);
        roads.put(rp35.getPosition(), rp35);

        Line2D rp36Line = new Line2D.Double(528, 600, 520, 609);
        ArrayList<Line2D> rp36Limits = new ArrayList<>();
        rp36Limits.add(rp36Line);
        Crossroad rp36 = new Crossroad(blocks[15][13], limit50, rp36Limits);
        roads.put(rp36.getPosition(), rp36);

        //Route de scénario
        Line2D sr1Line1 = new Line2D.Double(21*40, 15*40, 21*40, 16*40);
        Line2D sr1Line2 = new Line2D.Double(22*40, 15*40, 22*40, 16*40);
        ArrayList<Line2D> sr1Limits = new ArrayList<>();
        sr1Limits.add(sr1Line1);
        sr1Limits.add(sr1Line2);
        ScenarioRoad sr1 = new ScenarioRoad(blocks[15][21], up, limit50, sr1Limits, scenarios.get(1));
        roads.put(sr1.getPosition(), sr1);

        Line2D rr1Line1 = new Line2D.Double(19*40, 12*40, 20*40, 12*40);
        Line2D rr1Line2 = new Line2D.Double(19*40, 13*40, 20*40, 13*40);
        ArrayList<Line2D> rr1Limits = new ArrayList<>();
        rr1Limits.add(rr1Line1);
        rr1Limits.add(rr1Line2);
        ResolveRoad rr1 = new ResolveRoad(blocks[12][19], left, limit50, rr1Limits, scenarios.get(1));
        roads.put(rr1.getPosition(), rr1);

        Line2D sr2Line1 = new Line2D.Double(16*40, 12*40, 17*40, 12*40);
        Line2D sr2Line2 = new Line2D.Double(16*40, 13*40, 17*40, 13*40);
        ArrayList<Line2D> sr2Limits = new ArrayList<>();
        sr2Limits.add(sr2Line1);
        sr2Limits.add(sr2Line2);
        ScenarioRoad sr2 = new ScenarioRoad(blocks[12][16], left, limit50, sr2Limits, scenarios.get(2));
        roads.put(sr2.getPosition(), sr2);

        Line2D rr2Line1 = new Line2D.Double(7*40, 12*40, 8*40, 12*40);
        Line2D rr2Line2 = new Line2D.Double(7*40, 13*40, 8*40, 13*40);
        ArrayList<Line2D> rr2Limits = new ArrayList<>();
        rr2Limits.add(rr2Line1);
        rr2Limits.add(rr2Line2);
        ResolveRoad rr2 = new ResolveRoad(blocks[12][7], left, limit50, rr2Limits, scenarios.get(2));
        roads.put(rr2.getPosition(), rr2);

        Line2D sr3Line1 = new Line2D.Double(4*40, 12*40, 5*40, 12*40);
        Line2D sr3Line2 = new Line2D.Double(4*40, 13*40, 5*40, 13*40);
        ArrayList<Line2D> sr3Limits = new ArrayList<>();
        sr3Limits.add(sr3Line1);
        sr3Limits.add(sr3Line2);
        ScenarioRoad sr3 = new ScenarioRoad(blocks[12][4], left, limit50, sr3Limits, scenarios.get(3));
        roads.put(sr3.getPosition(), sr3);

        Line2D rr3Line1 = new Line2D.Double(40, 11*40, 40, 12*40);
        Line2D rr3Line2 = new Line2D.Double(2*40, 11*40, 2*40, 12*40);
        ArrayList<Line2D> rr3Limits = new ArrayList<>();
        rr3Limits.add(rr3Line1);
        rr3Limits.add(rr3Line2);
        ResolveRoad rr3 = new ResolveRoad(blocks[11][1], up, limit50, rr3Limits, scenarios.get(3));
        roads.put(rr3.getPosition(), rr3);

        Line2D sr4Line1 = new Line2D.Double(40, 6*40, 40, 7*40);
        Line2D sr4Line2 = new Line2D.Double(2*40, 6*40, 2*40, 7*40);
        ArrayList<Line2D> sr4Limits = new ArrayList<>();
        sr4Limits.add(sr4Line1);
        sr4Limits.add(sr4Line2);
        ScenarioRoad sr4 = new ScenarioRoad(blocks[6][1], up, limit50, sr4Limits, scenarios.get(4));
        roads.put(sr4.getPosition(), sr4);

        Line2D rr4Line1 = new Line2D.Double(43*40, 5*40, 43*40, 6*40);
        Line2D rr4Line2 = new Line2D.Double(44*40, 5*40, 44*40, 6*40);
        ArrayList<Line2D> rr4Limits = new ArrayList<>();
        rr4Limits.add(rr4Line1);
        rr4Limits.add(rr4Line2);
        ResolveRoad rr4 = new ResolveRoad(blocks[5][43], down, limit50, rr4Limits, scenarios.get(4));
        roads.put(rr4.getPosition(), rr4);

        Line2D sr5Line1 = new Line2D.Double(43*40, 9*40, 43*40, 10*40);
        Line2D sr5Line2 = new Line2D.Double(44*40, 9*40, 44*40, 10*40);
        ArrayList<Line2D> sr5Limits = new ArrayList<>();
        sr5Limits.add(sr5Line1);
        sr5Limits.add(sr5Line2);
        ScenarioRoad sr5 = new ScenarioRoad(blocks[9][43], down, limit50, sr5Limits, scenarios.get(5));
        roads.put(sr5.getPosition(), sr5);

        Line2D rr5Line1 = new Line2D.Double(40*40, 12*40, 41*40, 12*40);
        Line2D rr5Line2 = new Line2D.Double(40*40, 13*40, 41*40, 13*40);
        ArrayList<Line2D> rr5Limits = new ArrayList<>();
        rr5Limits.add(rr5Line1);
        rr5Limits.add(rr5Line2);
        ResolveRoad rr5 = new ResolveRoad(blocks[12][40], left, limit50, rr5Limits, scenarios.get(5));
        roads.put(rr5.getPosition(), rr5);

        Line2D sr6Line1 = new Line2D.Double(36*40, 12*40, 37*40, 12*40);
        Line2D sr6Line2 = new Line2D.Double(36*40, 13*40, 37*40, 13*40);
        ArrayList<Line2D> sr6Limits = new ArrayList<>();
        sr6Limits.add(sr6Line1);
        sr6Limits.add(sr6Line2);
        ScenarioRoad sr6 = new ScenarioRoad(blocks[12][36], left, limit50, sr6Limits, scenarios.get(6));
        roads.put(sr6.getPosition(), sr6);

        Line2D rr6Line1 = new Line2D.Double(31*40, 8*40, 31*40, 9*40);
        Line2D rr6Line2 = new Line2D.Double(32*40, 5*40, 32*40, 9*40);
        ArrayList<Line2D> rr6Limits = new ArrayList<>();
        rr6Limits.add(rr6Line1);
        rr6Limits.add(rr6Line2);
        ResolveRoad rr6 = new ResolveRoad(blocks[8][31], up, limit50, rr6Limits, scenarios.get(6));
        roads.put(rr6.getPosition(), rr6);

        Line2D sr7Line1 = new Line2D.Double(24*40, 5*40, 25*40, 5*40);
        Line2D sr7Line2 = new Line2D.Double(24*40, 6*40, 25*40, 6*40);
        ArrayList<Line2D> sr7Limits = new ArrayList<>();
        sr7Limits.add(sr7Line1);
        sr7Limits.add(sr7Line2);
        ScenarioRoad sr7 = new ScenarioRoad(blocks[5][24], left, limit50, sr7Limits, scenarios.get(7));
        roads.put(sr7.getPosition(), sr7);

        Line2D rr7Line1 = new Line2D.Double(19*40, 5*40, 20*40, 5*40);
        Line2D rr7Line2 = new Line2D.Double(19*40, 6*40, 20*40, 6*40);
        ArrayList<Line2D> rr7Limits = new ArrayList<>();
        rr7Limits.add(rr7Line1);
        rr7Limits.add(rr7Line2);
        ResolveRoad rr7 = new ResolveRoad(blocks[5][19], left, limit50, rr7Limits, scenarios.get(7));
        roads.put(rr7.getPosition(), rr7);

        Line2D sr8Line1 = new Line2D.Double(10*40, 8*40, 10*40, 9*40);
        Line2D sr8Line2 = new Line2D.Double(11*40, 8*40, 11*40, 9*40);
        ArrayList<Line2D> sr8Limits = new ArrayList<>();
        sr8Limits.add(sr8Line1);
        sr8Limits.add(sr8Line2);
        ScenarioRoad sr8 = new ScenarioRoad(blocks[8][10], down, limit50, sr8Limits, scenarios.get(8));
        roads.put(sr8.getPosition(), sr8);

        Line2D rr8Line1 = new Line2D.Double(14*40, 13*40, 15*40, 13*40);
        Line2D rr8Line2 = new Line2D.Double(14*40, 14*40, 15*40, 14*40);
        ArrayList<Line2D> rr8Limits = new ArrayList<>();
        rr8Limits.add(rr8Line1);
        rr8Limits.add(rr8Line2);
        ResolveRoad rr8 = new ResolveRoad(blocks[13][14], right, limit50, rr8Limits, scenarios.get(8));
        roads.put(rr8.getPosition(), rr8);

        Line2D sr9Line1 = new Line2D.Double(17*40, 13*40, 18*40, 13*40);
        Line2D sr9Line2 = new Line2D.Double(17*40, 14*40, 18*40, 14*40);
        ArrayList<Line2D> sr9Limits = new ArrayList<>();
        sr9Limits.add(sr9Line1);
        sr9Limits.add(sr9Line2);
        ScenarioRoad sr9 = new ScenarioRoad(blocks[13][17], right, limit50, sr9Limits, scenarios.get(9));
        roads.put(sr9.getPosition(), sr9);

        Line2D rr9Line1 = new Line2D.Double(22*40, 13*40, 22*40, 13*40);
        Line2D rr9Line2 = new Line2D.Double(22*40, 14*40, 22*40, 14*40);
        ArrayList<Line2D> rr9Limits = new ArrayList<>();
        rr9Limits.add(rr9Line1);
        rr9Limits.add(rr9Line2);
        ResolveRoad rr9 = new ResolveRoad(blocks[13][22], right, limit50, rr9Limits, scenarios.get(9));
        roads.put(rr9.getPosition(), rr9);

        Line2D sr10Line1 = new Line2D.Double(24*40, 13*40, 25*40, 13*40);
        Line2D sr10Line2 = new Line2D.Double(24*40, 14*40, 25*40, 14*40);
        ArrayList<Line2D> sr10Limits = new ArrayList<>();
        sr10Limits.add(sr10Line1);
        sr10Limits.add(sr10Line2);
        ScenarioRoad sr10 = new ScenarioRoad(blocks[13][24], right, limit50, sr10Limits, scenarios.get(10));
        roads.put(sr10.getPosition(), sr10);

        Line2D rr10Line1 = new Line2D.Double(30*40, 17*40, 30*40, 21*40);
        Line2D rr10Line2 = new Line2D.Double(31*40, 17*40, 31*40, 19*40);
        ArrayList<Line2D> rr10Limits = new ArrayList<>();
        rr10Limits.add(rr10Line1);
        rr10Limits.add(rr10Line2);
        ResolveRoad rr10 = new ResolveRoad(blocks[17][30], down, limit50, rr10Limits, scenarios.get(10));
        roads.put(rr10.getPosition(), rr10);

        Line2D sr11Line1 = new Line2D.Double(38*40, 20*40, 39*40, 20*40);
        Line2D sr11Line2 = new Line2D.Double(38*40, 21*40, 39*40, 21*40);
        ArrayList<Line2D> sr11Limits = new ArrayList<>();
        sr11Limits.add(sr11Line1);
        sr11Limits.add(sr11Line2);
        ScenarioRoad sr11 = new ScenarioRoad(blocks[20][38], right, limit50, sr11Limits, scenarios.get(11));
        roads.put(sr11.getPosition(), sr11);

        Line2D rr11Line1 = new Line2D.Double(43*40, 18*40, 43*40, 19*40);
        Line2D rr11Line2 = new Line2D.Double(44*40, 18*40, 44*40, 19*40);
        ArrayList<Line2D> rr11Limits = new ArrayList<>();
        rr11Limits.add(rr11Line1);
        rr11Limits.add(rr11Line2);
        ResolveRoad rr11 = new ResolveRoad(blocks[18][43], up, limit50, rr11Limits, scenarios.get(11));
        roads.put(rr11.getPosition(), rr11);

        Line2D sr12Line1 =new Line2D.Double(44*40, 16*40, 44*40, 19*40);
        Line2D sr12Line2 =new Line2D.Double(43*40, 16*40, 43*40, 19*40);
        ArrayList<Line2D> sr12Limits = new ArrayList<>();
        sr12Limits.add(sr12Line1);
        sr12Limits.add(sr12Line2);
        ScenarioRoad sr12 = new ScenarioRoad(blocks[17][43], up, limit50, sr12Limits, scenarios.get(12));
        roads.put(sr12.getPosition(), sr12);

        Line2D grLine1 =new Line2D.Double(44*40, 14*40, 45*40, 14*40);
        Line2D grLine2 =new Line2D.Double(44*40, 13*40, 45*40, 13*40);
        ArrayList<Line2D> grLimits = new ArrayList<>();
        grLimits.add(grLine1);
        grLimits.add(grLine2);
        GoalRoad gr = new GoalRoad(blocks[13][44], right, limit50, grLimits, scenarios.get(12));
        roads.put(gr.getPosition(), gr);

        //Route scénario raté
        Line2D rr13Line1 =new Line2D.Double(40, 14*40, 40, 15*40);
        Line2D rr13Line2 =new Line2D.Double(2*40, 14*40, 2*40, 15*40);
        ArrayList<Line2D> rr13Limits = new ArrayList<>();
        rr13Limits.add(rr13Line1);
        rr13Limits.add(rr13Line2);
        ResolveRoad rr13 = new ResolveRoad(blocks[14][1], down, limit50, rr13Limits, scenarios.get(0));
        roads.put(rr13.getPosition(), rr13);

        Line2D rr14Line1 =new Line2D.Double(10*40, 16*40, 10*40, 17*40);
        Line2D rr14Line2 =new Line2D.Double(11*40, 16*40, 11*40, 17*40);
        ArrayList<Line2D> rr14Limits = new ArrayList<>();
        rr14Limits.add(rr14Line1);
        rr14Limits.add(rr14Line2);
        ResolveRoad rr14 = new ResolveRoad(blocks[16][10], down, limit50, rr14Limits, scenarios.get(0));
        roads.put(rr14.getPosition(), rr14);

        Line2D rr15Line1 =new Line2D.Double(11*40, 9*40, 11*40, 10*40);
        Line2D rr15Line2 =new Line2D.Double(12*40, 9*40, 12*40, 10*40);
        ArrayList<Line2D> rr15Limits = new ArrayList<>();
        rr15Limits.add(rr15Line1);
        rr15Limits.add(rr15Line2);
        ResolveRoad rr15 = new ResolveRoad(blocks[9][11], up, limit50, rr15Limits, scenarios.get(0));
        roads.put(rr15.getPosition(), rr15);

        Line2D rr16Line1 =new Line2D.Double(20*40, 7*40, 20*40, 8*40);
        Line2D rr16Line2 =new Line2D.Double(21*40, 7*40, 21*40, 8*40);
        ArrayList<Line2D> rr16Limits = new ArrayList<>();
        rr16Limits.add(rr16Line1);
        rr16Limits.add(rr16Line2);
        ResolveRoad rr16 = new ResolveRoad(blocks[7][20], down, limit50, rr16Limits, scenarios.get(0));
        roads.put(rr16.getPosition(), rr16);

        Line2D rr17Line1 =new Line2D.Double(21*40, 11*40, 21*40, 12*40);
        Line2D rr17Line2 =new Line2D.Double(22*40, 11*40, 22*40, 12*40);
        ArrayList<Line2D> rr17Limits = new ArrayList<>();
        rr17Limits.add(rr17Line1);
        rr17Limits.add(rr17Line2);
        ResolveRoad rr17 = new ResolveRoad(blocks[11][21], up, limit50, rr17Limits, scenarios.get(0));
        roads.put(rr17.getPosition(), rr17);

        Line2D rr18Line1 =new Line2D.Double(20*40, 14*40, 20*40, 15*40);
        Line2D rr18Line2 =new Line2D.Double(20*40, 14*40, 21*40, 15*40);
        ArrayList<Line2D> rr18Limits = new ArrayList<>();
        rr18Limits.add(rr18Line1);
        rr18Limits.add(rr18Line2);
        ResolveRoad rr18 = new ResolveRoad(blocks[14][20], down, limit50, rr18Limits, scenarios.get(0));
        roads.put(rr18.getPosition(), rr18);

        Line2D rr19Line1 =new Line2D.Double(26*40, 12*40, 27*40, 12*40);
        Line2D rr19Line2 =new Line2D.Double(26*40, 13*40, 27*40, 13*40);
        ArrayList<Line2D> rr19Limits = new ArrayList<>();
        rr19Limits.add(rr19Line1);
        rr19Limits.add(rr19Line2);
        ResolveRoad rr19 = new ResolveRoad(blocks[12][26], left, limit50, rr19Limits, scenarios.get(0));
        roads.put(rr19.getPosition(), rr19);

        Line2D rr20Line1 =new Line2D.Double(42*40, 21*40, 42*40, 22*40);
        Line2D rr20Line2 =new Line2D.Double(43*40, 21*40, 43*40, 22*40);
        ArrayList<Line2D> rr20Limits = new ArrayList<>();
        rr20Limits.add(rr20Line1);
        rr20Limits.add(rr20Line2);
        ResolveRoad rr20 = new ResolveRoad(blocks[21][42], down, limit50, rr20Limits, scenarios.get(0));
        roads.put(rr20.getPosition(), rr20);

        Line2D rr21Line1 =new Line2D.Double(42*40, 15*40, 42*40, 16*40);
        Line2D rr21Line2 =new Line2D.Double(43*40, 15*40, 43*40, 16*40);
        ArrayList<Line2D> rr21Limits = new ArrayList<>();
        rr21Limits.add(rr21Line1);
        rr21Limits.add(rr21Line2);
        ResolveRoad rr21 = new ResolveRoad(blocks[15][42], down, limit50, rr21Limits, scenarios.get(0));
        roads.put(rr21.getPosition(), rr21);

        //Ajouts des routes ayant la priorité sur les crossroadEntry
        stop1.addRoads(crossroad13);
        stop1.addRoads(crossroad14);
        stop1.addRoads(crossroad16);
        stop1.addRoads(roads.get(blocks[5][21]));
        stop1.addRoads(roads.get(blocks[6][17]));
        stop1.addRoads(roads.get(blocks[6][18]));
        stop1.addRoads(roads.get(blocks[6][19]));
        stop1.addRoads(roads.get(blocks[7][21]));
        stop1.addRoads(roads.get(blocks[8][21]));
        stop1.addRoads(roads.get(blocks[9][21]));

        crossroadEntry1.addRoads(roads.get(blocks[20][1]));
        crossroadEntry1.addRoads(roads.get(blocks[21][1]));
        crossroadEntry1.addRoads(roads.get(blocks[22][1]));

        crossroadEntry2.addRoads(roads.get(blocks[19][2]));
        crossroadEntry2.addRoads(roads.get(blocks[19][3]));
        crossroadEntry2.addRoads(roads.get(blocks[19][4]));

        crossroadEntry3.addRoads(roads.get(blocks[19][1]));
        crossroadEntry3.addRoads(roads.get(blocks[18][1]));
        crossroadEntry3.addRoads(roads.get(blocks[17][1]));

        crossroadEntry4.addRoads(roads.get(blocks[20][0]));

        crossroadEntry7.addRoads(roads.get(blocks[10][8]));
        crossroadEntry7.addRoads(roads.get(blocks[10][9]));
        crossroadEntry7.addRoads(roads.get(blocks[10][10]));
        crossroadEntry7.addRoads(roads.get(blocks[11][8]));
        crossroadEntry7.addRoads(roads.get(blocks[11][9]));
        crossroadEntry7.addRoads(roads.get(blocks[11][10]));
        crossroadEntry7.addRoads(roads.get(blocks[12][8]));
        crossroadEntry7.addRoads(roads.get(blocks[12][9]));
        crossroadEntry7.addRoads(roads.get(blocks[12][10]));

        crossroadEntry8.addRoads(roads.get(blocks[13][8]));
        crossroadEntry8.addRoads(roads.get(blocks[13][9]));
        crossroadEntry8.addRoads(roads.get(blocks[13][10]));
        crossroadEntry8.addRoads(roads.get(blocks[14][8]));
        crossroadEntry8.addRoads(roads.get(blocks[14][9]));
        crossroadEntry8.addRoads(roads.get(blocks[14][10]));
        crossroadEntry8.addRoads(roads.get(blocks[15][8]));
        crossroadEntry8.addRoads(roads.get(blocks[15][9]));
        crossroadEntry8.addRoads(roads.get(blocks[15][10]));

        crossroadEntry9.addRoads(roads.get(blocks[13][11]));
        crossroadEntry9.addRoads(roads.get(blocks[13][12]));
        crossroadEntry9.addRoads(roads.get(blocks[13][13]));
        crossroadEntry9.addRoads(roads.get(blocks[14][11]));
        crossroadEntry9.addRoads(roads.get(blocks[14][12]));
        crossroadEntry9.addRoads(roads.get(blocks[14][13]));
        crossroadEntry9.addRoads(roads.get(blocks[15][11]));
        crossroadEntry9.addRoads(roads.get(blocks[15][12]));
        crossroadEntry9.addRoads(roads.get(blocks[15][13]));

        crossroadEntry10.addRoads(roads.get(blocks[10][11]));
        crossroadEntry10.addRoads(roads.get(blocks[10][12]));
        crossroadEntry10.addRoads(roads.get(blocks[10][13]));
        crossroadEntry10.addRoads(roads.get(blocks[11][11]));
        crossroadEntry10.addRoads(roads.get(blocks[11][12]));
        crossroadEntry10.addRoads(roads.get(blocks[11][13]));
        crossroadEntry10.addRoads(roads.get(blocks[12][11]));
        crossroadEntry10.addRoads(roads.get(blocks[12][12]));
        crossroadEntry10.addRoads(roads.get(blocks[12][13]));

        crossroadEntry13.addRoads(roads.get(blocks[14][21]));
        crossroadEntry13.addRoads(roads.get(blocks[15][21]));
        crossroadEntry13.addRoads(roads.get(blocks[16][21]));

        crossroadEntry14.addRoads(roads.get(blocks[12][22]));
        crossroadEntry14.addRoads(roads.get(blocks[12][23]));
        crossroadEntry14.addRoads(roads.get(blocks[12][24]));

        crossroadEntry15.addRoads(roads.get(blocks[11][20]));
        crossroadEntry15.addRoads(roads.get(blocks[10][20]));
        crossroadEntry15.addRoads(roads.get(blocks[9][20]));

        crossroadEntry16.addRoads(roads.get(blocks[13][19]));
        crossroadEntry16.addRoads(roads.get(blocks[13][18]));
        crossroadEntry16.addRoads(roads.get(blocks[13][17]));

        crossroadEntry17.addRoads(roads.get(blocks[7][21]));
        crossroadEntry17.addRoads(roads.get(blocks[8][21]));
        crossroadEntry17.addRoads(roads.get(blocks[9][21]));


        crossroadEntry22.addRoads(roads.get(blocks[10][28]));
        crossroadEntry22.addRoads(roads.get(blocks[10][29]));
        crossroadEntry22.addRoads(roads.get(blocks[10][30]));
        crossroadEntry22.addRoads(roads.get(blocks[11][28]));
        crossroadEntry22.addRoads(roads.get(blocks[11][29]));
        crossroadEntry22.addRoads(roads.get(blocks[11][30]));
        crossroadEntry22.addRoads(roads.get(blocks[12][28]));
        crossroadEntry22.addRoads(roads.get(blocks[12][29]));
        crossroadEntry22.addRoads(roads.get(blocks[12][30]));

        crossroadEntry23.addRoads(roads.get(blocks[13][28]));
        crossroadEntry23.addRoads(roads.get(blocks[13][29]));
        crossroadEntry23.addRoads(roads.get(blocks[13][30]));
        crossroadEntry23.addRoads(roads.get(blocks[14][28]));
        crossroadEntry23.addRoads(roads.get(blocks[14][29]));
        crossroadEntry23.addRoads(roads.get(blocks[14][30]));
        crossroadEntry23.addRoads(roads.get(blocks[15][28]));
        crossroadEntry23.addRoads(roads.get(blocks[15][29]));
        crossroadEntry23.addRoads(roads.get(blocks[15][30]));

        crossroadEntry24.addRoads(roads.get(blocks[13][31]));
        crossroadEntry24.addRoads(roads.get(blocks[13][32]));
        crossroadEntry24.addRoads(roads.get(blocks[13][33]));
        crossroadEntry24.addRoads(roads.get(blocks[14][31]));
        crossroadEntry24.addRoads(roads.get(blocks[14][32]));
        crossroadEntry24.addRoads(roads.get(blocks[14][33]));
        crossroadEntry24.addRoads(roads.get(blocks[15][31]));
        crossroadEntry24.addRoads(roads.get(blocks[15][32]));
        crossroadEntry24.addRoads(roads.get(blocks[15][33]));

        crossroadEntry25.addRoads(roads.get(blocks[10][31]));
        crossroadEntry25.addRoads(roads.get(blocks[10][32]));
        crossroadEntry25.addRoads(roads.get(blocks[10][33]));
        crossroadEntry25.addRoads(roads.get(blocks[11][31]));
        crossroadEntry25.addRoads(roads.get(blocks[11][32]));
        crossroadEntry25.addRoads(roads.get(blocks[11][33]));
        crossroadEntry25.addRoads(roads.get(blocks[12][31]));
        crossroadEntry25.addRoads(roads.get(blocks[12][32]));
        crossroadEntry25.addRoads(roads.get(blocks[12][33]));

        crossroadEntry28.addRoads(roads.get(blocks[21][43]));
        crossroadEntry28.addRoads(roads.get(blocks[22][43]));

        crossroadEntry30.addRoads(roads.get(blocks[20][41]));
        crossroadEntry30.addRoads(roads.get(blocks[20][40]));
        crossroadEntry30.addRoads(roads.get(blocks[20][39]));

    }


}
