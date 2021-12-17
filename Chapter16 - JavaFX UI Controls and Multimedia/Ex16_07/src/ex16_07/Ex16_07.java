/*
    (Set clock time) Write a program that displays a clock and sets the time with the
    input from three text fields, as shown in Figure 16.38b. Use the ClockPane in
    Listing 14.21. Resize the clock to the center of the pane
*/
package ex16_07;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex16_07 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Border Pane
        BorderPane pane = new BorderPane();
        // Creat HBox
        HBox hBox = new HBox(5);
        // Create labels and its text fields
        Label lbHour = new Label("Hour");
        TextField tfHour = new TextField();
        tfHour.setPrefColumnCount(3);
        Label lbMinute = new Label("Minute");
        TextField tfMinute = new TextField();
        tfMinute.setPrefColumnCount(3);
        Label lbSecond = new Label("Second");
        TextField tfSecond = new TextField();
        tfSecond.setPrefColumnCount(3);
        // Add nodes to hbox
        hBox.getChildren().addAll(lbHour, tfHour, lbMinute, tfMinute, lbSecond, tfSecond);
        hBox.setAlignment(Pos.CENTER);
        // Create clock Pane
        ClockPane clockPane = new ClockPane();
        clockPane.setPrefSize(200, 200);
        
        // Set up the border pane
        pane.setTop(clockPane);
        pane.setBottom(hBox);
        
        // Handlers for text fields
        tfHour.setOnAction(e ->{
            clockPane.setHour(Integer.parseInt(tfHour.getText()));
        });
        tfMinute.setOnAction(e ->{
            clockPane.setMinute(Integer.parseInt(tfMinute.getText()));
        });
        tfSecond.setOnAction(e ->{
            clockPane.setSecond(Integer.parseInt(tfSecond.getText()));
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Exercise_16_07"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
