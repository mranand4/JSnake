package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SuperFood extends Food {

    private BufferedImage tileImg;

    public SuperFood() throws IOException {
        tileImg = ImageIO.read(getClass().getResource("/resources/sprites/super-food.png"));

    }

    @Override
    public int getPoints() {
        return 6;
    }

    @Override
    public int getExpiryInSeconds() {
        return 5;
    }

    @Override
    public boolean isCollisible() {
        return false;
    }

    @Override
    public BufferedImage getTileImage() {
        return this.tileImg;
    }
}
