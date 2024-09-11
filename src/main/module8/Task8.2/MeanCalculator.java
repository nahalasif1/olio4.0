import java.util.Arrays;

public class MeanCalculator {
    public static void main(String[] args) {
        double[] numbers = {5.0, 10.0, 15.0, 20.0, 25.0};

        double mean = Arrays.stream(numbers)
                .average()
                .orElse(Double.NaN);

        System.out.println("Mean: " + mean);
    }
}
