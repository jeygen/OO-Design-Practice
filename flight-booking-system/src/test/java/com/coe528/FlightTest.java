package com.coe528;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FlightTest {
    
    @Test
    public void testConstructor() {
        Flight instance = new Flight(10, "Toronto", "Edmonton", "5:00 pm", 10, 45.4);
        assertTrue(instance instanceof Flight);
        // Could also check instance variables if correct ?
    }

    @Test (expected = IllegalArgumentException.class) // Test passes if exception thrown
    public void testInvalidConstructor() {
        Flight instance = new Flight(10, "Toronto", "Toronto", "5:00 pm", 10, 45.4);
    }

            
}