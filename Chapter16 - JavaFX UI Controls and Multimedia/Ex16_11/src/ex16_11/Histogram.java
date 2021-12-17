/*
    (Create a histogram for occurrences of letters) Write a program that reads a
    file and displays a histogram to show the occurrences of each letter in the file,
    as shown in Figure 16.40b. The file name is entered from a text field. Pressing
    the Enter key on the text field causes the program to start to read and process
    the file and displays the histogram. The histogram is displayed in the center of the
    window. Define a class named Histogram that extends Pane. The class contains
    the property counts that is an array of 26 elements. counts[0] stores the
    number of A, counts[1] the number of B, and so on. The class also contains a
    setter method
*/
package ex16_11;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Histogram extends Pane{
    private int[] counts = new int[26];
    private char[] letters = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    private int highest = 1;
    
    public Histogram(){
        printHistogram();
    }
    
    public int[] getCounts(){
        return counts;
    }
    
    public void setCounts(int[] newCounts){
        this.counts = newCounts;
    }

    public void increaseCount(int index){
        counts[index]++;
    }
    
    public void printHistogram(){
        findHighest();
        
        // Clear the pane
        getChildren().clear();
        
        // store how frequently should the columns appear in histogram
        double pixHor = getWidth() / (counts.length + 1);
        // stores the height of the highest column
        double pixVer = getHeight() * 0.90 / highest;
        
        // Add the x axis in histogram
        Line line = new Line(getWidth() * 0.02, getHeight() * 0.90,
                             getWidth() * 0.98, getHeight() * 0.90);
        getChildren().add(line);
        
        for (int i = 0; i < counts.length; i++) {
            // put the letter up
            getChildren().add(new Text(getWidth() * 0.02 + i * pixHor, getHeight() * 0.96, letters[i] +""));
            // Create the columns
            Rectangle rect = new Rectangle(
                                  getWidth() * 0.02 + i * pixHor,           // starting x
                                  getHeight() * 0.9 - counts[i] * pixVer,   // starting y
                                  pixHor - 5,                               // width
                                  counts[i] * pixVer);                      // height
            rect.setFill(Color.WHITE);
            rect.setStroke(Color.BLACK);
            getChildren().add(rect);
        }
        
    }
    // Find the highest column
    private void findHighest(){
        for(int count: counts){
            if (count >= highest){
                highest = count;
            }
        }
    }
    
}
