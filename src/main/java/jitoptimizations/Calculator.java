package jitoptimizations;

public class Calculator {

    public long multiply(long x, long y) {
        return x * y;
    }

    public void calculator() {
        long result = multiply(10, 20);
    }

    public static void main(String[] args) {
        
        new Calculator().calculator();
    }
}
