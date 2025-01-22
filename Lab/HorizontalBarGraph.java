package Lab;
import java.util.Scanner;

public class HorizontalBarGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // รับค่าจำนวนเต็มจากผู้ใช้
            System.out.print("Enter a number (0 or negative to stop): ");
            int number = scanner.nextInt();

            // ตรวจสอบว่าหยุดหรือไม่
            if (number <= 0) {
                break;
            }

            // สร้างเครื่องหมายดอกจันตามจำนวนที่ผู้ใช้ป้อน
            for (int i = 0; i < number; i++) {
                System.out.print("*");
            }
            System.out.println(); // ขึ้นบรรทัดใหม่
        }

        scanner.close(); // ปิด Scanner
        System.out.println("Program ended.");
    }
}
