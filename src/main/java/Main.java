import ui.GameManager;

import java.io.IOException;

public class Main {

    public static void main(String args[]) {

        try {
            GameManager manager = new GameManager();
            manager.init();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
