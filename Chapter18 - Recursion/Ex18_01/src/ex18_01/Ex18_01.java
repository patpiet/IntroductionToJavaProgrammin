/*
    (Factorial) Using the BigInteger class introduced in Section 10.9, you can
    find the factorial for a large number (e.g., 100!). Implement the factorial
    method using recursion. Write a program that prompts the user to enter an integer
    and displays its factorial.
 */
package ex18_01;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex18_01 {

    public static void main(String[] args) {
        // Create scanner   
        Scanner input = new Scanner(System.in);
        // ask for integer
        System.out.println("Enter integer: ");
        String number = input.next();
        
        BigInteger integer = new BigInteger(number);
        // display factorial of integer
        System.out.println("The factorial is: " + factorial(integer).toString() );
    }

    // returns BigInteger factorial
    public static BigInteger factorial(BigInteger num){
        if(num.intValue() <= 1){ // base case
            return num;
        }else{
            return num.multiply(factorial(num.subtract(new BigInteger("1")))); // recursive call
        }
        
        
    }
}
