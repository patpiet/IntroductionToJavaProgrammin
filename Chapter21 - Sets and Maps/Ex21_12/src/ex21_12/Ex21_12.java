/*
    (Name for both genders) Write a program that prompts the user to enter one of
    the filenames described in Programming Exercise 12.31 and displays the names
    that are used for both genders in the file. Use sets to store names and find common
    names in two sets. Here is a sample run: open the template in the editor.
 */
package ex21_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author patpiet
 */
public class Ex21_12 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create scanner for user input  
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a file name for baby name ranking: ");
        String fileName = scanner.next();

        // Create file object
        File file = new File("names/" + fileName);

        Set<String> boys = new HashSet<>();
        Set<String> girls = new HashSet<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] words = line.split("\\s+");

                boys.add(words[1]);
                girls.add(words[3]);
            }
        }

        boys.retainAll(girls);
        
        System.out.println(boys.size() + " names used for both genders.");
        System.out.print("They are ");
        boys.forEach((name) -> {
            System.out.print(name + " ");
        });
    }

}
