package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private char currentPlayer = 'X';
    private boolean gameOver = false;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton(" ");
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[row][col].addActionListener(this);
                add(buttons[row][col]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;
        JButton clickedButton = (JButton) e.getSource();
        if (!clickedButton.getText().equals(" ")) return;

        clickedButton.setText(String.valueOf(currentPlayer));
        if (checkWin()) {
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            gameOver = true;
        } else if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            gameOver = true;
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][0].getText().equals(buttons[i][2].getText()) &&
                !buttons[i][0].getText().equals(" ")) return true;

            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[0][i].getText().equals(buttons[2][i].getText()) &&
                !buttons[0][i].getText().equals(" ")) return true;
        }
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[0][0].getText().equals(buttons[2][2].getText()) &&
            !buttons[0][0].getText().equals(" ")) return true;

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[0][2].getText().equals(buttons[2][0].getText()) &&
            !buttons[0][2].getText().equals(" ")) return true;

        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().equals(" ")) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToe().setVisible(true));
    }
}
