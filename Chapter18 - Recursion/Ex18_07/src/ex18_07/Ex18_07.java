/*
    (Fibonacci series) Modify Listing 18.2, ComputeFibonacci.java, so that the program
    finds the number of times the fib method is called. (Hint: Use a static
    variable and increment it every time the method is called.)
 */
package ex18_07;

/**
 *
 * @author patpiet
 */
public class Ex18_07 {

    static int counter = 0;

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(counter);
    }

    public static int fib(int n) {
        counter++;
        switch (n) {
            case 1:
            case 2:
                return 1;
            case 0:
                return 0;
            default:
                return fib(n - 1) + fib(n - 2);
        }
    }
}
