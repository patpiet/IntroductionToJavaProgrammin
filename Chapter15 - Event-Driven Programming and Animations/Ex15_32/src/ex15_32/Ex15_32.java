/*
    (Control a clock) Modify Listing 14.21, ClockPane.java, to add the animation
    into this class and add two methods start() and stop() to start and stop the
    clock. Write a program that lets the user control the clock with the Start and
    Stop buttons, as shown in Figure 15.36a.
 */
package ex15_32;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex15_32 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create clockpane
        ClockPane pane = new ClockPane();
        pane.setPrefSize(400, 400);
        //Create Hbox
        HBox hBox = new HBox();
        // Create buttons
        Button btStart = new Button("Start");
        Button btStop = new Button("Stop");
        hBox.getChildren().addAll(btStart, btStop);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
        
        // Create VBOX
        VBox vBox = new VBox();
        vBox.getChildren().addAll(pane, hBox);
        
        // start/ stop the clock when buttons clicked
        btStop.setOnAction(e ->{
            pane.pause();
        });
        btStart.setOnAction(e ->{
            pane.start();
        });
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Exercise_15_32"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
