package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.RunnerException;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Measurement(time = 10, timeUnit = TimeUnit.MILLISECONDS, iterations = 20)
@Warmup(time = 10, timeUnit = TimeUnit.MILLISECONDS, iterations = 20)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 10, jvmArgs = {"-Xmixed"})
public class Test {

	public static void main(String[] args) throws RunnerException, IOException {
		org.openjdk.jmh.Main.main(args);
	}


	@Benchmark
	public int[] method() {
		int[] arr = new int[1_000_000];
		for(int i = 0; i < arr.length; ++i) {
			arr[i] = i;
		}
		return arr;
	}
}
