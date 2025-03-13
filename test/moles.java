package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class moles extends JFrame implements ActionListener {
  JButton btn[];
  int mole[];
  JLabel jx, jy, jid;
  JTextField x, y, id;
  JButton rr, rst, rsp;

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
      btn[idx].setBackground(Color.ORANGE);
      btn[idx].addActionListener(this);
      con.add(btn[idx]);
    }
    mole = new int[3];
    mole_move();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void mole_move() {
    Random rand = new Random();
    for (int i = 0; i < mole.length; i++) {
      btn[mole[i]].setBackground(Color.ORANGE);
      mole[i] = rand.nextInt(16);
      btn[mole[i]].setBackground(Color.blue);
    }
  }

  @Override

  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(rr)) {
      System.out.println(rr);
      mole_move();
    }
    for (int i = 0; i < btn.length; i++) {
      if (e.getSource().equals(btn[i])) {
        System.out.println(((JButton) e.getSource()).getText());
        System.out.println(btn[i].getBackground());

      }
    }
  }

  public static void main(String[] args) {

    moles game = new moles();
  }

}
