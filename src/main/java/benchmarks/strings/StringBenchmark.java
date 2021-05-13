package benchmarks.strings;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 20, timeUnit = TimeUnit.MILLISECONDS,  time = 10)
@Warmup(iterations = 10, timeUnit = TimeUnit.MILLISECONDS, time = 10)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringBenchmark {


    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }



    @Benchmark
    public void concatenation(BenchmarkInput input) {
        String result = null;
        for (String string : input.strings) {
            result += string;
        }
    }


    @Benchmark
    public void withStringBuilder(BenchmarkInput input) {
        StringBuilder builder = new StringBuilder();
        for (String string : input.strings) {
            builder.append(string);
        }
    }

    @Benchmark
    public void withStringBuffer(BenchmarkInput input) {
        StringBuffer buffer = new StringBuffer();
        for (String string : input.strings) {
            buffer.append(string);
        }
    }

    @State(Scope.Benchmark)
    public static class BenchmarkInput {
        final String[] strings = Stream.iterate(1, i -> i + 1)
                                    .limit(1000).map(i -> "string" + i)
                                    .toArray(String[]::new);
    }
}
