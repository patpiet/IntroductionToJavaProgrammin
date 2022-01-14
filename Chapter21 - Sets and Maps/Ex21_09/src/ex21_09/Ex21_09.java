/*
    (Guess the capitals using maps) Rewrite Programming Exercise 8.37 to store
    pairs of each state and its capital in a map. Your program should prompt the user
    to enter a state and should display the capital for the state.
 */
package ex21_09;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex21_09 {
    static String[][] d = {
        {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
        {"Arkansas", "Little Rock"}, {"California", "Sacramento"},
        {"Colorado", "Denver"}, {"Connecticut", "Hartford"},
        {"Delaware", "Dover"}, {"Florida", "Tallahassee"},
        {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
        {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
        {"Iowa Des", "Moines"}, {"Kansas", "Topeka"}, {"Kentucky", "Frankfort"},
        {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"},
        {"Maryland", "Annapolis"}, {"Massachusetts", "Boston"},
        {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"},
        {"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"},
        {"Montana", "Helena"}, {"Nebraska", "Lincoln"},
        {"Nevada", "Carson City"}, {"New Hampshire", "Concord"},
        {"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"},
        {"New York", "Albany"}, {"North Carolina", "Raleigh"},
        {"North Dakota", "Bismarck"}, {"Ohio", "Columbus"},
        {"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"},
        {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"},
        {"South Carolina", "Columbia"}, {"South Dakota", "Pierre"},
        {"Tennessee", "Nashville"}, {"Texas", "Austin"},
        {"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"},
        {"Virginia", "Richmond"}, {"Washington", "Olympia"},
        {"West Virginia", "Charleston"}, {"Wisconsin", "Madison"},
        {"Wyoming", "Cheyenne"}};

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        
        Map<String, String> data = getData();
        
        data.forEach((k, v) ->{
            System.out.println("What is the capital of " + k + "?");
            String guess = input.nextLine();
            if(guess.equals(v)){
                System.out.println("You are right! The capital of " + k + " is " + v);
            }else{
                System.out.println("Wrong. The capital of " + k + " is " + v);
            }
            System.out.println("");
        });
    }

    private static HashMap<String, String> getData() {
        HashMap<String, String> map = new HashMap<>();

        for(String[] ds: d){
            map.put(ds[0], ds[1]);
        }
        
        return map;
    }

}
