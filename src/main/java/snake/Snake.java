package snake;

import board.Board;
import model.Position;

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

    public Snake(int size, Direction direction, Position headPosition) {
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

    private void initialize(int size, Position headPosition) {
        SnakeBody head = new SnakeBody();
        head.setImage(spriteHead);
        head.setCoordinates(headPosition);

        SnakeBody temp = head;
        int remainingLen = size - 1;

        while(remainingLen != 0) {
            Position coors;

            // in the board array, y(vertical) is for row, x(horizontal) is for col
            // note the settings here do not correspond to movement settings
            // here we are setting body tiles one after the other, starting from the head tile
            // e.g. if head is at [3][6] and direction is up
            // then next body tile should be at [3][7]
            // logic in board will render head at array row 6 and col 3 and body at row 7 and col 3
            if(direction == Direction.UP){
                coors = new Position(temp.getCoordinates().x(), temp.getCoordinates().y() + 1);
            } else if(direction == Direction.DOWN) {
                coors = new Position(temp.getCoordinates().x(), temp.getCoordinates().y() - 1);
            } else if(direction == Direction.LEFT) {
                coors = new Position(temp.getCoordinates().x() + 1, temp.getCoordinates().y());
            } else {
                coors = new Position(temp.getCoordinates().x() - 1, temp.getCoordinates().y());
            }

            SnakeBody body = new SnakeBody();
            body.setImage(spriteBody);
            body.setCoordinates(coors);

            temp.setNext(body);
            temp = body;

            remainingLen--;
        }

        this.head = head;
    }

    public void add(Position position) {
        this.head.setImage(spriteBody);
        SnakeBody head = new SnakeBody();
        head.setCoordinates(position);
        head.setImage(spriteHead);
        head.setNext(this.head);
        this.size++;
        this.head = head;
    }

    public void moveTo(Position position) {
        SnakeBody head = this.head;
        Position newPosition = position;
        while(head != null) {
            Position oldPosition = head.getCoordinates();
            head.setCoordinates(newPosition);
            newPosition = oldPosition;
            head = head.getNext();
        }
    }

    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    public Direction getDirection() {
        return direction;
    }

    public void clearInBoard(Board board) {
        SnakeBody head = this.head;
        while(head != null) {
            board.clearTile(head.getCoordinates());
            head = head.getNext();
        }
    }

    public void updateInBoard(Board board) {
        SnakeBody head = this.head;
        while(head != null) {
            board.setTile(head.getCoordinates(), head);
            head = head.getNext();
        }
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
