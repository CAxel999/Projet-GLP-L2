package GUI;

import Config.GameConfiguration;

import javax.swing.*;
import java.awt.*;


public class MainGUI extends JFrame implements Runnable{
    private GamePanel dashboard;
    private final KeyControls keyControls = new KeyControls();
    private int FPS=60;

    public MainGUI(String title) {
        super(title);
        init();
    }

    private void init() {
        Container contentPane=getContentPane();
        //contentPane.setLayout(new BorderLayout());

        dashboard=new GamePanel();

        contentPane.add(dashboard);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);

    }

    /*@Override
    public void run() {
        double drawInterval= 1000000000/FPS;
        double delta = 0;
        long lasTime = System.nanoTime();
        long currentTime;
        while(true) {
            currentTime = System.nanoTime();
            delta += (currentTime - lasTime) / drawInterval;
            lasTime = currentTime;
            if (delta >= 1) {
                dashboard.update();
                dashboard.repaint();
                delta--;
            }
        }
    }*/

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(GameConfiguration.GAME_SPEED);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            dashboard.update();
            dashboard.repaint();
        }
    }

}

