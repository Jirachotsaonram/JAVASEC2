package Final;

import java.util.Scanner;
public class converTemperature {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the temperature in Celsius: ");
        float temp = scan.nextInt();

        System.out.println("The temperature in Fahrenheit is: " + convertTemperature(temp));
    }

    public static float convertTemperature(float temp){
        return (temp * 9/5) + 32;
    }
}
