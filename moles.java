import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class moles extends JFrame implements ActionListener, MouseListener {
    JButton btnRand, btnStart, btnStop, btn[];
    JLabel jx, jy, jid, jscore;
    JTextField Fx, Fy, Fid, Fscore;
    Timer timer;
    int score = 0;
    int delay = 2000;

    moles() {
        super("Whack-a-Mole");
        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        jx = new JLabel("X");
        con.add(jx);
        Fx = new JTextField(4);
        con.add(Fx);
        jy = new JLabel("Y");
        con.add(jy);
        Fy = new JTextField(4);
        con.add(Fy);
        jid = new JLabel("id");
        con.add(jid);
        Fid = new JTextField(2);
        con.add(Fid);
        btnRand = new JButton("Random");
        btnRand.addActionListener(this);
        con.add(btnRand);
        btnStart = new JButton("Start");
        btnStart.addActionListener(this);
        con.add(btnStart);
        btnStop = new JButton("Stop");
        btnStop.addActionListener(this);
        con.add(btnStop);
        btn = new JButton[16];
        for (int idx = 0; idx < 16; idx++) {
            btn[idx] = new JButton(idx + "");
            btn[idx].setPreferredSize(new Dimension(100, 100));
            btn[idx].setOpaque(true);
            btn[idx].setBackground(Color.red);
            btn[idx].addActionListener(this);
            btn[idx].addMouseListener(this);
            con.add(btn[idx]);
        }
        jscore = new JLabel("Debug imformation");
        con.add(jscore);
        Fscore = new JTextField(12);
        Fscore.setEditable(false);
        con.add(Fscore);
    }

    public void move_moles() {
        Random rand = new Random();
        Set<Integer> molePositions = new HashSet<>();
        while (molePositions.size() < 3) {
            molePositions.add(rand.nextInt(16));
        }
        for (int idx = 0; idx < 16; idx++) {
            if (molePositions.contains(idx)) {
                btn[idx].setBackground(Color.green);
            } else {
                btn[idx].setBackground(Color.red);
            }
        }
    }

    public void mole_clear() {
        for (int idx = 0; idx < 16; idx++) {
            btn[idx].setBackground(Color.red);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRand) {
            move_moles();
        }
        if (e.getSource() == btnStart) {
            startGame();
        }
        if (e.getSource() == btnStop) {
            stopGame();
        }
        for (int idx = 0; idx < 16; idx++) {
            boolean status = false;
            if (e.getSource() == btn[idx]) {
                if (btn[idx].getBackground() == Color.green) {
                    score++;
                    status = true;
                    btn[idx].setBackground(Color.red);
                    if (score >= 20) {
                        stopGame();
                    } else {
                        delay = Math.max(500, delay - 50);
                        if (timer != null) {
                            timer.setDelay(delay);
                        }
                    }
                }
            }

            if (e.getSource() instanceof JButton) {
                JButton source = (JButton) e.getSource();
                if (source == btn[idx]) {
                    Fscore.setText("Click on " + idx + ": " + status);
                    break;
                }

            }
        }
    }

    public void startGame() {
        score = 0;
        delay = 2000;
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move_moles();
            }
        });
        timer.start();
    }

    public void stopGame() {
        if (timer != null) {
            timer.stop();
        }
        JOptionPane.showMessageDialog(this, "You scored: " + score);
        score = 0;
        delay = 2000;
        mole_clear();
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        Fx.setText(x + "");
        Fy.setText(y + "");
        if (event.getSource() instanceof JButton) {
            JButton source = (JButton) event.getSource();
            for (int idx = 0; idx < btn.length; idx++) {
                if (source == btn[idx]) {
                    Fid.setText(idx + "");
                    break;
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent event) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
    }

    @Override
    public void mousePressed(MouseEvent event) {
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        repaint();
    }

    public static void main(String[] args) {
        moles window = new moles();
        window.setSize(480, 550);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}