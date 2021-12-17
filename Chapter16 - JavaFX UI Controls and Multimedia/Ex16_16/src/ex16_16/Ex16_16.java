/*
    (Use ComboBox and ListView) Write a program that demonstrates selecting
    items in a list. The program uses a combo box to specify a selection mode, as
    shown in Figure 16.43a. When you select items, they are displayed in a label
    below the list.
 */
package ex16_16;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex16_16 extends Application {

    String[] countries = {"China", "Japan", "Korea", "India", "Malaysia", "Vietnam",
        "Poland", "France", "Spain", "Germany", "Indonesia"};

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create border pane
        BorderPane pane = new BorderPane();

        // Creat top menu
        HBox paneForTop = new HBox(5);
        paneForTop.setAlignment(Pos.CENTER);
        Label lbMode = new Label("Choose Selection Mode: ");
        ComboBox<SelectionMode> cboSelectionMode = new ComboBox<>();
        cboSelectionMode.getItems().addAll(SelectionMode.values());
        cboSelectionMode.setValue(SelectionMode.SINGLE);
        paneForTop.getChildren().addAll(lbMode, cboSelectionMode);

        // Create list view
        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(countries));
        lv.setPrefSize(200, 150);

        // Create Text at the bottom
        Label lbSelected = new Label("No items selected");

        pane.setTop(paneForTop);
        pane.setCenter(lv);
        pane.setBottom(lbSelected);

        // Action Handlers
        // Change the selection mode
        cboSelectionMode.setOnAction(e -> lv.getSelectionModel().setSelectionMode(cboSelectionMode.getValue()));
        
        // Change the label to display selected items 
        lv.getSelectionModel().selectedItemProperty().addListener(ov -> {
            // check if there is at least one item selected
            if (!lv.getSelectionModel().isEmpty()) {
                // Store countries in the string
                String countriesString = "";
                // Loop through all selected elements
                for (String country : lv.getSelectionModel().getSelectedItems()) {
                    countriesString += country + " ";
                }
                // set the label test
                lbSelected.setText("Selected Items are " + countriesString);
            }
            else
                lbSelected.setText("No items selected.");

        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_16"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

}
