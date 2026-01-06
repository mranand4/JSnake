package model;

import java.io.IOException;

public class Board {

    private Tile[][] board;

    public Board(int rows, int columns) throws IOException {
        this.board = new Tile[rows][columns];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                board[i][j] = new Ground();
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }


}
