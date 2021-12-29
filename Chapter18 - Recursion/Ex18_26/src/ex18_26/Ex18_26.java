/*
    (Create a maze) Write a program that will find a path in a maze, as shown in
    Figure 18.13a. The maze is represented by an 8 * 8 board. The path must meet
    the following conditions:
    ■ The path is between the upper-left corner cell and the lower-right corner cell
    in the maze.
    ■ The program enables the user to place or remove a mark on a cell. A path
    consists of adjacent unmarked cells. Two cells are said to be adjacent if they
    are horizontal or vertical neighbors, but not if they are diagonal neighbors.
    ■ The path does not contain cells that form a square. The path in Figure 18.13b,
    for example, does not meet this condition. (The condition makes a path easy
    to identify on the board.)
 */
package ex18_26;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author patpiet
 */
public class Ex18_26 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create border pane
        BorderPane pane = new BorderPane();
        
        MazePane mazePane = new MazePane();
        
        pane.setCenter(mazePane);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_18_26"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
