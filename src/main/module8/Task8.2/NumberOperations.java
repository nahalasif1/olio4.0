import java.util.Arrays;

public class NumberOperations {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] oddNumbers = Arrays.stream(numbers)
                .filter(n -> n % 2 != 0)
                .toArray();

        int[] doubledNumbers = Arrays.stream(oddNumbers)
                .map(n -> n * 2)
                .toArray();

        int sum = Arrays.stream(doubledNumbers)
                .sum();

        System.out.println("Original List: " + Arrays.toString(numbers));
        System.out.println("Filtered (odd) Numbers: " + Arrays.toString(oddNumbers));
        System.out.println("Doubled Numbers: " + Arrays.toString(doubledNumbers));
        System.out.println("Sum of Doubled Numbers: " + sum);
    }
}