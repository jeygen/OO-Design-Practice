package src.test.java.com.coe528;

import org.junit.Test;

import main.java.com.coe528.Flight;


public class FlightTest {
    
    @Test
    public void testConstructor() {
        Flight instance = new Flight(10, "Toronto", "Toronto", "5:00 pm", 10, 45.4);
        if (instance instanceof Flight)
            assertTrue("Valid Constructor");
        else    
            fail("Invalid Constructor");
        // Could also test data types with getters
    }

    @Test(expected = Exception.class)
    public void testInvalidConstructor() {
        try {
            Flight instance = new Flight(10, "Toronto", "Toronto", "5:00 pm", 10, 45.4);
            fail("Exception was expected");
        }
        catch (Exception e) {
            assertTrue("Invalid Constructor");
        }
    }

            
}
