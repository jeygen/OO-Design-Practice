package com.coe528;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class FlightTest {
    
    @Test
    public void testConstructor() {
        Flight instance = new Flight(10, "Toronto", "Edmonton", "5:00 pm", 10, 45.4);
        /*
        if (instance instanceof Flight)
            assertTrue(true);
        else    
            fail("Invalid Constructor");
        */
        assertTrue(instance instanceof Flight);
        // Could also check instance variables if correct
    }

    @Test(expected = Exception.class) // Start here
    public void testInvalidConstructor() {
        Flight instance = new Flight(10, "Toronto", "Toronto", "5:00 pm", 10, 45.4);
        /*
        try {
            Flight instance = new Flight(10, "Toronto", "Toronto", "5:00 pm", 10, 45.4);
            fail("Exception was expected");
        }
        catch (Exception e) {
            //assertTrue(true);
        }
            */
    }

            
}