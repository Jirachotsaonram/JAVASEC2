package Lab7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab7_2 implements ActionListener {
    JLabel salaryLabel, taxLabel, resultLabel;
    JTextField salaryField, taxField, resultField;
    JButton btnCaButton, btnExit;
    JFrame window;

    public Lab7_2() {
        window = new JFrame("Program Calulate Tax");
        Container container = window.getContentPane();
        container.setLayout(new FlowLayout());

        salaryLabel = new JLabel("Enter salary");
        container.add(salaryLabel);
        salaryField = new JTextField(10);
        container.add(salaryField);

        taxLabel = new JLabel("Tax");
        container.add(taxLabel);
        taxField = new JTextField(10);
        taxField.setEditable(false);
        container.add(taxField);

        resultLabel = new JLabel("Net Salary");
        container.add(resultLabel);
        resultField = new JTextField(10);
        resultField.setEditable(false);
        container.add(resultField);

        btnCaButton = new JButton("Calculate");
        btnCaButton.addActionListener(this);
        container.add(btnCaButton);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(this);
        container.add(btnExit);

        window.setSize(300, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void actionPerformed( ActionEvent event) {
            double salary = Double.parseDouble(salaryField.getText());
            if (event.getSource() == btnCaButton) {
                double tax, netSalary, taxRate;

                if (salary < 20000) taxRate = 0.2;
                else if (salary < 50000) taxRate = 0.4;
                else if (salary < 100000) taxRate = 0.7;
                else if (salary < 500000) taxRate = 0.10;
                else taxRate = 0.15;
                tax = salary * taxRate;
                netSalary = salary - tax;
                taxField.setText(Double.toString( tax));
                resultField.setText(Double.toString( netSalary));
            }else if (event.getSource() == btnExit) {
                System.exit(0);
        } // end method actionPerformed
    } // end actionPerformed
    
    public static void main(String[] args) {
        Lab7_2 gui = new Lab7_2();
    } // end main

}
