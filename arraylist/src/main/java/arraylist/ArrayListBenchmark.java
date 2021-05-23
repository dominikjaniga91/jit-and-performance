package arraylist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.runner.RunnerException;

/**
 * Is there a way to improve the performance of theArrayList method?
 * Write at least two solutions and measure the performance with JMH.
 *
 * Requirements:
 *  - benchmarks should measure Throughput of execution
 *  - at least 10 warmup iterations and 100 measurement iterations
 *  - one thread and one fork is enough
 *
 * @author Dominik_Janiga
 */
public class ArrayListBenchmark {

    public static void main(String[] args) throws RunnerException, IOException {
        org.openjdk.jmh.Main.main(args);
    }

    public List<String> theArrayList(BenchmarkInput input) {
        List<String> list = new ArrayList<>();
        for(int i=0; i < input.input; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    public class BenchmarkInput {

        final int input = 1_000_000;
    }

}
