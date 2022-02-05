package coe528;
import java.util.ArrayList;

public class QueueOfDistinctStrings {
    
 // Overview: QueueOfDistinctStrings are mutable, bounded 
 // collection of distinct strings that operate in 
 // FIFO (First-In-First-Out) order. 
 //
 // The abstraction function is:
 // a) Write the abstraction function here
 // 
 // 
 //
 //
 // The rep invariant is:
 // b) Write the rep invariant here
 // 
 // 
 // 
 //
 
    //the rep
    private ArrayList<String> items;

    // constructor
    // EFFECTS: Creates a new QueueOfDistinctStrings object
    public QueueOfDistinctStrings () {
        items = new ArrayList<String>();
    }
    
    // MODIFIES: this
    // EFFECTS: Appends the element at the end of the queue
    // if the element is not in the queue, otherwise
    // does nothing.
    public void enqueue(String element) throws Exception {
        if(element == null) throw new Exception();
        if(false == items.contains(element)) 
        items.add(element);
    }
    
    // MODIFIES: this
    // EFFECTS: Removes an element from the front of the queue
    public String dequeue() throws Exception {
        if (items.size() == 0) throw new Exception();
        return items.remove(0);
    }
    
    // EFFECTS: Returns true if the rep invariant holds for this 
    // object; otherwise returns false 
    public boolean repOK() {
    // c) Write the code for the repOK() here
        boolean placeholderImade = false;
        return false;
    }
    
    // EFFECTS: Returns a string that contains the strings in the 
    // queue, the front element and the end element. 
    // Implements the abstraction function. 
    public String toString() {
    // d) Write the code for the toString() here
        String placeholderImade = "placeholder";
        return placeholderImade;
    }
    

    public static void main(String [] args) {
        System.out.println("Hello Borld");
    }
}
