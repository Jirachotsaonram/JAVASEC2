import javax.swing.*;
import java.awt.*;

public class CalculatorGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorFrame());
    }
}

class CalculatorFrame extends JFrame {
    private JTextField display;
    
    public CalculatorFrame() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);
        
        // Buttons panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 10));
        
        String[] buttons = {
            "Save", "Clear", "Show", "c",
            "C", "Backspace", "/", "c",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "="
        };
        
        for (String text : buttons) {
            if (text.isEmpty()) {
                panel.add(new JLabel()); // Empty space
            } else {
                JButton button = new JButton(text);
                button.setFont(new Font("Arial", Font.PLAIN, 18));
                panel.add(button);
            }
        }
        
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}
