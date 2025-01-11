package Lab4;

// File name : Lab4_4.java 
import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab4_4 {

    public static void main(String args[]) {
        int total; // sum of grades
        int counter; // number of grades entered
        int score; // grade value
        double average; // number with decimal point for average
        Scanner scan = new Scanner(System.in);

        // initialization phase
        total = 0; // initialize total
        counter = 0; // initialize loop counter
        do {
            // get score from user
            System.out.println("Enter Integer Score or -1 to Quit:");
            score = scan.nextInt();
            if (score != -1) {
                total = total + score; // add score to total
                counter = counter + 1; // increment counter
            }
            // loop until sentinel value read from user
        } while (score != -1);

        DecimalFormat twoDigits = new DecimalFormat("0.00");
        // if user entered at least one score...
        if (counter != 0) {
            // calculate average of all scores entered
            average = (double) total / counter;
            // display average with two digits of precision
            System.out.println("Class average is " +
                    twoDigits.format(average));
        } // end if part of if...else
        else // if no grades entered, output appropriate message
            System.out.println("No scores were entered");
    }
}