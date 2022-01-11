/*
    (Match grouping symbols) A Java program contains various pairs of grouping
    symbols, such as:

    ■ Parentheses: ( and )
    ■ Braces: { and }
    ■ Brackets: [ and ]
    
    Note that the grouping symbols cannot overlap. For example, (a{b)} is illegal.
    Write a program to check whether a Java source-code file has correct pairs of
    grouping symbols. Pass the source-code file name as a command-line argument.
 */
package ex20_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author patpiet
 */
public class Ex20_11 {

    public static void main(String[] args) {
        File file = new File("java.txt");
        
        // Create stack to store operators
        Stack<Character> list = new Stack<>();
        
        try(Scanner input = new Scanner(file)){
            // loop through all lines in the file
            while(input.hasNext()){
                String line = input.nextLine();
                // loop through each character in the line
                for (int i = 0; i < line.length(); i++) {
                    // Continue if the character is an operator
                    if(line.charAt(i) == '{' || 
                       line.charAt(i) == '}' ||
                       line.charAt(i) == '(' ||
                       line.charAt(i) == ')' ||
                       line.charAt(i) == '[' || 
                       line.charAt(i) == ']'){
                       if(list.isEmpty()){      // Empty list case
                           list.push(line.charAt(i));
                       }else if(list.peek() == '('){    // When the top of stack is '('
                           if(line.charAt(i) == ')'){   // Clear the stack
                               list.pop();
                            }else if(line.charAt(i) != '{' || line.charAt(i) != '['){
                               list.push(line.charAt(i));   
                           }
                       }
                       else{ // '[' or '{' on top of the stack
                           if((int) list.peek() + 2 == (int) line.charAt(i)){
                               list.pop();
                           }else if(line.charAt(i) == '{' ||
                                   line.charAt(i) == '(' ||
                                   line.charAt(i) == '[' ){
                               list.push(line.charAt(i));
                           }
                           else{
                               System.out.println("false");
                               System.exit(1);
                           }
                       }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
        
        System.out.println("true");
    }
    
}
