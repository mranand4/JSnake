package model;

import java.awt.image.BufferedImage;

public abstract class Tile {

    private int size = 32;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public abstract boolean isCollisible();
    public abstract BufferedImage getImage();
}
