package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrickBreaker extends JPanel implements ActionListener {
    private final int WIDTH = 600, HEIGHT = 400;
    private final int PADDLE_WIDTH = 80, PADDLE_HEIGHT = 10;
    private final int BALL_SIZE = 10;
    private final int BRICK_ROWS = 4, BRICK_COLS = 8;
    private final int BRICK_WIDTH = 60, BRICK_HEIGHT = 20;

    private int paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
    private int ballX = WIDTH / 2, ballY = HEIGHT / 2;
    private int ballDX = 2, ballDY = -2;
    private boolean[][] bricks;
    private Timer timer;
    
    public BrickBreaker() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT && paddleX > 0) {
                    paddleX -= 20;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddleX < WIDTH - PADDLE_WIDTH) {
                    paddleX += 20;
                }
            }
        });
        bricks = new boolean[BRICK_ROWS][BRICK_COLS];
        for (int i = 0; i < BRICK_ROWS; i++) {
            for (int j = 0; j < BRICK_COLS; j++) {
                bricks[i][j] = true;
            }
        }
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballX += ballDX;
        ballY += ballDY;

        if (ballX <= 0 || ballX >= WIDTH - BALL_SIZE) ballDX = -ballDX;
        if (ballY <= 0) ballDY = -ballDY;
        if (ballY >= HEIGHT) {
            JOptionPane.showMessageDialog(this, "Game Over!");
            System.exit(0);
        }
        if (ballY + BALL_SIZE >= HEIGHT - PADDLE_HEIGHT && ballX >= paddleX && ballX <= paddleX + PADDLE_WIDTH) {
            ballDY = -ballDY;
        }
        for (int i = 0; i < BRICK_ROWS; i++) {
            for (int j = 0; j < BRICK_COLS; j++) {
                if (bricks[i][j]) {
                    int brickX = j * BRICK_WIDTH;
                    int brickY = i * BRICK_HEIGHT;
                    if (ballX >= brickX && ballX <= brickX + BRICK_WIDTH &&
                        ballY >= brickY && ballY <= brickY + BRICK_HEIGHT) {
                        bricks[i][j] = false;
                        ballDY = -ballDY;
                    }
                }
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(paddleX, HEIGHT - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
        g.setColor(Color.YELLOW);
        for (int i = 0; i < BRICK_ROWS; i++) {
            for (int j = 0; j < BRICK_COLS; j++) {
                if (bricks[i][j]) {
                    g.fillRect(j * BRICK_WIDTH, i * BRICK_HEIGHT, BRICK_WIDTH - 5, BRICK_HEIGHT - 5);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker");
        BrickBreaker game = new BrickBreaker();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
