package test;

import gui.MainGUI;

import java.io.IOException;

public class TestGame {
	public static void main(String[] args) {
        try {
			MainGUI gameMainGUI = new MainGUI("Car");
			Thread gameThread = new Thread(gameMainGUI);
			gameThread.start();
        } catch (IOException e) {
			System.err.println("File not found");
            //Write exception handling with logs
        }
	}
}
