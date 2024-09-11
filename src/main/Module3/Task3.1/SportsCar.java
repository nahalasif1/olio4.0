// TASK 1
public class SportsCar extends Car {
    private double acceleration;
    private double deceleration;
    private double gasolineConsumption;

    public SportsCar(String logo, String model, int year, double gasolineTankCapacity, int topSpeed,
                     double acceleration, double deceleration, double gasolineConsumption) {
        super(logo, model, year, gasolineTankCapacity, topSpeed);
        this.acceleration = acceleration;
        this.deceleration = deceleration;
        this.gasolineConsumption = gasolineConsumption;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getDeceleration() {
        return deceleration;
    }

    public double getGasolineConsumption() {
        return gasolineConsumption;
    }

    public static void main(String[] args) {
        SportsCar mySportsCar = new SportsCar("Ferrari", "Spider", 2022, 100.0, 200, 50, 20, 50.0);

        System.out.println("Car Logo: " + mySportsCar.getLogo());
        System.out.println("Car Model: " + mySportsCar.getModel());
        System.out.println("Car Year: " + mySportsCar.getYear());
        System.out.println("Gasoline Tank Capacity: " + mySportsCar.getGasolineTankCapacity() + " gallons");
        System.out.println("Gasoline Consumption: " + mySportsCar.getGasolineConsumption() + " gallons");
        System.out.println("Top Speed: " + mySportsCar.getTopSpeed() + " mph");
        System.out.println("Acceleration: " + mySportsCar.getAcceleration() + " mph");
        System.out.println("Deceleration: " + mySportsCar.getDeceleration() + " mph");
    }
}