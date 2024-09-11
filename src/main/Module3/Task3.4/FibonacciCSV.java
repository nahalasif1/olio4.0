import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FibonacciCSV {
    public static void main(String[] args) {
        int n = 100;
        long[] fibonacciSequence = generateFibonacciSequence(n);

        String csvFileName = "fibonacci_sequence.csv";
        writeFibonacciToCSV(fibonacciSequence, csvFileName);

        System.out.println("Fibonacci sequence has been written to " + csvFileName);
    }

    private static long[] generateFibonacciSequence(int n) {
        long[] fibonacciSequence = new long[n];
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }

        return fibonacciSequence;
    }

    private static void writeFibonacciToCSV(long[] fibonacciSequence, String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            for (long number : fibonacciSequence) {
                writer.write(Long.toString(number));
                writer.write(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
