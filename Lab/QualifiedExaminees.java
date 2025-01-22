package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Examinee {
    String id; // รหัสผู้เข้าสอบ
    int score; // คะแนนสอบ

    // Constructor สำหรับสร้างข้อมูลผู้เข้าสอบ
    public Examinee(String id, int score) {
        this.id = id;
        this.score = score;
    }
}

public class QualifiedExaminees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับจำนวนผู้เข้าสอบ
        System.out.println("Enter the number of examinees (N):");
        int N = scanner.nextInt();
        scanner.nextLine(); // รับบรรทัดใหม่เพื่อเตรียมรับข้อมูลถัดไป

        // สร้างรายการสำหรับเก็บข้อมูลผู้เข้าสอบ
        List<Examinee> examinees = new ArrayList<>();

        // รับข้อมูลผู้เข้าสอบ
        System.out.println("Enter the examinees' data (ID and score):");
        int totalScore = 0;
        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            String id = input[0]; // รหัสประจำตัว
            int score = Integer.parseInt(input[1]); // คะแนน
            examinees.add(new Examinee(id, score)); // เพิ่มข้อมูลผู้เข้าสอบในรายการ
            totalScore += score; // รวมคะแนน
        }

        // คำนวณค่าเฉลี่ย
        double average = (double) totalScore / N;

        // ตรวจสอบผู้ที่สอบผ่าน
        List<Examinee> qualifiedExaminees = new ArrayList<>();
        for (Examinee examinee : examinees) {
            if (examinee.score >= average) {
                qualifiedExaminees.add(examinee); // เพิ่มผู้สอบผ่านในรายการ
            }
        }

        // พิมพ์ผลลัพธ์
        System.out.println(qualifiedExaminees.size()); // จำนวนผู้สอบผ่าน
        for (Examinee examinee : qualifiedExaminees) {
            System.out.println(examinee.id); // รหัสผู้สอบผ่าน
        }

        scanner.close();
    }
}

