/*
    (Text viewer) Write a program that displays a text file in a text area, as shown
    in Figure 16.40a. The user enters a file name in a text field and clicks the View
    button; the file is then displayed in a text area
 */
package ex16_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex16_10 extends Application{
    private TextArea taFile = new TextArea();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Border Pane
        BorderPane pane = new BorderPane();
        
        // Create text area
        taFile.setPrefColumnCount(40);
        taFile.setPrefRowCount(30);
        
        // Create ScrollPane
        ScrollPane scrollPane = new ScrollPane(taFile);
        
        // Create hBox
        HBox hBox = new HBox(5);
        Label lbFileName = new Label("Filename: ");
        TextField tfFileName = new TextField();
        tfFileName.setPrefColumnCount(25);
        Button btView = new Button("View");
        
        hBox.getChildren().addAll(lbFileName, tfFileName, btView);
        
        pane.setCenter(scrollPane);
        pane.setBottom(hBox);
        
        // Action handlers
        btView.setOnAction(e -> {
            try {
                printFile(tfFileName.getText());
            } catch (FileNotFoundException ex) {
                taFile.setText("File not found.");
            }
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Exercise_16_10"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    public void printFile(String path) throws FileNotFoundException{
        // Create file object
        File file = new File(path);
        // Create scanner to read the file
        Scanner input = new Scanner(file);
        
        String taText = "";
        
        // Loop through every line in file
        while (input.hasNext()){
            String line = input.nextLine();
            taText += line + "\n";
            System.out.println(line);
        }
        // set the text area on the program
        taFile.setText(taText);
    }
}
