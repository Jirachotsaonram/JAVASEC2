package work;
import javax.swing.*;
import java.awt.*;

public class MickeyMouse extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // ตั้งค่าคุณสมบัติกราฟิก
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLACK);

        // วาดหู
        g2d.drawOval(50, 50, 80, 80);  // หูซ้าย
        g2d.drawOval(170, 50, 80, 80); // หูขวา

        // วาดหัว
        g2d.drawOval(90, 90, 120, 120);

        // วาดตา
        g2d.drawOval(120, 120, 30, 50); // ตาซ้าย
        g2d.drawOval(150, 120, 30, 50); // ตาขวา

        // วาดจมูก
        g2d.drawOval(135, 160, 30, 20);

        // วาดปาก
        g2d.drawArc(120, 170, 60, 40, 0, -180);

        // วาดลำตัว
        g2d.drawOval(110, 210, 80, 100);

        // วาดขา
        g2d.drawOval(100, 300, 40, 80); // ขาซ้าย
        g2d.drawOval(160, 300, 40, 80); // ขาขวา

        // วาดรองเท้า
        g2d.drawOval(85, 370, 60, 30);  // รองเท้าซ้าย
        g2d.drawOval(155, 370, 60, 30); // รองเท้าขวา

        // วาดแขน
        g2d.drawLine(120, 230, 50, 280);  // แขนซ้าย
        g2d.drawLine(180, 230, 230, 280); // แขนขวา

        // วาดมือ
        g2d.drawOval(30, 270, 40, 40);  // มือซ้าย
        g2d.drawOval(220, 270, 40, 40); // มือขวา
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mickey Mouse");
        MickeyMouse mickey = new MickeyMouse();
        frame.add(mickey);
        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
