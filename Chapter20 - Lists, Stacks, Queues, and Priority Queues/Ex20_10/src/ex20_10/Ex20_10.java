/*
    (Perform set operations on priority queues) Create two priority queues,
    {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and
    {"George", "Katie", "Kevin", "Michelle", "Ryan"}, and find their
    union, difference, and intersection.
 */
package ex20_10;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author patpiet
 */
public class Ex20_10 {

    public static void main(String[] args) {
        PriorityQueue<String> queue1 = new PriorityQueue<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        PriorityQueue<String> queue2 = new PriorityQueue<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));
    
        System.out.println("UNION: ");
        System.out.println(getUnion(queue1, queue2));
        
        System.out.println("DIFFERENCE");
        System.out.println(getDifference(queue1, queue2));

        System.out.println("INTERSECTION");
        System.out.println(getIntersection(queue1, queue2));
        
    }
    
    public static PriorityQueue<String> getUnion(PriorityQueue<String> q1, PriorityQueue<String> q2){
        PriorityQueue<String> temp = new PriorityQueue<>(q1);
        temp.addAll(q2);
        
        return temp;
    }

    private static PriorityQueue<String> getDifference(PriorityQueue<String> q1, PriorityQueue<String> q2) {
        PriorityQueue<String> temp = new PriorityQueue<>();
        
        for(String str: q2){
            if(!q1.contains(str))
                temp.offer(str);
        }
        
        return temp;
    }
    public static PriorityQueue<String> getIntersection(PriorityQueue<String> q1, PriorityQueue<String> q2){
        PriorityQueue<String> temp = new PriorityQueue<>(q1);
        temp.retainAll(q2);
        
        return temp;
    }
}
