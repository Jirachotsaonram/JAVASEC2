package Lab;

import java.util.Scanner;

public class ForwardBackwardPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่า N
        System.out.println("Enter the number of integers (N):");
        int N = scanner.nextInt();

        // รับค่า N ตัว
        System.out.println("Enter " + N + " integers:");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        // รับค่า M
        System.out.println("Enter the value of M:");
        int M = scanner.nextInt();

        // บวก M กับเลขแต่ละตัวใน array numbers
        for (int i = 0; i < N; i++) {
            numbers[i] += M;
        }

        // พิมพ์ผลลัพธ์
        if (M > 0) {
            // พิมพ์เรียงจากตัวแรกไปตัวสุดท้าย
            for (int i = 0; i < N; i++) {
                System.out.print(numbers[i] + (i == N - 1 ? "" : " "));
            }
        } else {
            // พิมพ์เรียงจากตัวสุดท้ายไปตัวแรก
            for (int i = N - 1; i >= 0; i--) {
                System.out.print(numbers[i] + (i == 0 ? "" : " "));
            }
        }

        scanner.close();
    }
}

