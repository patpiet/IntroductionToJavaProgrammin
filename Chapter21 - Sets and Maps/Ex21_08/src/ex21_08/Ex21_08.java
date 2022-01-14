/*
    (Count the occurrences of words in a text file) Rewrite Listing 21.9 to read the
    text from a text file. The text file is passed as a command-line argument. Words
    are delimited by whitespace characters, punctuation marks (,;.:?), quotation
    marks ('"), and parentheses. Count words in case-insensitive fashion (e.g., consider
    Good and good to be the same word). The words must start with a letter.
    Display the output in alphabetical order of words, with each word preceded by
    its occurrence count.
 */
package ex21_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author patpiet
 */
public class Ex21_08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create file object
        File file = new File(args[0]);
        
        // Exit if file does not exist
        if(!file.exists()){
            System.out.println("File does not exist.");
            System.exit(0);
        }
        
        // Create Map to store words
        Map<String, Integer> map = new TreeMap<>();
        
        // Create scanner object
        try(Scanner input = new Scanner(file)){
            // Loop through the file
            while(input.hasNext()){
                String line = input.nextLine().toLowerCase();
                // Split the line into words
                String[] words = line.split("[,;.:?'\" ]");
                // Loop through each word
                for(String word: words){
                    // Check for starting letter
                    if(word.length() > 0 && Character.isLetter(word.charAt(0))){
                        if(!map.containsKey(word)){
                            map.put(word, 1);
                        }else{
                            map.put(word, map.get(word) + 1);
                        }
                    }
                }
            }
        }
        
        map.forEach((k, v) ->{
            System.out.println(k + "\t" + v);
        });
    }
    
}
