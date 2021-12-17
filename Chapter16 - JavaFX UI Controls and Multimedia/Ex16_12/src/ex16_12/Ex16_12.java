/*
    (Demonstrate TextArea properties) Write a program that demonstrates the
    properties of a text area. The program uses a check box to indicate whether the
    text is wrapped onto next line, as shown in Figure 16.41a.
 */
package ex16_12;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex16_12 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create border pane
        BorderPane pane = new BorderPane();
        
        // Create text area
        TextArea ta = new TextArea();
        ta.setPrefColumnCount(30);
        ta.setPrefRowCount(50);
        
        // Create scroll pane
        ScrollPane scrollPane = new ScrollPane(ta);
        
        // Creat Hbox for check boxes
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        
        // Create check boxes
        CheckBox cbEditable = new CheckBox("Editable");
        CheckBox cbWrap = new CheckBox("Wrap");
        hBox.getChildren().addAll(cbEditable, cbWrap);
        
        pane.setCenter(scrollPane);
        pane.setBottom(hBox);
        
        // Action handlers for check boxes
        cbEditable.setOnAction(e ->{
            if(cbEditable.isSelected())
                ta.setEditable(true);
            else
                ta.setEditable(false);
        });
        
        cbWrap.setOnAction(e ->{
            if(cbWrap.isSelected())
                ta.setWrapText(true);
            else
                ta.setWrapText(false);
        });
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Exercise_16_12"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
