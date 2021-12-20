/*
    (View bits) Write the following method that displays the bit representation for the
    last byte in an integer:

    public static String getBits(int value)

    For a hint, see Programming Exercise 5.44. Write a program that prompts the
    user to enter a file name, reads bytes from the file, and displays each byte’s binary
    representation.
 */
package ex17_18;


/**
 *
 * @author patpiet
 */
public class Ex17_18 {

    public static void main(String[] args) {
        
    }

    // retruns string with the bit representattion for the last byte in an integer
    public static String getBits(int value){
        StringBuilder bits = new StringBuilder();
        long i;
        for (i = 128; i > 0; i /= 2) {
           bits.append((value & i) != 0 ? "1" : "0");
        }
        return bits.toString();
    }
}
