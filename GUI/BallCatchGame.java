package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BallCatchGame extends JFrame {
    private JLabel ball;
    private JButton startButton;
    private JTextField scoreField;
    private Timer timer;
    private int score = 0;
    private int timeLeft = 30;
    private Random random;
    
    public BallCatchGame() {
        setTitle("Ball Catch Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        random = new Random();
        
        // สร้าง JLabel เป็นลูกบอล
        ball = new JLabel();
        ball.setOpaque(true);
        ball.setBackground(Color.RED);
        ball.setBounds(100, 100, 50, 50);
        getContentPane().add(ball);
        
        // ช่องคะแนน
        scoreField = new JTextField("Score: 0");
        scoreField.setBounds(450, 10, 120, 30);
        scoreField.setEditable(false);
        getContentPane().add(scoreField);
        
        // ปุ่มเริ่มเกม
        startButton = new JButton("Start");
        startButton.setBounds(250, 320, 100, 30);
        startButton.addActionListener(e -> startGame());
        getContentPane().add(startButton);
        
        // Event จับลูกบอล
        ball.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                score++;
                scoreField.setText("Score: " + score);
                moveBall();
            }
        });
        
        setVisible(true);
    }
    
    private void startGame() {
        score = 0;
        timeLeft = 30;
        scoreField.setText("Score: " + score);
        startButton.setEnabled(false);
        
        timer = new Timer(1000, e -> {
            if (timeLeft > 0) {
                timeLeft--;
                moveBall();
            } else {
                timer.stop();
                startButton.setEnabled(true);
                JOptionPane.showMessageDialog(this, "Time's up! Final Score: " + score);
            }
        });
        timer.start();
    }
    
    private void moveBall() {
        int x = random.nextInt(getWidth() - 60);
        int y = random.nextInt(getHeight() - 100);
        ball.setLocation(x, y);
    }
    
    public static void main(String[] args) {
        new BallCatchGame();
    }
}
