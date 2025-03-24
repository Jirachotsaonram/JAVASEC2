package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test5_14 extends JFrame {
    JLabel numberLabel, resultLabel;
    JTextField numberField, resultField;

    /** สร้างอินสแตนซ์ใหม่ของ Test5_14 */
    public Test5_14() {
        super("Summation number Swing Application");
        // รับคอนเทนต์เพนและตั้งค่าเลย์เอาต์เป็น FlowLayout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        // สร้าง numberLabel และแนบไปยังคอนเทนต์เพน
        numberLabel = new JLabel("Enter an integer and press Enter");
        container.add(numberLabel);
        // สร้าง numberField และแนบไปยังคอนเทนต์เพน
        numberField = new JTextField(10);
        container.add(numberField);
        // ลงทะเบียนแอปเพล็ตนี้เป็น ActionListener ของ numberField
        numberField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                long number, sumValue;
                // รับอินพุตของผู้ใช้และแปลงเป็น long
                number = Long.parseLong(numberField.getText());
                // คำนวณค่าผลรวมสำหรับจำนวนที่ผู้ใช้ป้อน
                sumValue = summation(number);
                // แสดงผลการประมวลผลเสร็จสิ้นและแสดงผลลัพธ์
                // showStatus( "เสร็จสิ้น." );
                resultField.setText(Long.toString(sumValue));
            } // สิ้นสุดเมธอด actionPerformed
        });
        // สร้าง resultLabel และแนบไปยังคอนเทนต์เพน
        resultLabel = new JLabel("Summation value is");
        container.add(resultLabel);
        // สร้าง resultField, ทำให้ไม่สามารถแก้ไขได้
        // และแนบไปยังคอนเทนต์เพน
        resultField = new JTextField(15);
        resultField.setEditable(false);
        container.add(resultField);
    }

    public static void main(String[] args) {
        Test5_14 window = new Test5_14();
        window.setSize(350, 150);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public long summation(long n) {
        long total = 0;
        for (long x = 0; x <= n; x++)
            total += x;
        return (total);
    } // สิ้นสุดเมธอด summation
}
