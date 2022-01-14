/*
    (Count the occurrences of numbers entered) Write a program that reads an
    unspecified number of integers and finds the one that has the most occurrences.
    The input ends when the input is 0. For example, if you entered 2 3 40 3 5 4 –3
    3 3 2 0, the number 3 occurred most often. If not one but several numbers have
    the most occurrences, all of them should be reported. For example, since 9 and 3
    appear twice in the list 9 30 3 9 3 2 4, both occurrences should be reported.
 */
package ex21_06;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author patpiet
 */
public class Ex21_06 {

    public static void main(String[] args) {
        // Create map
        Map<Integer, Integer> map = new HashMap<>();

        // Create scanner
        Scanner input = new Scanner(System.in);

        int number;

        // Ask for numbers
        do {
            // Read number
            number = input.nextInt();
            // Check number if != 0
            if (number != 0) {
                // Number not in map yet case
                if (!map.containsKey(number)) {
                    map.put(number, 1);
                // Number already in map case
                } else {
                    map.put(number, map.get(number) + 1);
                }
            }
        } while (number != 0);
        
        // Get max value from the map
        int max = Collections.max(map.values());

        // Print most occurences keys
        System.out.println("Most appearences: " + getMaxKeys(map, max));
    }
    
    // Returns set of integers that appeared the most in the input
    private static Set<Integer> getMaxKeys(Map<Integer, Integer> map, int max) {
        Set<Integer> maxKeys = new HashSet<>();
        // Loop through the map
        map.forEach((k, v) ->{
            if(v == max){
                maxKeys.add(k);
            }
        });
        
        return maxKeys;
    }


}
