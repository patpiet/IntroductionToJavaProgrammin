/*
    (Binary to decimal) Write a recursive method that parses a binary number as a
    string into a decimal integer. The method header is:

    public static int bin2Dec(String binaryString)
    
    Write a test program that prompts the user to enter a binary string and displays
    its decimal equivalent.
 */
package ex18_23;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex18_23 {

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        // Ask for a string
        System.out.print("Enter a binary string: ");
        String str = input.next();
    
        System.out.println("The decimal equivalent is: " + bin2Dec(str));
    }
    
    public static int bin2Dec(String binaryString){
        return bin2Dec(binaryString, binaryString.length() - 1, 0);     // recursive helper method
    }

    private static int bin2Dec(String binaryString, int high, int power) {
        if(high == -1){      // base case
            return 0;
        }else{              // recursive call
            return (int) ((binaryString.charAt(high) == '1') ?
                    Math.pow(2, power) + bin2Dec(binaryString, high - 1, power + 1) :
                    bin2Dec(binaryString, high -1, power + 1));
        }
    }
}
