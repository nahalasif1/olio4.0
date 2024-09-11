// TASK 3-4
public abstract class Shape {
    public double calculateArea() {
        return 0;
    }
    public abstract String getDimensions();
}

abstract class ColoredShape extends Shape {
    private String color;

    public ColoredShape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class Circle extends ColoredShape {
    private double radius;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getDimensions() {
        return "radius " + radius;
    }
}

class Rectangle extends ColoredShape {
    private double width;
    private double height;

    public Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String getDimensions() {
        return "width " + width + " and height " + height;
    }
}

class Triangle extends ColoredShape {
    private double base;
    private double height;

    public Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getDimensions() {
        return "base " + base + " and height " + height;
    }
}

class ShapeCalculator {
    public static void main(String[] args) {
        ColoredShape[] shapes = {
                new Circle(5.0, "Black"),
                new Rectangle(4.0, 6.0, "Baby Blue"),
                new Triangle(3.0, 8.0, "Green")
        };

        System.out.println("Shape Calculator:");

        for (ColoredShape shape : shapes) {
            String shapeType = shape.getClass().getSimpleName();
            String dimensions = shape.getDimensions();
            String color = shape.getColor();

            System.out.println("Area of " + color + " " + shapeType + " with " + dimensions + ": " + shape.calculateArea());
        }
    }
}