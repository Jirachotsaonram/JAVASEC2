package Lab3;
// File name : Lab3_8.java 
import java.util.Scanner;

public class Lab3_8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float hours, rate, salary;
        System.out.print("Enter hours work : ");
        hours = scan.nextFloat();
        System.out.print("Enter hourly rate : ");
        rate = scan.nextFloat();
        salary = (hours <= 40) ? (hours * rate) : (rate * (1.5f * hours - 40));
        System.out.println("Employee get salary :  " + salary);
    }
}