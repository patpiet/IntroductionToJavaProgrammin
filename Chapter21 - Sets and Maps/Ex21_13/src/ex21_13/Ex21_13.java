/*
    (Baby name popularity ranking) Revise Programming Exercise 21.11 to prompt
    the user to enter year, gender, and name and display the ranking for the name.
    Prompt the user to enter another inquiry or exit the program.
 */
package ex21_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex21_13 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create scanner
        Scanner s = new Scanner(System.in);

        boolean isTrue;

        do {
            // Get data from user
            System.out.print("Enter the year: ");
            int year = s.nextInt();
            System.out.print("Enther the gender: ");
            char gender = s.next().toLowerCase().charAt(0);
            System.out.print("nEnter the name: ");
            String name = s.next();
            
            // Create file object
            File file = new File("names/babynamesranking" + year + ".txt");

            // Store names and their ranking
            HashMap<String, Integer> map = getRanking(file, gender);
            
            if(map.containsKey(name)){
                String gend = (gender == 'M') ? "Boy" : "Girl";
                System.out.println(gend + " name " + name + " is ranked #" + map.get(name) + " in year " + year);
            }
            // Check if continue desired
            System.out.print("Enter another inquiry? ");
            char inquiry = s.next().toLowerCase().charAt(0);
            isTrue = inquiry == 'y';
           
        } while (isTrue);

    }

    private static HashMap<String, Integer> getRanking(File file, char gender) throws FileNotFoundException {
        // Store all names of the gender and its ranking
        HashMap<String, Integer> map = new HashMap<>();

        // Create scanner object
        try (Scanner input = new Scanner(file);) {
            // Loop through the file
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] words = line.split("\\s+");

                // Loop through the line
                for (int i = 0; i < words.length; i++) {
                    switch (gender) {
                        case 'f': {     // Add female name
                            map.put(words[3], Integer.parseInt(words[0]));
                            break;
                        }
                        case 'm': {   // Add male name
                            map.put(words[1], Integer.parseInt(words[0]));
                            break;
                        }
                    }
                }
            }
        }
        return map;
    }
}
