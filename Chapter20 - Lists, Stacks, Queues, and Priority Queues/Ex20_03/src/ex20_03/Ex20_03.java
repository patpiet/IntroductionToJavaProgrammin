/*
    (Guessing the capitals) Rewrite Programming Exercise 8.37 to store the pairs
    of states and capitals so that the questions are displayed randomly.
 */
package ex20_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author patpiet
 */
public class Ex20_03 {

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        // Store states and its capitals
        String[][] statesCapitals = getData();

        // Initialize list with 0-49 values in it
        Stack<Integer> stack = new Stack<>();
        fillStack(stack);
        // shuffle the stack
        Collections.shuffle(stack);
        
        // Count correct answers
        int count = 0;
        
        for (int i = 0; i < statesCapitals.length; i++) {
            // assign the last value from stack to index
            int index = stack.pop();
            System.out.printf("What is the capital of %s? ", statesCapitals[index][0]);
            String capital = input.nextLine().toLowerCase();
            
            if(capital.equals(statesCapitals[index][1].toLowerCase())){
                System.out.println("The answer is correct.");
                count++;
            }
            else{
                System.out.printf("The correct answer should be %s\n", statesCapitals[index][1]);
            }
        }
        System.out.println("The correct count is " + count);
        
    }
    // Returns array with 50 states and its Capitals
    public static String[][] getData(){
		String[][] d = {
			{"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
			{"Arkansas", "Little Rock"}, {"California", "Sacramento"},
			{"Colorado", "Denver"}, {"Connecticut", "Hartford"}, 
			{"Delaware", "Dover"}, {"Florida", "Tallahassee"}, 
			{"Georgia", "Atlanta"},{"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
			{"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
			{"Iowa Des", "Moines"}, {"Kansas", "Topeka"}, {"Kentucky","Frankfort"}, 
			{"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"}, 
			{"Maryland", "Annapolis"}, {"Massachusetts", "Boston"}, 
			{"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"}, 
			{"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"}, 
			{"Montana", "Helena"}, {"Nebraska", "Lincoln"}, 
			{"Nevada	", "Carson City"}, {"New Hampshire", "Concord"}, 
			{"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"}, 
			{"New York", "Albany"}, {"North Carolina", "Raleigh"}, 
			{"North Dakota", "Bismarck"},{"Ohio", "Columbus"},
			{"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"}, 
			{"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"}, 
			{"South Carolina", "Columbia"}, {"South Dakota", "Pierre"}, 
			{"Tennessee", "Nashville"}, {"Texas", "Austin"}, 
			{"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"}, 
			{"Virginia", "Richmond"}, {"Washington", "Olympia"}, 
			{"West Virginia", "Charleston"}, {"Wisconsin", "Madison"}, 
			{"Wyoming", "Cheyenne"}};
                return d;
    }

    private static void fillStack(Stack<Integer> stack) {
        for (int i = 0; i < 50; i++) {
            stack.add(i);
        }
    }
    
}
