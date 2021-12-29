/*
    (Revising Listing 19.1) Revise the GenericStack class in Listing 19.1 to implement
    it using an array rather than an ArrayList. You should check the array size
    before adding a new element to the stack. If the array is full, create a new array that
    doubles the current array size and copy the elements from the current array to the
    new array.
 */
package ex19_01;

import java.util.Arrays;

/**
 *
 * @author patpiet
 * @param <E>
 */
public class GenerickStack<E> {
    private E[] list;
    private static int index = 0; 
    
    // constructor with an class' object that will the stack work with
    public GenerickStack() {
        list = (E[]) new Object[5];
    }
    // return stack'size
    public int getSize(){
        return index ;
    }
    // returns the last element in stack
    public E peek(){
        return list[list.length - 1];
    }
    // adds given element to the end of stack
    public void push(E o){
        if(list[list.length - 1] == null){
            list[index++] = o;
        }else{
            E[] tempList = (E[]) new Object[list.length * 2];
            for (int i = 0; i < list.length; i++) {
                tempList[i] = list[i];
            }
            
            this.list = tempList;
            list[index++] = o;
        }
    }
    // removes and returns the last element in stack
    public E pop(){
        E o = list[index--];
        list[index] = null;
        return o;
    }
    // returns true if stack is empty
    public boolean isEmpty(){
        return index == 0;
    }
    
    @Override
    public String toString(){
        return "stack: " + Arrays.toString(list);
    }
    
}
