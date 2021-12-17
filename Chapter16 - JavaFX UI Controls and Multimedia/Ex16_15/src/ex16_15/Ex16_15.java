/*
    (Demonstrate Label properties) Write a program to let the user dynamically
    set the properties contentDisplay and graphicTextGap, as shown in
    Figure 16.42b.
*/
package ex16_15;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ex16_15 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create border pane
        BorderPane pane = new BorderPane();
        
        // Create pane for top menu
        HBox hBox = new HBox(5);

        Label lbContentDisplay = new Label("contentDisplay");
        
        ComboBox<ContentDisplay> cboContentDisplay = new ComboBox<>();
        cboContentDisplay.getItems().addAll(ContentDisplay.values());
        cboContentDisplay.setValue(ContentDisplay.RIGHT);
        
        Label lbGap = new Label("graphicTextGap");
        TextField tfGap = new TextField();
        tfGap.setText("4");
        tfGap.setPrefColumnCount(4);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lbContentDisplay, cboContentDisplay, lbGap, tfGap);
        
        // Create pane for the Label 
        StackPane paneForLabel = new StackPane();
        
        // Create Image view
        ImageView imgGrapes = new ImageView(new Image("image/grapes.png", 100, 100, false, false));

        Label lbGrapes = new Label("Grapes", imgGrapes);
        paneForLabel.getChildren().add(lbGrapes);
        
        
        pane.setTop(hBox);
        pane.setCenter(paneForLabel);
        
        // Action event handlers
        cboContentDisplay.setOnAction(e ->{
            lbGrapes.setContentDisplay(cboContentDisplay.getValue());
        });
        tfGap.setOnAction(e ->{
            lbGrapes.setGraphicTextGap(Double.parseDouble(tfGap.getText()));
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 150);
        primaryStage.setTitle("Exercise_16_15"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
