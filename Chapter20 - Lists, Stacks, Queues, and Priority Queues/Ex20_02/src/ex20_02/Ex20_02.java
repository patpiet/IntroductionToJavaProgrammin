/*
    (Store numbers in a linked list) Write a program that lets the user enter numbers
    from a graphical user interface and displays them in a text area, as shown in
    Figure 20.17a. Use a linked list to store the numbers. Do not store duplicate numbers.
    Add the buttons Sort, Shuffle, and Reverse to sort, shuffle, and reverse the list.
 */
package ex20_02;

import java.util.Collections;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author patpiet
 */
public class Ex20_02 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create linked list to store number
        LinkedList<Integer> list = new LinkedList<>(); 
        
        // Create border pane
        BorderPane pane = new BorderPane();
        
        // Create HBox
        HBox topPane = new HBox(10);
        topPane.setAlignment(Pos.CENTER);
        // Create text field for user
        TextField tfNumber = new TextField();
        topPane.getChildren().addAll(new Label("Enter a number: "), tfNumber);
        
        // Create text area
        TextArea ta = new TextArea();
        ScrollPane scrollPane = new ScrollPane(ta);
        ta.setEditable(false);
        
        // Create Hbox for buttons
        HBox bottomPane = new HBox(10);
        bottomPane.setAlignment(Pos.CENTER);
        
        // Create buttons
        Button btSort = new Button("Sort");
        Button btShuffle = new Button("Shuffle");
        Button btReverse = new Button("Reverse");
        bottomPane.getChildren().addAll(btSort, btShuffle, btReverse);
        
        pane.setTop(topPane);
        pane.setCenter(scrollPane);
        pane.setBottom(bottomPane);
        
        // Create event handlers for buttons and text field
        tfNumber.setOnAction(e ->{
            try{
                // add number to the list
                list.add(Integer.parseInt(tfNumber.getText()));
                // clear the text area
                ta.clear();
                // print the list to text area
                ta.setText(list.toString());
            }
            catch(NumberFormatException ex){
                System.out.println("Error! Enter number.");
            }
            tfNumber.clear();
        });
        
        btSort.setOnAction(e ->{
            Collections.sort(list);
            ta.clear();
            ta.setText(list.toString());
        });
        
        btShuffle.setOnAction(e ->{
            Collections.shuffle(list);
            ta.clear();
            ta.setText(list.toString());
        });
        btReverse.setOnAction(e ->{
            Collections.reverse(list);
            ta.clear();
            ta.setText(list.toString());
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_20_02"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
