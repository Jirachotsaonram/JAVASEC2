package Lab;

import java.util.Scanner;

public class survival_bag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่าจำนวนชุดของ x, y, z
        System.out.print("Enter x, y, z: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        // คำนวณจำนวนถุงยังชีพที่สามารถจัดได้
        int water = x / 3;
        int bread = y / 4;
        int eggs = z / 2;

        // จำนวนถุงที่สามารถจัดได้ คือค่าต่ำสุดของ water, bread, eggs
        int maxBags = Math.min(water, Math.min(bread, eggs));

        // คำนวณสิ่งของที่เหลือ
        int leftoverWater = x - (maxBags * 3);
        int leftoverBread = y - (maxBags * 4);
        int leftoverEggs = z - (maxBags * 2);

        // แสดงผลลัพธ์
        System.out.println(maxBags + " " + leftoverWater + " " + leftoverBread + " " + leftoverEggs);
    }
}

