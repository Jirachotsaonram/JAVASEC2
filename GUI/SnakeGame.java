package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    private final int TILE_SIZE = 20;
    private final int GRID_SIZE = 20;
    private final int SCREEN_SIZE = TILE_SIZE * GRID_SIZE;
    private final int DELAY = 150;
    private final int MAX_LENGTH = GRID_SIZE * GRID_SIZE;
    
    private int[] x = new int[MAX_LENGTH];
    private int[] y = new int[MAX_LENGTH];
    private int length;
    private int foodX;
    private int foodY;
    private char direction = 'R';
    private boolean running = false;
    private Timer timer;
    private Random random;
    
    public SnakeGame() {
        this.setPreferredSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                changeDirection(e);
            }
        });
        startGame();
    }
    
    private void startGame() {
        length = 3;
        for (int i = 0; i < length; i++) {
            x[i] = (length - i - 1) * TILE_SIZE;
            y[i] = 0;
        }
        random = new Random();
        spawnFood();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    private void spawnFood() {
        foodX = random.nextInt(GRID_SIZE) * TILE_SIZE;
        foodY = random.nextInt(GRID_SIZE) * TILE_SIZE;
    }
    
    private void changeDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> { if (direction != 'R') direction = 'L'; }
            case KeyEvent.VK_RIGHT -> { if (direction != 'L') direction = 'R'; }
            case KeyEvent.VK_UP -> { if (direction != 'D') direction = 'U'; }
            case KeyEvent.VK_DOWN -> { if (direction != 'U') direction = 'D'; }
        }
    }
    
    private void move() {
        for (int i = length; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'L' -> x[0] -= TILE_SIZE;
            case 'R' -> x[0] += TILE_SIZE;
            case 'U' -> y[0] -= TILE_SIZE;
            case 'D' -> y[0] += TILE_SIZE;
        }
    }
    
    private void checkCollision() {
        for (int i = length; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) running = false;
        }
        if (x[0] < 0 || x[0] >= SCREEN_SIZE || y[0] < 0 || y[0] >= SCREEN_SIZE) running = false;
        if (!running) timer.stop();
    }
    
    private void checkFood() {
        if (x[0] == foodX && y[0] == foodY) {
            length++;
            spawnFood();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkFood();
            checkCollision();
        }
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (running) {
            g.setColor(Color.RED);
            g.fillOval(foodX, foodY, TILE_SIZE, TILE_SIZE);
            for (int i = 0; i < length; i++) {
                g.setColor(i == 0 ? Color.GREEN : Color.WHITE);
                g.fillRect(x[i], y[i], TILE_SIZE, TILE_SIZE);
            }
        } else {
            g.setColor(Color.WHITE);
            g.drawString("Game Over", SCREEN_SIZE / 2 - 20, SCREEN_SIZE / 2);
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
