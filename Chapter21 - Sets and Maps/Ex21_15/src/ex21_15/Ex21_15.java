/*
    (Addition quiz) Rewrite Programming Exercise 11.16 to store the answers in a
    set rather than a list.
 */
package ex21_15;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author patpiet
 */
public class Ex21_15 {


    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        
        // Create list to store answers
        Set<Integer> answers = new HashSet<>();
        // Create random integers
        int num1 = (int) (Math.random() * 10);
        int num2 = (int) (Math.random() * 10);
        
        int answer = num1 + num2;
        int guess;
        
        // Ask user to answer
        System.out.print("What is " + num1 + " + " + num2 + "? ");
        
        do {
            guess = input.nextInt();
            
            // When the guess appears again
            if(guess != answer && answers.contains(guess)){
                System.out.println("You already entered " + guess );
                System.out.print("Wrong answer. Try Again. What is " + num1 + " + " + num2 + "? ");
            }
            else if(guess != answer){
                System.out.print("Wrong answer. Try Again. What is " + num1 + " + " + num2 + "? ");
                answers.add(guess);
            }
            
        } while (guess != answer);
        
        System.out.println("You got it!");
        
    }
    
}
