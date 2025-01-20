package Lab;

import java.util.Random;
import javax.swing.*;

public class Vote {
    public static void main(String[] args) {
        final int TOTAL_VOTERS = 80000;
        final int NUM_CANDIDATES = 5;
        String[] candidates = {"Candidate 1", "Candidate 2", "Candidate 3", "Candidate 4", "Candidate 5"};
        int[] votes = new int[NUM_CANDIDATES];
        int spoiledBallots = 0;

        Random random = new Random();

        // สุ่มจำนวนผู้ที่ใช้สิทธิ์เลือกตั้ง
        int usedVotes = random.nextInt(TOTAL_VOTERS + 1);
        int notUsedVotes = TOTAL_VOTERS - usedVotes;

        // สุ่มคะแนนและบัตรเสีย
        for (int i = 0; i < usedVotes; i++) {
            int vote = random.nextInt(NUM_CANDIDATES + 1); // สุ่มค่าระหว่าง 0 ถึง 5 (รวม 6)
            if (vote == NUM_CANDIDATES) {
                spoiledBallots++;
            } else {
                votes[vote]++;
            }
        }

        // คำนวณสัดส่วนผู้มาใช้สิทธิ์และบัตรเสีย
        double usedVotesPercentage = (double) usedVotes / TOTAL_VOTERS * 100;
        double spoiledBallotsPercentage = (double) spoiledBallots / usedVotes * 100;

        // หาผู้สมัครที่ได้คะแนนสูงสุด 2 ลำดับ
        int firstMaxIndex = 0, secondMaxIndex = 0;
        for (int i = 1; i < NUM_CANDIDATES; i++) {
            if (votes[i] > votes[firstMaxIndex]) {
                secondMaxIndex = firstMaxIndex;
                firstMaxIndex = i;
            } else if (votes[i] > votes[secondMaxIndex]) {
                secondMaxIndex = i;
            }
        }

        // สร้างข้อความเพื่อแสดงผลลัพธ์
        StringBuilder output = new StringBuilder();
        output.append("Election Results :\n");
        output.append("Number of eligible people: 80000 people :\n");
        for (int i = 0; i < NUM_CANDIDATES; i++) {
            output.append(candidates[i]).append(": ").append(votes[i]).append(" votes\n");
        }
        output.append("Spoiled Ballots: ").append(spoiledBallots).append("\n");
        output.append("Not Used Votes: ").append(notUsedVotes).append("\n");
        output.append(String.format("Used Votes Percentage: %.2f%%\n", usedVotesPercentage));
        output.append(String.format("Spoiled Ballots Percentage: %.2f%%\n", spoiledBallotsPercentage));
        output.append("Top 2 Candidates:\n");
        output.append("1. ").append(candidates[firstMaxIndex]).append(": ").append(votes[firstMaxIndex]).append(" votes\n");
        output.append("2. ").append(candidates[secondMaxIndex]).append(": ").append(votes[secondMaxIndex]).append(" votes\n");

        // แสดงผลลัพธ์ในกล่องข้อความ
        JTextArea textArea = new JTextArea(output.toString());
 
        JOptionPane.showMessageDialog(null, textArea, "Election Results", JOptionPane.INFORMATION_MESSAGE);
    }
}