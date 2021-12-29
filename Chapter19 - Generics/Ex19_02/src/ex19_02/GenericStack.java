/*
    (Implement GenericStack using inheritance) In Listing 19.1, GenericStack is
    implemented using composition. Define a new stack class that extends ArrayList.
    Draw the UML diagram for the classes and then implement GenericStack.
    Write a test program that prompts the user to enter five strings and displays them in
    reverse order
 */
package ex19_02;

import java.util.ArrayList;

/**
 *
 * @author patpiet
 */
public class GenericStack<E> extends ArrayList<E>{
    
    // no arg constructor
    public GenericStack(){
        super();
    }
    
    public E peek(){
        return get(size() - 1);
    }
    
    public void push(E o){
        add(o);
    }
    
    public E pop(){
        E o = get(size() - 1);
        remove(size() - 1);
        return o;
    }
    
}
