/*
    (Game: connect four) Programming Exercise 8.20 enables two players to play
    the connect-four game on the console. Rewrite a GUI version for the program,
    as shown in Figure 16.49c. The program enables two players to place red and
    yellow discs in turn. To place a disk, the player needs to click an available cell.
    An available cell is unoccupied and its downward neighbor is occupied. The
    program flashes the four winning cells if a player wins and reports no winners if
    all cells are occupied with no winners.
 */
package ex16_31;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex16_31 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the game pane
        GamePane gamePane = new GamePane();
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(gamePane, 180, 150);
        primaryStage.setTitle("Exercise_16_31"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
}
