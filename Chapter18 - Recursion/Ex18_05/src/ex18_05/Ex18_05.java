/*
    (Sum series) Write a recursive method to compute the following series:
    m(i) =
    1/3 + 2/5 + 3/7 +4/9 +5/11 +6/13 + ... + i/ 2i + 1

    Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 */
package ex18_05;

/**
 *
 * @author patpiet
 */
public class Ex18_05 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("m(" + i + ") = " + sum(i));
        }
    }
    
    public static double sum(int i){
        if(i == 1){
            return i / (2 * i + 1.0);
        }else{
            return i /(2 * i + 1.0) + sum(i - 1);
        }
    }
}
