package onstackreplacement;

public class OnStackReplacement {

    public static void main(String[] arg) {

        long before = System.currentTimeMillis();
        int sum = 0;

        for (int index = 0; index < 10_000_000; index += 1) {
            sum += index;
        }
        long after = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (after - before) + " milliseconds");
    }
}