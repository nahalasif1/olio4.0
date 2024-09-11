import java.util.ArrayList;
import java.util.List;

class ThreadSafeArrayListManager<T> {
    private final List<T> arrayList = new ArrayList<>();
    private final Object lock = new Object();

    public void addElement(T element) {
        synchronized (lock) {
            arrayList.add(element);
        }
    }

    public int getSize() {
        synchronized (lock) {
            return arrayList.size();
        }
    }

    public void removeElement(T element) {
        synchronized (lock) {
            arrayList.remove(element);
        }
    }
}

class TestThreadSafeArrayList {
    public static void main(String[] args) {
        ThreadSafeArrayListManager<String> manager = new ThreadSafeArrayListManager<>();

        Thread addThread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                manager.addElement("Element-" + i);
                System.out.println("Added Element-" + i);
            }
        });

        Thread addThread2 = new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                manager.addElement("Element-" + i);
                System.out.println("Added Element-" + i);
            }
        });

        Thread removeThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                manager.removeElement("Element-" + i);
                System.out.println("Removed Element-" + i);
            }
        });

        Thread sizeThread = new Thread(() -> {
            int size;
            do {
                size = manager.getSize();
                System.out.println("Current size: " + size);
            } while (size > 0);
        });

        addThread1.start();
        addThread2.start();
        removeThread.start();
        sizeThread.start();

        try {
            addThread1.join();
            addThread2.join();
            removeThread.join();
            sizeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
