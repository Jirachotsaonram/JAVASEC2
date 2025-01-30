package Lab7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab7_3 implements ActionListener {
    JLabel numberLabel;
    JTextField numberField;
    JButton btn1 , btn2 , btn3;
    JFrame window;

    public Lab7_3() {
        window = new JFrame("Program Show Text");
        Container container = window.getContentPane();
        container.setLayout(new FlowLayout());

        numberLabel = new JLabel("Enter integer and press Enter");
        container.add(numberLabel);
        numberField = new JTextField(10);
        container.add(numberField);

        btn1 = new JButton("Button 1");
        btn1.addActionListener(this);
        container.add(btn1);
        
        btn2 = new JButton("Button 2");
        btn2.addActionListener(this);
        container.add(btn2);

        btn3 = new JButton("Button 3");
        btn3.addActionListener(this);
        container.add(btn3);
    } // end constructor


    public void actionPerformed( ActionEvent event) {

    } // end actionPerformed


    public static void main(String[] args) {
        Lab7_2 lab7_3 = new Lab7_3();
    } // end main
}
