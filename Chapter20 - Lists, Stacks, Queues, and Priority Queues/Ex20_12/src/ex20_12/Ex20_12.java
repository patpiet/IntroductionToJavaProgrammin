/*
    (Clone PriorityQueue) Define MyPriorityQueue class that extends
    PriorityQueue to implement the Cloneable interface and implement the
    clone() method to clone a priority queue.
 */
package ex20_12;

/**
 *
 * @author patpiet
 */
public class Ex20_12 {

    public static void main(String[] args) throws CloneNotSupportedException {
        MyPriorityQueue<String> q = new MyPriorityQueue<>();
        q.offer("John");
        q.offer("Mark");
        q.offer("Kirsten");
        
        System.out.println(q.clone());
    }
    
}
