/*
    (Same-number subsequence) Write an O(n) program that prompts the user to
    enter a sequence of integers ending with 0 and finds the longest subsequence
    with the same number. Here is a sample run of the program:
 */
package ex22_05;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex22_05 {

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        boolean isTrue = true;
        int number;
        System.out.println("Enter a series of numbers ending with 0: ");
        do {
            number = input.nextInt();
            if(number != 0){
                list.add(number);
            }else{
                isTrue = false;
            }
        } while (isTrue);
        
        displaySequence(list);
    }
    
    public static void displaySequence(ArrayList<Integer> list){
        int index = -1, countTemp, value, tempIndex, count = 0, tempValue;
        value = list.get(0);
        tempIndex = 0;
        countTemp = 1;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) == list.get(i- 1)){
                if(countTemp == 1){
                    tempIndex = i - 1;
                }
                countTemp++;
                tempValue = list.get(i);
                if(countTemp > count){
                    count = countTemp;
                    index = tempIndex;
                    value = tempValue;
                }
                
            } else{
                tempValue = list.get(i);
                countTemp = 1;
                tempIndex = i;
                
            }
        }
        System.out.println("The longest same number sequence start at index " + index
                            + " with " + count + " values of " + value);
    }
}
