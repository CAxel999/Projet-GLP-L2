package Config;

public class GameConfiguration {

    public static final int ORIGINALTILE_SIZE = 16;// Blocks size in window
    public static final int SCALE = 3;

    public static final int MAX_SCREEN_COL = 20;
    public static final int MAX_SCREEN_ROW = 16;

    public static final int TILE_SIZE = ORIGINALTILE_SIZE * SCALE;

    public static final int WINDOW_WIDTH = TILE_SIZE * MAX_SCREEN_COL; //
    public static final int WINDOW_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW; // Windows height

    public static final long GAME_SPEED = 10;
}
    /*public static final int LINE_COUNT = WINDOW_HEIGHT / TILE_SIZE;
    public static final int COLUMN_COUNT = WINDOW_WIDTH / TILE_SIZE;

    public static final int GAME_SPEED = 1000;

    public static final int MAX_BOMB_COUNT = 3;

    public static final int BOMB_EXPLOSION_DELAY = 3;
}   */
