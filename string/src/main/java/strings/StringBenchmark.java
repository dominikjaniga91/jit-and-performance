package strings;

import java.io.IOException;
import java.util.stream.Stream;

import org.openjdk.jmh.runner.RunnerException;

/**
 * Compare performance of this methods using JMH
 *
 * @author Dominik_Janiga
 */
public class StringBenchmark {


    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }


    String concatenation(BenchmarkInput input) {
        String result = null;
        for (String string : input.strings) {
            result += string;
        }
        return result;
    }


    String withStringBuilder(BenchmarkInput input) {
        StringBuilder builder = new StringBuilder();
        for (String string : input.strings) {
            builder.append(string);
        }
        return builder.toString();
    }

    String withStringBuffer(BenchmarkInput input) {
        StringBuffer buffer = new StringBuffer();
        for (String string : input.strings) {
            buffer.append(string);
        }
        return buffer.toString();
    }

    public static class BenchmarkInput {
        final String[] strings = Stream.iterate(1, i -> i + 1)
                                    .limit(1000).map(i -> "string" + i)
                                    .toArray(String[]::new);
    }
}
