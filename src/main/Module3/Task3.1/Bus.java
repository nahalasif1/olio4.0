// TASK 2
public class Bus extends Car {
    private int numberOfPassengers;

    public Bus(String logo, String model, int year, double gasolineTankCapacity, int topSpeed) {
        super(logo, model, year, gasolineTankCapacity, topSpeed);
        this.numberOfPassengers = 0;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void passengerEnter(int passengers) {
        if (passengers > 0) {
            numberOfPassengers += passengers;
            System.out.println(passengers + " passengers entered the bus.");
        }
    }

    public void passengerExit(int passengers) {
        if (passengers > 0 && passengers <= numberOfPassengers) {
            numberOfPassengers -= passengers;
            System.out.println(passengers + " passengers exited the bus.");
        } else {
            System.out.println("There is no passengers for them to exit.");
        }
    }

    public static void main(String[] args) {
        Bus myBus = new Bus("Volvo", "School Bus", 2020, 50.0, 60);

        System.out.println("Bus Logo: " + myBus.getLogo());
        System.out.println("Bus Model: " + myBus.getModel());
        System.out.println("Bus Year: " + myBus.getYear());
        System.out.println("Gasoline Tank Capacity: " + myBus.getGasolineTankCapacity() + " gallons");
        System.out.println("Top Speed: " + myBus.getTopSpeed() + " mph");

        System.out.println("Number of Passengers on the Bus: " + myBus.getNumberOfPassengers());

        myBus.passengerEnter(10);
        System.out.println("Number of Passengers on the Bus: " + myBus.getNumberOfPassengers());

        myBus.passengerExit(5);
        System.out.println("Number of Passengers on the Bus: " + myBus.getNumberOfPassengers());
    }
}