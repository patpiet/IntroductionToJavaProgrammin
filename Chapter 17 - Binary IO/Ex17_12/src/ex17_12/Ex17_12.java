/*
    (Combine files) Write a utility program that combines the files together into a
    new file using the following command:
    java Exercise17_12 SourceFile1 . . . SourceFilen TargetFile
    The command combines SourceFile1, . . . , and SourceFilen into TargetFile.
 */
package ex17_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex17_12 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // create array of source files 
        RandomAccessFile[] pieces = new RandomAccessFile[args.length - 1];
        
        // Create target file
        File targetFile = new File(args[args.length - 1]);
        
        RandomAccessFile raf = new RandomAccessFile(targetFile, "rw");
        
        // loop through the source files
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = new RandomAccessFile(new File(args[i]), "rw");
            
            // write bytes from source file to the target file
            while(pieces[i].read() != -1){
                raf.write(pieces[i].read());
            }
        }
        
    }
}
