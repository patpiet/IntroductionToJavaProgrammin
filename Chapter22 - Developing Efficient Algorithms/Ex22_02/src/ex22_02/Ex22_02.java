/*
    Maximum increasingly ordered subsequence) Write a program that prompts
    the user to enter a string and displays the maximum increasingly ordered subsequence
    of characters. Analyze the time complexity of your program.
 */
package ex22_02;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex22_02 {

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = input.next();
        
        System.out.println(getSub(str));
    }
    
    public static String getSub(String str){
        char chTemp = str.charAt(0);
        String result = chTemp + ""; 
        
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) > chTemp){
                result += str.charAt(i);
                chTemp = str.charAt(i);
            }
        }
        return result;
    }
}
