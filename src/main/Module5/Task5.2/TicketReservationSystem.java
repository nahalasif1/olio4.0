import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Theater {
    private int availableSeats;
    private Lock lock = new ReentrantLock();

    public Theater(int totalSeats) {
        this.availableSeats = totalSeats;
    }

    public boolean reserveSeats(int numSeats) {
        lock.lock();
        try {
            if (numSeats <= availableSeats) {
                availableSeats -= numSeats;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
}

class Customers extends Thread {
    private int id;
    private int numSeats;
    private Theater theater;

    public Customers(int id, int numSeats, Theater theater) {
        this.id = id;
        this.numSeats = numSeats;
        this.theater = theater;
    }

    private void printReservationStatus(boolean success) {
        if (success) {
            System.out.println("Customer " + id + " reserved " + numSeats + " tickets.");
        } else {
            System.out.println("Customer " + id + " couldn't reserve " + numSeats + " tickets.");
        }
    }

    @Override
    public void run() {
        boolean success = theater.reserveSeats(numSeats);
        printReservationStatus(success);
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        int totalSeats = 10;
        Theater theater = new Theater(totalSeats);

        for (int i = 1; i <= 15; i++) {
            int numSeats = (int) (Math.random() * 5) + 1;
            Customers customer = new Customers(i, numSeats, theater);
            customer.start();
        }
    }
}