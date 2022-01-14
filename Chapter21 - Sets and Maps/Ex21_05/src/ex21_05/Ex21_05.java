/*
    (Syntax highlighting) Write a program that converts a Java file into an HTML
    file. In the HTML file, the keywords, comments, and literals are displayed in
    bold navy, green, and blue, respectively. Use the command line to pass a Java file
    and an HTML file. For example, the following command
    java Exercise21_05 Welcome.java Welcome.html
    converts Welcome.java into Welcome.html.
 */
package ex21_05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author patpiet
 */
public class Ex21_05 {
    private static final String[] KEY_WORDS = {"abstract", "assert", "boolean",
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static",
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};

    public static void main(String[] args) throws FileNotFoundException {
        // Create file objects
        File javaFile = new File(args[0]);
        File htmlFile = new File(args[1]);


        // Store all java lines
        ArrayList<String> javaLines = getLines(javaFile);
        // Store html lines
        ArrayList<String> htmlLines = mapJavaToHtml(javaLines);
        
        // Write lines to html file
        try(PrintWriter output = new PrintWriter(htmlFile);){
            for(String htmlLine: htmlLines){
                output.write(htmlLine);
            }
        }
    }
    // Returns list of all lines from the file
    private static ArrayList<String> getLines(File file) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>();
        
        try(Scanner input = new Scanner(file)){
            while(input.hasNext()){
                lines.add(input.nextLine());
            }
        }
        return lines;
    }
    // Returns list with html lines mapped from java
    private static ArrayList<String> mapJavaToHtml(ArrayList<String> javaLines) {
        // Store keywords
        Set<String> keywordsSet = new HashSet<>(Arrays.asList(KEY_WORDS));
        // Store html Lines
        ArrayList<String> htmlLines = new ArrayList<>();
        // Create the base of html
        htmlLines.add("<!DOCTYPE html>");
        htmlLines.add("<html>");
        htmlLines.add("<head>");
        htmlLines.add("<style>");
        htmlLines.add("div{display: inline-block}");
        htmlLines.add("</style>");
        htmlLines.add("<title>Ex21_05</title>");
        htmlLines.add("</head>");
        htmlLines.add("<body>");
        
        // Loop through each java line
        for(String line: javaLines){
            StringBuilder lineBuilder = new StringBuilder();
            
            lineBuilder.append("<div>");
            
            String[] words = line.split(" ");
            
            for (int i = 0; i < words.length; i++) {
                
                // Comment case
                if(words[i].startsWith("//")){
                    lineBuilder.append("<div style = \"font-weight: bold; color: green;\">");
                    
                    while(i < words.length){
                        lineBuilder.append(words[i++]).append("&nbsp");
                    }
                    lineBuilder.append("</div>");
                    continue;
                }
                // Keyword case
                if(keywordsSet.contains(words[i])){
                    lineBuilder.append("<div style = \"font-weight: bold; color: navy;\">");
                    lineBuilder.append(words[i]).append("&nbsp");
                    lineBuilder.append("</div>");
                    continue;
                }
                // Literal case
                if(words[i].startsWith("\"")){
                    lineBuilder.append("<div style = \"font-weight: bold; color: blue;\">");
                    while(!words[i].endsWith("\"")){
                        lineBuilder.append(words[i++]).append("&nbsp");
                    }
                    lineBuilder.append(words[i]);
                    lineBuilder.append("</div>");
                    continue;
                }
                
                if(words[i].isEmpty()){
                    lineBuilder.append("&nbsp");
                }else{
                    lineBuilder.append(words[i]).append("&nbsp");
                }
                
            }
            htmlLines.add(lineBuilder + "</div><br>");
        }
        htmlLines.add("</body>");
        htmlLines.add("</html>");
        
        return htmlLines;
    }


}
