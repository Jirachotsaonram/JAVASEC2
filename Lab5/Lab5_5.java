package Lab5;

// File name : Lab5_5.java 
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Lab5_5 {
    public static void main(String[] args) {
        String menu, choiceStr;
        boolean done = true;
        int choice;
        DecimalFormat fourDigit = new DecimalFormat("0.0000");

        menu = "Main Menu\n 1. Circle \n 2. Rectangle\n 3. Triangle \n4. Trapezium \n5. Exit";
        do {
            choiceStr = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceStr);
            if (choice >= 1 && choice <= 5) {
                if (choice == 1) {
                    String radiusStr;
                    double radius;
                    radiusStr = JOptionPane.showInputDialog(
                            "Enter radius :");
                    radius = Double.parseDouble(radiusStr);
                    JOptionPane.showMessageDialog(null,
                            "Area circle is " + fourDigit.format(area(radius)),
                            "Result", JOptionPane.INFORMATION_MESSAGE);
                } else if (choice == 2) {
                    String widthStr, heightStr;
                    double width, height;
                    widthStr = JOptionPane.showInputDialog(
                            "Enter width :");
                    width = Double.parseDouble(widthStr);
                    heightStr = JOptionPane.showInputDialog(
                            "Enter height :");
                    height = Double.parseDouble(heightStr);
                    JOptionPane.showMessageDialog(null,
                            "Area rectangle is " +
                                    fourDigit.format(area(width, height)),
                            "Result", JOptionPane.INFORMATION_MESSAGE);
                } else if (choice == 3) {
                    String baseStr, heightStr;
                    double base, height, a = 0.5;
                    baseStr = JOptionPane.showInputDialog(
                            "Enter base :");
                    base = Double.parseDouble(baseStr);
                    heightStr = JOptionPane.showInputDialog(
                            "Enter height :");
                    height = Double.parseDouble(heightStr);
                    JOptionPane.showMessageDialog(null,
                            "Area rectangle is " +
                                    fourDigit.format(area(a,base, height)),
                            "Result", JOptionPane.INFORMATION_MESSAGE);
                } else if (choice == 4) {
                    String TopbaseStr, BottombaseStr, heightStr;
                    double Topbase ,Bottombase,ALLbase, height, a = 0.5;
                    TopbaseStr = JOptionPane.showInputDialog(
                            "Enter Top base :");
                    Topbase = Double.parseDouble(TopbaseStr);
                    BottombaseStr = JOptionPane.showInputDialog(
                            "Enter Bottom base :");
                    Bottombase = Double.parseDouble(BottombaseStr);
                    heightStr = JOptionPane.showInputDialog(
                            "Enter height :");
                    height = Double.parseDouble(heightStr);
                    ALLbase = Topbase + Bottombase;
                    JOptionPane.showMessageDialog(null,
                            "Area rectangle is " +
                                    fourDigit.format(area(a,ALLbase, height)),
                            "Result", JOptionPane.INFORMATION_MESSAGE);
                } else if (choice == 5)
                    done = false;
            }
        } while (done);
        System.exit(0);
    }

    public static double area(double r) {
        return (Math.PI * r * r);
    }

    public static double area(double w, double h) {

        return (w * h);
    }

    public static double area(double a ,double b, double h) {

        return (a * b * h);
    }
}
