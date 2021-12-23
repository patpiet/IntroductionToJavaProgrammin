/*
    (Find the number of uppercase letters in an array) Write a recursive method
    to return the number of uppercase letters in an array of characters. You need to
    define the following two methods. The second one is a recursive helper method.

    public static int count(char[] chars)
    public static int count(char[] chars, int high)
   
    Write a test program that prompts the user to enter a list of characters in one line
    and displays the number of uppercase letters in the list.
 */
package ex18_16;

/**
 *
 * @author patpiet
 */
public class Ex18_16 {

    public static void main(String[] args) {
        char[] array = {'A', 'f', 'f', 'K'};
        
        
        System.out.println(count(array));
        
    }
    
    public static int count(char[] chars){
        return count(chars, chars.length - 1);  // recursive helper method
    }
    
    public static int count(char[] chars, int high){
        if(high == 0){
            return (Character.isUpperCase(chars[high])) ? 1 : 0;
        }else{
            return (Character.isUpperCase(chars[high])) ?
                    1 + count(chars, high - 1) : count(chars, high - 1);
        }
    }
}
