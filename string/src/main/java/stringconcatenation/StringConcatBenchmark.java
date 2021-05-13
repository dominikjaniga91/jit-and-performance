package stringconcatenation;

import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 20, timeUnit = TimeUnit.NANOSECONDS,  time = 10)
@Warmup(iterations = 10, timeUnit = TimeUnit.NANOSECONDS, time = 10)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class StringConcatBenchmark {

    public static void main(String[] args) throws RunnerException, IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Param({"1"})
    private int nStrings;

    private String[] strings;
    private String prefix;

    @Setup
    public void setup() {
        strings = new String[nStrings];
	for (int i = 0; i < nStrings; i++) {
	    strings[i] = RandomStringUtils.randomAscii(24);
	}
	prefix = RandomStringUtils.randomAscii(24);
    }

    @Benchmark
    public void testJDK11StyleDouble(Blackhole bh) {
        String s = "";
	double d = 1.0;
	for (int i = 0; i < nStrings; i++) {
	    s = s + strings[i] + d;
	}
	bh.consume(s);
    }

    @Benchmark
    public void testJDK8StyleDouble(Blackhole bh) {
        String s = "";
	double d = 1.0;
	for (int i = 0; i < nStrings; i++) {
	    s = new StringBuilder()
                .append(s)
                .append(strings[i])
                .append(d)
                .toString();
	}
	bh.consume(s);
    }

    @Benchmark
    public void testJDK11Style(Blackhole bh) {
        String s = "";
	for (int i = 0; i < nStrings; i++) {
	    s = s + strings[i];
	}
	bh.consume(s);
    }

    @Benchmark
    public void testJDK8Style(Blackhole bh) {
        String s = "";
	for (int i = 0; i < nStrings; i++) {
	    s = new StringBuilder().append(s).append(strings[i]).toString();
	}
	bh.consume(s);
    }

    @Benchmark
    public void testStringBuilder(Blackhole bh) {
        StringBuilder sb = new StringBuilder();
	for (int i = 0; i < nStrings; i++) {
	    sb.append(strings[i]);
	}
	bh.consume(sb.toString());
    }

    @Benchmark
    public void testSingleStringBuilder(Blackhole bh) {
        String s = new StringBuilder(prefix).append(strings[0]).toString();
	bh.consume(s);
    }

    @Benchmark
    public void testSingleJDK11Style(Blackhole bh) {
	String s = prefix + strings[0];
	bh.consume(s);
    }

    @Benchmark
    public void testSingleJDK8Style(Blackhole bh) {
	String s = new StringBuilder().append(prefix).append(strings[0]).toString();
	bh.consume(s);
    }
}