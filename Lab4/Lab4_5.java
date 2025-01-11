
package Lab4;

// File name : Lab4_5.java 
import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab4_5 {
    public static void main(String args[]) {
        double amount; // amount on deposit at end of each year
        double interest; // interest on deposit at end of each year
        double principal; // initial amount before interest
        double rate; // interest rate
        Scanner scan = new Scanner(System.in);

        // get principal from user
        System.out.println("Enter principal :");
        principal = scan.nextDouble();
        // get interest rate from user
        System.out.println("Enter interest rate :");
        rate = scan.nextInt();
        rate = rate / 100;
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        DecimalFormat threeDigits = new DecimalFormat("0.000");
        // set first line of text
        System.out.println("Year\tAmount on deposit\n");
        // calculate amount on deposit for each of ten years
        amount = principal;
        for (int year = 1; year <= 10; year++) {
            // calculate new amount for specified year
            interest = amount * rate;
            amount = amount + interest;
            System.out.println(year + "\t" +
                    threeDigits.format(interest) + "\t\t" +
                    twoDigits.format(amount));
        }
    }
}