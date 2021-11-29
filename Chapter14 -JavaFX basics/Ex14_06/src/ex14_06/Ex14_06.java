/*
    Write a program that displays a checkerboard
    in which each white and black cell is a Rectangle with a fill color black or
    white, as shown in Figure 14.44c.
 */
package ex14_06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex14_06 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        
        // Loops through each row
        for (int i = 0; i < 8; i++) {
            if(i % 2 == 0){
                setStartingWhite(pane, i);
            }
            else
                setStartingBlack(pane, i);
        }
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_06"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    // Sets the row black white with starting white
    public static void setStartingWhite(GridPane pane, int i){
        // loops through each column in the row
        for (int j = 0; j < 8; j++) {
            Rectangle rectangle = new Rectangle(40, 40);
            if(j % 2 != 0){
                rectangle.setFill(Color.BLACK);
                pane.add(rectangle, i, j);
            }
            else{
                rectangle.setFill(Color.WHITE);
                pane.add(rectangle, i, j);
            }
        }
    }
    
    // Sets the row black white with starting black
    public static void setStartingBlack(GridPane pane, int i){
        // loops through each column in the row
        for (int j = 0; j < 8; j++) {
            Rectangle rectangle = new Rectangle(40, 40);
            if(j % 2 != 0){
                rectangle.setFill(Color.WHITE);
                pane.add(rectangle, i, j);
            }
            else{
                rectangle.setFill(Color.BLACK);
                pane.add(rectangle, i, j);
            }
        }
    }
    
}
