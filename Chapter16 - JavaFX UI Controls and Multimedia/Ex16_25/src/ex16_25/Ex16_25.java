/*
    (Racing cars) Write a program that simulates four cars racing, as shown in
    Figure 16.47b. You can set the speed for each car, with maximum 100.
*/
package ex16_25;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex16_25 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create vBox
        VBox vBox = new VBox(5);
        // Create hbox for speed menu
        HBox hBox = new HBox(10);
        Label lbCar1 = new Label("Car 1:");
        TextField tfCar1 = new TextField();
        Label lbCar2 = new Label("Car 2:");
        TextField tfCar2 = new TextField();
        Label lbCar3 = new Label("Car 3:");
        TextField tfCar3 = new TextField();
        Label lbCar4 = new Label("Car 4:");
        TextField tfCar4 = new TextField();
        
        hBox.getChildren().addAll(lbCar1, tfCar1, lbCar2, tfCar2, lbCar3, tfCar3, lbCar4, tfCar4);
        
        // Create four cars
        RacingCarPane car1 = new RacingCarPane();
        RacingCarPane car2 = new RacingCarPane();
        RacingCarPane car3 = new RacingCarPane();
        RacingCarPane car4 = new RacingCarPane();
        
        // Display cars
        vBox.getChildren().addAll(hBox, car1, car2, car3, car4);
        
        tfCar1.setOnAction(e -> car1.setSpeed(Double.parseDouble(tfCar1.getText())));
        tfCar2.setOnAction(e -> car2.setSpeed(Double.parseDouble(tfCar2.getText())));
        tfCar3.setOnAction(e -> car3.setSpeed(Double.parseDouble(tfCar3.getText())));
        tfCar4.setOnAction(e -> car4.setSpeed(Double.parseDouble(tfCar4.getText())));
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Exercise_14_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
