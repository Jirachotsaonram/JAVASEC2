package Lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab8_3 extends JFrame implements ActionListener {
        JLabel textLabel;
        JTextField textField;
        JButton saveBtn, clearBtn, showBtn;
        JButton addBtn, subBtn, mulBtn, divBtn, eqbtn, dotBtn;
        JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
        JButton btnClear, btnBackspace;
        Container container;
        NumberNew obj;

        public Lab8_3() {
                super("Program Calculate Number");
                container = getContentPane();
                container.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();

                // Add textLabel
                textLabel = new JLabel("Enter number :");
                textLabel.setFont(new Font("Courier New", Font.BOLD, 20));
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 2; // Span 2 columns
                gbc.insets = new Insets(5, 5, 5, 5);
                container.add(textLabel, gbc);

                // Add textField
                textField = new JTextField(10);
                textField.setFont(new Font("Courier New", Font.BOLD, 24));
                gbc.gridx = 2;
                gbc.gridy = 0;
                gbc.gridwidth = 2; // Span 2 columns
                container.add(textField, gbc);

                // Add saveBtn
                saveBtn = new JButton("     Save     ");
                saveBtn.setFont(new Font("Courier New", Font.BOLD, 20));
                saveBtn.addActionListener(this);        
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.gridwidth = 2;
                container.add(saveBtn, gbc);

                // Add clearBtn
                clearBtn = new JButton("Clear");
                clearBtn.setFont(new Font("Courier New", Font.BOLD, 20));
                clearBtn.addActionListener(this);
                gbc.gridx = 2;
                gbc.gridy = 1;
                gbc.gridwidth = 1;
                container.add(clearBtn, gbc);

                // Add showBtn
                showBtn = new JButton(" Show ");
                showBtn.setFont(new Font("Courier New", Font.BOLD, 20));
                showBtn.addActionListener(this);
                gbc.gridx = 3;
                gbc.gridy = 1;
                container.add(showBtn, gbc);

                

                btnClear = new JButton("  C  ");
                btnClear.setFont(new Font("Courier New", Font.BOLD, 20));
                btnClear.addActionListener(this);
                gbc.gridx = 0;
                gbc.gridy = 2;
                container.add(btnClear, gbc);

                btnBackspace = new JButton("      <-      ");
                btnBackspace.setFont(new Font("Courier New", Font.BOLD, 20));
                btnBackspace.addActionListener(this);
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.gridwidth = 2; // Span 2 columns
                container.add(btnBackspace, gbc);

                divBtn = new JButton("  /  ");
                divBtn.setFont(new Font("Courier New", Font.BOLD, 20));
                divBtn.addActionListener(this);
                gbc.gridx = 3;
                gbc.gridy = 2;

                container.add(divBtn, gbc);

                btn7 = new JButton("  7  ");
                btn7.setFont(new Font("Courier New", Font.BOLD, 20));
                btn7.addActionListener(this);
                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.gridwidth = 1;
                container.add(btn7, gbc);

                btn8 = new JButton("  8  ");
                btn8.setFont(new Font("Courier New", Font.BOLD, 20));
                btn8.addActionListener(this);
                gbc.gridx = 1;
                gbc.gridy = 3;
                container.add(btn8, gbc);

                btn9 = new JButton("  9  ");
                btn9.setFont(new Font("Courier New", Font.BOLD, 20));
                btn9.addActionListener(this);
                gbc.gridx = 2;
                gbc.gridy = 3;
                container.add(btn9, gbc);

                mulBtn = new JButton("  *  ");
                mulBtn.setFont(new Font("Courier New", Font.BOLD, 20));
                mulBtn.addActionListener(this);
                gbc.gridx = 3;
                gbc.gridy = 3;
                container.add(mulBtn, gbc);

                btn4 = new JButton("  4  ");
                btn4.setFont(new Font("Courier New", Font.BOLD, 20));
                btn4.addActionListener(this);
                gbc.gridx = 0;
                gbc.gridy = 4;
                container.add(btn4, gbc);

                btn5 = new JButton("  5  ");
                btn5.setFont(new Font("Courier New", Font.BOLD, 20));
                btn5.addActionListener(this);
                gbc.gridx = 1;
                gbc.gridy = 4;
                container.add(btn5, gbc);

                btn6 = new JButton("  6  ");
                btn6.setFont(new Font("Courier New", Font.BOLD, 20));
                btn6.addActionListener(this);
                gbc.gridx = 2;
                gbc.gridy = 4;
                container.add(btn6, gbc);

                subBtn = new JButton("  -  ");
                subBtn.setFont(new Font("Courier New", Font.BOLD, 20));
                subBtn.addActionListener(this);
                gbc.gridx = 3;
                gbc.gridy = 4;
                container.add(subBtn, gbc);

                btn1 = new JButton("  1  ");
                btn1.setFont(new Font("Courier New", Font.BOLD, 20));
                btn1.addActionListener(this);
                gbc.gridx = 0;
                gbc.gridy = 5;
                container.add(btn1, gbc);

                btn2 = new JButton("  2  ");
                btn2.setFont(new Font("Courier New", Font.BOLD, 20));
                btn2.addActionListener(this);
                gbc.gridx = 1;
                gbc.gridy = 5;
                container.add(btn2, gbc);

                btn3 = new JButton("  3  ");
                btn3.setFont(new Font("Courier New", Font.BOLD, 20));
                btn3.addActionListener(this);
                gbc.gridx = 2;
                gbc.gridy = 5;
                container.add(btn3, gbc);

                addBtn = new JButton("  +  ");
                addBtn.setFont(new Font("Courier New", Font.BOLD, 20));
                addBtn.addActionListener(this);
                gbc.gridx = 3;
                gbc.gridy = 5;
                container.add(addBtn, gbc);

                btn0 = new JButton("  0  ");
                btn0.setFont(new Font("Courier New", Font.BOLD, 20));
                btn0.addActionListener(this);
                gbc.gridx = 0;
                gbc.gridy = 6;

                container.add(btn0, gbc);

                dotBtn = new JButton("  .  ");
                dotBtn.setFont(new Font("Courier New", Font.BOLD, 20));
                dotBtn.addActionListener(this);
                gbc.gridx = 1;
                gbc.gridy = 6;
                
                container.add(dotBtn, gbc);

                eqbtn = new JButton("      =      ");
                eqbtn.setFont(new Font("Courier New", Font.BOLD, 20));
                eqbtn.addActionListener(this);
                gbc.gridx = 2;
                gbc.gridy = 6;
                gbc.gridwidth = 2;
                container.add(eqbtn, gbc);

                setSize(500, 500);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public static void main(String[] args) {
                Lab8_3 test = new Lab8_3();
                // create obj of class NumberNew
                test.obj = new NumberNew();
                test.textField.setText(test.obj.toString());
        }

        public void actionPerformed(ActionEvent event) {

                if (event.getSource() == saveBtn) {
                        int value = Integer.parseInt(textField.getText());
                        obj.setValue(value);
                        textField.setText("");
                } else if (event.getSource() == clearBtn) {
                        obj.setValue(0);
                        textField.setText("");
                } else if (event.getSource() == showBtn) {
                        textField.setText(obj.toString());
                } else if (event.getSource() == addBtn) {
                        int value = Integer.parseInt(textField.getText());
                        obj.add(value);
                        textField.setText(obj.toString());
                } else if (event.getSource() == subBtn) {
                        int value = Integer.parseInt(textField.getText());
                        obj.subtract(value);
                        textField.setText(obj.toString());
                } else if (event.getSource() == mulBtn) {
                        int value = Integer.parseInt(textField.getText());
                        obj.multiply(value);
                        textField.setText(obj.toString());
                } else if (event.getSource() == divBtn) {
                        int value = Integer.parseInt(textField.getText());
                        obj.divide(value);
                        textField.setText(obj.toString());
                } else if (event.getSource() == eqbtn) {
                        textField.setText(obj.toString());
                } else if (event.getSource() == btnClear) {
                        textField.setText("");
                } else if (event.getSource() == btnBackspace) {
                        String str = textField.getText();
                        if (str.length() > 0) {
                                str = str.substring(0, str.length() - 1);
                                textField.setText(str);
                        }
                } else if (btn0 == event.getSource()) {
                        textField.setText(textField.getText() + "0");
                } else if (btn1 == event.getSource()) {
                        textField.setText(textField.getText() + "1");
                } else if (btn2 == event.getSource()) {
                        textField.setText(textField.getText() + "2");
                } else if (btn3 == event.getSource()) {
                        textField.setText(textField.getText() + "3");
                } else if (btn4 == event.getSource()) {
                        textField.setText(textField.getText() + "4");
                } else if (btn5 == event.getSource()) {
                        textField.setText(textField.getText() + "5");
                } else if (btn6 == event.getSource()) {
                        textField.setText(textField.getText() + "6");
                } else if (btn7 == event.getSource()) {
                        textField.setText(textField.getText() + "7");
                } else if (btn8 == event.getSource()) {
                        textField.setText(textField.getText() + "8");
                } else if (btn9 == event.getSource()) {
                        textField.setText(textField.getText() + "9");
                } else if (dotBtn == event.getSource()) {
                        textField.setText(textField.getText() + ".");
                }
        }
}
