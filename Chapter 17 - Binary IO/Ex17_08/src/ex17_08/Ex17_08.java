/*
    (Update count) Suppose you wish to track how many times a program has been
    executed. You can store an int to count the file. Increase the count by 1 each
    time this program is executed. Let the program be Exercise17_08 and store the
    count in Exercise17_08.dat.
*/
package ex17_08;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex17_08 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Create raf object
        try(RandomAccessFile raf = new RandomAccessFile("Ex17_08.dat", "rw");){
            int count = (raf.length() != 0) ? raf.readInt() + 1 : 1;
            raf.seek(0);
            raf.writeInt(count);
            System.out.println("The program has been executed " + count + " times.");
        }
    }
    
}
