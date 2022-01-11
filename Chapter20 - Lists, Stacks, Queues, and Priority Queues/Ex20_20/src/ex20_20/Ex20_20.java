/*
    (Directory size) Rewrite Programming Exercise 20.18 using a stack instead of
    a queue.
 */
package ex20_20;

import java.io.File;
import java.util.Stack;

/**
 *
 * @author patpiet
 */
public class Ex20_20 {

    public static void main(String[] args) {
        File directory = new File("directory");
        System.out.println(getSize(directory)); 
    }
    
    public static long getSize(File directory){
        // Store the size of the directroy
        long size = 0;
        // Add the directory to the queue
        Stack<File> stack = new Stack<>();
        stack.push(directory);
        
        // Loop until stack is empty
        while(!stack.isEmpty()){
            // Store the first file in the stack
            File temp = stack.pop();
            
            if(temp.isFile()){  // The file is not a directory
                size += temp.length();
            }else{              // The file is a directory
                // Loop through directory
                for(File sub: temp.listFiles()){
                    // Push each file to the stack
                    stack.push(sub);
                }
            }
        }
        return size;
    }
}
