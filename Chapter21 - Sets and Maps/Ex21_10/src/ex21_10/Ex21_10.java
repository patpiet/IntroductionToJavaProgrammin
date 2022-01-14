/*
    (Count the occurrences of each keyword) Rewrite Listing 21.7 CountKeywords.
    java to read in a Java source code file and count the occurrence of each keyword
    in the file, but don’t count the keyword if it is in a comment or in a string literal.
 */
package ex21_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author patpiet
 */
public class Ex21_10 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create file
        File file = new File(args[0]);

        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(0);
        }

        countKeywords(file).forEach((k, v) -> {
            System.out.println(k + "\t" + v);
        });

    }

    private static HashMap<String, Integer> countKeywords(File file) throws FileNotFoundException {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

        Set<String> set = new HashSet<>(Arrays.asList(keywordString));

        HashMap<String, Integer> map = new HashMap<>();

        Stack<String> stack = new Stack<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String word = input.next();
                // Check for comments 
                if (word.contains("//")) {
                    input.nextLine();
                    continue;
                } else if (word.contains("/*")) {
                    stack.push("/*");
                } else if (word.contains("*/")) {
                    stack.pop();
                } // Check for quotation mark
                else if (word.contains("\"")) {
                    // Even number of marks - then continue
                    if (countMark(word) % 2 == 0) {
                        continue;
                    } else if (stack.contains("\"")) {
                        stack.remove("\"");
                    } else {
                        stack.push("\"");
                    }
                }
                // Scan the word if stack is not empty AND
                // it is a keyword
                if (stack.isEmpty() && set.contains(word)) {
                    if (!map.containsKey(word)) {
                        map.put(word, 1);
                    } else {
                        map.put(word, map.get(word) + 1);
                    }
                }
            }
        }
        return map;
    }

    // Returns number of quotation marks in the string
    private static int countMark(String str) {
        int count = 0;
        for (Character ch : str.toCharArray()) {
            if (ch == '"') {
                count++;
            }
        }
        return count;
    }
}
