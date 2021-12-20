/*
    (Encrypt files) Encode the file by adding 5 to every byte in the file. Write a program
    that prompts the user to enter an input file name and an output file name and
    saves the encrypted version of the input file to the output file.
 */
package ex17_14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex17_14 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Create scanner
        Scanner scanner = new Scanner(System.in);
        // prompt for file names
        System.out.println("Enter input file name: ");
        String inputFileString = scanner.next();
        System.out.println("Enter output file name: ");
        String outputFileString = scanner.next();
        
        // Create stream objects
        try(BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputFileString));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFileString))){
            
            int buffer;
            // loop through input file
            while( (buffer = input.read()) != -1){
                output.write(buffer);
            }
            
        }
        
    }
    
}
