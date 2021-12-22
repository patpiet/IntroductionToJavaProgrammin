/*
    (Occurrences of a specified character in a string) Write a recursive method that
    finds the number of occurrences of a specified letter in a string using the following
    method header:
    public static int count(String str, char a)
    For example, count("Welcome", 'e') returns 2. Write a test program that
    prompts the user to enter a string and a character, and displays the number of
    occurrences for the character in the string.
 */
package ex18_10;

/**
 *
 * @author patpiet
 */
public class Ex18_10 {

    public static void main(String[] args) {
        System.out.println(count("Welcome", 'e'));

    }

    public static int count(String str, char a) {
        if (str.length() == 0) { // base case
            return 0;
        }else{
            if (str.charAt(0) == a) {  // count if the characters are the same
                return 1 + count(str.substring(1, str.length()), a);  // recursive call
            }
            return 0 + count(str.substring(1, str.length()), a);  // recursive call
        }
    }
}
