package uncommontrap;

/**
 * Do you like inheritance, right? After that example you will not.
 *
 * @author Dominik_Janiga
 * @version 0.1
 *
 */
public class UncommonTrap {

    private static Object uncommonTrap(Object trap){
        if (trap != null) {
            System.out.println("I am being trapped!");
        }
        return null;
    }

    public static void main(String[] argv) {
        Object trap = null;
        for (int i = 0; i < 250; ++i) {
            for (int j = 0; j < 10_000; ++j) {
                trap = uncommonTrap(trap);
            }
            if (i == 200) {
                trap = new Object();
            }
        }
    }
}
