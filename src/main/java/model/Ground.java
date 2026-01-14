package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ground extends Tile {

    private BufferedImage tileImg;

    public Ground() throws IOException {
        tileImg = ImageIO.read(getClass().getResourceAsStream("/sprites/ground.png"));
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
