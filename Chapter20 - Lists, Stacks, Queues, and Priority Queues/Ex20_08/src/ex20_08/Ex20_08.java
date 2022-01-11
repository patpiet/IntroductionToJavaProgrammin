/*
    (Game: lottery) Revise Programming Exercise 3.15 to add an additional $2,000
    award if two digits from the user input are in the lottery number. (Hint: Sort
    the three digits in the lottery number and three digits in the user input into two
    lists, and use the Collection’s containsAll method to check whether the
    two digits in the user input are in the lottery number.)
 */
/*  Ex3.15
    (Game: lottery) Revise Listing 3.8, Lottery.java, to generate a lottery of a threedigit
    number. The program prompts the user to enter a three-digit number and
    determines whether the user wins according to the following rules:
    1. If the user input matches the lottery number in the exact order, the award is
    $10,000.
    2. If all digits in the user input match all digits in the lottery number, the award is
    $3,000.
    3. If one digit in the user input matches a digit in the lottery number, the award is
    $1,000.
 */
package ex20_08;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author patpiet
 */
public class Ex20_08 {

    public static void main(String[] args) {
        // Create random 3digit number
        Random random = new Random();
        int x = random.nextInt(900) + 100;
        System.out.println(x);

        // Create scanner 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 3 digit number: ");
        int number = input.nextInt();
        // Create lists to store digits of lotter number and user's number
        ArrayList<Integer> randomDigits = new ArrayList<>();
        splitDigits(randomDigits, x);
        ArrayList<Integer> userDigits = new ArrayList<>();
        splitDigits(userDigits, number);

        
        if(number == x)     // Same number 
            System.out.println("You won 10,000$!");
        else if(randomDigits.containsAll(userDigits))   // 3 digits the same
            System.out.println("You won 3,000$!");
        else if(isTwoDigits(randomDigits, userDigits)) {    // 2 digits the same
            System.out.println("You won 2,000$!");
        }
        else if(randomDigits.contains(userDigits.get(0)) ||
                randomDigits.contains(userDigits.get(1)) ||
                randomDigits.contains(userDigits.get(2)) )  // 1 digit the same
            System.out.println("You won 1,000$");
        
    }
    
    public static void splitDigits(ArrayList<Integer> list, int x){
        list.add(x % 10);
        x /=10;
        list.add(x % 10);
        x /=10;
       list.add(x % 10);
        x /=10;
    }

    private static boolean isTwoDigits(ArrayList<Integer> randomDigits, ArrayList<Integer> userDigits) {
        ArrayList<Integer> copy = new ArrayList<>(randomDigits);
        copy.removeAll(userDigits);
        
        if(copy.size() == 1){
            return true;
        }else 
            return false;
        
    }
}
