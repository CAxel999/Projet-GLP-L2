package engine.process;

import data.Mistake;
import data.Scenario;
import data.Score;

import java.util.ArrayList;
import java.util.HashMap;

public class ScoreManager {
    private Score score;
    private HashMap<Integer, Scenario> scenarioHashMap = new HashMap<Integer,Scenario>();
    private ArrayList<Mistake> mistakes = new ArrayList<Mistake>();
}
