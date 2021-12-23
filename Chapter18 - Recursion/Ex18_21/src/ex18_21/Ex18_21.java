/*
    (Decimal to binary) Write a recursive method that converts a decimal number
    into a binary number as a string. The method header is:

    public static String dec2Bin(int value)

    Write a test program that prompts the user to enter a decimal number and displays
    its binary equivalent.
 */
package ex18_21;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex18_21 {

    public static void main(String[] args) {
        // create scanner  
        Scanner input = new Scanner(System.in);
        // ask for decimal number
        System.out.print("Enter decimal number: ");
        int number = input.nextInt();
        
        System.out.println("The equivalent binary is: " + dec2Bin(number));
    }
    
    public static String dec2Bin(int value){
        if(value / 2  == 0){        // base case
            return (value % 2) + "";
        }else{
            return dec2Bin(value / 2) + (value % 2);    // recursive call
        }
    }
}
