package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่า N
        System.out.print("Enter the number of elements (N): ");
        int N = scanner.nextInt();

        // รับชุดตัวเลข
        System.out.println("Enter " + N + " numbers:");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        // รับค่าตัวเลขที่ผู้ใช้สนใจ
        System.out.print("Enter the number you want to find: ");
        int target = scanner.nextInt();

        // ค้นหาตำแหน่งของตัวเลขที่สนใจ
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (numbers[i] == target) {
                positions.add(i + 1); // เพิ่มตำแหน่ง (เริ่มที่ 1)
            }
        }

        // แสดงผลลัพธ์
        if (positions.isEmpty()) {
            System.out.println("0"); // ถ้าไม่พบตัวเลขที่สนใจ
        } else {
            for (int pos : positions) {
                System.out.print(pos + " ");
            }
            System.out.println(); // ขึ้นบรรทัดใหม่
        }

        scanner.close(); // ปิด Scanner
    }
}

