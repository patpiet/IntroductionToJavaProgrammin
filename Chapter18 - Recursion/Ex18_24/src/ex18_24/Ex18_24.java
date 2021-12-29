/*
    (Hex to decimal) Write a recursive method that parses a hex number as a string
    into a decimal integer. The method header is:

    public static int hex2Dec(String hexString)

    Write a test program that prompts the user to enter a hex string and displays its
    decimal equivalent.
*/
package ex18_24;

/**
 *
 * @author patpiet
 */
public class Ex18_24 {

    public static void main(String[] args) {
        System.out.println(hex2Dec("FF3e"));
    }
    
    public static int hex2Dec(String hexString){
        return hex2Dec(hexString.toUpperCase(), hexString.length() - 1, 1);     // recursive helper method
    }

    private static int hex2Dec(String hexString, int high, int coefficient) {
        if(high == -1){     // base case
            return 0;
        }else{              // recursive call
            return getHex(hexString.charAt(high)) * coefficient + hex2Dec(hexString, high - 1, coefficient * 16);
        }
    }
    // get value from hex character
    private static int getHex(char value) {
        switch(value){
            case 'F': return 15;
            case 'E': return 14;
            case 'D': return 13;
            case 'C': return 12;
            case 'B': return 11;
            case 'A': return 10;
            default: return Integer.parseInt(value + "");
        }
    }
}
