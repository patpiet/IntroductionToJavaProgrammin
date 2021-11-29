/*
    Modify the ClockPane class with three new Boolean properties—
    hourHandVisible, minuteHandVisible, and secondHandVisible—and
    their associated accessor and mutator methods. You can use the set methods to
    make a hand visible or invisible. Write a test program that displays only the hour
    and minute hands. The hour and minute values are randomly generated. The hour
    is between 0 and 11, and the minute is either 0 or 30, as shown in Figure 14.52b.
 */
package ex14_28;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex14_28 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClockPane clockPane = new ClockPane();
        clockPane.setSecondHandVisible(false);
        
        clockPane.setHour((int) (Math.random() * 11));
        clockPane.setMinute((int) (Math.random() * 30));
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(clockPane);
        primaryStage.setTitle("Exercise_14_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
