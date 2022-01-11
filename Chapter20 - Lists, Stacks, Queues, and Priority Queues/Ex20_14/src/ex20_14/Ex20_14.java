/*
    (Postfix notation) Postfix notation is a way of writing expressions without
    using parentheses. For example, the expression (1 + 2) * 3 would be
    written as 1 2 + 3 *. A postfix expression is evaluated using a stack. Scan a
    postfix expression from left to right. A variable or constant is pushed into the
    stack. When an operator is encountered, apply the operator with the top two
    operands in the stack and replace the two operands with the result. The following
    diagram shows how to evaluate 1 2 + 3 *.

    Write a program to evaluate postfix expressions. Pass the expression as a
    command-line argument in one string.
 */
package ex20_14;

import java.util.Stack;

/**
 *
 * @author patpiet
 */
public class Ex20_14 {

    public static void main(String[] args) {
        String expression = "";
        for (int i = 0; i < args.length; i++) {
            expression += args[i];
        }
        
        String[] parts = expression.split(" ");
        // Create a stack to store a variable
        Stack<String> stack = new Stack<>();
    
        // Loop through each part
        for(String part: parts){
            if(!"+".equals(part) && !"-".equals(part) &&
               !"*".equals(part) && !"/".equals(part)){
                stack.push(part);
            }else{
                switch(part){
                    case "+": add(stack); break;
                    case "-": substitute(stack); break;
                    case "*": multiply(stack); break;
                    case "/": divide(stack); break;
                }
            }
        }
        
        System.out.println(stack.pop());
    }

    private static void add(Stack<String> stack) {
        int number = 0;
        for (int i = 0; i <= stack.size(); i++) {
            number += Integer.parseInt(stack.pop());
        }
        stack.push(number + "");
    }

    private static void substitute(Stack<String> stack) {
        int number = 0;
        for (int i = 0; i <= stack.size(); i++) {
            number -= Integer.parseInt(stack.pop());
        }
        stack.push(number + "");
    }

    private static void multiply(Stack<String> stack) {
        int number = 1;
        for (int i = 0; i <= stack.size(); i++) {
            number *= Integer.parseInt(stack.pop());
        }
        stack.push(number + "");
    }

    private static void divide(Stack<String> stack) {
        int number = 1;
        for (int i = 0; i <= stack.size(); i++) {
            number /= Integer.parseInt(stack.pop());
        }
        stack.push(number + "");

    }

    
}
