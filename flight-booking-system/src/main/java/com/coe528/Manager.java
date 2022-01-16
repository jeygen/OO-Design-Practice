package com.coe528;
import java.util.*;

public class Manager {
    Flight [] fList;
    Ticket [] tickList;
    
    public void createFlights(){ // Prompts user to populate the flight option information
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please input total amount of flights:"); // Prompt user for number of Flights and create array of Flight objects.
        int numOfFlights;
        if (scan.hasNextInt()) {
            numOfFlights = scan.nextInt();
            if (numOfFlights < 0)
                throw new IllegalArgumentException("Number of flights cannot be 0 or less");
        }
        else {
            numOfFlights = 0;
            System.out.println("No flights available at this time. Goodbye.");
            System.exit(0);
        }
        fList = new Flight[numOfFlights];
        
        for (int i = 0; i < numOfFlights; i++) { // Prompts user to input values for Flight object and constructs Flight objects.
            System.out.println("Please input Flight Number: ");
            if (scan.hasNextInt() != true)
                throw new IllegalArgumentException("Flight number must be integer.");
            int fnum = scan.nextInt();
            System.out.println("Please input city of origin: ");
            String o = scan.next();
            System.out.println("Please input destination city: ");
            String dest = scan.next();
            System.out.println("Please input departure time: ");
            String departT = scan.next();
            System.out.println("Please input flight capacity: ");
            if (scan.hasNextInt() != true)
                throw new IllegalArgumentException("Flight capacity must be an integer.");
            int cap = scan.nextInt();
            System.out.println("Please input price per ticket: ");
            if (scan.hasNextDouble() != true)
                throw new IllegalArgumentException("Flight capacity can not be negative.");
            double origPrice = scan.nextDouble();
            fList[i] = new Flight(fnum, o, dest, departT, cap, origPrice);
        }        
    }

    public void displayAvailableFlights(String origin, String destination) { // Displays unbooked flights from origin to destination
        for(int i = 0; i < fList.length; i++) {
            if (fList[i].getCapacity() > 0)
                System.out.println(fList[i].toString());
            else    
                System.out.println(fList[i].getFlightNumber() + " is booked.");
        }
    }

    public Flight getFlight(int flightNumber) { // Returns flight object for specified flight number
        
        for(int i = 0; i < fList.length; i++) {
            if (fList[i].getFlightNumber() == flightNumber)
                return fList[i];
            else
                throw new IllegalArgumentException("No flight with that flight number exists.");
        }
        return fList[0]; // dummy return
        //return fList[flightNumber];
    }

    /*
        Tries to find flight with given flight number.
        If exists, tries to book seat.
        If successful applies correct discount.
        Issues ticket.
    */
    public void bookSeat(int flightNumber, Passenger p) { 
        double price;
        int totalCap = 0;

        for(int i = 0; i < fList.length; i++) 
            totalCap += fList[i].getCapacity(); 
        tickList = new Ticket[totalCap];

        for(int i = 0; i < fList.length; i++) {
            if (fList[i].getFlightNumber() == flightNumber) {
                fList[i].setCapacity(fList[i].getCapacity() - 1);
                price = p.applyDiscount(fList[i].getOriginalPrice());
                /*
                if (p instanceof Member) // May have to typecast p?
                    price = p.applyDiscount(fList[i].getOriginalPrice());
                else    
                    p.applyDiscount()
                    */
        
                tickList[i] = new Ticket(p, fList[i], price);
            }
            else
                System.out.println("No flight with that flight number exists.");
        } 
    }

    public static void main(String [] args) {
        Manager manager = new Manager();
        manager.createFlights();
        manager.displayAvailableFlights("Toronto", "Edmonton");
        System.out.println();
        
        Member mem1 = new Member("Josh", 20, 3);
        Member mem2 = new Member("Moe", 30, 10);
        NonMember nonMem1 = new NonMember("Xi", 42);
        NonMember nonMem2 = new NonMember("Karen", 82);
        NonMember nonMem3 = new NonMember("Karen", 10);

        manager.bookSeat(200, mem1);
        System.out.println(manager.getFlight(200).getOriginalPrice());

        System.out.println("Printing out all issued tickets:");
        for(int i = 0; i < manager.tickList.length; i++) {
            if (manager.tickList[i] == null)
                continue;
            else
                System.out.println(manager.tickList[i]);
        }
    }
}
