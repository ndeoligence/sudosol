package org.ngam.sudosol.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phoenix on 7/20/16.
 */
public class SudokuWindow extends JFrame {
    private static final int ROWS = 9;
    private static final int COLS = 9;
    private JButton[][] buttons;
    public SudokuWindow() {
        buttons = new JButton[ROWS][COLS];

        JPanel panel = (JPanel) getContentPane();
        panel.setLayout(new GridLayout(9,9));
        panel.setPreferredSize(new Dimension(384,384));

        for (int r = 0; r < buttons.length; ++r) {
            for (int c = 0; c < buttons[0].length; ++c) {
                buttons[r][c] = new JButton("");
                panel.add(buttons[r][c]);
            }
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
    }
    public void set(int row, int col, int value) {
        buttons[row][col].setText(Integer.toString(value));
    }
    public int get(int row, int col) {
        String strVal = buttons[row][col].getText();
        if (strVal.length() == 0)
            return 0;
        else
            return Integer.parseInt(strVal);
    }
    public void lock() {
        for (int r = 0; r < buttons.length; ++r) {
            for (int c = 0; c < buttons[0].length; ++c) {
                if (! buttons[r][c].getText().equals(""))
                    buttons[r][c].setEnabled(false);
            }
        }
    }
}
