package Lab;


import java.util.Scanner;

public class any_max_consec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // แสดงข้อความให้ผู้ใช้ใส่ข้อมูล
        System.out.println("กรุณาป้อนตัวเลขทีละตัว (ป้อน 0 เพื่อสิ้นสุด):");

        int maxCount = 0; // เก็บจำนวนครั้งที่ตัวเลขซ้ำกันมากที่สุด
        int currentCount = 1; // ตัวนับจำนวนครั้งที่ตัวเลขซ้ำกันในปัจจุบัน
        int maxNumber = -1; // เก็บค่าของตัวเลขที่ซ้ำกันมากที่สุด
        int prevNumber = -1; // เก็บค่าตัวเลขก่อนหน้า
        int firstMaxNumber = -1; // เก็บตัวเลขแรกที่ซ้ำกันมากที่สุด

        while (true) {
            // อ่านค่าจากผู้ใช้
            int number = scanner.nextInt();

            // ถ้าผู้ใช้ป้อน 0 ให้หยุดการทำงานของลูป
            if (number == 0) {
                System.out.println("สิ้นสุดการป้อนข้อมูล.");
                break;
            }

            // ถ้าตัวเลขที่ป้อนเหมือนกับตัวเลขก่อนหน้า
            if (number == prevNumber) {
                currentCount++; // เพิ่มตัวนับซ้ำ
            } else {
                // ถ้าตัวเลขเปลี่ยน (ไม่เหมือนตัวเลขก่อนหน้า)
                if (currentCount > maxCount) {
                    // อัปเดตค่าที่ซ้ำมากที่สุด ถ้าค่าปัจจุบันมากกว่า
                    maxCount = currentCount;
                    maxNumber = prevNumber;
                    firstMaxNumber = maxNumber; // เก็บตัวเลขแรกที่ซ้ำกันมากที่สุด
                }
                currentCount = 1; // รีเซ็ตตัวนับซ้ำ
            }

            // อัปเดตค่าตัวเลขก่อนหน้า
            prevNumber = number;
        }

        // ตรวจสอบชุดตัวเลขสุดท้ายหลังจากออกจากลูป
        if (currentCount > maxCount) {
            maxCount = currentCount;
            maxNumber = prevNumber;
            firstMaxNumber = maxNumber; // เก็บตัวเลขแรกที่ซ้ำกันมากที่สุด
        }

        // แสดงผลลัพธ์
        if (maxCount > 0) {
            System.out.println("ผลลัพธ์:");
            System.out.println("จำนวนครั้งที่ซ้ำกันมากที่สุด: " + maxCount);
            System.out.println("ตัวเลขที่ซ้ำกันมากที่สุด: " + firstMaxNumber);
        } else {
            System.out.println("ไม่พบตัวเลขที่ซ้ำกัน.");
        }

        scanner.close(); // ปิด Scanner เพื่อคืนทรัพยากร
    }
}


