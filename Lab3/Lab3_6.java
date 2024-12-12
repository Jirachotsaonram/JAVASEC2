package Lab3;

public class Lab3_6 {
    final double PI = 3.1416;
    String message;
    double area;

    public Lab3_6(double radius) {
        message = "Circle";
        area = PI * radius * radius;
    }

    public Lab3_6(double width, double height) {
        message = "Rectangle";
        area = width * height;
    }

    public static void main(String[] args) {

        // create instance variable
        Lab3_6 circle = new Lab3_6(10.0);
        System.out.print("Calculate Area " + circle.message);
        System.out.println(" = " + circle.area);
        // create instance variable
        Lab3_6 rectangle = new Lab3_6(12.0, 20.0);
        System.out.print("Calculate Area " + rectangle.message);
        System.out.println(" = " + rectangle.area);
    }
}