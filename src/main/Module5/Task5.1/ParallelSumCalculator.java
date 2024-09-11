import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelSumCalculator {
    private static final int NUM_THREADS = 4;
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arrayLength = numbers.length;

        int[] partialSums = new int[NUM_THREADS];

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        int chunkSize = arrayLength / NUM_THREADS;

        for (int i = 0; i < NUM_THREADS; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == NUM_THREADS - 1) ? arrayLength : startIndex + chunkSize;
            executorService.submit(new PartialSumTask(numbers, startIndex, endIndex, partialSums, i));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = 0;
        for (int partialSum : partialSums) {
            totalSum += partialSum;
        }

        System.out.println("The sum of the numbers is: " + totalSum);
    }
}

class PartialSumTask implements Runnable {
    private final int[] numbers;
    private final int startIndex;
    private final int endIndex;
    private final int[] partialSums;
    private final int threadIndex;

    public PartialSumTask(int[] numbers, int startIndex, int endIndex, int[] partialSums, int threadIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.partialSums = partialSums;
        this.threadIndex = threadIndex;
    }

    @Override
    public void run() {
        int partialSum = 0;

        for (int i = startIndex; i < endIndex; i++) {
            partialSum += numbers[i];
        }
        partialSums[threadIndex] = partialSum;
    }
}