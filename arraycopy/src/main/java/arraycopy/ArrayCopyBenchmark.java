package arraycopy;

import java.util.stream.IntStream;

/**
 * Is there a better way to copy one array onto new one?
 * Write at least two solutions and measure the performance with JMH.
 *
 *  Requirements:
 *  - benchmarks should measure average time of execution in milliseconds
 *  - at least 10 warmup iterations and 100 measurement iterations
 *  - one thread and one fork is enough
 *
 * @author Dominik_Janiga
 */
public class ArrayCopyBenchmark {

    public static void main(String[] args) {

    }

    public int[] copyWithForLoop(BenchmarkInput input) {
        int[] newArray = new int[input.input.length];
        for (int i = 0; i < input.input.length; i++) {
            newArray[i] = input.input[i];
        }
        return newArray;
    }

    public static class BenchmarkInput {

        final int[] input = IntStream.range(0, 1_000_000).toArray();
    }

}
