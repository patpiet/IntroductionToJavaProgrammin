/*
    Write a program that displays two clocks. The hour,
    minute, and second values are 4, 20, 45 for the first clock and 22, 46, 15 for the
    second clock, as shown in Figure 14.51c.
 */
package ex14_26;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex14_26 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create hBox
        HBox hBox = new HBox();
        
        
        // Create  2 clock panes
        ClockPane clockPane1 = new ClockPane(4, 20, 45);
        clockPane1.setWidth(300);
        clockPane1.setHeight(300);
        
        ClockPane clockPane2 = new ClockPane(22, 46, 15);
        clockPane2.setWidth(300);
        clockPane2.setHeight(300);
        
        
        hBox.getChildren().addAll(clockPane1, clockPane2);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(hBox);
        primaryStage.setTitle("Exercise_14_26"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

}
