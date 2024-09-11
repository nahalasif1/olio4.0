import java.util.ArrayList;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(20);
        numbers.add(3);
        numbers.add(9);
        numbers.add(10);
        numbers.add(45);
        numbers.add(7);
        numbers.add(12);

        numbers.removeIf(n -> n % 2 == 0);

        numbers.replaceAll(n -> n % 2 != 0 ? n * 2 : n);

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        System.out.println("List after filtering even numbers and doubling odd numbers:");
        System.out.println(numbers);

        System.out.println("\nSum of all numbers in the list: " + sum);
    }
}