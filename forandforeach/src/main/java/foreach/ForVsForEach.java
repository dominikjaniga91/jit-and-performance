package foreach;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 20, timeUnit = TimeUnit.MILLISECONDS,  time = 10)
@Warmup(iterations = 10, timeUnit = TimeUnit.MILLISECONDS, time = 10)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Fork(value = 3, jvmArgs = {"-XX:ReservedCodeCacheSize=2m"})
public class ForVsForEach {

    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public int invokingMethodWithForEach(BenchmarkInput input) {
        int sum = 0;
        for (int i = 0; i < input.ints.length; i++) {
            sum += forEachMethod(input);
        }
        return sum;
    }

    int forEachMethod(BenchmarkInput input) {
        int sum = 0;
        for (int number : input.ints) {
            sum += number;
        }
        return sum;
    }

    @Benchmark
    public int invokingMethodWithForI(BenchmarkInput input) {
        int sum = 0;

        for (int i = 0; i < input.ints.length; i++) {
            sum += forIMethod(input);
        }
        return sum;
    }

    int forIMethod(BenchmarkInput input) {
        int sum = 0;
        for (int i = 0; i < input.ints.length; i++) {
            sum += input.ints[i];
        }
        return sum;
    }


    @State(Scope.Benchmark)
    public static class BenchmarkInput {
        final int[] ints  = IntStream.rangeClosed(1, 10_000).toArray();
    }

}
