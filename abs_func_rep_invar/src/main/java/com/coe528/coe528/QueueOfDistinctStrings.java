package com.coe528.coe528;
import java.util.ArrayList;
import java.util.HashSet;

public class QueueOfDistinctStrings {
    
 // Overview: QueueOfDistinctStrings are mutable, bounded 
 // collection of distinct strings that operate in 
 // FIFO (First-In-First-Out) order. 
 //
 // The abstraction function is:
 // a) Write the abstraction function here
 // 
 //     AF(q) = An abstract queue of distinct strings where q is a QueueOfDistinctStrings object.  
 //             Where q.list.get(i) == a distinct string element, i is an integer index for the q.list.eue with a size q.list.[1..n].
 // --------- Do I need any of this additional stuff?
 //             Where q.list.get(0) == the front of the q.list.eue.
 //             Where q.list.get((q.list.size()-1)) == the end of the q.list.eue.
 //             Where q.list.dequeue() removes the an element from the front of the q.list.eue.
 //             Where q.list.enqueue() adds a new element to the end of the q.list.eue.
 //
 // The rep invariant is:
 // b) Write the rep invariant here
 //     
 //     RI(q) = True if all elements are unique.
 //             False otherwise.
 // ---------- Should this be code?
 
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

    // is this sufficient?
    // EFFECTS: Returns true if the rep invariant holds for this 
    // object; otherwise returns false 
    public boolean repOK() {
    // c) Write the code for the repOK() here

        ArrayList<String> copy = new ArrayList<String>();
        //copy = this.items.clone();
        for (String s : items) {
            copy.add(s);
        }

        HashSet<String> compItems = new HashSet<String>(copy); 
        //System.out.println(compItems);
        //System.out.println(items);
        //System.out.println(copy);
        
        if (compItems.size() == this.items.size())
            return true;

        return false;
        }
    
    // EFFECTS: Returns a string that contains the strings in the 
    // queue, the front element and the end element. 
    // Implements the abstraction function. 
    public String toString() {
    // d) Write the code for the toString() here

        // should this be every element or just front and end?
        return "The front elements is: " + this.items.get(0) + " and the end element is: " + this.items.get(this.items.size() - 1);
    }
    
    // I added this to test stuff // delete before submission
    public static void main(String [] args) throws Exception {
        QueueOfDistinctStrings q = new QueueOfDistinctStrings();
        String o = new String("one");
        q.enqueue(o);
        q.enqueue("two");
        q.enqueue("three");
        q.enqueue("four");
        System.out.println(q);
        System.out.println(q.repOK());

        q.dequeue();
        System.out.println(q);
        
        q.enqueue("two");
        q.enqueue("two");
        q.enqueue("zonk");
        System.out.println(q);
        System.out.println(q.repOK());
        
        System.out.println(q);
    }
}
