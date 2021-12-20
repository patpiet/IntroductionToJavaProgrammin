/*
    (Create a binary data file) Write a program to create a file named
    Exercise17_02.dat if it does not exist. Append new data to it if it already exists.
    Write 100 integers created randomly into the file using binary I/O.
 */
package ex17_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex17_01 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Create file object
        File file = new File("file.txt");
        
        
        // Create an output stream
        try(PrintWriter output = new PrintWriter(file)){
            // loop 100 times
            for (int i = 0; i < 100; i++) {
                // write random number to the file
                output.write((int) (Math.random() * 100) + "");
            }
        }
    }
    
    
}
