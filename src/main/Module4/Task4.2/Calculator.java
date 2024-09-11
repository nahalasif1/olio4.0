public class Calculator {
    private int currentValue;

    public void reset() {
        currentValue = 0;
    }

    public void add(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed");
        }
        currentValue += num;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            calculator.add(5);
            calculator.add(10);
            calculator.add(3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Current Value: " + calculator.getCurrentValue());

        calculator.reset();

        try {
            calculator.add(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Current Value after exception: " + calculator.getCurrentValue());
    }
}