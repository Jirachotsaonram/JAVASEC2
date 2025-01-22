package Lab;

import java.util.Scanner;

public class TeamCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // อ่านจำนวนผู้เข้าแข่งขันของแต่ละทีม
        System.out.print("Enter the number of players per team (N): ");
        int N = scanner.nextInt();

        // สร้างอาเรย์เพื่อเก็บคะแนนของทีม 1 และทีม 2
        int[] team1 = new int[N];
        int[] team2 = new int[N];

        // อ่านคะแนนของทีม 1
        System.out.println("Enter the scores for Team 1:");
        for (int i = 0; i < N; i++) {
            team1[i] = scanner.nextInt();
        }

        // อ่านคะแนนของทีม 2
        System.out.println("Enter the scores for Team 2:");
        for (int i = 0; i < N; i++) {
            team2[i] = scanner.nextInt();
        }

        // คำนวณคะแนนรวมของแต่ละทีม
        int scoreTeam1 = 0;
        int scoreTeam2 = 0;

        for (int i = 0; i < N; i++) {
            if (team1[i] > team2[i]) {
                scoreTeam1 += 2; // ทีม 1 ชนะในเกมนี้
            } else if (team1[i] < team2[i]) {
                scoreTeam2 += 2; // ทีม 2 ชนะในเกมนี้
            } else {
                scoreTeam1 += 1; // เสมอ
                scoreTeam2 += 1; // เสมอ
            }
        }

        // แสดงผลลัพธ์
        if (scoreTeam1 > scoreTeam2) {
            System.out.println("Winner: Team 1");
            System.out.println("Scores: " + scoreTeam1 + " " + scoreTeam2);
        } else if (scoreTeam1 < scoreTeam2) {
            System.out.println("Winner: Team 2");
            System.out.println("Scores: " + scoreTeam2 + " " + scoreTeam1);
        } else {
            System.out.println("It's a draw!");
            System.out.println("Scores: " + scoreTeam1 + " " + scoreTeam2);
        }

        scanner.close(); // ปิด Scanner
    }
}

