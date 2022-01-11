/*
    Cloneable PriorityQueue
 */
package ex20_12;

import java.util.PriorityQueue;

/**
 *
 * @author patpiet
 */
public class MyPriorityQueue<T> extends PriorityQueue<T> implements Cloneable{
    @Override
    public MyPriorityQueue<T> clone() throws CloneNotSupportedException{
        return (MyPriorityQueue<T>) super.clone();
    }
}
