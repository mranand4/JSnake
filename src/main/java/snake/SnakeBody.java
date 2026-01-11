package snake;

import java.awt.image.BufferedImage;

public class SnakeBody {

    private Coordinates position;
    private BufferedImage sprite;
    private SnakeBody next;

    public Coordinates getCoordinates() {
        return position;
    }

    public void setCoordinates(Coordinates position) {
        this.position = position;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public SnakeBody getNext() {
        return next;
    }

    public void setNext(SnakeBody next) {
        this.next = next;
    }
}
