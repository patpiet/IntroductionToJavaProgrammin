/*
    (Koch snowflake fractal) The text presented the Sierpinski triangle fractal. In
    this exercise, you will write a program to display another fractal, called the Koch
    snowflake, named after a famous Swedish mathematician. A Koch snowflake is
    created as follows:

    1. Begin with an equilateral triangle, which is considered to be the Koch fractal
    of order (or level) 0, as shown in Figure 18.14a.
    2. Divide each line in the shape into three equal line segments and draw an outward
    equilateral triangle with the middle line segment as the base to create a
    Koch fractal of order 1, as shown in Figure 18.14b.
    3. Repeat Step 2 to create a Koch fractal of order 2, 3, . . . , and so on, as shown
    in Figure 18.14c–d.
 */
package ex18_27;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author patpiet
 */
public class Ex18_27 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create border pane
        BorderPane pane = new BorderPane();
        
        KochSnowflakePane kochPane = new KochSnowflakePane();
        kochPane.setOrder(0);
        
        pane.setCenter(kochPane);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_18_27"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
