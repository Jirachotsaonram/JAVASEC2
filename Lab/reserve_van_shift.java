package Lab;

import java.util.Scanner;

public class reserve_van_shift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        int n = 0;
        int a=0, b=0, c=0;
        System.err.println("Enter the number of shifts: ");
        num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            n = scan.nextInt();
            if(n>=1){
                if(n>=1 && n<=15){
                    if (a == 0 && b == 0 && c == 0) {
                        System.out.println("A");
                        a += n;
                    } else if (a <= b && a <= c) {
                        System.out.println("A");
                        a += n;
                    } else if (b < a && b <= c) {
                        System.out.println("B");
                        b += n;
                    } else if (c < a && c < b) {
                        System.out.println("C");
                        c += n;
                    }
                    System.out.println("+--------------------------------+");
                }else{
                    System.out.println("Day 1 to 15 only");
                    i--;
                }
            }else{
                System.out.println("Enter a valid number");
                i--;
            }
        }
    }
}