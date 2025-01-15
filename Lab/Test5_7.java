package Lab;

import javax.swing.*;

public class Test5_7 {
    public static void main(String[] args) {
        int startNumber, endNumber;
        String str1, str2;
        int score[][] = new int[10][3];
        str1 = JOptionPane.showInputDialog("Enter start number : ");
        str2 = JOptionPane.showInputDialog("Enter end number : ");
        startNumber = Integer.parseInt(str1);
        endNumber = Integer.parseInt(str2);
        getData(score, startNumber, endNumber);
        JTextArea output = new JTextArea();
        output.setText(displayData(score));
        JOptionPane.showMessageDialog(null, output, "Display Score in Array",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void getData(int data[][], int sValue, int eValue) {
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[i].length; j++)
                data[i][j] = rnd(sValue, eValue);
    }

    public static String displayData(int data[][]) {
        String outputStr = "";
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++)
                outputStr += data[i][j] + "\t";
            outputStr += "\n";
        }
        return (outputStr);
    }

    public static int rnd(int st, int ed) {
        int offset = ed - st + 1;
        return (st + (int) (Math.random() * offset));
    }
}