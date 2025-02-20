package CityElement;

import Config.GameConfiguration;
import GUI.GamePanel;
import GUI.KeyControls;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class UserCar extends MobileElement{
    private GamePanel dashboard;
    private KeyControls keyControls;

    public UserCar(KeyControls keyControls, GamePanel dashboard) {
        this.keyControls = keyControls;
        this.dashboard = dashboard;
        setUserCarValues();
        getUserCarImage();
    }

    public void setUserCarValues(){
        setPosX(96);
        setPosY(96);
        setSpeed(4);
        setDirection("up");
    }

    public void getUserCarImage(){
        try{
            carUp= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/userCar/carUp.png")));
            carDown= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/userCar/carDown.png")));
            carLeft= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/userCar/carLeft.png")));
            carRight= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/userCar/carRight.png")));

        } catch (IOException e) {
            System.err.println("-- Can not read the image file ! --");
        }
    }

    public void update(){
        if(keyControls.isUpPressed() && getPosY() > 0) {
            setDirection("up");
            setPosY(getPosY() - getSpeed());
        }
        else if (keyControls.isLeftPressed() && getPosX() > 0) {
            setDirection("left");
            setPosX(getPosX() - getSpeed());
        }
        else if (keyControls.isRightPressed() && getPosX() < GameConfiguration.WINDOW_WIDTH - 48) {
            setDirection("right");
            setPosX(getPosX() + getSpeed());
        }
        else if(keyControls.isDownPressed() && getPosY() < GameConfiguration.WINDOW_HEIGHT - 48){
            setDirection("down");
            setPosY(getPosY() + getSpeed());
        }
    }

    public void draw(Graphics g){
//        g.setColor(Color.BLACK);
//        g.fillRect(posX,posY, GameConfiguration.TILE_SIZE, GameConfiguration.TILE_SIZE);

        BufferedImage image=null;

        switch (getDirection()){
            case"up":
                image=carUp;
                break;
            case"left":
                image=carLeft;
                break;
            case"right":
                image=carRight;
                break;
            case"down":
                image=carDown;
                break;
            default:
                break;
        }
        g.drawImage(image, getPosX(), getPosY(), GameConfiguration.TILE_SIZE, GameConfiguration.TILE_SIZE, null);

    }
}
