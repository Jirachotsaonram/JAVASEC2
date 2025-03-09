package Lab13;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class Lab13_02 extends JFrame implements ActionListener  { 
    private Animation display; 
    private JButton playBtn, stopBtn, upBtn, downBtn, leftBtn, rightBtn; 
     
    public Lab13_02() { 
        Container c = getContentPane(); 
        c.setLayout(new FlowLayout()); 
        playBtn = new JButton("Play"); 
        playBtn.addActionListener(this); 
        stopBtn = new JButton("Stop"); 
        stopBtn.addActionListener(this); 
        upBtn = new JButton("Up");
        upBtn.addActionListener(this);
        downBtn = new JButton("Down");
        downBtn.addActionListener(this);
        leftBtn = new JButton("Left");
        leftBtn.addActionListener(this);
        rightBtn = new JButton("Right");
        rightBtn.addActionListener(this);

         
        display = new Animation(); 
        c.add(playBtn); 
        c.add(stopBtn); 
        c.add(display); 
        c.add(upBtn);
        c.add(downBtn);
        c.add(leftBtn);
        c.add(rightBtn);
    } 
     
    public void paint(Graphics g) { 
        super.paint(g); 
    } 
     
    public void stop( ) { 
        display.stop(); 
    } 
     
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == playBtn) { 
            display.play(); 
            playBtn.setEnabled(false); 
        } 
        else if (e.getSource() == stopBtn) {  
            display.stop(); 
            playBtn.setEnabled(true); 
        }

        else if (e.getSource() == upBtn) {
            display.moveUp();
            playBtn.setEnabled(true); 
        } 
        else if (e.getSource() == downBtn) {
            display.moveDown();
        } 
        else if (e.getSource() == leftBtn) {
            display.moveLeft();
        } 
        else if (e.getSource() == rightBtn) {
            display.moveRight();
        }
    } 
    public static void main(String[] args) { 
        Lab13_02 window = new Lab13_02(); 
        window.setSize(400,350); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setVisible(true); 
    } 
}
