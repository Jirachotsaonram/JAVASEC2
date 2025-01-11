package Lab4;

import java.util.Scanner;

public class Lab4_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1, num2;
        double result = 0;
        char operator;
        boolean done = true;
        String message;

        System.out.println("Program Calculator.");
        System.out.println("Enter first value : ");
        num1 = scan.nextInt();
        System.out.println("Enter second value : ");
        num2 = scan.nextInt();
        System.out.println("Enter operator(+, -, *, /, %) : ");
        message = scan.next();
        operator = message.charAt(0);
        switch (operator) {
            case '+':
                result = num1 + num2;
                message = "result = num1 + num2 = ";
                break;
            case '-':
                result = num1 - num2;
                message = "result = num1 - num2 = ";
                break;
            case '*':
                result = num1 * num2;
                message = "result = num1 * num2 = ";
                break;
            case '/':
                result = (double) num1 / num2;
                message = "result = num1 / num2 = ";
                break;
            case '%':
                result = num1 % num2;
                message = "result = num1 % num2 = ";
                break;
            default:
                done = false;
        }
        if (done)
            System.out.println(message + result);
        else
            System.out.println("Invalid Operator.");
    }
}
