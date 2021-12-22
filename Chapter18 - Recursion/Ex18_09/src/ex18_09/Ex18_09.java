/*
    (Print the characters in a string reversely) Write a recursive method that displays
    a string reversely on the console using the following header:

    public static void reverseDisplay(String value)

    For example, reverseDisplay("abcd") displays dcba. Write a test program
    that prompts the user to enter a string and displays its reversal.
 */
package ex18_09;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex18_09 {

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        // Ask for string
        System.out.println("Enter string: ");
        String value = input.next();
        
        reverseDisplay(value);
    }
    
    // displays reversed string
    public static void reverseDisplay(String value){
        if(value.length() != 0){
            // print last character of the string
            System.out.print(value.charAt(value.length() - 1));
            // pass value string without last character
            reverseDisplay(value.substring(0, value.length() - 1));
        }
    }
}
