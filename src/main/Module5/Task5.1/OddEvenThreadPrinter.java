class NumberPrinter {
    private int start;
    private int end;

    public NumberPrinter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public synchronized void printOdd() {
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.println("Odd Thread: " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void printEven() {
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.println("Even Thread: " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class OddEvenThreadPrinter {
    public static void main(String[] args) {
        int start = 2;
        int end = 20;

        NumberPrinter numberPrinter = new NumberPrinter(start, end);

        System.out.println("Odd Thread: 1");
        Thread evenThread = new Thread(() -> numberPrinter.printEven());
        Thread oddThread = new Thread(() -> numberPrinter.printOdd());

        evenThread.start();
        oddThread.start();


        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Printing complete.");
    }
}