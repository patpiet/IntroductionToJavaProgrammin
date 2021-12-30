/*
    (ComplexMatrix) Use the Complex class introduced in Programming
    Exercise 13.17 to develop the ComplexMatrix class for performing matrix operations
    involving complex numbers. The ComplexMatrix class should extend the
    GenericMatrix class and implement the add, multiple, and zero methods.
    You need to modify GenericMatrix and replace every occurrence of Number by
    Object, because Complex is not a subtype of Number. Write a test program that
    creates the following two matrices and displays the result of addition and multiplication
    of the matrices by invoking the printResult method.
 */
package ex19_11;

/**
 *
 * @author patpiet
 */
public class Ex19_11 {

    public static void main(String[] args) {
        // Create two array of Complex numbers
        Complex[][] m1 = new Complex[3][3];
        Complex[][] m2 = new Complex[3][3];
        
        // assign some value to the matrices
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = new Complex(i, 1);
                m2[i][j] = new Complex(i, 1);
            }
        }
        // Create matrix object
        ComplexMatrix complexMatrix = new ComplexMatrix();
        
        
        // display addition of matrices
        System.out.println("\nm1 + m2 is ");
        complexMatrix.printResult(m1, m2, complexMatrix.addMatrix(m1, m2), '+');

        // display multiplication of matrices
        System.out.println("\nm1 * m2 is ");
        complexMatrix.printResult(m1, m2, complexMatrix.multiplyMatrix(m1, m2), '*');
        
    }
    
}
