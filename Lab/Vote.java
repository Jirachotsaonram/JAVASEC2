package Lab;

import java.util.Random;
import javax.swing.*;

public class Vote {
    private static final String Color = null;
    
        public static void main(String[] args) {
            final int TOTAL_VOTERS = 80000;
            final int NUM_CANDIDATES = 5;
            String[] candidates = {"Candidate 1", "Candidate 2", "Candidate 3", "Candidate 4", "Candidate 5"};
            int[] votes = new int[NUM_CANDIDATES];
            int spoiledBallots = 0;
    
            Random random = new Random();
    
            // สุ่มคะแนนและบัตรเสีย
            for (int i = 0; i < TOTAL_VOTERS; i++) {
                int vote = random.nextInt(NUM_CANDIDATES + 1); // สุ่มค่าระหว่าง 0 ถึง 5 (รวม 6)
                if (vote == NUM_CANDIDATES) {
                    spoiledBallots++;
                } else {
                    votes[vote]++;
                }
            }
    
            // สร้างข้อความเพื่อแสดงผลลัพธ์
            StringBuilder output = new StringBuilder();
            output.append("Election Results:\n");
            for (int i = 0; i < NUM_CANDIDATES; i++) {
                output.append(candidates[i]).append(": ").append(votes[i]).append(" votes\n");
            }
            output.append("Spoiled Ballots: ").append(spoiledBallots).append("\n");
    
            // แสดงผลลัพธ์ในกล่องข้อความ
            JTextArea textArea = new JTextArea(output.toString());
            
        JOptionPane.showMessageDialog(null, textArea, "Election Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
