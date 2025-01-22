package Lab;

import java.util.Scanner;

public class RhombusPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่าจำนวนเต็มคี่บวก N
        System.out.print("Enter an odd positive number (N): ");
        int N = scanner.nextInt();

        // ตรวจสอบว่า N เป็นจำนวนเต็มคี่บวก
        if (N <= 0 || N % 2 == 0) {
            System.out.println("N must be an odd positive number.");
            return;
        }

        // จำนวนแถวในครึ่งบนของรูป
        int mid = N / 2;

        // สร้างครึ่งบนของรูป
        for (int i = 0; i <= mid; i++) {
            // พิมพ์ช่องว่าง
            for (int j = 0; j < mid - i; j++) {
                System.out.print(" ");
            }
            // พิมพ์เครื่องหมายดอกจัน
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // สร้างครึ่งล่างของรูป
        for (int i = mid - 1; i >= 0; i--) {
            // พิมพ์ช่องว่าง
            for (int j = 0; j < mid - i; j++) {
                System.out.print(" ");
            }
            // พิมพ์เครื่องหมายดอกจัน
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close(); // ปิด Scanner
    }
}