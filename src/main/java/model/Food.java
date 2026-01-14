package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Food extends Tile {

    private BufferedImage tileImg;

    public Food() throws IOException {
        tileImg = ImageIO.read(getClass().getResource("/sprites/food.png"));
    }

    public int getPoints() {
        return 1;
    }

    public int getExpiryInSeconds() {
        return -1;
    }

    @Override
    public boolean isCollisible() {
        return false;
    }

    @Override
    public BufferedImage getImage() {
        return this.tileImg;
    }
}
