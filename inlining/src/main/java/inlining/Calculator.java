package inlining;

/**
 *
 *
 * @author Dominik_Janiga
 * @version 0.1
 */
public class Calculator {

    public static void main(String[] args) {

        int result = 0;
        for (int i = 0; i < 1_000_000; i++) {
            result = new Calculator().add(1, 1);
        }
        System.out.println(result);
    }

    private int add(int x, int y) {
        return x + y;
    }
}
