import model.Container;
import model.Food;
import snake.Coordinates;
import snake.Direction;
import snake.Snake;
import snake.SnakeBody;
import ui.Playground;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        try {
            final Coordinates[] initCoords = {new Coordinates(6, 14)};
            Snake snake = new Snake(3, Direction.UP, initCoords[0]);
            JFrame frame = new JFrame("JSnake");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Playground ground = new Playground(snake);
            frame.add(ground);
            frame.pack();
            frame.setVisible(true);
            frame.setResizable(false);

            Container c = new Container();

            new Timer(500, e-> {
                System.out.println("------");
                System.out.println(snake);
                double r = Math.random();
                Coordinates coordinates;
                if(r > 0.85) {
                    Direction dir;
                    if(snake.getDirection() == Direction.DOWN || snake.getDirection() == Direction.UP) {
                        dir = Math.random() > 0.5 ? Direction.LEFT : Direction.RIGHT;
                    } else {
                        dir = Math.random() > 0.5 ? Direction.UP : Direction.DOWN;
                    }
                    snake.setDirection(dir);
                    System.out.println("Changed direction to " + dir);
                }

                if(snake.getDirection() == Direction.UP) coordinates = new Coordinates(initCoords[0].x(), initCoords[0].y() - 1);
                else if(snake.getDirection() == Direction.DOWN) coordinates = new Coordinates(initCoords[0].x(), initCoords[0].y() + 1);
                else if(snake.getDirection() == Direction.LEFT) coordinates = new Coordinates(initCoords[0].x() - 1, initCoords[0].y());
                else coordinates = new Coordinates(initCoords[0].x() + 1, initCoords[0].y());

                initCoords[0] = coordinates;
                snake.moveTo(coordinates);
                System.out.println(snake);
                ground.repaint();

            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
