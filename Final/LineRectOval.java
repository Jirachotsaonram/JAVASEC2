package Final;

import java.awt.*;
import javax.swing.*;
public class LineRectOval extends JFrame{
    public LineRectOval(){
        super("Draw String Line Rect Oval");
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.drawLine(25,50,400,50);
    }

    public static void main(String[] args){
        LineRectOval test = new LineRectOval();
        test.setSize(600,200);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}
