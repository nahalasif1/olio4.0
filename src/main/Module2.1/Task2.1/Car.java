// Task 1-4
public class Car {
    private String logo;
    private String model;
    private int year;
    private double gasolineTankCapacity;
    private int topSpeed;

    private boolean cruiseControlOn = false;
    private int targetSpeed = 0;
    private final int minSpeed = 0;
    private final int maxSpeed = 200;

    public Car(String logo, String model, int year, double gasolineTankCapacity, int topSpeed) {
        this.logo = logo;
        this.model = model;
        this.year = year;
        this.gasolineTankCapacity = gasolineTankCapacity;
        this.topSpeed = topSpeed;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public int getTargetSpeed() {
        return targetSpeed;
    }

    public boolean turnOnCruiseControl(int targetSpeed) {
        if (targetSpeed >= minSpeed && targetSpeed <= maxSpeed) {
            this.targetSpeed = targetSpeed;
            cruiseControlOn = true;
            return true;
        } else {
            cruiseControlOn = false;
            return false;
        }
    }

    public void turnOffCruiseControl() {
        cruiseControlOn = false;
    }

    public boolean accelerateToTargetSpeed(int accelerationValue) {
        if (cruiseControlOn) {
            int newSpeed = topSpeed + accelerationValue;
            if (newSpeed <= targetSpeed) {
                topSpeed = newSpeed;
                return true;
            }
        }
        return false;
    }

    public boolean decelerateToTargetSpeed(int decelerationValue) {
        if (cruiseControlOn) {
            int newSpeed = topSpeed - decelerationValue;
            if (newSpeed >= targetSpeed) {
                topSpeed = newSpeed;
                return true;
            }
        }
        return false;
    }

    public String getLogo() {
        return logo;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getGasolineTankCapacity() {
        return gasolineTankCapacity;
    }

    public int getTopSpeed() {
        return topSpeed;
    }
}
class CarDriver {
    public static void main(String[] args) {
        Car myCar = new Car("Ferrari", "Spider", 2022, 100.0, 120);

        int targetSpeed = 80;
        boolean success = myCar.turnOnCruiseControl(targetSpeed);

        System.out.println("Car Logo: " + myCar.getLogo());
        System.out.println("Car Model: " + myCar.getModel());
        System.out.println("Car Year: " + myCar.getYear());
        System.out.println("Gasoline Tank Capacity: " + myCar.getGasolineTankCapacity() + " gallons");
        System.out.println("Top Speed: " + myCar.getTopSpeed() + " mph");

        if (success) {
            System.out.println("Cruise control is on with a target speed of " + myCar.getTargetSpeed() + " mph");

            int accelerationValue = 0;
            int decelerationValue = 51;

            boolean accelerationSuccess = myCar.accelerateToTargetSpeed(accelerationValue);
            boolean decelerationSuccess = myCar.decelerateToTargetSpeed(decelerationValue);

            if (accelerationSuccess || decelerationSuccess) {
                System.out.println("You reached the target speed: " + myCar.getTopSpeed() + " mph");
            } else {
                System.out.println("Failed to reach the target speed.");
            }

            myCar.turnOffCruiseControl();
            System.out.println("Cruise control turned off.");
        } else {
            System.out.println("Cruise control turned off.");
        }
    }
}