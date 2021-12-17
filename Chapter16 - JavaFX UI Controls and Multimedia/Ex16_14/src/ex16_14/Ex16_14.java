/*
    (Select a font) Write a program that can dynamically change the font of a text
    in a label displayed on a stack pane. The text can be displayed in bold and
    italic at the same time. You can select the font name or font size from combo
    boxes, as shown in Figure 16.42a. The available font names can be obtained
    using Font.getFamilies(). The combo box for the font size is initialized
    with numbers from 1 to 100.
 */
package ex16_14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex16_14 extends Application {

    // Create nodes for Editing
    Text text = new Text("Programming is fun");
    ComboBox<String> cboName = new ComboBox<>();
    ComboBox<Integer> cboSize = new ComboBox<>();
    CheckBox cbBold = new CheckBox("Bold");
    CheckBox cbItalic = new CheckBox("Italic");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create border Pane
        BorderPane pane = new BorderPane();

        // Hbox for top menu
        HBox paneForTop = new HBox(5);
        paneForTop.setAlignment(Pos.CENTER);
        // Create elements from top menu
        Label lbName = new Label("Font Name");
        cboName.getItems().addAll(Font.getFamilies());
        cboName.setValue("Book Antiqua");
        Label lbSize = new Label("Font Size");
        cboSize.setValue(48);
        for (int i = 1; i <= 100; i++) {
            cboSize.getItems().add(i);
        }
        paneForTop.getChildren().addAll(lbName, cboName, lbSize, cboSize);

        // Create Pane for text
        StackPane paneForText = new StackPane();
        paneForText.setPrefSize(700, 200);
        // Create Font
        Font font = new Font("Book Antiqua", 48);
        text.setFont(font);

        paneForText.getChildren().add(text);

        // Create pane for radio buttons at the bottom
        HBox paneForRadioButtons = new HBox(5);
        paneForRadioButtons.setAlignment(Pos.CENTER);
        paneForRadioButtons.getChildren().addAll(cbBold, cbItalic);

        pane.setTop(paneForTop);
        pane.setCenter(paneForText);
        pane.setBottom(paneForRadioButtons);

        // Create action handlers
        cboName.setOnAction(e -> setFont());

        cboSize.setOnAction(e -> setFont());

        cbBold.setOnAction(e -> setFont());
        
        cbItalic.setOnAction(e -> setFont());
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_14"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    // Updates the font of text to the current 
    public void setFont() {
        text.setFont(Font.font(cboName.getValue(),
                cbBold.isSelected() ? FontWeight.BOLD : FontWeight.LIGHT,
                cbItalic.isSelected() ? FontPosture.ITALIC : FontPosture.REGULAR,
                cboSize.getValue()));
    }
}
