package iooperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openjdk.jmh.runner.RunnerException;

/**
 *
 * Write the benchmark to the method readWithFileInputStream().
 * What do you think about the performance of that method? Can you improve it?
 *
 * @author Dominik Janiga
 * @version 0.1
 */
public class IOOperationsBenchmark {

    public static void main(String[] args) throws RunnerException, IOException {
    }

    private File file = new File("iooperations\\src\\main\\resources\\test.txt");

    public void readWithFileInputStream() throws IOException {

        try (FileInputStream fis = new FileInputStream(file)) {
            int i;
            while ((i = fis.read()) != -1) {
//                System.out.print((char) i);
            }
        }
    }
}
