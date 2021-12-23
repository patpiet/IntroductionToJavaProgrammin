/*
    (Print the digits in an integer reversely) Write a recursive method that displays
    an int value reversely on the console using the following header:

    public static void reverseDisplay(int value)
    
    For example, reverseDisplay(12345) displays 54321. Write a test program
    that prompts the user to enter an integer and displays its reversal.
 */
package ex18_08;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex18_08 {

    public static void main(String[] args) {
        // Create scanner   
        Scanner input = new Scanner(System.in);
        // ask for integer
        System.out.println("Enter integer: ");
        int value = input.nextInt();

        reverseDisplay(value);
    }

    // returns reverse display of integer
    public static void reverseDisplay(int value) {
        if (value / 10 == 0) {    // base case
            System.out.print(value);
            return;
        }
        System.out.print(value % 10);
        reverseDisplay(value / 10);
    }
}
