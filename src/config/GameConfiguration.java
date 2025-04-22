package config;

import engine.process.GameBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Contains parameter for the game.
 */
public class GameConfiguration {
	public static boolean EXAM;
	public static final int WINDOW_WIDTH = 1800;
	public static final int WINDOW_HEIGHT = 920;
	
	public static final int BLOCK_SIZE = 40;
	
	public static final int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE;
	public static final int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE;
	
	public static final int GAME_SPEED = 16;

	public static final int STOPTIME = 120;

	public static final BufferedImage RED_LIGHT;
	public static final BufferedImage ORANGE_LIGHT;
	public static final BufferedImage GREEN_LIGHT;

	static {
		try {
			RED_LIGHT = ImageIO.read(new File("src/images/red_light.png"));
			ORANGE_LIGHT = ImageIO.read(new File("src/images/orange_light.png"));
			GREEN_LIGHT = ImageIO.read(new File("src/images/green_light.png"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
