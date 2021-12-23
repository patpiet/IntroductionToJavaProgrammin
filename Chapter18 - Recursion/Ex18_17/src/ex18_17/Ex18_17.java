/*
    (Occurrences of a specified character in an array) Write a recursive method that
    finds the number of occurrences of a specified character in an array. You need to
    define the following two methods. The second one is a recursive helper method.

    public static int count(char[] chars, char ch)
    public static int count(char[] chars, char ch, int high)

    Write a test program that prompts the user to enter a list of characters in one line,
    and a character, and displays the number of occurrences of the character in the list.
*/
package ex18_17;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex18_17 {

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        String line = input.next();
        char ch = input.next().charAt(0);

        // Create array for characters
        char[] chars = new char[line.length()];
        
        // assign characters to array
        for (int i = 0; i < line.length(); i++) {
            chars[i] = line.charAt(i);
        }
        
        // Output
        System.out.println("Number of occurences: " + count(chars, ch));
        
    }

    public static int count(char[] chars, char ch){
        return count(chars, ch, chars.length - 1);  // recursive helper method
    }
    
    public static int count(char[] chars, char ch, int high){
        if(high == 0){      // base case
            return (chars[high] == ch) ? 1 : 0;
        }else{
            return (chars[high] == ch) ?            // recursive call
                    1 + count(chars, ch , high - 1) : 
                    count(chars, ch, high - 1);
        }
    }
}
