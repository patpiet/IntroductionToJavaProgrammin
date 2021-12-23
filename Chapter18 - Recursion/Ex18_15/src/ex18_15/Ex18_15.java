/*
    (Occurrences of a specified character in a string) Rewrite Programming Exercise
    18.10 using a helper method to pass the substring high index to the method.
    The helper method header is:

    public static int count(String str, char a, int high)
 */
package ex18_15;

/**
 *
 * @author patpiet
 */
public class Ex18_15 {

    public static void main(String[] args) {
        System.out.println(count("Welcome", 'e'));
    }

    public static int count(String str, char a) {
        if (str.length() == 0) { // base case
            return 0;
        } else {
            if (str.charAt(0) == a) {  // count if the characters are the same
                return 1 + count(str.substring(1, str.length()), a);  // recursive call
            }
            return 0 + count(str.substring(1, str.length()), a);  // recursive call
        }
    }
    
}
