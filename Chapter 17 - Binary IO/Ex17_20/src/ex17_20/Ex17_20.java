/*
    (Binary editor) Write a GUI application that lets the user enter a file name in the
    text field and press the Enter key to display its binary representation in a text area.
    The user can also modify the binary code and save it back to the file, as shown in
    Figure 17.23a.
 */
package ex17_20;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author patpiet
 */
public class Ex17_20 extends Application {

    TextArea ta;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create border pane
        BorderPane pane = new BorderPane();

        // Create gridPane 
        GridPane gridPane = new GridPane();

        // Create text field for the file
        TextField tfFile = new TextField();
        tfFile.setPrefColumnCount(36);

        gridPane.add(new Label("Enter a file: "), 0, 0);
        gridPane.add(tfFile, 1, 0);

        // Create Text area for binary representation
        ta = new TextArea();
        ta.setWrapText(true);

        // Create Scrollpane
        ScrollPane scrollPane = new ScrollPane(ta);

        // Create button
        Button btSave = new Button("Save the change");

        pane.setTop(gridPane);
        pane.setCenter(scrollPane);
        pane.setBottom(new StackPane(btSave));

        // Create event handler for text field when ENTER clicked
        tfFile.setOnKeyPressed(e -> {
            if (e.getCode() == ENTER) {
                try {
                    displayBinary(tfFile.getText());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Ex17_20.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Ex17_20.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        // Event handler for button to save the change
        btSave.setOnAction(e -> {
            try {
                saveChange(tfFile.getText());
            } catch (IOException ex) {
                Logger.getLogger(Ex17_20.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_17_20"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    private void displayBinary(String fileString) throws FileNotFoundException, IOException {
        // Create file
        File file = new File(fileString);
        // Create input stream
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
            int buffer;
            // Store the binary 
            String binaryString = "";
            // loop until end of file
            while ((buffer = input.read()) != -1) {
                binaryString += Integer.toBinaryString(buffer);
            }
            // set text of text area to binary
            ta.setText(binaryString);
        }

    }

    // writes the text area string to the file
    private void saveChange(String fileString) throws FileNotFoundException, IOException {
        // Create file
        File file = new File(fileString);

        // Get the binary string from text area
        String binaryString = ta.getText();
        // Create output stream
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file))) {
            // loop through the string
            for (int i = 0; i < binaryString.length(); i++) {
                // write the bytes
                output.writeByte(Byte.parseByte(binaryString.charAt(i) + "", 2));
            }
        }
    }

}
