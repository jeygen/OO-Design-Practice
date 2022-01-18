package com.coe528;
import java.util.*;


public class Manager {
    private static Flight [] fList;
    private static Ticket [] tickList;
    
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
            System.out.println();
        }        
    }

    public void displayAvailableFlights(String origin, String destination) { // Displays unbooked flights of specified origin, dest
        for(int i = 0; i < fList.length; i++) {
            if (fList[i].getCapacity() > 0 && fList[i].getOrigin().toUpperCase().equals(origin.toUpperCase()) && fList[i].getDestination().toUpperCase().equals(destination.toUpperCase())) {
                System.out.println("Printing available flights with specified origin and destination: ");
                System.out.println(fList[i].toString());
            }
            else if (fList[i].getOrigin().toUpperCase().equals(origin.toUpperCase()) && fList[i].getDestination().equals(destination.toUpperCase()))  
                System.out.println(fList[i].getFlightNumber() + " is booked.");
            else 
                System.out.println("No flights with that origin and destination exist");  
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
        double price = 0;
        int totalCap = 0;

        // Gets capacity of all flights and creates Ticket[] of total capacity size
        for(int i = 0; i < fList.length; i++) 
            totalCap += fList[i].getCapacity(); 
        tickList = new Ticket[totalCap];
        

        for(int i = 0; i < fList.length; i++) {
            if (fList[i].getFlightNumber() == flightNumber) {
                int count = 0;
                fList[i].setCapacity(fList[i].getCapacity() - 1);
               // price = p.applyDiscount(fList[i].getOriginalPrice());
             
                if (p instanceof Member) { // Keep getting wrong values for price 
                    // Member m = (Member) p;
                    //price = m.applyDiscount(fList[i].getOriginalPrice());
                    System.out.println("Member Status");
                    System.out.println(price);
                    price = ((Member)p).applyDiscount(fList[i].getOriginalPrice());
                    System.out.println(price);
                    System.out.println(fList[i].getOriginalPrice());

                }
                else {    
                    // NonMember nm = (NonMember) p;
                    // price = nm.applyDiscount(fList[i].getOriginalPrice());
                    System.out.println("Non-Member Status");
                    price = ((NonMember)p).applyDiscount(fList[i].getOriginalPrice());
                }       
                
                
                count++;
                tickList[count] = new Ticket(p, fList[i], price);
            }
            else
                System.out.println("No flight with that flight number exists.");
        } 
    }

    public static void main(String [] args) {
        Manager manager = new Manager();
        manager.createFlights(); // Creating and populating flights through user input

        manager.displayAvailableFlights("YYZ", "YEG"); // Seeing all availabe flights with input origin and destination
        System.out.println(); 
        
        Member mem1 = new Member("Josh", 20, 3); // Creating Member and non-Member Passenger objects
        Member mem2 = new Member("Moe", 30, 10);
        NonMember nonMem1 = new NonMember("Xi", 72);
        NonMember nonMem2 = new NonMember("Karen", 52);
        NonMember nonMem3 = new NonMember("Kai", 10);

        manager.bookSeat(737, mem1); // Booking a Member Passenger on Lfight 737 
        manager.bookSeat(737, nonMem1); // Booking a Non-Member on Flight 737
        //System.out.println(manager.getFlight(737).getOriginalPrice());
        System.out.println(Manager.tickList.length);


        System.out.println("Printing out all issued tickets:"); // Prints out all issued tickets
        for(int i = 0; i < Ticket.getNumber(); i++) {
            if (Manager.tickList[i] != null)
                System.out.println("Ticket: " +  Ticket.getNumber() + " ---> " + Manager.tickList[i]);
        }
    }
}
