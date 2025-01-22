package Lab;

import java.util.Scanner;

public class WaypointOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // แจ้งให้ผู้ใช้ป้อนค่า R และ C
        System.out.print("Enter the number of rows (R): ");
        int R = sc.nextInt();
        System.out.print("Enter the number of columns (C): ");
        int C = sc.nextInt();

        // แจ้งให้ผู้ใช้ป้อนค่า K
        System.out.print("Enter the number of waypoints (K): ");
        int K = sc.nextInt();

        // สร้างแผนที่
        int[][] mapGrid = new int[R][C];

        // กำหนดค่าเริ่มต้นเป็น 0 สำหรับแผนที่ทั้งหมด
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                mapGrid[i][j] = 0;
            }
        }

        // แจ้งให้ผู้ใช้ป้อนตำแหน่งของจุดที่ต้องเดินทาง
        System.out.println("Enter the positions of the waypoints (row and column):");
        for (int i = 1; i <= K; i++) {
            System.out.print("Waypoint " + i + " - Row: ");
            int A = sc.nextInt();  // แถว
            System.out.print("Waypoint " + i + " - Column: ");
            int B = sc.nextInt();  // คอลัมน์
            mapGrid[A - 1][B - 1] = i;  // ลดค่า A และ B ลง 1 เพื่อใช้กับดัชนีที่เริ่มจาก 0
        }

        // พิมพ์แผนที่
        System.out.println("Map grid:");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(mapGrid[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
