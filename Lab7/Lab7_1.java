package Lab7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab7_1 extends JFrame {
    JLabel numberLabel, blankLabel, resultLabel;
    JTextField numberField, blankField;
    JTextArea resultArea;

    public Lab7_1() {
        // title bar in window
        super("Program display value n");
        // obtain content pane and set its layout to FlowLayout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // create numberLabel and attach it to content pane
        numberLabel = new JLabel("Enter integer and press Enter:");
        container.add(numberLabel);

        // create numberField and attach it to content pane
        numberField = new JTextField(10);
        container.add(numberField);

        // create blankLabel and attach it to content pane
        blankLabel = new JLabel("Enter number of blanks:");
        container.add(blankLabel);

        // create blankField and attach it to content pane
        blankField = new JTextField(10);
        container.add(blankField);

        // create resultArea and attach it to content pane
        resultArea = new JTextArea(5, 20);
        container.add(resultArea);

        // register this applet as numberField’s ActionListener
        numberField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                displayResult();
            }
        });

        // register this applet as blankField’s ActionListener
        blankField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                displayResult();
            }
        });
    }

    private void displayResult() {
        try {
            int number = Integer.parseInt(numberField.getText());
            int blanks = Integer.parseInt(blankField.getText());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < blanks; i++) {
                result.append(" ");
            }
            result.append(number);
            resultArea.setText(result.toString());
        } catch (NumberFormatException e) {
            resultArea.setText("Please enter valid integers.");
        }
    }

    public static void main(String[] args) {
        Lab7_1 app = new Lab7_1();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(300, 200);
        app.setVisible(true);
    }
}