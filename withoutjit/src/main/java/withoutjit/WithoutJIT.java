package withoutjit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Dominik Janiga
 * @version 0.1
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 20, timeUnit = TimeUnit.NANOSECONDS,  time = 10)
@Warmup(iterations = 10, timeUnit = TimeUnit.NANOSECONDS, time = 10)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class WithoutJIT {

    public static void main(String[] args) throws RunnerException, IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void fibonacci(BenchmarkInput input) {
        int a = 0;
        int b = 1;
        for (int i = 2; i < input.input; i++) {
            int prev = b;
            b = a + b;
            a = prev;
        }
    }

    @State(Scope.Benchmark)
    public static class BenchmarkInput {
        final int input = 1000;
    }
}
