package config;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Contains parameter for the car
 */
public class CarConfiguration {
    public static final double CAR_ROTATION = Math.PI/12;
    public static final int CAR_LENGTH = 35;
    public static final int CAR_WIDTH = 25;
    public static final int CAR_INNERDIAGONAL = (int) Math.sqrt(CAR_LENGTH*CAR_LENGTH + CAR_WIDTH*CAR_WIDTH) - 5;
    public static final double CAR_ACCERLERATION = 0.125;
    public static final BufferedImage CAR;
    public static final BufferedImage CAR_LEFTLIGHT;
    public static final BufferedImage CAR_RIGHTLIGHT;
    public static final BufferedImage CAR_LEFTDEAD;
    public static final BufferedImage CAR_RIGHTDEAD;
    public static final BufferedImage CAR_BRAKING;
    public static final BufferedImage NPCCAR;
    public static final BufferedImage NPCCAR_LEFTLIGHT;
    public static final BufferedImage NPCCAR_RIGHTLIGHT;
    public static final BufferedImage NPCCAR_BRAKING;

    static {
        try {
            CAR = ImageIO.read(new File("src/images/car.png"));
            CAR_LEFTLIGHT = ImageIO.read(new File("src/images/cligno_gauche_2.png"));
            CAR_RIGHTLIGHT = ImageIO.read(new File("src/images/cligno_droit_2.png"));
            CAR_LEFTDEAD = ImageIO.read(new File("src/images/angle_mort_gauche.png"));
            CAR_RIGHTDEAD = ImageIO.read(new File("src/images/angle_mort_droit.png"));
            CAR_BRAKING = ImageIO.read(new File("src/images/warning.png"));
            NPCCAR =  ImageIO.read(new File("src/images/npc_car.png"));;
            NPCCAR_LEFTLIGHT =  ImageIO.read(new File("src/images/npc_cligno_gauche.png"));;
            NPCCAR_RIGHTLIGHT =  ImageIO.read(new File("src/images/npc_cligno_droit.png"));;
            NPCCAR_BRAKING =  ImageIO.read(new File("src/images/npc_warning.png"));;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
