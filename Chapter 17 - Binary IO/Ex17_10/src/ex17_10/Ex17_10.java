/*
    (Split files) Suppose you want to back up a huge file (e.g., a 10-GB AVI file) to a
    CD-R. You can achieve it by splitting the file into smaller pieces and backing up
    these pieces separately. Write a utility program that splits a large file into smaller
    ones using the following command:

    java Exercise17_10 SourceFile numberOfPieces

    The command creates the files SourceFile.1, SourceFile.2, . . . , SourceFile.n,
    where n is numberOfPieces and the output files are about the same size.
 */
package ex17_10;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;

public class Ex17_10 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Create source file
        File file = new File(args[0]);
        // Number of smaller pieces
        int numberOfPieces = Integer.parseInt(args[1]);
        // size of smaller piece
        BigDecimal sizePerFile = new BigDecimal(file.length() / Double.parseDouble(args[1]));
        
        // Create raf object for the source file
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(0);
        
        // Loop numberOfPieces
        for (int i = 1; i <= numberOfPieces; i++) {
            // Create new file
            File pieceFile = new File("pieces/SourceFile." + i);
            
            // Create input source
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(pieceFile));
            
            // Write the bytes to the smaller piece until its bigger than size dedicated per file
            while(pieceFile.length() <= sizePerFile.longValue()){
                output.write(raf.readByte());
            }
        }
        
    }
    
}
