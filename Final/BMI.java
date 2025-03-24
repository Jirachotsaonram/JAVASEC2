package Final;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Your Weight in Kilograms: ");
        double weight = scan.nextDouble();
        System.out.print("Enter Your Height in Meters: ");
        double height = scan.nextDouble();

        System.out.println("Your BMI is: " + calculateBMI(weight, height));

        if(calculateBMI(weight, height) < 18.5){
            System.out.println("You are underweight");
        } else if(calculateBMI(weight, height) >= 18.5 && calculateBMI(weight, height) < 25){
            System.out.println("You are normal weight");
        } else if(calculateBMI(weight, height) >= 25 && calculateBMI(weight, height) < 30){
            System.out.println("You are overweight");
        } else {
            System.out.println("You are obese");
        }
    }

    public static double calculateBMI(double weight, double height){
        return weight / (height * height);
    }
}
