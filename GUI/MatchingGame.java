package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.ArrayList;

public class MatchingGame extends JFrame implements ActionListener {
    JButton[] buttons = new JButton[16];
    String[] icons = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H"};
    ArrayList<String> shuffledIcons;
    JButton firstSelected = null;
    JButton secondSelected = null;
    int score = 0;
    JLabel scoreLabel;
    Timer timer;

    public MatchingGame() {
        super("Matching Game");
        setLayout(new GridLayout(4, 4));
        shuffledIcons = new ArrayList<>();
        Collections.addAll(shuffledIcons, icons);
        Collections.shuffle(shuffledIcons);

        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
            buttons[i].setActionCommand(String.valueOf(i));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
        
        scoreLabel = new JLabel("Score: 0");
        add(scoreLabel);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        int index = Integer.parseInt(clickedButton.getActionCommand());
        clickedButton.setText(shuffledIcons.get(index));
        clickedButton.setEnabled(false);

        if (firstSelected == null) {
            firstSelected = clickedButton;
        } else {
            secondSelected = clickedButton;
            if (firstSelected.getText().equals(secondSelected.getText())) {
                score++;
                scoreLabel.setText("Score: " + score);
                firstSelected = null;
                secondSelected = null;
                if (score == 8) {
                    JOptionPane.showMessageDialog(this, "You Win!");
                }
            } else {
                timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        firstSelected.setText("");
                        firstSelected.setEnabled(true);
                        secondSelected.setText("");
                        secondSelected.setEnabled(true);
                        firstSelected = null;
                        secondSelected = null;
                        timer.stop();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    public static void main(String[] args) {
        new MatchingGame();
    }
}


