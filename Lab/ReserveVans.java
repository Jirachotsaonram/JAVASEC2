package Lab;
import java.util.Scanner;

public class ReserveVans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่าจำนวนคำสั่งทั้งหมด
        int N = scanner.nextInt();
        int[] days = new int[N];
        int[] vans = {0, 0, 0}; // ตัวแทนรถ A, B, C

        // รับข้อมูลวัน
        for (int i = 0; i < N; i++) {
            days[i] = scanner.nextInt();
        }

        // กระบวนการจัดการคำสั่งจอง
        for (int i = 0; i < N; i++) {
            int earliestVan = getEarliestVan(vans);
            vans[earliestVan] += days[i];
            System.out.println("Command " + (i + 1) + " -> Van " + (char) ('A' + earliestVan));
        }

        scanner.close();
    }

    // ฟังก์ชันหา Van ที่ว่างเร็วที่สุด
    private static int getEarliestVan(int[] vans) {
        int minIndex = 0;
        for (int i = 1; i < vans.length; i++) {
            if (vans[i] < vans[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
