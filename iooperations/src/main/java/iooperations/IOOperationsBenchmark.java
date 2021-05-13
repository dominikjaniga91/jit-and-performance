package iooperations;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Dominik Janiga
 * @version 0.1
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 20, timeUnit = TimeUnit.MILLISECONDS,  time = 10)
@Warmup(iterations = 10, timeUnit = TimeUnit.MILLISECONDS, time = 10)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class IOOperationsBenchmark {

    public static void main(String[] args) throws RunnerException, IOException {
        org.openjdk.jmh.Main.main(args);
    }

    private File file = new File("/home/epam/IdeaProjects/jit-and-performance/iooperations/src/main/resources/test.txt");

    @Benchmark
    public void readWithFileInputStream() throws IOException {

        try (var fis = new FileInputStream(file)) {
            int i;
            while ((i = fis.read()) != -1) {
//                System.out.print((char) i);
            }
        }
    }


    @Benchmark
    public void readWithBufferedReader() throws IOException {

        try (var bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
//                System.out.print((char) i);
            }
        }
    }
}
