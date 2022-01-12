/*
    (Display nonduplicate words in ascending order) Write a program that reads
    words from a text file and displays all the nonduplicate words in ascending order.
    The text file is passed as a command-line argument.
 */
package ex21_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author patpiet
 */
public class Ex21_02 {

    public static void main(String[] args) throws FileNotFoundException {
        //Create file
        File file = new File(args[0]);

        String hi = "while";

        // Leave if file does not exist
        if (!file.exists()) {
            System.out.println("The file while does not exist.");
            System.exit(0);
        }

        // Create a set
        Set<String> words = new TreeSet<>();

        // Create an input scanner
        try (Scanner input = new Scanner(file)) {
            // Loop until the file finishes
            while (input.hasNext()) {
                String word = input.next();
                words.add(word);
            }
        }

        System.out.println(words);

    }

}
