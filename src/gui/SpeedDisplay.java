package gui;

import engine.mobile.MainCar;
import engine.process.MobileInterface;
import javax.swing.*;
import java.awt.*;

/**
 * Display the speed of the mainCar overtime in a JPanel.
 */
public class SpeedDisplay extends JPanel {
    private static final long serialVersionUID = 1L;

    private MobileInterface manager;
    private PaintStrategy paintStrategy = new PaintStrategy();

    public SpeedDisplay(MobileInterface manager) {
        this.manager = manager;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = getWidth();
        int y = getHeight();

        MainCar mainCar = manager.getA();
        paintStrategy.paint(mainCar.getSpeed(),g, x/2-10, y/2+10);
    }
}
