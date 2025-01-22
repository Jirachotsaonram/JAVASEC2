package Lab;

import java.util.Scanner;

public class ClosestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่า X
        System.out.print("Enter X: ");
        int X = scanner.nextInt();

        // ตัวแปรเพื่อเก็บค่าที่ใกล้เคียงที่สุดและค่าความต่างน้อยที่สุด
        int closestNumber = 0;
        int minDifference = Integer.MAX_VALUE;

        // รับค่า 8 ตัวถัดไป
        System.out.println("Enter 8 numbers:");
        for (int i = 0; i < 8; i++) {
            int currentNumber = scanner.nextInt();
            int difference = Math.abs(currentNumber - X); // คำนวณความต่างแบบค่าสัมบูรณ์

            // ถ้าค่าความต่างของตัวเลขปัจจุบันน้อยกว่าค่าความต่างที่น้อยที่สุดในตอนนี้
            if (difference < minDifference) {
                minDifference = difference; // อัพเดตค่าความต่างที่น้อยที่สุด
                closestNumber = currentNumber; // อัพเดตค่าที่ใกล้เคียงที่สุด
            }
        }

        // แสดงผลลัพธ์
        System.out.println("The closest number to X is: " + closestNumber);

        scanner.close(); // ปิด Scanner
    }
}
