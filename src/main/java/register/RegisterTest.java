package register;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Dominik Janiga
 * @version 0.1
 */

@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 20, timeUnit = TimeUnit.MILLISECONDS,  time = 10)
@Warmup(iterations = 10, timeUnit = TimeUnit.MILLISECONDS, time = 10)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class RegisterTest {

    public static void main(String[] args) throws RunnerException, IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void calculateSum(RegisterBenchmark input) {
        for (int i = 0; i < input.n; i++) {
            input.sum += i;
        }
    }

    @State(Scope.Benchmark)
    public static class RegisterBenchmark {
        volatile int sum;
        int n = 1_000_000;
    }
}
