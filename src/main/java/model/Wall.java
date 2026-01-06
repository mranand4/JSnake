package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.IOException;

public class Wall extends Tile {

    private BufferedImage tileImg;

    public Wall() throws IOException {
        tileImg = ImageIO.read(getClass().getResource("/resources/sprites/wall.png"));
    }

    @Override
    public boolean isCollisible() {
        return true;
    }

    @Override
    public BufferedImage getTileImage() {
        return this.tileImg;
    }
}
