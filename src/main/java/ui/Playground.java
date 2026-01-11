package ui;

import model.Board;
import model.Ground;
import model.Tile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Playground extends JPanel {

    private int rows = 15;
    private int cols = 20;
    private Board board;


    public Playground() throws IOException {
        this.board = new Board(rows, cols);
        setPreferredSize(new Dimension(rows * 32, cols * 32));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Tile[][] map = board.getBoard();

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                g.drawImage(map[i][j].getTileImage(), i * 32, j * 32, 32, 32, null);
            }
        }
    }

    public Board getBoard() {
        return this.board;
    }

}
