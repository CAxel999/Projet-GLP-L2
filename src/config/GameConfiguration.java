package config;

/**
 * Contains parameter for the game.
 */
public class GameConfiguration {
	public static final int WINDOW_WIDTH = 1800;
	public static final int WINDOW_HEIGHT = 1000;
	
	public static final int BLOCK_SIZE = 40;
	
	public static final int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE;
	public static final int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE;
	
	public static final int GAME_SPEED = 16;

}
