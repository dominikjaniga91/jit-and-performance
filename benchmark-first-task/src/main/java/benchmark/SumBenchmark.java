package benchmark;

import java.util.stream.IntStream;

public class SumBenchmark {

    public static void main(String[] args) {
    }

    public int calculateSumWithFor(BenchmarkInput input) {
        int sum = 0;
        for (int i = 0; i < input.n; i++) {
            sum += i;
        }
        return sum;
    }


    public int calculateSumWithStream(BenchmarkInput input) {
        return IntStream.range(0, input.n).sum();
    }

    public static class BenchmarkInput {
        int n = 1_000_000;
    }
}
