/*
    (Sum all the integers in a binary data file) Suppose a binary data file named
    Exercise17_03.dat has been created and its data are created using
    writeInt(int) in DataOutputStream. The file contains an unspecified
    number of integers. Write a program to find the sum of the integers.
 */
package ex17_03;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex17_03 {

    public static void main(String[] args) throws IOException {
        // Create File
        File file = new File("Ex17_03.dat");
        
        // store the sum of integers
        int sum = 0;
                
        try(DataInputStream input = new DataInputStream(new FileInputStream(file))){
            int r;
            while( ( r = input.read() ) != -1){
                sum += input.readInt();
            }
        }
        
        System.out.println("The sum of all integers is: " + sum);
    }
    
}
