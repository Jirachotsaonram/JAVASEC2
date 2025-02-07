package Lab8;

public class NumberNew {
    private double number;

    public NumberNew() {
        setValue((int) (Math.random() * 100));
    }

    public NumberNew(double n) {
        setValue(n);
    }

    public void setValue(double n) {
        number = n;
    }

    public double getValue() {
        return number;
    }

    public String toString() {
        return Double.toString(getValue());
    }

    public void add(double n) {
        number += n;
    }

    public void subtract(double n) {
        number -= n;
    }

    public void multiply(double n) {
        number *= n;
    }

    public void divide(double n) {
        if (n != 0) {
            number /= n;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }
}