package benchmark;

import java.util.stream.IntStream;

/**
 * Write a benchmark for the following methods.
 *
 * Requirements:
 * - benchmarks should measure average time of execution in milliseconds
 * - at least 10 warmup iterations and 100 measurement iterations
 * - one thread and one fork is enough
 *
 * @author Dominik_Janiga
 * @version 0.1
 */
public class SumBenchmark {

    public static void main(String[] args) {

    }

    public int calculateSumWithFor(BenchmarkInput input) {

        int sum = 0;
        for (int i = 0; i < input.n; i++) {
            sum += i;
        }
        return sum;
    }


    public int calculateSumWithStream(BenchmarkInput input) {

        return IntStream.range(0, input.n).sum();
    }

    public static class BenchmarkInput {

        int n = 1_000_000;
    }
}
