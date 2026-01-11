package snake;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Snake {

    private SnakeBody head;
    private Direction direction;
    private int size;

    private static BufferedImage spriteHead;
    private static BufferedImage spriteBody;

    public Snake(int size, Direction direction, Coordinates headPosition) {
        this.size = size;
        this.direction = direction;

        try {
            spriteHead = ImageIO.read(getClass().getResource("/sprites/snake-head.png"));
            spriteBody = ImageIO.read(getClass().getResource("/sprites/snake-body.png"));;
        } catch (IOException e) {
            System.err.println("Error while loading snake images.");
            e.printStackTrace();
        }

        initialize(size, headPosition);
    }

    private void initialize(int size, Coordinates headPosition) {
        SnakeBody head = new SnakeBody();
        head.setSprite(spriteHead);
        head.setPosition(headPosition);

        SnakeBody temp = head;
        int remainingLen = size - 1;

        while(remainingLen != 0) {
            Coordinates coors;
            if(direction == Direction.UP){
                coors = new Coordinates(temp.getPosition().x(), temp.getPosition().y() + 1);
            } else if(direction == Direction.DOWN) {
                coors = new Coordinates(temp.getPosition().x(), temp.getPosition().y() - 1);
            } else if(direction == Direction.LEFT) {
                coors = new Coordinates(temp.getPosition().x() + 1, temp.getPosition().y());
            } else {
                coors = new Coordinates(temp.getPosition().x() - 1, temp.getPosition().y());
            }

            SnakeBody body = new SnakeBody();
            body.setSprite(spriteBody);
            body.setPosition(coors);

            temp.setNext(body);
            temp = body;

            remainingLen--;
        }

        this.head = head;
    }

    public void add(Coordinates coordinates) {
        this.head.setSprite(spriteBody);
        SnakeBody head = new SnakeBody();
        head.setPosition(coordinates);
        head.setSprite(spriteHead);
        head.setNext(this.head);
        this.head = head;
    }

    @Override
    public String toString() {
        SnakeBody head = this.head;
        StringBuilder sb = new StringBuilder();
        while(head != null) {
            sb.append(head.getPosition());
            sb.append(",");
            head = head.getNext();
        }
        return sb.toString();
    }
}
