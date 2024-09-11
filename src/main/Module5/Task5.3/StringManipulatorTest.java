import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {

    @Test
    public void testConcatenate() {
        StringManipulator stringManipulator = new StringManipulator();
        assertEquals("HelloWorld", stringManipulator.concatenate("Hello", "World"));
    }

    @Test
    public void testFindLength() {
        StringManipulator stringManipulator = new StringManipulator();
        assertEquals(5, stringManipulator.findLength("Hello"));
    }

    @Test
    public void testConvertToUpperCase() {
        StringManipulator stringManipulator = new StringManipulator();
        assertEquals("HELLO", stringManipulator.convertToUpperCase("Hello"));
    }

    @Test
    public void testConvertToLowerCase() {
        StringManipulator stringManipulator = new StringManipulator();
        assertEquals("hello", stringManipulator.convertToLowerCase("Hello"));
    }

    @Test
    public void testContainsSubstring() {
        StringManipulator stringManipulator = new StringManipulator();
        assertTrue(stringManipulator.containsSubstring("Hello", "el"));
        assertFalse(stringManipulator.containsSubstring("Hello", "abc"));
    }
}