/*
    (Execution time for GCD) Write a program that obtains the execution time for
    finding the GCD of every two consecutive Fibonacci numbers from the index
    40 to index 45 using the algorithms in Listings 22.3 and 22.4.
 */
package ex22_06;

/**
 *
 * @author patpiet
 */
public class Ex22_06 {

    public static void main(String[] args) {
        System.out.print("\t\t\t |40\t41\t42\t43\t44\t45\t");
        System.out.print("\nListing 22.3 GCD\t |");
        for (int i = 40; i < 46; i++) {
            System.out.printf("%d\t", getTime(i, i + 1));
        }
        System.out.print("\nListing 22.3 GCDEuclid\t |");
        for (int i = 40; i < 46; i++) {
            System.out.printf("%d\t", getTimeEuclid(i, i + 1));
        }
    }

    /**
     * Find GCD for integers m and n
     */
    public static int gcd(int m, int n) {
        int gcd = 1;
        if (m % n == 0) {
            return n;
        }

        for (int k = n / 2; k >= 1; k--) {
            if (m % k == 0 && n % k == 0) {
                gcd = k;
                break;
            }
        }

        return gcd;
    }

    /**
     * Find GCD for integers m and n
     */
    public static int gcdEuclid(int m, int n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }
    }

    private static long getTimeEuclid(int i, int i0) {
        long startTime = System.currentTimeMillis();
        int num = gcdEuclid(i, i0);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        return executionTime;
    }

    private static long getTime(int i, int i0) {
        long startTime = System.currentTimeMillis();
        int num = gcdEuclid(i, i0);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        return executionTime;
    }
}
