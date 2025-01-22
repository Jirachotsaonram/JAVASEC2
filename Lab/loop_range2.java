package Lab;

import java.util.Scanner;

public class loop_range2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่าจำนวนเต็ม x และ y
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();

        // ตรวจสอบเงื่อนไข x > y หรือ x <= y
        if (x > y) {
            // กรณี x > y: พิมพ์เลขจาก x ถึง y แบบเรียงลำดับจากมากไปน้อย
            for (int i = x; i >= y; i--) {
                System.out.print(i + " ");
            }
        } else {
            // กรณี x <= y: พิมพ์เลขจาก x ถึง y แบบเรียงลำดับจากน้อยไปมาก
            for (int i = x; i <= y; i++) {
                System.out.print(i + " ");
            }
        }
        
        scanner.close(); // ปิด Scanner
    }
}

    
