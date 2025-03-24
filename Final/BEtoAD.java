package Final;

import java.util.Scanner;
public class BEtoAD {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the year in Buddhist Era: ");
        int year = scan.nextInt();

        System.out.println("The year in Anno Domini is: " + convertBEtoAD(year));
    }

    public static int convertBEtoAD(int year){
        return year - 543;
    }
}
