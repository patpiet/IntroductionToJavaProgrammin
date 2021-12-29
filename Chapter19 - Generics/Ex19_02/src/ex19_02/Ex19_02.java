/*
    (Implement GenericStack using inheritance) In Listing 19.1, GenericStack is
    implemented using composition. Define a new stack class that extends ArrayList.
    Draw the UML diagram for the classes and then implement GenericStack.
    Write a test program that prompts the user to enter five strings and displays them in
    reverse order.
 */
package ex19_02;

import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex19_02 {

    public static void main(String[] args) {
            // Create stack
        GenericStack<String> stackOfStrings = new GenericStack<>();
        
        // Create scanner
        Scanner input = new Scanner(System.in);
        // ask for input
        System.out.print("Enter 5 strings: ");
        
        for (int i = 0; i < 5; i++) {
            stackOfStrings.push(input.next());
        }
        
        // display in reverse order
        for (int i = 0; i < 5; i++) {
            System.out.print(stackOfStrings.pop() + " ");
        }
    }
    
}
