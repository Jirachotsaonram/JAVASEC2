package Lab3;

public class Lab3_5 {
    // main method begins execution of Java application
    public static void main(String args[]) {
        final double PI = 3.1416;
        double width = 22.0, height = 12.0, radius = 16.0, result;
        char type;
        String message;

        type = '1';
        result = (type == '1') ? (width * height) : (PI * radius * radius);

        message = (type == '1') ? "Rectangle" : "Circle";

        System.out.println("Calculate Area " + message + " = " + result);
    } // end method main
} // end class