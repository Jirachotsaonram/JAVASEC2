package Lab7;

// File Name : Lab7_1.java 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab7_1 extends JFrame {
    JLabel numberLabel, resultLabel, blankLabel;
    JTextField numberField,blankField;
    JTextArea resultArea;
    JScrollPane scroller;

    public Lab7_1() {
        // title bar in window
        super("Program display value n");
        // obtain content pane and set its layout to FlowLayout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        // create numberLabel and attach it to content pane

        numberLabel = new JLabel("Enter integer and press Enter");
        container.add(numberLabel);
        // create numberField and attach it to content pane
        
        numberField = new JTextField(10);
        container.add(numberField);

        // create numberLabel and attach it to content pane
        blankLabel = new JLabel("Enter integer number of larbel");
        container.add(blankLabel);
        // create numberField and attach it to content pane
        blankField = new JTextField(10);
        container.add(blankField);
        // register this applet as numberField’s ActionListener

        numberField.addActionListener(
                // create inner class
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        int number, sumValue , blanknumber;
                        String blank5 = "";
                        number = Integer.parseInt(numberField.getText());
                        blanknumber = Integer.parseInt(blankField.getText());
                        for (int i = 0; i < blanknumber; i++) {
                            blank5 += " ";
                        }
                        // clear value in TextArea
                        resultArea.setText("");
                        // add data in textarea
                        for (int n = 1; n <= number; n++) {
                            resultArea.append(blank5 + Integer.toString(n));
                            if (n % 5 == 0)
                                resultArea.append("\n");
                        }
                        // clear value in numberField
                        numberField.setText("");
                    } // end method actionPerformed
                });
                
        // create display
        resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);
        scroller = new JScrollPane(resultArea);
        container.add(scroller);
    }

    public static void main(String[] args) {
        Lab7_1 window = new Lab7_1();
        window.setSize(360, 260);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}