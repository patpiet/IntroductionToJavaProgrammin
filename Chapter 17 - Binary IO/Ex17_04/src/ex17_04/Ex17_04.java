/*
    (Convert a text file into UTF) Write a program that reads lines of characters from
    a text file and writes each line as a UTF-8 string into a binary file. Display the
    sizes of the text file and the binary file. Use the following command to run the
    program:
    java Exercise17_04 Welcome.java Welcome.utf
 */
package ex17_04;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex17_04 {

    public static void main(String[] args) throws IOException {
        // Create text file object
        File textFile = new File(args[0]);
        // Create binary file object
        File binaryFile = new File(args[1]);

        try (DataOutputStream output
                = new DataOutputStream(new FileOutputStream(binaryFile));
                Scanner input = new Scanner(textFile);) {
            // Loop through txt file
            while(input.hasNext()){
                // Write every line of txt file to binary file as utf
                output.writeUTF(input.nextLine() + "\n");
            }
            // print size of files
            System.out.println("Binary file size: " + binaryFile.length());
            System.out.println("Text file size: " + textFile.length());
        }
    }

}
