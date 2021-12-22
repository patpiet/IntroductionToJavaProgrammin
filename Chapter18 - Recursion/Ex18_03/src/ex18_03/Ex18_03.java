/*
    (Compute greatest common divisor using recursion) The gcd(m, n) can also
    be defined recursively as follows:
    ■ If m % n is 0, gcd(m, n) is n.
    ■ Otherwise, gcd(m, n) is gcd(n, m % n).
    Write a recursive method to find the GCD. Write a test program that prompts the
    user to enter two integers and displays their GCD.
 */
package ex18_03;

import java.util.Scanner;

public class Ex18_03 {

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        // ask for two integers
        System.out.print("Enter two integers for gcd: ");
        int m = input.nextInt();
        int n = input.nextInt();
    
        System.out.println("The greates common divisor for these integers is: " + gcd(m, n));
    }
    
    // returns greates common divisor
    public static int gcd(int m, int n){
        if(m % n == 0){   // base case
            return n;
        }else{
            return gcd(n, m % n);   // recursive call
        }
    }
}
