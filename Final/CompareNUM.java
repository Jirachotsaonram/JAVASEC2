package Final;

import java.util.Scanner;
public class CompareNUM {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scan.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scan.nextInt();

        if (num1 > num2){
            System.out.println(num1 + " is greater than " + num2);
        } else if (num1 < num2){
            System.out.println(num1 + " is less than " + num2);
        } else {
            System.out.println(num1 + " is equal to " + num2);
        }
    }
}
