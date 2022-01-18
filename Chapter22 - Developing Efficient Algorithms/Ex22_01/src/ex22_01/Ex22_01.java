/*
    (Maximum consecutive increasingly ordered substring) Write a program that
    prompts the user to enter a string and displays the maximum consecutive
    increasingly ordered substring. Analyze the time complexity of your program.

================================================================================
                        TIME COMPLEXITY ANALYSIS
================================================================================

                    Time complexity is O(n)
    As the length of the string grows, the time will grow lineary 
    
 */
package ex22_01;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex22_01 {

    public static void main(String[] args) {
        // Create scanner   
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = input.next();

        System.out.println(getSub(str));

    }

    public static String getSub(String str) {
        String sub = "";
        String temp = "";

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) < str.charAt(i) && i != str.length() - 1) {
                temp += str.charAt(i - 1);
            } else {
                temp += str.charAt(i - 1);

                if (i == str.length() - 1) {
                    temp += str.charAt(i);
                }

                if (temp.length() >= sub.length()) {
                    sub = temp;
                }
                temp = "";
            }
        }
        return sub;
    }
}
