package Lab3;

import java.util.Scanner;

public class Lab3_8a {
    float F;
    int d;
    int c1,c2,c3,c4;
    public Lab3_8a(float a) {
        F = (9/5) * a + 32;
    }

    public Lab3_8a(int b, int i) {
        d = b * i;
    }

    public Lab3_8a(int c) {
        c1 = c / 1000;
        c2 = (c / 100) % 10;
        c3 = (c / 10) % 10;
        c4 = c % 10;
    }
    
    public static void main(String[] args) {
        int num;
        Scanner scan = new Scanner(System.in);
        Lab3_8a Fahrenheit = new Lab3_8a(0.0f);
        System.out.println("Celsius to Fahrenheit is " + Fahrenheit.F);
        Lab3_8a Income = new Lab3_8a(100, 2);
        System.out.println("Income " + Income.d);
        System.out.print("Enter Number : ");
        num = scan.nextInt();
        Lab3_8a Number = new Lab3_8a(num);
        System.out.println(Number.c1 + " " + Number.c2 + " " + Number.c3 + " " + Number.c4);

    }
}
