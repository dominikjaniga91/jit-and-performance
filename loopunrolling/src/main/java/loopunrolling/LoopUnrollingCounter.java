//package loopunrolling;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//import org.openjdk.jmh.annotations.Benchmark;
//import org.openjdk.jmh.annotations.BenchmarkMode;
//import org.openjdk.jmh.annotations.Measurement;
//import org.openjdk.jmh.annotations.Mode;
//import org.openjdk.jmh.annotations.OutputTimeUnit;
//import org.openjdk.jmh.annotations.Scope;
//import org.openjdk.jmh.annotations.Setup;
//import org.openjdk.jmh.annotations.State;
//import org.openjdk.jmh.annotations.Warmup;
//import org.openjdk.jmh.runner.RunnerException;
//
//@BenchmarkMode(Mode.Throughput)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@State(Scope.Benchmark)
//@Measurement(iterations = 20, timeUnit = TimeUnit.MILLISECONDS,  time = 10)
//@Warmup(iterations = 10, timeUnit = TimeUnit.MILLISECONDS, time = 10)
//public class LoopUnrollingCounter {
//
//    public static void main(String[] args) throws RunnerException, IOException {
//        org.openjdk.jmh.Main.main(args);
//    }
//
//    private static final int MAX = 1_000_000;
//    private long[] data = new long[MAX];
//
//    @Setup
//    public void createData() {
//
//        java.util.Random random = new java.util.Random();
//        for (int i = 0; i < MAX; i++) {
//            data[i] = random.nextLong();
//        }
//    }
//
//    @Benchmark
//    public long intStride1() {
//
//        long sum = 0;
//        for (int i = 0; i < MAX; i++) {
//            sum += data[i];
//        }
//        return sum;
//    }
//
//    @Benchmark
//    public long longStride1() {
//
//        long sum = 0;
//        for (long l = 0; l < MAX; l++) {
//            sum += data[(int) l];
//        }
//        return sum;
//    }
//}
