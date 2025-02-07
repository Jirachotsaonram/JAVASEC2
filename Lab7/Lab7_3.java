package Lab7;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class Lab7_3 implements ActionListener { 
    private JLabel numberLabel; 
    private JTextField numberField; 
    private JButton[] numberButtons; 
    private JFrame window;  

    public Lab7_3() { 
        // สร้างหน้าต่าง JFrame
        window = new JFrame("Programm Show Text"); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setLayout(new BorderLayout(10, 10));

        // ส่วนแสดงผล (Label + TextField)
        JPanel displayPanel = new JPanel(new FlowLayout());
        numberLabel = new JLabel("Show Number: "); 
        numberField = new JTextField(15);
        numberField.setEditable(false); // ไม่ให้พิมพ์เอง
        displayPanel.add(numberLabel);
        displayPanel.add(numberField);
        
        // ส่วนปุ่มกด
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5)); 
        numberButtons = new JButton[10];

        // เพิ่มปุ่มหมายเลข 0-9
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            buttonPanel.add(numberButtons[i]);
        }

        // เพิ่มส่วนต่างๆ ลงใน JFrame
        window.add(displayPanel, BorderLayout.NORTH);
        window.add(buttonPanel, BorderLayout.CENTER);

        // ตั้งค่าขนาดหน้าต่างและแสดงผล
        window.setSize(300, 250);
        window.setLocationRelativeTo(null); // จัดให้อยู่ตรงกลางจอ
        window.setVisible(true); 
    } 

    public void actionPerformed(ActionEvent event) {   
        String str = numberField.getText(); 
        for (int i = 0; i < 10; i++) {
            if (event.getSource() == numberButtons[i]) { 
                str += i; 
                break;
            }
        }
        numberField.setText(str); 
    } 

    public static void main(String[] args) { 
        SwingUtilities.invokeLater(() -> new Lab7_3()); 
    } 
}
