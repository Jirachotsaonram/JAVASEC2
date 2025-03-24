package GUI;

// นำเข้าคลาสที่จำเป็นจากแพ็กเกจ java.awt และ javax.swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chap09_01 extends JFrame implements MouseListener {
    int x = 15, y = 160; // ประกาศตัวแปร x และ y เพื่อเก็บตำแหน่งของวงกลม
    int numClicked = 0; // ประกาศตัวแปร numClicked เพื่อเก็บจำนวนครั้งที่คลิก

    public Chap09_01() {
        super("Example using MouseListener"); // ตั้งชื่อหน้าต่างเป็น "Example using MouseListener"
        addMouseListener(this); // เพิ่ม MouseListener ให้กับ JFrame
    }

    public void paint(Graphics g) {
        super.paint(g); // เรียกใช้เมธอด paint ของคลาสแม่
        g.drawString("x = " + x + ", y = " + y, 15, 50); // วาดข้อความแสดงตำแหน่ง x และ y
        g.drawString(numClicked + " clicked", 15, 70); // วาดข้อความแสดงจำนวนครั้งที่คลิก
        g.fillOval(x, y, 20, 20); // วาดวงกลมที่ตำแหน่ง x และ y
    }

    public void mousePressed(MouseEvent event) {
        int x = event.getX(); // รับตำแหน่ง x ที่คลิก
        int y = event.getY(); // รับตำแหน่ง y ที่คลิก
        Graphics g = getGraphics(); // รับออบเจ็กต์ Graphics
        g.drawString("[" + x + ", " + y + " ]", x, y); // วาดข้อความแสดงตำแหน่งที่คลิก
    }

    public void mouseReleased(MouseEvent event) {
        repaint(); // เรียกใช้เมธอด repaint เพื่อวาดใหม่
    }

    public void mouseClicked(MouseEvent event) {
        this.x = event.getX(); // อัปเดตตำแหน่ง x ด้วยค่าที่คลิก
        this.y = event.getY(); // อัปเดตตำแหน่ง y ด้วยค่าที่คลิก
        numClicked++; // เพิ่มจำนวนครั้งที่คลิก
    }

    public void mouseEntered(MouseEvent event) {
        // ไม่ได้ทำอะไรเมื่อเมาส์เข้าสู่คอมโพเนนต์
    }

    public void mouseExited(MouseEvent event) {
        // ไม่ได้ทำอะไรเมื่อเมาส์ออกจากคอมโพเนนต์
    }

    public static void main(String[] args) {
        Chap09_01 test = new Chap09_01(); // สร้างอินสแตนซ์ของ Chap09_01
        test.setSize(640, 480); // กำหนดขนาดหน้าต่าง
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ตั้งค่าให้ปิดโปรแกรมเมื่อปิดหน้าต่าง
        test.setVisible(true); // ทำให้หน้าต่างมองเห็นได้
    }
}