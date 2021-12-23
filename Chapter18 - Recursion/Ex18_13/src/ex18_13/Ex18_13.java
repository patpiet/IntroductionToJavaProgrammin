/*
    (Find the largest number in an array) Write a recursive method that returns the
    largest integer in an array. Write a test program that prompts the user to enter a
    list of eight integers and displays the largest element.
 */
package ex18_13;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex18_13 {

    public static void main(String[] args) {
        // Create array to store integers
        int[] array = new int[8];
        // Create scanner
        Scanner input = new Scanner(System.in);
        // ask for integers
        System.out.println("Enter 8 integers: ");
        for (int i = 0; i < 8; i++) {
            array[i] = input.nextInt();
        }
        
        System.out.println("The largest integer in array is: " + largest(array));
        
    }

    public static int largest(int[] array) {
        return largest(array, 0, array[0]);
    }

    public static int largest(int[] array, int index, int largest) {
        if (index == array.length - 1) {  // base case
            if (array[index] > largest) {
                return array[index];
            }
        } else {
            if (array[index] > largest) {
                largest = array[index];
            }
            return largest(array, index + 1, largest);      // recursive call
        }
        return largest;
    }
}
