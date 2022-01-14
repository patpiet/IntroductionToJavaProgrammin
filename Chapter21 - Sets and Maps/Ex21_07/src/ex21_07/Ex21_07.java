/*
    (Revise Listing 21.9, CountOccurrenceOfWords.java) Rewrite Listing 21.9 to
    display the words in ascending order of occurrence counts.

    (Hint: Create a class named WordOccurrence that implements the Comparable
    interface. The class contains two fields, word and count. The compareTo
    method compares the counts. For each pair in the hash set in Listing 21.9, create
    an instance of WordOccurrence and store it in an array list. Sort the array list
    using the Collections.sort method. What would be wrong if you stored the
    instances of WordOccurrence in a tree set?)
*/
package ex21_07;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author patpiet
 */
public class Ex21_07 {

    public static void main(String[] args) {
        // Set text string
        String text = "Good morning. Have a good class. " +
          "Have a good visit. Have fun!";     
        
        // Store splitted words
        String[] words = text.split("[\\s+\\p{P}]");

        // Store WordOccurence objects
        ArrayList<WordOccurence> list = new ArrayList<>();
        
        // Loop through each word
        for(String word: words){
            word = word.toLowerCase();
            
            if(word.length() > 0){  
                if(!checkWord(list, word)){     // New word case
                    list.add(new WordOccurence(word));
                }else{  // Word already in the text
                    getWordOccurence(list, word).increaseCount();   
                }
            }
        }
        // Sort the list
        Collections.sort(list);
        
        // Print number of occurences of each word
        list.forEach((obj) ->{
            System.out.println(obj.getWord() + "\t" + obj.getCounter());
        });
    }
    // Returns true if the word appears in any WordOccurence object in the list
    private static boolean checkWord(ArrayList<WordOccurence> list, String word) {
        for(WordOccurence obj: list){
            if(obj.getWord().equals(word)){
                return true;
            }
        }
        return false;
    }
    // Returns the WordOccurence object that contains given word
    private static WordOccurence getWordOccurence(ArrayList<WordOccurence> list, String word) {
        for(WordOccurence obj: list){
            if(obj.getWord().equals(word)){
                return obj;
            }
        }
        return null;
    }
    
}
