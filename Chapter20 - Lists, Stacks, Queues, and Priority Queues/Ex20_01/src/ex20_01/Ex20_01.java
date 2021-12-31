/*
    (Display words in ascending alphabetical order) Write a program that reads
    words from a text file and displays all the words (duplicates allowed) in ascending
    alphabetical order. The words must start with a letter. The text file is passed
    as a command-line argument.
 */
package ex20_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patpiet
 */
public class Ex20_01 {

    public static void main(String[] args) {
        // upload the file
        File file = new File("Ex20_01.txt");
        
        // Create list
        ArrayList<String> list = new ArrayList<>();
        
        // Create a file scanner
        try(Scanner input = new Scanner(file)) {
            // continue until end of file
            while(input.hasNext()){
                String name = input.next().toLowerCase();
                // Check if the first character is a letter
                if(Character.isLetter(name.charAt(0))){
                    // add to the list
                    list.add(name);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Something went wrong with reading the file");
        }
        
        // sort the list
        Collections.sort(list);
        // print the list
        System.out.println(list);
    }
    
}
