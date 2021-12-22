/*
    (Sum series) Write a recursive method to compute the following series:

    m(i) = 1 + 1/2 + 1/3 + ... + 1/i

    Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 */
package ex18_04;

/**
 *
 * @author patpiet
 */
public class Ex18_04 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("m(" + i + ") = " + sum(i));
        }
    }
    
    public static double sum(int i){
        if(1 / i == 1){
            return 1;
        }else{
            return 1.0 / i + sum(i - 1);
        }
    }
}
