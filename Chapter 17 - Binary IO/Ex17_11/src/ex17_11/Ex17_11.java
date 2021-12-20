/*
    (Split files GUI) Rewrite Exercise 17.10 with a GUI, as shown in Figure 17.21a.
 */
package ex17_11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ex17_11 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create border pane
        BorderPane pane = new BorderPane();

        //Create grid pane
        GridPane gridPane = new GridPane();

        //Create text fields
        TextField tfFile = new TextField();
        TextField tfNumber = new TextField();

        gridPane.add(new Label("Enter a file:"), 0, 0);
        gridPane.add(tfFile, 1, 0);
        gridPane.add(new Label("Specify the number of smaller files:"), 0, 1);
        gridPane.add(tfNumber, 1, 1);

        // Create button
        Button btStart = new Button("Start");
        btStart.setAlignment(Pos.CENTER);

        pane.setTop(new Label("If you split a file named temp.txt into 3 smaller files,\n"
                + "the three smaller files are temp.txt.1, temp.txt.2 and temp.txt.3"));
        pane.setCenter(gridPane);
        pane.setBottom(new StackPane(btStart));

        // Create event handler for button
        btStart.setOnAction(e -> {
            try {
                splitFile(tfFile.getText(), Integer.parseInt(tfNumber.getText()));
            } catch (IOException ex) {
                Logger.getLogger(Ex17_11.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_17_11"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    public void splitFile(String fileString, int number) throws FileNotFoundException, IOException {
        // Create source file
        File file = new File(fileString);
        // Number of smaller pieces
        int numberOfPieces = number;
        // size of smaller piece
        BigDecimal sizePerFile = new BigDecimal(file.length() / number + 1);

        
        // Loop numberOfPieces
        try ( // Create raf object for the source file
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
            // Loop numberOfPieces
            for (int i = 1; i <= numberOfPieces; i++) {
                // Create new file
                File pieceFile = new File("pieces/" + fileString + "." + i);
                
                try ( // Create input source
                        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(pieceFile))) {
                    int buffer;
                    
                    // Write the bytes to the smaller piece until its bigger than size dedicated per file
                    while (pieceFile.length() <= sizePerFile.doubleValue() && (buffer = input.read()) != -1) {
                        output.write(buffer);
                    }
                }
            }
        }
    }

}
