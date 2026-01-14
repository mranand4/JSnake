package ui;

import board.Board;
import model.Tile;
import model.Position;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Playground extends JPanel {

    private int rows = 20;
    private int cols = 15;
    private Board board; // maintains the latest state of game board
    private Board lastBoard;
    private Queue<Board> renderQueue;


    public Playground(Board board) throws IOException {
        this.board = board;
        this.lastBoard = board;
        renderQueue = new LinkedList<>();
        enqueueBoard();
        setPreferredSize(new Dimension(cols * 32, rows * 32));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Board board = renderQueue.poll();
//        if(board != null) lastBoard = board;

        Tile[][] map = lastBoard.getBoard();

        // row wise rendering, like we traverse an array
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                g.drawImage(map[i][j].getImage(), j * 32, i * 32, 32, 32, null);
            }
        }
    }

    public Board getBoard() {
        return this.board;
    }

    public void updateBoard(Position position, Tile tile) {
        board.setTile(position, tile);
    }

    public void enqueueBoard() {
        renderQueue.offer(board);
    }

}
