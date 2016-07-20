package org.ngam.sudosol.model;

/**
 * Created by phoenix on 7/20/16.
 */
public class Table {
    private int[][] array;
    private int rows;
    private int cols;
    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        array = new int[rows][cols];
    }
    int getElement(int row, int col) {
        if (exists(row,col))
            return array[row][col];
        else {
            throw new IllegalArgumentException("Non-existent element specified");
        }
    }
    void setElement(int row, int col, int value) {
        if (exists(row,col))
            array[row][col] = value;
        else {
            throw new IllegalArgumentException("Non-existent element specified");
        }
    }
    private boolean exists(int row, int col) {
        return (row >= 0 && row <= rows) && (col >= 0 && col <= cols);
    }
}
