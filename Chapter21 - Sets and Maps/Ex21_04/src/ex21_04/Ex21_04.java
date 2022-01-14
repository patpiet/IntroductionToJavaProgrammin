/*
    (Count consonants and vowels) Write a program that prompts the user to enter a
    text file name and displays the number of vowels and consonants in the file. Use
    a set to store the vowels A, E, I, O, and U.
 */
package ex21_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author patpiet
 */

public class Ex21_04 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a set of vovels
        Set<Character> vovels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));

        // Create scanner
        Scanner scanner = new Scanner(System.in);
        
        // Ask for file name
        System.out.println("Enter file name: ");
        File file = new File(scanner.next());
        
        // Exit if file does not exist
        if(!file.exists()){
            System.out.println("File does not exist.");
            System.exit(0);
        }
        
        // Counters
        int vovelsCounter = 0;
        int consonantsCounter = 0;
        
        // Create file scanner object
        try(Scanner input = new Scanner(file)){
            // loop through the file
            while(input.hasNext()){
                String line = input.nextLine();
                line = line.toUpperCase();
                // Loop through each character in the line
                for(Character ch: line.toCharArray()){
                    if(Character.isLetter(ch)){
                        if(vovels.contains(ch))  // VOVEL case
                            vovelsCounter++;
                        else    // CONSONANTS case
                            consonantsCounter++;
                    }
                }
            }
        }
        
        System.out.println("Vovels: " + vovelsCounter);
        System.out.println("Consonants: " + consonantsCounter);
        
    }
    
}
