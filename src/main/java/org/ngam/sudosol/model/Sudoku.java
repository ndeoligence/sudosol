package org.ngam.sudosol.model;

/**
 * Created by phoenix on 7/20/16.
 */
public class Sudoku {
    private Board board;
    public Sudoku() {
        board = new Board(9,9);
    }
    public void setElement(int row, int col, int value) {
        board.setElement(row,col,value);
    }
    public int getElement(int row, int col) {
        return board.getElement(row,col);
    }
    public boolean solve() {return rSolve(0,0);}
    private boolean rSolve(int row, int col) {
        if (col == board.getCols()) {
            ++row;
            col = 0;
        }

        if (row == board.getRows())
            return true;	// The puzzle is solved if we are trying to rSolve for the next cell and there isn't a next cell.

        if (board.getElement(row,col) == 0) {	// If current cell is empty (on original puzzle).
            for (int val = 1; val <= 9; ++val)
            {
                if (isValid(row, col, val)) {
                    board.setElement(row,col,val);

                    if (rSolve(row, col+1))
                        return true;
                }
            }
            board.setElement(row,col,0);
            return false;
        } else
            return rSolve(row, col+1);
    }
    private boolean isValid(int row, int col, int val) {
        return (!(inHouse(row, col, val) || inRow(row, val) || inCol(col, val)));
    }
    private boolean withinRange(int x) {
        return ( (x >= 1) && (x <= 9));
    }
    private boolean inHouse(int row, int col, int val) {
        int hR = row/3;
        int hC = col/3;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board.getElement(3*hR+i,3*hC+j) == val)
                    return true;
            }
        }
        return false;
    }
    private boolean inRow(int row, int val) {
        for (int i = 0; i < board.getCols(); ++i) {
            if (board.getElement(row,i) == val)
                return true;
        }
        return false;
    }
    private boolean inCol(int col, int val) {
        for (int i = 0; i < board.getRows(); ++i) {
            if (board.getElement(i,col) == val)
                return true;
        }
        return false;
    }
}
