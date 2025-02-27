package Lab11;

// File Name : Lab11_03.java 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab11_03 extends JFrame implements ActionListener {
    Timer swTimer;
    int x1 = 20, y1 = 20, x2 = 100, y2 = 100;
    int dx1 = 18, dy1 = 18, dx2 = 20, dy2 = 20;
    int ballSize = 20;

    public Lab11_03() {
        super("Program Using Timer");
        swTimer = new Timer(200, this);
        swTimer.start();
    }

    public void paint(Graphics g) {
        Image buffer = createImage(getWidth(), getHeight());
        Graphics bufferGraphics = buffer.getGraphics();
        bufferGraphics.setColor(getBackground());
        bufferGraphics.fillRect(0, 0, getWidth(), getHeight());
        bufferGraphics.setColor(Color.RED);
        bufferGraphics.fillOval(x1, y1, ballSize, ballSize);
        bufferGraphics.setColor(Color.BLUE);
        bufferGraphics.fillOval(x2, y2, ballSize, ballSize);
        g.drawImage(buffer, 0, 0, this);
    }
    

    public void actionPerformed(ActionEvent event) {
         x1 += dx1;
        y1 += dy1;
        if (x1 < 0 || x1 > getWidth() - ballSize) dx1 = -dx1;
        if (y1 < 0 || y1 > getHeight() - ballSize) dy1 = -dy1;

        // Move ball 2
        x2 += dx2;
        y2 += dy2;
        if (x2 < 0 || x2 > getWidth() - ballSize) dx2 = -dx2;
        if (y2 < 0 || y2 > getHeight() - ballSize) dy2 = -dy2;

        // Check collision between balls
        if (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) <= ballSize) {
            dx1 = -dx1;
            dy1 = -dy1;
            dx2 = -dx2;
            dy2 = -dy2;
        }
        repaint();
    }

    public static void main(String[] args) {
        Lab11_03 test = new Lab11_03();
        test.setSize(480, 300);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}