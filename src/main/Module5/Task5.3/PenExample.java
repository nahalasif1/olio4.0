import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PenTest {
    @Test
    void canDrawDefault() {
        Pen p = new Pen();
        assertEquals("", p.draw());
        p.capOff();
        assertEquals("Drawing red", p.draw());
        p.capOn();
        assertEquals("", p.draw());
    }

    @Test
    void canDrawSelectedColor() {
        Pen p = new Pen(Pen.Color.BLUE);
        assertEquals("", p.draw());
        p.capOff();
        assertEquals("Drawing blue", p.draw());
        p.capOn();
        assertEquals("", p.draw());
    }

    @Test
    void canChangeColor() {
        Pen p = new Pen(Pen.Color.RED);
        p.capOff();
        assertEquals("Drawing red", p.draw());
        p.changeColor(Pen.Color.GREEN);
        assertEquals("Drawing red", p.draw());

        p.capOn();
        p.changeColor(Pen.Color.GREEN);
        assertEquals("", p.draw());
        p.capOff();
        assertEquals("Drawing green", p.draw());
    }
}

class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; }
        @Override public String toString() { return color; }
    }

    private Color currentColor;
    private boolean capOn;

    public Pen() {
        this(Color.RED);
    }

    public Pen(Color initialColor) {
        this.currentColor = initialColor;
        this.capOn = true;
    }

    public String draw() {
        if (capOn) {
            return "";
        } else {
            return "Drawing " + currentColor;
        }
    }

    public void capOff() {
        capOn = false;
    }

    public void capOn() {
        capOn = true;
    }

    public void changeColor(Color newColor) {
        if (!capOn) {
            currentColor = newColor;
        }
    }
}

public class PenExample {
    public static void main(String[] args) {
        Pen defaultPen = new Pen();
        System.out.println("Default Pen: " + defaultPen.draw());

        Pen bluePen = new Pen(Pen.Color.BLUE);
        System.out.println("Blue Pen: " + bluePen.draw());

        bluePen.capOff();
        System.out.println("Drawing with Blue Pen: " + bluePen.draw());

        bluePen.capOn();
        System.out.println("After capping: " + bluePen.draw());
    }
}

