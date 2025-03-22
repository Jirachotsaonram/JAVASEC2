package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class moles extends JFrame implements ActionListener, MouseListener {
  JButton btn[];
  int mole[];
  JLabel jx, jy, jid, jg;
  JTextField x, y, id, j;
  JButton rr, rst, rsp;
  Timer timer;
  int score;
  int delay = 2000;
  int hits = 0;
  int misses = 0;

  moles() {
    super("Game demo");
    setSize(480, 550);
    Container con = getContentPane();
    con.setLayout(new FlowLayout());
    jx = new JLabel("X");
    con.add(jx);
    x = new JTextField(4);
    con.add(x);
    jy = new JLabel("Y");
    con.add(jy);
    y = new JTextField(4);
    con.add(y);
    jid = new JLabel("id");
    con.add(jid);
    id = new JTextField(2);
    con.add(id);
    
    // Add MouseListener to JLabels
    jx.addMouseListener(this);
    jy.addMouseListener(this);
    jid.addMouseListener(this);
    
    btn = new JButton[16];
    rr = new JButton("Ramdom");
    rr.addActionListener(this);
    con.add(rr);
    rst = new JButton("start");
    rst.addActionListener(this);
    con.add(rst);
    rsp = new JButton("stop");
    rsp.addActionListener(this);
    con.add(rsp);
    for (int idx = 0; idx < btn.length; idx++) {
      btn[idx] = new JButton(idx + "");
      btn[idx].setPreferredSize(new Dimension(100, 100));
      btn[idx].setOpaque(true);
      btn[idx].setBackground(Color.red);
      btn[idx].addActionListener(this);
      con.add(btn[idx]);
    }

    jg = new JLabel("Debug information : ");
    con.add(jg);
    j = new JTextField(20);
    con.add(j);
    
    mole = new int[3];
    mole_move();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void mole_move() {
    Random rand = new Random();
    for (int i = 0; i < mole.length; i++) {
      btn[mole[i]].setBackground(Color.red);
      mole[i] = rand.nextInt(16);
      btn[mole[i]].setBackground(Color.green);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(rr)) {
      System.out.println(rr);
      mole_move();
    } else if (e.getSource().equals(rst)) {
      startGame();
    } else if (e.getSource().equals(rsp)) {
      stopGame();
    } else {
      for (int i = 0; i < btn.length; i++) {
        if (e.getSource().equals(btn[i])) {
          if (btn[i].getBackground() == Color.green) {
            hits++;
            score++;
            if (score >= 20) {
              stopGame();
              showResults();
            } else {
              delay = Math.max(500, delay - 50);
              if (timer != null) {
                timer.setDelay(delay);
              }
            }
          } else {
            misses++;
          }
          System.out.println(((JButton) e.getSource()).getText());
          System.out.println(btn[i].getBackground());
        }
      }
    }
  }

  public void startGame() {
    score = 0;
    hits = 0;
    misses = 0;
    delay = 2000;
    timer = new Timer(delay, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mole_move();
      }
    });
    timer.start();
  }

  public void stopGame() {
    if (timer != null) {
      timer.stop();
    }
    score = 0;
    delay = 2000;
    for (int i = 0; i < btn.length; i++) {
      btn[i].setBackground(Color.red);
    }
  }

  public void showResults() {
    double successRate = (hits + misses) > 0 ? (double) hits / (hits + misses) * 100 : 0;
    String message = String.format("You Win/Lost\nHits: %d\nMisses: %d\nSuccess rate: %.2f%%", hits, misses, successRate);
    JOptionPane.showMessageDialog(this, message);
  }

  @Override
  public void mouseEntered(MouseEvent event) {
    JLabel source = (JLabel) event.getSource();
    Point location = source.getLocationOnScreen();
    x.setText(String.valueOf(location.x));
    y.setText(String.valueOf(location.y));
    if (source == jx) {
      id.setText("X");
    } else if (source == jy) {
      id.setText("Y");
    } else if (source == jid) {
      id.setText("ID");
    }
    repaint();
  }

  @Override
  public void mouseExited(MouseEvent event) {}

  @Override
  public void mouseClicked(MouseEvent event) {
    JLabel source = (JLabel) event.getSource();
    int clickedPosition = -1;
    if (source == jx) {
      clickedPosition = 11; // Example position for X
    } else if (source == jy) {
      clickedPosition = 7; // Example position for Y
    } else if (source == jid) {
      clickedPosition = 5; // Example position for ID
    }
    boolean isMole = false;
    for (int pos : mole) {
      if (pos == clickedPosition) {
        isMole = true;
        break;
      }
    }
    System.out.println("Click on " + clickedPosition + " : " + isMole);
  }

  @Override
  public void mousePressed(MouseEvent event) {}

  @Override
  public void mouseReleased(MouseEvent event) {}

  public static void main(String[] args) {
    moles game = new moles();
  }
}
