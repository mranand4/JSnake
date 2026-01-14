package ui;

import board.Board;
import model.Position;
import model.Ground;
import snake.Direction;
import snake.Snake;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GameManager {

    public void init() throws IOException {

        final Position[] initCoords = {new Position(6, 10)};
        Snake snake = new Snake(3, Direction.UP, initCoords[0]);
        Board board = new Board(20, 15, new Ground());
        snake.updateInBoard(board);

        Playground ground = new Playground(board);

        ground.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                Position pos;
                Direction dir;

                if (keycode == KeyEvent.VK_UP) {
                    pos = new Position(initCoords[0].x(), initCoords[0].y() - 1);
                    dir = Direction.UP;
                } else if (keycode == KeyEvent.VK_DOWN) {
                    pos = new Position(initCoords[0].x(), initCoords[0].y() + 1);
                    dir = Direction.DOWN;
                } else if (keycode == KeyEvent.VK_LEFT) {
                    pos = new Position(initCoords[0].x() - 1, initCoords[0].y());
                    dir = Direction.LEFT;
                } else if (keycode == KeyEvent.VK_RIGHT) {
                    pos = new Position(initCoords[0].x() + 1, initCoords[0].y());
                    dir = Direction.RIGHT;
                } else {
                    pos = null;
                    dir = null;
                }


                if(pos != null) {
                    initCoords[0] = pos;
                    snake.setDirection(dir);
//                    snake.clearInBoard(ground.getBoard());
                    snake.moveTo(pos);
//                    snake.updateInBoard(ground.getBoard());
                }
            }
        });
        ground.setFocusable(true);

        render(ground);

        new Timer(500, e -> {
            Position pos;
            Direction dir = snake.getDirection();
            pos = switch (dir) {
                case UP -> new Position(initCoords[0].x(), initCoords[0].y() - 1);
                case DOWN -> new Position(initCoords[0].x(), initCoords[0].y() + 1);
                case LEFT -> new Position(initCoords[0].x() - 1, initCoords[0].y());
                case RIGHT -> new Position(initCoords[0].x() + 1, initCoords[0].y());
            };

            initCoords[0] = pos;
            snake.clearInBoard(ground.getBoard());
            snake.moveTo(pos);
            snake.updateInBoard(ground.getBoard());

            ground.enqueueBoard();
            ground.repaint();
        }).start();
    }

    public void render(Playground playground) {
        JFrame frame = new JFrame("JSnake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(playground);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }


}
