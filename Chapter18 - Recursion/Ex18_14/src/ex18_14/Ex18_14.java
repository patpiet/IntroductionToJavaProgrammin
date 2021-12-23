/*
    (Find the number of uppercase letters in a string) Write a recursive method
    to return the number of uppercase letters in a string. Write a test program that
    prompts the user to enter a string and displays the number of uppercase letters in
    the string.
 */
package ex18_14;

/**
 *
 * @author patpiet
 */
public class Ex18_14 {

    public static void main(String[] args) {
        System.out.println(uppercaseCount("Hi, Its 3 Uppercases"));
    }
    
    
    public static int uppercaseCount(String str){
        return uppercaseCount(str, str.length() - 1);   // recursive helper method 
    }
    
    public static int uppercaseCount(String str, int high){
        if(high == 0){      /// base case
            return ( Character.isUpperCase(str.charAt(high)) ) ? 1 : 0;   
        }
        else{
            return (Character.isUpperCase(str.charAt(high))) ?  // recursive call
                    1 + uppercaseCount(str, high - 1) : uppercaseCount(str, high - 1);
        }
    }
}
