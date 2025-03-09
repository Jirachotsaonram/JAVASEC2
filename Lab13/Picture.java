package Lab13;

// File Name : Picture.java 
 
import java.awt.*; 
import javax.swing.*; 
  
public class Picture { 
    private ImageIcon image; 
    private int  x, y; 
     
    public Picture(String fname) { 
        image = new ImageIcon(fname);  
    } 
     
    public void draw( JPanel jPanel ) { 
        image.paintIcon( jPanel , jPanel.getGraphics(), x, y ); 
    } 
 
    public void position(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
     
    public void clear(JPanel jPanel) { 
        jPanel.paint(jPanel.getGraphics()); 
    } 
} 
