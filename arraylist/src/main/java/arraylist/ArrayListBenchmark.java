package arraylist;

import java.io.IOException;
import java.util.ArrayList;
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
@Fork(value = 2)
@Warmup(iterations = 10, timeUnit = TimeUnit.MILLISECONDS, time = 20)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ArrayListBenchmark {

    public static void main(String[] args) throws RunnerException, IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public List<String> theArrayList(BenchmarkInput input) {
        List<String> list = new ArrayList<>();
        for(int i=0; i < input.input; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    @State(Scope.Benchmark)
    public class BenchmarkInput {

        final int input = 1_000_000;
    }

}
