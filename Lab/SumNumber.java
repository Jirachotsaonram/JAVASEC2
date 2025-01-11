package Lab;

import java.util.Scanner;

public class SumNumber {
    public static void main(String[] args) {
        int number, sum = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positiv integers:");
        number = scan.nextInt();
        do {
            sum = sum + number;
            number = number - 1;
        } while (number > 0);
        System.out.println("Sum value is " + sum);
    }
}
