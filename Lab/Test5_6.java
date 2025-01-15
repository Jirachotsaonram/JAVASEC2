package Lab;

import javax.swing.*;

public class Test5_6 {
    public static void main(String[] args) {
        int number[][] = new int[10][];
        int count = 1;
        int num = 1;
        for (int i = 0; i < number.length; i++) {
            number[i] = new int[count++];
            for (int j = 0; j < number[i].length; j++) {
                number[i][j] = num++;
                System.out.print(number[i][j] + "\t");
            }
            System.out.println();
        }
    }
}