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

        while(true) {
            System.out.println("Initialize your snake");
            System.out.println("Enter snake size");
            int n = new Scanner(System.in).nextInt();
            int dir = new Scanner(System.in).nextInt();
            int x = new Scanner(System.in).nextInt();
            int y = new Scanner(System.in).nextInt();

            Direction mDir;
            if(dir == 8) mDir = Direction.UP;
            else if(dir == 2) mDir = Direction.DOWN;
            else if(dir == 4) mDir = Direction.LEFT;
            else mDir = Direction.RIGHT;

            Snake snake = new Snake(n, mDir, new Coordinates(x, y));
            System.out.print(snake);

            System.out.println("Eat at");
            x = new Scanner(System.in).nextInt();
            y = new Scanner(System.in).nextInt();
            snake.add(new Coordinates(x, y));
            System.out.println(snake);
        }

//        try {
//            JFrame frame = new JFrame("JSnake");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            Playground ground = new Playground();
//            frame.add(ground);
//            frame.pack();
//            frame.setVisible(true);
//            frame.setResizable(false);
//
//            Container c = new Container();
//
//            new Timer(500, e-> {
//                int row = c.r;
//                int col = c.c;
//                c.incrementRow();
//
//                try {
//                    ground.getBoard().setTile(new Food(), row, col);
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//
//               ground.repaint();
//
//            }).start();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
