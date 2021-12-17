/*
    (Create a miles/kilometers converter) Write a program that converts miles and
    kilometers, as shown in Figure 16.37b. If you enter a value in the Mile text field
    and press the Enter key, the corresponding kilometer measurement is displayed
    in the Kilometer text field. Likewise, if you enter a value in the Kilometer text
    field and press the Enter key, the corresponding miles is displayed in the Mile
    text field.
 */
package ex16_04;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ex16_04 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creat Pane
        GridPane pane = new GridPane();
        
        // Create labels and text fields
        Label lbMile = new Label("Mile ");
        TextField tfMile = new TextField("1");
        tfMile.setAlignment(Pos.CENTER_RIGHT);
        Label lbKm = new Label("Kilometer ");
        TextField tfKm = new TextField("1.6023");
        tfKm.setAlignment(Pos.CENTER_RIGHT);
        
        pane.add(lbMile, 0, 0);
        pane.add(tfMile, 1, 0);
        pane.add(lbKm, 0, 1);
        pane.add(tfKm, 1, 1);
        
        // Convert the values
        tfMile.setOnAction(e ->{
            double miles = Integer.parseInt(tfMile.getText());
            tfKm.setText((miles * 1.6023) + "");
        });
        
        tfKm.setOnAction(e ->{
            double kilometers = Integer.parseInt(tfKm.getText());
            tfMile.setText((kilometers / 1.6023) + "");
        });
        


        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_04"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
