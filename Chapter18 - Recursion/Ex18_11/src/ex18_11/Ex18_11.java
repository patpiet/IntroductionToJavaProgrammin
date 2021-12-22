/*
    (Sum the digits in an integer using recursion) Write a recursive method that
    computes the sum of the digits in an integer. Use the following method header:
    public static int sumDigits(long n)
    For example, sumDigits(234) returns 2 + 3 + 4 = 9. Write a test program
    that prompts the user to enter an integer and displays its sum.
*/
package ex18_11;

/**
 *
 * @author paptiet
 */
public class Ex18_11 {

    public static void main(String[] args) {
            System.out.println(sumDigits(2345));
        }
    
    public static int sumDigits(long n){
        if(n / 10 == 0){    // base cse
            return (int) n;
        }else{
            return (int) (n % 10 + sumDigits(n / 10));  // recursive call
        }
    }
}
