import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JPanel panel;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, equButton, clrButton, decButton;
    private String operator = "";
    private double num1, num2, result;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 450);
        frame.setLayout(new BorderLayout());

        // TextField สำหรับแสดงค่าตัวเลข
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH);

        // Panel สำหรับปุ่มกด
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // สร้างปุ่มตัวเลข 0-9
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].addActionListener(this);
        }

        // สร้างปุ่มฟังก์ชัน
        decButton = new JButton(".");
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        clrButton = new JButton("C");

        // ตั้งค่า Font และ ActionListener
        JButton[] functionButtons = { decButton, addButton, subButton, mulButton, divButton, equButton, clrButton };
        for (JButton btn : functionButtons) {
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
        }

        // จัดเรียงปุ่มเป็นเครื่องคิดเลข
        panel.add(numberButtons[7]); panel.add(numberButtons[8]); panel.add(numberButtons[9]); panel.add(divButton);
        panel.add(numberButtons[4]); panel.add(numberButtons[5]); panel.add(numberButtons[6]); panel.add(mulButton);
        panel.add(numberButtons[1]); panel.add(numberButtons[2]); panel.add(numberButtons[3]); panel.add(subButton);
        panel.add(numberButtons[0]); panel.add(decButton);         panel.add(equButton);      panel.add(addButton);

        // ปุ่ม Clear อยู่ด้านล่างสุด
        frame.add(clrButton, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null); // แสดงหน้าต่างตรงกลางจอ
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
                return;
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText() + ".");
        } else if (e.getSource() == addButton) {
            setOperator("+");
        } else if (e.getSource() == subButton) {
            setOperator("-");
        } else if (e.getSource() == mulButton) {
            setOperator("*");
        } else if (e.getSource() == divButton) {
            setOperator("/");
        } else if (e.getSource() == equButton) {
            calculateResult();
        } else if (e.getSource() == clrButton) {
            textField.setText("");
        }
    }

    private void setOperator(String op) {
        if (!textField.getText().isEmpty()) {
            num1 = Double.parseDouble(textField.getText());
            operator = op;
            textField.setText("");
        }
    }

    private void calculateResult() {
        if (!textField.getText().isEmpty() && !operator.isEmpty()) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = (num2 != 0) ? num1 / num2 : 0; break;
            }

            textField.setText(String.valueOf(result));
            operator = "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
