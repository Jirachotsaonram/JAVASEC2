package Lab;

import java.text.NumberFormat;
import java.util.Scanner;

public class Wages {
    public static void main(String[] args) {
        final double RATE = 8.25; // regular pay rate
        // standard hours in a work week
        final int STANDARD = 40;
        Scanner scan = new Scanner(System.in);
        double pay = 0.0;
        System.out.print("Enter the number of hours worked:");
        int hours = scan.nextInt();
        System.out.print("Your entered: " + hours);

        if (hours > STANDARD)
            pay = STANDARD * RATE +
                    (hours - STANDARD) * (RATE * 1.5);
        else
            pay = hours * RATE;
        NumberFormat fmt;
        fmt = NumberFormat.getCurrencyInstance();
        System.out.print("Gross earings: " + fmt.format(pay));
    }
}