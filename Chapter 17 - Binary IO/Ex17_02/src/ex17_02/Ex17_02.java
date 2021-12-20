/*
    (Create a binary data file) Write a program to create a file named
    Exercise17_02.dat if it does not exist. Append new data to it if it already exists.
    Write 100 integers created randomly into the file using binary I/O.
*/
package ex17_02;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex17_02 {

    public static void main(String[] args) throws IOException {
        // Create file 
        File file = new File("Ex17_02.dat");
        // Create output stream
        try(BufferedOutputStream output =
              new BufferedOutputStream(new FileOutputStream(file, true));){
            output.write((int) (Math.random() * 100));
        }
    }
    
}
