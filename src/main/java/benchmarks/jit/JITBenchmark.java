package benchmarks.jit;

public class JITBenchmark {
    private static final int BATCH_SIZE = 15000;

    public static double sum(double[] array) {

        double total = 0.0d;

        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    }

    private static void benchmarkSum(double[] array) {
        long start = System.nanoTime();
        for (int j = 0; j < BATCH_SIZE; j++) {
            sum(array);
        }
        long stop = System.nanoTime();
        System.out.printf("Computation finished in %d ns.%n",
                ((stop - start) / BATCH_SIZE));
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