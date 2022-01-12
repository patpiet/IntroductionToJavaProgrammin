/*
    (Count the keywords in Java source code) Revise the program in Listing 21.7. If
    a keyword is in a comment or in a string, don’t count it. Pass the Java file name
    from the command line. Assume that the Java source code is correct and line
    comments and paragraph comments do not overlap.
 */
package ex21_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/*
 *
 * @author patpiet
 */
public class Ex21_03 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create file
        File file = new File(args[0]);

        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(0);
        }

        
        System.out.println("Number of keywords in the file: " + countKeywords(file));
    }

    private static int countKeywords(File file) throws FileNotFoundException {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"while", "try"};

        Set<String> set = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        Stack<String> stack = new Stack<>(); 
        
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String word = input.next();
                // Check for comments 
                if(word.contains("//")){
                    input.nextLine();
                    continue;
                }else if(word.contains("/*")){
                    stack.push("/*");
                }else if(word.contains("*/")){
                    stack.pop();
                }
                // Check for quotation mark
                else if(word.contains("\"")){
                    // Even number of marks - then continue
                    if(countMark(word) % 2 == 0){
                        continue;
                    }
                    else if(stack.contains("\"")){
                        stack.remove("\"");
                    }else{
                        stack.push("\"");
                    }
                }
                // Scan the word if stack is not empty
                if(stack.isEmpty()){
                    if(set.contains(word))
                        count++;
                }
            }
        }
        return count;
    }
    // Returns number of quotation marks in the string
    private static int countMark(String str) {
        int count = 0;
        for(Character ch: str.toCharArray()){
            if(ch == '"')
                count++;
        }
        return count;
    }

}
