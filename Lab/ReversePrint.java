package Lab;

import java.util.Scanner;

public class ReversePrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // แจ้งให้ผู้ใช้ป้อนค่า N
        System.out.print("Enter the number of elements (N): ");
        int N = scanner.nextInt();
        int[] numbers = new int[N];
        
        // แจ้งให้ผู้ใช้ป้อนตัวเลข N จำนวน
        System.out.println("Enter " + N + " numbers:");
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        // แสดงผลตัวเลขเรียงย้อนกลับ
        System.out.println("Numbers in reverse order:");
        for (int i = N - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }

        scanner.close();
    }
}
