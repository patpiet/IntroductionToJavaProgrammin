/*
    (Store Loan objects) The Loan class in Listing 10.2 does not implement
    Serializable. Rewrite the Loan class to implement Serializable. Write
    a program that creates five Loan objects and stores them in a file named
    Exercise17_06.dat.
 */
package ex17_06;

import ex17_06.Loan;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ex17_06 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Create 5 loan objects
        Loan loan1 = new Loan(5, 5, 10000);
        Loan loan2 = new Loan(5, 5, 10000);
        Loan loan3 = new Loan(5, 5, 10000);
        Loan loan4 = new Loan(5, 5, 10000);
        Loan loan5 = new Loan(5, 5, 10000);
        
        // Create an output stream object
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Ex17_06.dat"))){
            output.writeObject(loan1);
            output.writeObject(loan2);
            output.writeObject(loan3);
            output.writeObject(loan4);
            output.writeObject(loan5);
        }
    }
    
}
