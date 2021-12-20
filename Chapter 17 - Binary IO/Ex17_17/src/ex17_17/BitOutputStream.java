/*
    (BitOutputStream) Implement a class named BitOutputStream, as shown
    in Figure 17.22, for writing bits to an output stream. The writeBit(char bit)
    method stores the bit in a byte variable. When you create a BitOutputStream,
    the byte is empty. After invoking writeBit('1'), the byte becomes 00000001.
    After invoking writeBit("0101"), the byte becomes 00010101. The first
    three bits are not filled yet. When a byte is full, it is sent to the output stream. Now
    the byte is reset to empty. You must close the stream by invoking the close()
    method. If the byte is neither empty nor full, the close() method first fills the
    zeros to make a full 8 bits in the byte, and then outputs the byte and closes the
    stream. For a hint, see Programming Exercise 5.44. Write a test program that
    sends the bits 010000100100001001101 to the file named Exercise17_17.dat..
 */
package ex17_17;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author patpiet
 */
public class BitOutputStream implements Closeable {

    private int value;
    private int positionCounter = 0;
    private FileOutputStream fileOutputStream;
    private File file;
    // Create an object
    public BitOutputStream(File file) throws FileNotFoundException {
        this.file = file;
        fileOutputStream = new FileOutputStream(this.file);
    }
    // Writes a bit '0' or '1' to the output stream
    public void writeBit(char bit) throws IOException {
        if (isValid(bit)) { // check if bit is '1' or '0'
            positionCounter++; 
            value = value << 1; // shift the bit value to the lefy by one 
            if (bit == '1') {  // if bit is '1' changer right most 0 to 1
                value = value | 1; // turn the last bit on
            }
            if (positionCounter == 8) { // if the byte is full - write to the stream
                fileOutputStream.write(value);
                positionCounter = 0;    // reset value
                value = 0;
            }

        } else {
            System.out.println("Wrong input.");
        }
    }

    public void writeBit(String bits) throws IOException{
        for (int i = 0; i < bits.length(); i++) { // loop through bits 
            writeBit(bits.charAt(i));
        }
    }
    // returns true when bit is valid
    private boolean isValid(char bit) { 
        return (bit == '1'
                || bit == '0'
                || bit == '\n'
                || bit == '\t');
    }
    // close the stream
    @Override
    public void close() throws IOException {
        // fill the value with 0s if applicable
        if(positionCounter > 0 ){
            int shift = 8 - positionCounter; // get the shift number
            value = value << shift;         // shift the number
            fileOutputStream.write(value);
        }
        fileOutputStream.close();        // close the stream
    }

}
