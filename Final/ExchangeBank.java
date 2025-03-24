package Final;

import java.util.Scanner;
public class ExchangeBank {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the amount in Thai Baht: ");
        int money = scan.nextInt();

        if (money >= 1000){
            System.out.println("1000 bant " + (money / 1000));
            money = money % 1000;  
        }if(money >= 500){
            System.out.println("500 bant " + (money / 500));
            money = money % 500;
        }if(money >= 100){
            System.out.println("100 bant " + (money / 100));
            money = money % 100;
        }if(money >= 50){
            System.out.println("50 bant " + (money / 50));
            money = money % 50;
        }if(money >= 20){
            System.out.println("20 bant " + (money / 20));
            money = money % 20;
        }if(money >= 10){
            System.out.println("10 bant " + (money / 10));
            money = money % 10;
        }if(money >= 5){
            System.out.println("5 bant " + (money / 5));
            money = money % 5;
        }if(money >= 2){
            System.out.println("2 bant " + (money / 2));
            money = money % 2;
        }if(money >= 1){
            System.out.println("1 bant " + (money / 1));
            money = money % 1;
        }
        
    }
}
