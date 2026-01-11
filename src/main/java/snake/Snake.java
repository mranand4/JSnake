package snake;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        head.setCoordinates(headPosition);

        SnakeBody temp = head;
        int remainingLen = size - 1;

        while(remainingLen != 0) {
            Coordinates coors;
            if(direction == Direction.UP){
                coors = new Coordinates(temp.getCoordinates().x(), temp.getCoordinates().y() + 1);
            } else if(direction == Direction.DOWN) {
                coors = new Coordinates(temp.getCoordinates().x(), temp.getCoordinates().y() - 1);
            } else if(direction == Direction.LEFT) {
                coors = new Coordinates(temp.getCoordinates().x() + 1, temp.getCoordinates().y());
            } else {
                coors = new Coordinates(temp.getCoordinates().x() - 1, temp.getCoordinates().y());
            }

            SnakeBody body = new SnakeBody();
            body.setSprite(spriteBody);
            body.setCoordinates(coors);

            temp.setNext(body);
            temp = body;

            remainingLen--;
        }

        this.head = head;
    }

    public void add(Coordinates coordinates) {
        this.head.setSprite(spriteBody);
        SnakeBody head = new SnakeBody();
        head.setCoordinates(coordinates);
        head.setSprite(spriteHead);
        head.setNext(this.head);
        this.size++;
        this.head = head;
    }

    public void moveTo(Coordinates coordinates) {
        SnakeBody head = this.head;
        Coordinates newCoordinates = coordinates;
        while(head != null) {
            Coordinates oldCoordinates = head.getCoordinates();
            head.setCoordinates(newCoordinates);
            newCoordinates = oldCoordinates;
            head = head.getNext();
        }
    }

    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<SnakeBody> toList() {
        List<SnakeBody> list = new ArrayList<>(this.size);
        SnakeBody head = this.head;
        while(head != null) {
            list.add(head);
            head = head.getNext();
        }
        return list;
    }

    @Override
    public String toString() {
        SnakeBody head = this.head;
        StringBuilder sb = new StringBuilder();
        while(head != null) {
            sb.append(head.getCoordinates());
            sb.append(",");
            head = head.getNext();
        }
        return sb.toString();
    }
}
