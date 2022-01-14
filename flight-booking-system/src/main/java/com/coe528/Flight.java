package com.coe528;

public class Flight {
   private int flightNumber;
   private String origin;
   private String destination;
   private String departureTime;
   private int capacity;
   private int numberOfSeatsLeft; 
   private double originalPrice;

   public Flight(int fNum, String o, String dest, String departT, int cap, double origPrice) {
        if (o.equals(dest)) {
            throw new IllegalArgumentException("Origin can not match destination.");
        }

        this.flightNumber = fNum;
        this.origin = o;
        this.destination = dest;
        this.departureTime = departT;
        this.capacity = cap;
        this.numberOfSeatsLeft = this.capacity; // This may have to change
        this.originalPrice = origPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }

    public String getOrigin() {
        return origin;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setDestination(String destination) {
        if (destination.equals(this.origin)) {
            throw new IllegalArgumentException("Origin can not match destination.");
        }
        this.destination = destination;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }

    public void setOrigin(String origin) {
        if (origin.equals(this.destination)) {
            throw new IllegalArgumentException("Origin can not match destination.");
        }
        this.origin = origin;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    public boolean bookAseat() {
        if (this.getNumberOfSeatsLeft() > 0) {
            setNumberOfSeatsLeft(this.getNumberOfSeatsLeft() - 1);
            return true; 
        }
        return false;
    }

    @Override
    public String toString() {
        return "Flight: " + this.getFlightNumber() + ", " + this.getOrigin() + " to " + this.getDestination() + ", " + this.getDepartureTime() + ". Original Price: $" + this.getOriginalPrice();
    }

}

