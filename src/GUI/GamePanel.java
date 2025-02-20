package GUI;

import Block.BlockManager;
import CityElement.UserCar;
import Config.GameConfiguration;
import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {
    private final static Dimension preferedDimension = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
    private KeyControls keyControls = new KeyControls();
    private UserCar userCar=new UserCar(keyControls,this);
    private BlockManager blockManager = new BlockManager(this);

    public GamePanel(){
        setPreferredSize(preferedDimension);
        setBackground(Color.black);
        setDoubleBuffered(true);
        addKeyListener(keyControls);
        setFocusable(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        blockManager.draw(g);
        userCar.draw(g);


    }

    public void update(){
        userCar.update();
    }



}

