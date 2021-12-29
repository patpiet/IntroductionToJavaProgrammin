/*
    (Distinct elements in ArrayList) Write the following method that returns a new
    ArrayList. The new list contains the non-duplicate elements from the original list.
   
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
 */
package ex19_03;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author patpiet
 */
public class Ex19_03 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 5 ,6 ,5 ,7 ,4));
        
        System.out.println(list.toString());
        
        System.out.println(removeDuplicates(list).toString());
    }
    
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        ArrayList<E> newList = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++) {
            if(!newList.contains(list.get(i))){
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}
