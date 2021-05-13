//package benchmarks.foreach;
//
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.runner.RunnerException;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.IntStream;
//
//@BenchmarkMode(Mode.AverageTime)
//@Measurement(iterations = 20, timeUnit = TimeUnit.MILLISECONDS,  time = 10)
//@Warmup(iterations = 10, timeUnit = TimeUnit.MILLISECONDS, time = 10)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//public class ForVsForEach {
//
//    public static void main(String[] args) throws IOException, RunnerException {
//
//        org.openjdk.jmh.Main.main(args);
//    }
//
//    @Benchmark
//    public void iteratingWithForEach(BenchmarkInput input) {
//        int sum = 0;
//        for (int number : input.ints) {
//            sum += number;
//        }
//    }
//
//    @Benchmark
//    public void iteratingWithFor(BenchmarkInput input) {
//        int sum = 0;
//
//        for (int i = 0; i < input.ints.length; i++) {
//            sum += input.ints[i];
//        }
//    }
//
//
//    @State(Scope.Benchmark)
//    public static class BenchmarkInput {
//        final int[] ints  = IntStream.rangeClosed(1, 10_000_000).toArray();
//    }
//
//}
