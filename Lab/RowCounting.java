package Lab;

import java.util.Scanner;

public class RowCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่า R และ C
        System.out.println("Enter the number of rows (R) and columns (C):");
        int R = scanner.nextInt(); // จำนวนแถว
        int C = scanner.nextInt(); // จำนวนหลัก (คอลัมน์)

        // นับเลขและพิมพ์ผลลัพธ์
        int counter = 1; // เริ่มต้นนับเลขจาก 1
        for (int i = 0; i < R; i++) { // ลูปสำหรับแถว
            for (int j = 0; j < C; j++) { // ลูปสำหรับคอลัมน์
                System.out.print(counter + " "); // พิมพ์เลข
                counter++; // เพิ่มค่า counter
            }
            System.out.println(); // ขึ้นบรรทัดใหม่หลังจากครบ C หลัก
        }

        scanner.close();
    }
}



