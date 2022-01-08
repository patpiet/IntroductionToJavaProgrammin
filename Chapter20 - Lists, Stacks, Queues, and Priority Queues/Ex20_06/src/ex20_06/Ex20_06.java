/*
    (Use iterators on linked lists) Write a test program that stores 5 million integers
    in a linked list and test the time to traverse the list using an iterator vs. using
    the get(index) method.
 */
package ex20_06;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author patpiet
 */
public class Ex20_06 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        
        assignNumbers(list);
        Iterator<Integer> iterator = list.iterator();
        
        
        long start = System.currentTimeMillis();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        
        
        
        long start2 = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        long finish2 = System.currentTimeMillis();
        long timeElapsed2 = finish - start;
        System.out.println("Iterator");
        System.out.println(timeElapsed);
        System.out.println("GET");
        System.out.println(timeElapsed2);
        
        

    }

    public static void assignNumbers(LinkedList<Integer> list) {
        for (int i = 0; i < 5000000; i++) {
            list.add((int) (Math.random() * 10000));
        }
    }
}
