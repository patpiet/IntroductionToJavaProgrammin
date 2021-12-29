/*
    (Revising Listing 19.1) Revise the GenericStack class in Listing 19.1 to implement
    it using an array rather than an ArrayList. You should check the array size
    before adding a new element to the stack. If the array is full, create a new array that
    doubles the current array size and copy the elements from the current array to the
    new array.
 */
package ex19_01;

/**
 *
 * @author patpiet
 */
public class Ex19_01 {

    public static void main(String[] args) {
        GenerickStack stack = new GenerickStack();
        stack.push(4);
        stack.push(4);
        stack.push(4);
        stack.push(4);
        stack.push(4);
        stack.push(4);
        stack.push(4);
        stack.push(4);
        stack.pop();
        System.out.println(stack.getSize());
        System.out.println(stack.toString());
    }
    
}
