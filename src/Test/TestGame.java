package Test;
import GUI.MainGUI;

public class TestGame {
    public static void main(String[] args) {

        MainGUI gameMainGUI = new MainGUI("Auto Ecole");
        //gameMainGUI.setVisible(true);
        Thread gameThread = new Thread(gameMainGUI);
        gameThread.start();
    }
}
