/*
    (Demonstrate TextField properties) Write a program that sets the horizontalalignment
    and column-size properties of a text field dynamically, as shown in
    Figure 16.38a.
 */
package ex16_06;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex16_06 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // HBox for main text field
        HBox paneForMainTF = new HBox(10);
        Label lbTextField = new Label("Text Field");
        TextField tf = new TextField();
        tf.setText("JavaFX");
        tf.setAlignment(Pos.CENTER);
        paneForMainTF.getChildren().addAll(lbTextField, tf);
        paneForMainTF.setAlignment(Pos.CENTER);
        
        // HBox for the control menu
        HBox hBox = new HBox(5);
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");
        
        // Group the radio buttons
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        rbRight.setToggleGroup(group);
    
        Label lbColSize = new Label("Column Size");
        TextField tfColSize = new TextField();
        tfColSize.setPrefColumnCount(3);
        tfColSize.setText("12");
        hBox.getChildren().addAll(rbLeft, rbCenter, rbRight, lbColSize, tfColSize);
        
        // Border Pane to store both pane and hbox
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        pane.setTop(paneForMainTF);
        pane.setBottom(hBox);
        
        // event handlers
        rbLeft.setOnAction(e ->{
            if(rbLeft.isSelected())
                tf.setAlignment(Pos.CENTER_LEFT);
        });
        rbCenter.setOnAction(e ->{
            if(rbCenter.isSelected())
                tf.setAlignment(Pos.CENTER);
        });
        rbRight.setOnAction(e ->{
            if(rbRight.isSelected())
                tf.setAlignment(Pos.CENTER_RIGHT);
        });
        tfColSize.setOnAction(e ->{
            tf.setPrefColumnCount(Integer.parseInt(tfColSize.getText()));
        });
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_06"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
