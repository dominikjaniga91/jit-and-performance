package loopunrolling;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.RunnerException;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 20, timeUnit = TimeUnit.MILLISECONDS, time = 20)
@Warmup(iterations = 10, timeUnit = TimeUnit.MILLISECONDS, time = 20)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Fork(value = 10, jvmArgs = {"-client"})
public class LoopUnrollingBenchmark {

    public static void main(String[] args) throws RunnerException, IOException {

        System.out.println(System.getProperty("java.vm.name"));
        System.out.println(System.getProperty("java.vm.version"));
        org.openjdk.jmh.Main.main(args);
    }


    @Benchmark
    public int iterationWithInt(BenchmarkInput input) {

        int sum = 0;
        for (int i = 0; i < input.INPUT; i++) {
            sum += i;
        }
        return sum;
    }


    @Benchmark
    public long iterationWithLong(BenchmarkInput input) {

        long sum = 0;
        for (long i = 0; i < input.INPUT; i++) {
            sum += i;
        }
        return sum;
    }

    @State(Scope.Benchmark)
    public static class BenchmarkInput {

        final int INPUT = 1_000_000;

    }
}
