/*
    (Create a histogram for occurrences of letters) Write a program that reads a
    file and displays a histogram to show the occurrences of each letter in the file,
    as shown in Figure 16.40b. The file name is entered from a text field. Pressing
    the Enter key on the text field causes the program to start to read and process
    the file and displays the histogram. The histogram is displayed in the center of the
    window. Define a class named Histogram that extends Pane. The class contains
    the property counts that is an array of 26 elements. counts[0] stores the
    number of A, counts[1] the number of B, and so on. The class also contains a
    setter method for setting a new counts and displaying the histogram for the new
    counts.
 */
package ex16_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex16_11 extends Application{
    Histogram histogram = new Histogram();


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Border Pane
        BorderPane pane = new BorderPane();
        
        
        // Create hBox
        HBox hBox = new HBox(5);
        Label lbFileName = new Label("Filename: ");
        TextField tfFileName = new TextField();
        tfFileName.setPrefColumnCount(25);
        Button btView = new Button("View");
        
        hBox.getChildren().addAll(lbFileName, tfFileName, btView);
        
        pane.setCenter(histogram);
        pane.setBottom(hBox);
        
        // Action handlers
        btView.setOnAction(e -> {
            try {
                scanFile(tfFileName.getText());
                histogram.printHistogram();
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Exercise_16_10"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    // Scans through the files and counts the letters 
    // adds each letter to the array from histogram
    public void scanFile(String path) throws FileNotFoundException{
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        
        // Create file object
        File file = new File(path);
        // Create scanner to read the file
        Scanner input = new Scanner(file);
        
        
        // Loop through every line in file
        while (input.hasNext()){
            String line = input.nextLine().toUpperCase();
            // loop through every char in the line
            for (int i = 0; i < line.length(); i++) {
                // loop through alphabet
                for (int j = 0; j < alphabet.length; j++) {
                    if(line.charAt(i) == alphabet[j]){
                        histogram.increaseCount(j);
                    }
                }
            }
        }
    }
    
}
