package uncommontrap;

/**
 * Do you like inheritance, right? After that example you will not.
 *
 * @author Dominik_Janiga
 * @version 0.1
 */
public class UncommonTrapInheritance {

    public static void main(String[] args) {
        Calculator trap = new Subtract();
        int result = 0;

        for (int i = 0; i< 250; ++i) {
            for (int j = 0; j < 10_000; ++j) {
                result = trap.calculate(2, 2);
            }
            if (i == 200) {
                System.out.println("I am being trapped!");
                trap = new Sum();
            }
        }

        System.out.println(result);
    }
}


abstract class Calculator {

    abstract int calculate(int a, int b);

}

class Sum extends Calculator {

    @Override
    int calculate(int a, int b) {
        return a + b;
    }
}

class Subtract extends Calculator {

    @Override
    int calculate(int a, int b) {
        return a - b;
    }
}

