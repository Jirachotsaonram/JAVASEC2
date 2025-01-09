package Lab5;

// File name : Lab5_6.java 
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Lab5_6 {
    public static void main(String[] args) {
        JTextArea outputArea = new JTextArea();
        String output;
        output = printTriangle(6);
        outputArea.setText(output);
        JOptionPane.showMessageDialog(null, outputArea, "Result",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static String printTriangle(int n) {
        String s = "";
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= r; c++)
                s += "*";
            s += "\n";
        }
        return (s);
    }
}