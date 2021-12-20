/*
    (Store objects and arrays in a file) Write a program that stores an array of the five
    int values 1, 2, 3, 4, and 5, a Date object for the current time, and the double
    value 5.5 into the file named Exercise17_05.dat.
 */
package ex17_05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Ex17_05 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Create an output stream 
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Ex17_05.dat"))) {
            Object[] array = new Object[7];
            for (int i = 0; i < 5; i++) {
                array[i] = i;
            }
            array[5] = (new Date());
            array[6] = 5.5;
            output.writeObject(array);
        }
    }

}
