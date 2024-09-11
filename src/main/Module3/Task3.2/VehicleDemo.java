// TASK 1-4 Done
interface Vehicle {
    void start();
    void stop();
    String getInfo();
    double calculateFuelEfficiency();
}

interface ElectricVehicle {
    void charge();
}

abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String fuel;
    protected double fuelEfficiency;

    public AbstractVehicle(String type, String fuel, double fuelEfficiency) {
        this.type = type;
        this.fuel = fuel;
        this.fuelEfficiency = fuelEfficiency;
    }

    public abstract String getAdditionalInfo();

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public String getInfo() {
        return String.format("Type: %s\nFuel: %s\n%s\nFuel Efficiency: %.2f", type, fuel, getAdditionalInfo(), calculateFuelEfficiency());
    }

    @Override
    public void charge() {
        System.out.println(type + " is charging...");
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }
}

class Cars extends AbstractVehicle {
    private String color;

    public Cars(String color, double fuelEfficiency) {
        super("Car", "Petrol", fuelEfficiency);
        this.color = color;
    }

    @Override
    public String getAdditionalInfo() {
        return String.format("Color: %s", color);
    }
}

class Motorcycle extends AbstractVehicle {
    private String color;

    public Motorcycle(String color, double fuelEfficiency) {
        super("Motorcycle", "Gasoline", fuelEfficiency);
        this.color = color;
    }

    @Override
    public String getAdditionalInfo() {
        return String.format("Color: %s", color);
    }
}

class Buses extends AbstractVehicle {
    private int capacity;

    public Buses(int capacity, double fuelEfficiency) {
        super("Bus", "Diesel", fuelEfficiency);
        this.capacity = capacity;
    }

    @Override
    public String getAdditionalInfo() {
        return String.format("Capacity: %d passengers", capacity);
    }
}

class ElectricCar extends AbstractVehicle {
    private String color;

    public ElectricCar(String color) {
        super("Electric Car", "Electricity", 0);
        this.color = color;
    }

    @Override
    public String getAdditionalInfo() {
        return String.format("Color: %s", color);
    }
}

class ElectricMotorcycle extends AbstractVehicle {
    private String color;

    public ElectricMotorcycle(String color) {
        super("Electric Motorcycle", "Electricity", 0);
        this.color = color;
    }

    @Override
    public String getAdditionalInfo() {
        return String.format("Color: %s", color);
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Cars("Red", 30.5);
        Vehicle motorcycle = new Motorcycle("Black", 40.2);
        Vehicle bus = new Buses(40, 8.5);

        ElectricVehicle electricCar = new ElectricCar("Blue");
        ElectricVehicle electricMotorcycle = new ElectricMotorcycle("White");

        car.start();
        car.stop();
        System.out.println("Car Information:\n" + car.getInfo() + "\n");

        motorcycle.start();
        motorcycle.stop();
        System.out.println("Motorcycle Information:\n" + motorcycle.getInfo() + "\n");

        bus.start();
        bus.stop();
        System.out.println("Bus Information:\n" + bus.getInfo() + "\n");

        electricCar.charge();
        electricMotorcycle.charge();
    }
}