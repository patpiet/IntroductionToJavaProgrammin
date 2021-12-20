/*
    (Restore objects from a file) Suppose a file named Exercise17_07.dat has been
    created using the ObjectOutputStream. The file contains Loan objects. The
    Loan class in Listing 10.2 does not implement Serializable. Rewrite the
    Loan class to implement Serializable. Write a program that reads the Loan
    objects from the file and displays the total loan amount. Suppose you don’t
    know how many Loan objects are there in the file, use EOFException to end
    the loop.
 */
package ex17_07;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex17_07 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // Create input source
        try(ObjectInputStream input = new ObjectInputStream( new FileInputStream("Ex17_07.dat"))){
            while(true){
                // read the loan
                Loan loan = (Loan) input.readObject();
                // display its amount
                System.out.println(loan.getLoanAmount());
            }
        }catch(EOFException ox){
            // finish when end of line
            System.out.println("No more loans to read");
        }
    }
    
}
