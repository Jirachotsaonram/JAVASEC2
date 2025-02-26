package Lab10;

public class PointJFrame exteds java.swing.JFrame {
    int size;
    Point p[];
    public PointJFrame() {
        super("Program Inheritance Point");
        String input;

        input = JOptionPane.showInputDialog("Enter the number of points: ");
        size = Integer.parseInt(input);
        p = new Point[size];

        for(int n = 0; n < p.length; n++) {
            int x = 5 + (int) (Math.random() * 300);
            int y = 5 + (int) (Math.randow() * 300);
            p[n] = new Point(x,y);
         }
    }
}
