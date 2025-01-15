package Lab;

import javax.swing.*;

public class Test5_2 {
    public static void main(String[] args) {
        int array[]; // declare reference to an array
        array = new int[10]; // create array
        String output = "Index\tValue\n";
        // append each array element's value to String output
        for (int counter = 0; counter < 10; counter++)
            output += counter + "\t" + array[counter] + "\n";
        JTextArea outputArea = new JTextArea();
        outputArea.setText(output);
        JOptionPane.showMessageDialog(null, outputArea,
                "Initializing an Array of int Values",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}