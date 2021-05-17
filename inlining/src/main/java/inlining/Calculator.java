package inlining;

public class Calculator {

    public static void main(String[] args) {

        int result = new Calculator().add(1, 2);
        System.out.println(result);
    }

    private int add(int x, int y) {
        return x + y;
    }
}
