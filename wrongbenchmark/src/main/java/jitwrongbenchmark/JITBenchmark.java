package jitwrongbenchmark;

import java.util.Arrays;

public class JITBenchmark {
    private static final int BATCH_SIZE = 15000;

    public static double sum(double[] array) {

        double total = 0.0d;

        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    }

    private static long benchmarkSum(double[] array) {
        long sum = 0;
        long start = System.nanoTime();
        for (int j = 0; j < BATCH_SIZE; j++) {
            sum += sum(array);
        }
        long stop = System.nanoTime();
        System.out.printf("Computation finished in %d ns.%n",
                ((stop - start) / BATCH_SIZE));
        return sum;
    }

    public static void main(String[] args) {
        double[] array = new double[10000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        for (int iteration = 0; iteration < 100; iteration++) {
            benchmarkSum(array);
        }
    }
}