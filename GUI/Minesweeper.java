package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Minesweeper extends JFrame {
    private final int SIZE = 8;
    private final int MINES = 10;
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private boolean[][] mines = new boolean[SIZE][SIZE];
    private boolean[][] revealed = new boolean[SIZE][SIZE];

    public Minesweeper() {
        setTitle("Minesweeper");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));

        initializeButtons();
        placeMines();
    }

    private void initializeButtons() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 20));
                buttons[row][col].addActionListener(new ButtonClickListener(row, col));
                add(buttons[row][col]);
            }
        }
    }

    private void placeMines() {
        Random rand = new Random();
        int count = 0;
        while (count < MINES) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            if (!mines[row][col]) {
                mines[row][col] = true;
                count++;
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        int row, col;

        ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (mines[row][col]) {
                buttons[row][col].setText("💣");
                buttons[row][col].setBackground(Color.RED);
                gameOver();
            } else {
                revealCell(row, col);
            }
        }
    }

    private void revealCell(int row, int col) {
        if (row < 0 || col < 0 || row >= SIZE || col >= SIZE || revealed[row][col]) return;
        revealed[row][col] = true;
        int count = countMines(row, col);
        buttons[row][col].setText(count == 0 ? "" : String.valueOf(count));
        buttons[row][col].setEnabled(false);
        if (count == 0) {
            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    revealCell(row + r, col + c);
                }
            }
        }
    }

    private int countMines(int row, int col) {
        int count = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                int nr = row + r, nc = col + c;
                if (nr >= 0 && nc >= 0 && nr < SIZE && nc < SIZE && mines[nr][nc]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over! You hit a mine.");
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Minesweeper().setVisible(true));
    }
}

