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


@State(Scope.Benchmark)
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
    public List<String> properlySizedArrayList() {
        List<String> list = new ArrayList<>(1_000_000);
        for(int i=0; i < 1_000_000; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }
    @Benchmark
    public List<String> resizingArrayList() {
        List<String> list = new ArrayList<>();
        for(int i=0; i < 1_000_000; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }


    @Benchmark
    public List<String> stream() {
       return  IntStream.range(0, 1_000_000)
               .mapToObj(String::valueOf)
               .collect(Collectors.toList());
    }

}
