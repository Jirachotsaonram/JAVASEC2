package Lab;

import java.util.Scanner;
import java.text.NumberFormat;

public class WinPercentage {
    public static void main(String[] args) {
        final int NUM_GAMES = 12;
        int won;
        double ration;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of games won(0 to " +
                NUM_GAMES + ") : ");
        won = scan.nextInt();
        while (won < 0 || won > NUM_GAMES) {
            System.out.print("Invalid input. Please reenter : ");
            won = scan.nextInt();
        }

        ration = (double) won / NUM_GAMES;
        NumberFormat fmt = NumberFormat.getPercentInstance();
        System.out.println();
        System.out.println("Winning percentage : " +
                fmt.format(ration));
    }
}
