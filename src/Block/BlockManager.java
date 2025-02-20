package Block;

import Config.GameConfiguration;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class BlockManager {
    private final Block[] block;
    private final int[][] mapBlockNum;

    public BlockManager(){
        block = new Block[10];
        mapBlockNum = new int[GameConfiguration.MAX_SCREEN_COL][GameConfiguration.MAX_SCREEN_ROW]; //Used to store all the numbers of the mapDesign file
        getBlockImage();
        loadMap("/maps/mapDesign.txt");
    }

    public void getBlockImage(){
        try {
            block[0] = new Block();
            block[0].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/immobileBlock/sol.png"))));
            block[1] = new Block();
            block[1].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/immobileBlock/trottoir.png"))));
            block[1].setCollision(true);
            block[2] = new Block();
            block[2].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/immobileBlock/discontinue.png"))));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){
        try{
            InputStream stream = getClass().getResourceAsStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            int col = 0;
            int row = 0;
            while(col < GameConfiguration.MAX_SCREEN_COL && row < GameConfiguration.MAX_SCREEN_ROW){
                String line = reader.readLine();
                while(col < GameConfiguration.MAX_SCREEN_COL){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapBlockNum[col][row]=num;
                    col++;
                }
                if(col == GameConfiguration.MAX_SCREEN_COL){
                    col = 0;
                    row++;
                }
            }
            reader.close();
        }catch(IOException e){
            System.err.println("-- Can not read the txt file ! --");
        }
    }

    public void draw(Graphics g){
        int col = 0;
        int row = 0;
        int x = 0 ;
        int y = 0;

        while(col < GameConfiguration.MAX_SCREEN_COL && row < GameConfiguration.MAX_SCREEN_ROW){
            int blockNum = mapBlockNum[col][row];

            g.drawImage(block[blockNum].getImage(), x, y, GameConfiguration.TILE_SIZE, GameConfiguration.TILE_SIZE, null);
            col += 1;
            x += GameConfiguration.TILE_SIZE;

            if(col == GameConfiguration.MAX_SCREEN_COL){
                col = 0;
                x = 0;
                row += 1;
                y += GameConfiguration.TILE_SIZE;
            }


        }
    }

}
