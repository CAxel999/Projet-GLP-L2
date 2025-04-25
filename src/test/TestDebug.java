package test;

import config.GameConfiguration;
import gui.StartMenu;

public class TestDebug {
    public static void main(String[] args) {
        GameConfiguration.DEBUG = true;
        StartMenu startMenu = new StartMenu("Auto Ecole");
    }
}
