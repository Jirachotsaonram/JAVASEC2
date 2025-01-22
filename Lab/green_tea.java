package Lab;

import java.util.Scanner;

public class green_tea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับข้อมูลขนาดของใบชาและปริมาณน้ำ
        System.out.print("Enter tea amount and water amount: ");
        int waterAmount = scanner.nextInt();
        int teaAmount = scanner.nextInt();

        int leftoverwater = waterAmount / 250; // คำนวณปริมาณน้ำที่เหลือ
        int leftovertea = teaAmount / 15; // คำนวณปริมาณใบชาที่เหลือ
        // ตรวจสอบว่าใช้ปริมาณน้ำเกินหรือไม่

        if (waterAmount % 2 == 0) {
            System.out.println(leftovertea); // แสดงค่าปริมาณน้ำที่ต้องการ
        } else {
            int min = Math.min(leftoverwater, leftovertea); // หาค่าน้อยสุด
            System.out.println(min + "water"); // แสดงข้อความ "water" หากไม่พอ

        }

        scanner.close();
    }
}
