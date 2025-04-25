package test;

import config.GameConfiguration;
import gui.StartMenu;

public class TestGame {
	public static void main(String[] args) {
			GameConfiguration.DEBUG = false;
			StartMenu startMenu = new StartMenu("Auto Ecole");
	}

}
