package board;

import model.Position;
import model.Tile;

import java.io.IOException;

public class Board {

    private Tile[][] board;
    private Tile base;

    public Board(int rows, int columns, Tile base) throws IOException {
        this.board = new Tile[rows][columns];
        this.base = base;

        // we are rendering it row wise
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                board[i][j] = this.base;
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void setTile(Position position, Tile t) {
        // y coordinate corresponds to rows, x to columns
        board[position.y()][position.x()] = t;
    }

    public Tile getTile(int row, int col) {
        return board[row][col];
    }

    public void clearTile(Position coords) {
        // again y is for rows, x is for cols
        board[coords.y()][coords.x()] = base;
    }


}
