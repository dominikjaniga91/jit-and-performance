package arraycopy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.RunnerException;

/**
 * Is there a way to improve the performance of theArrayList method?
 * Write at least two solutions and measure the performance with JMH.
 *
 * @author Dominik_Janiga
 */
@BenchmarkMode(Mode.Throughput)
@Measurement(iterations = 20, timeUnit = TimeUnit.MILLISECONDS,  time = 20)
@Warmup(iterations = 10, timeUnit = TimeUnit.MILLISECONDS, time = 20)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ArrayCopyBenchmark {

    public static void main(String[] args) throws RunnerException, IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public int[] arrayCopy(BenchmarkInput input) {
        int[] newArray = new int[input.input.length];
        System.arraycopy(input.input, 0, newArray, 0, input.input.length);
        return newArray;
    }

    @Benchmark
    public int[] systemCopy(BenchmarkInput input) {
        return Arrays.copyOf(input.input, input.input.length);
    }

    @State(Scope.Benchmark)
    public static class BenchmarkInput {

        final int[] input = IntStream.range(0, 1_000_000).toArray();
    }

}
