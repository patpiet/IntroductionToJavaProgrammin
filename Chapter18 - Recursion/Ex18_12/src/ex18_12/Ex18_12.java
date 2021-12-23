/*
    (Print the characters in a string reversely) Rewrite Programming Exercise 18.9
    using a helper method to pass the substring high index to the method. The
    helper method header is:
    public static void reverseDisplay(String value, int high)
 */
package ex18_12;

/**
 *
 * @author patpiet  
 */
public class Ex18_12 {

    public static void main(String[] args) {
        reverseDisplay("siema");
    }
    
    public static void reverseDisplay(String value){
        reverseDisplay(value, value.length() - 1);
    }
    
    public static void reverseDisplay(String value, int high){
        if(high == 0){              // base case
            System.out.print(value.charAt(high));
        }
        else{
            System.out.print(value.charAt(high));
            reverseDisplay(value, high  - 1);       // recursive call
        }
    }
}
