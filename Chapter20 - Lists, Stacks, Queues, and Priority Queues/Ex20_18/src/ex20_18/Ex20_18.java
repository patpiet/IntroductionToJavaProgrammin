/*
    Directory size) Listing 18.7, DirectorySize.java, gives a recursive method for
    finding a directory size. Rewrite this method without using recursion. Your
    program should use a queue to store the subdirectories under a directory.
 */
package ex20_18;

import java.io.File;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author patpiet
 */
public class Ex20_18 {

    public static void main(String[] args) {
        File directory = new File("directory");
        System.out.println(getSize(directory));
    }

    public static long getSize(File directory){
        // Store the size of the directroy
        long size = 0;
        // Add the directory to the queue
        Queue<File> q = new PriorityQueue<>();
        q.offer(directory);
        
        // Loop until queue is empty
        while(!q.isEmpty()){
            // Store the first file in the queue
            File temp = q.poll();
            
            if(temp.isFile()){  // The file is not a directory
                size += temp.length();
            }else{              // The file is a directory
                // Loop through directory
                for(File sub: temp.listFiles()){
                    // Offer each file to the Queue
                    q.offer(sub);
                }
            }
        }
        return size;
    }
}
