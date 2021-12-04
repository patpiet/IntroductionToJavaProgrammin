/*
    (Move the ball) Write a program that moves the ball in a pane. You should
    define a pane class for displaying the ball and provide the methods for moving
    the ball left, right, up, and down, as shown in Figure 15.24c. Check the boundary
    to prevent the ball from moving out of sight completely.
 */
package ex15_03;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex15_03 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create BallPane
        BallPane ballPane = new BallPane();
        
        // Create hbox
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        
        // Create buttons and its handlers
        Button btLeft = new Button("Left");
        btLeft.setOnAction(e -> ballPane.moveLeft());
        Button btRight = new Button("Right");
        btRight.setOnAction(e -> ballPane.moveRight());
        Button btUp = new Button("Up");
        btUp.setOnAction(e -> ballPane.moveUp());
        Button btDown = new Button("Down");
        btDown.setOnAction(e -> ballPane.moveDown());
        
        // place the buttons in right place
        ballPane.setBottom(hBox);
        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(ballPane, 200, 200);
        primaryStage.setTitle("Exercise_15_03"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
    }
    
}
