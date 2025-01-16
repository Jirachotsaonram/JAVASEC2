package Lab6;

import javax.swing.*;

public class Lab6_2 {
    public static void main(String[] args) {
        int score[] = {85, 78, 92, 69, 74, 88, 91, 67, 80, 76};
        String output = "";
        // สร้างข้อความเพื่อแสดงคะแนนทั้งหมดในอาร์เรย์
        for (int n = 0; n < score.length; n++)
            output += "Score " + (n + 1) + " :  " + score[n] + "\n";
        // เพิ่มค่าต่ำสุดในข้อความ
        output += "Minimum value is " + getMin(score) + "\n";
        // เพิ่มค่าสูงสุดในข้อความ
        output += "Maximum value is " + getMax(score) + "\n";
        // เพิ่มค่าเฉลี่ยในข้อความ
        output += "Average value is " + getAverage(score) + "\n";
        // แสดงข้อความในกล่องข้อความ
        JOptionPane.showMessageDialog(null, output,
                "Display Score in Array", JOptionPane.INFORMATION_MESSAGE);
    }

    // เมธอดเพื่อหาค่าต่ำสุดในอาร์เรย์
    public static int getMin(int data[]) {
        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    // เมธอดเพื่อหาค่าสูงสุดในอาร์เรย์
    public static int getMax(int data[]) {
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    // เมธอดเพื่อคำนวณค่าเฉลี่ยของอาร์เรย์
    public static double getAverage(int data[]) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return (double) sum / data.length;
    }

    // เมธอดเพื่อสุ่มค่าระหว่าง st และ ed
    public static int rnd(int st, int ed) {
        int offset = ed - st + 1;
        return st + (int)(Math.random() * offset);
    }
}