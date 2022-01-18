/*
    (Pattern matching) Write a program that prompts the user to enter two strings
    and tests whether the second string is a substring of the first string. (Don’t use
    the indexOf method in the String class.) Analyze the time complexity of
    your algorithm.
 */
package ex22_04;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex22_04 {

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string s1: ");
        String s1 = input.nextLine();
        System.out.print("Enter a string s2: ");
        String s2 = input.nextLine();

        System.out.println("matched at index " + getMatch(s1, s2));
    }

    public static int getMatch(String s1, String s2) {
        // Counts number of characters matched in a row
        int count = 0;
        // Stores index of first character of s2 in s1
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(count)) {
                if (count == 0) {
                    index = i;
                }
                count++;
                if (count == s2.length()) {
                    return index;
                }
            } else {
                // Case when neighboring characters are the same
                if(s1.charAt(i) == s2.charAt(0)){ 
                    count = 1;
                    index = i;
                }else{
                    count = 0;
                }
            }
        }
        return -1;
    }

}
