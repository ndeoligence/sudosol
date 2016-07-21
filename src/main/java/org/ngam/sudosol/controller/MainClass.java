package org.ngam.sudosol.controller;
import org.ngam.sudosol.model.Sudoku;
import org.ngam.sudosol.view.SudokuWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by phoenix on 7/20/16.
 */
public class MainClass implements ActionListener {
    private static Sudoku puzzle;
    private static SudokuWindow window;
    public static void main(String[] args) {
        puzzle = new Sudoku();

        window = new SudokuWindow();
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        copySudokuState(puzzle,window);
    }
    private void copySudokuState(Sudoku puzzle, SudokuWindow window) {
        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                puzzle.setElement(r,c,window.get(r,c));
            }
        }
    }
    private boolean solve() {
        return false;
    }
}
