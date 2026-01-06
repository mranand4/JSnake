import ui.Playground;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String args[]) {
        try {
            JFrame frame = new JFrame("JSnake");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(new Playground());
            frame.pack();
            frame.setVisible(true);
            frame.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
