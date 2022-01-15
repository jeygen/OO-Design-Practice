package com.coe528;
import java.util.*;

public class Manager {
    ArrayList <Flight> fList;
    
    public void createFlights(){ // Prompts user to populate the flight option information
    }

    public void displayAvailableFlights(String origin, String destination) { // Displays unbooked flights from origin to destination
    }

    public Flight getFlight(int flightNumber) { // Returns flight object for specified flight number
    }

    /*
        Tries to find flight with given flight number.
        If exists, tries to book seat.
        If successful applies correct discount.
        Issues ticket.
    */
    public void bookSeat(int flightNumber, Passenger p) { 
    }

    public static void main(String [] args) {
    }
}
