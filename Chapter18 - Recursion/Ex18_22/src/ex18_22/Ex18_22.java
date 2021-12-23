/*
    (Decimal to hex) Write a recursive method that converts a decimal number into
    a hex number as a string. The method header is:

    public static String dec2Hex(int value)

    Write a test program that prompts the user to enter a decimal number and displays
    its hex equivalent
 */
package ex18_22;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex18_22 {

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        // ask for decimal number
        System.out.println("Enter decimal number: ");
        int value = input.nextInt();
        
        // output
        System.out.println("The hex equivalent is: " + dec2Hex(value));
        
    }
    
    public static String dec2Hex(int value){
        if(value == 0){     // base case
            return "";
        }else{
            return dec2Hex(value / 16) + checkHex(value % 16);  // recursive call
        }
    }
    // Change value to hexadecimal
    private static String checkHex(int value) {
        switch(value){
            case 10: return "A";
            case 11: return "B";
            case 12: return "C";
            case 13: return "D";
            case 14: return "E";
            case 15: return "F";
            default: return value + "";
        }
    }
}
