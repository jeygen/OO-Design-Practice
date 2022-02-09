package com.coe528;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
int: Following are the webpages containing documentation of some java classes that can be used for 
writing to or reading from text files:
https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html
https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html


// A singleton with parameters isn't a singleton but they want it to
*/

public class Record {
    // Name of the associated file
    private String filename;
    private static Record instance;

    private Record(String n) throws FileNotFoundException {
        filename = n;
        //String location = System.getProperty("user.dir");
        //File file = new File("C:\\Users\\joshm\\OneDrive - Ryerson University\\Documents\\GitHub\\OO-Design-Practice\\singleton-composite\\src\\main\\java\\com\\coe528\\record.txt");
        File file = new File("record.txt"); //this works
        //FileOutputStream fos = new FileOutputStream("C:\\Users\\joshm\\OneDrive - Ryerson University\\Documents\\GitHub\\OO-Design-Practice\\singleton-composite\\src\\main\\java\\com\\coe528\\Record.java");
        //file.createNewFile("record.txt");
    }

    // Singleton 
    // Effects: Constructs Record class if none exists. Returns Record object.
    public static Record getInstance() throws FileNotFoundException {
        if (instance == null)
            instance = new Record("record.txt");
        return instance;
    }

    // Effects: Reads and prints the contents of the associated 
    // file to the standard output. 
    public void read() {
        try {
            // Write the code here
            FileReader reader = new FileReader(filename);
            System.out.println(reader.read());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Effects: Appends the specified message, msg, to the 
    // associated file.
    public void write(String msg) {
        try {
        // Write the code here
            FileWriter writer = new FileWriter("record.txt", true);
            writer.append(msg);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
    // Fill the blank below that obtains the sole instance 
    // of the Record class. 
    // (You should not invoke the Record constructor here.)
           // ______________________________________ ;
        Record r = Record.getInstance();

        // Do not modify the code below
        r.write("Hello-1\n");
        r.write("Hello-2\n");

        System.out.println("Currently the file record.txt " +
        "contains the following lines:");
        r.read();
        }
    }