package inlining;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.RunnerException;

@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 20, timeUnit = TimeUnit.NANOSECONDS,  time = 10)
@Warmup(iterations = 10, timeUnit = TimeUnit.NANOSECONDS, time = 10)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 10, warmups = 10, jvmArgs = {"-XX:FreqInlineSize=2", "-XX:+"})
public class JitInlining {

    public static void main(String[] args) throws RunnerException, IOException {

        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void benchmark() {

        Position position = new Position(25);
        for (int i = 0; i < 1_000_000; ++i) {
            int x = position.getX();
            position.setX(x + 1);
        }
    }
}

class Position {
    private int x;

    public Position(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}