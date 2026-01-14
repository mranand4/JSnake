package snake;

import model.Position;
import model.Tile;

import java.awt.image.BufferedImage;

public class SnakeBody extends Tile {

    private Position position;
    private BufferedImage image;
    private SnakeBody next;

    public Position getCoordinates() {
        return position;
    }

    public void setCoordinates(Position position) {
        this.position = position;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public SnakeBody getNext() {
        return next;
    }

    public void setNext(SnakeBody next) {
        this.next = next;
    }

    @Override
    public boolean isCollisible() {
        return true;
    }

    @Override
    public BufferedImage getImage() {
        return this.image;
    }
}
