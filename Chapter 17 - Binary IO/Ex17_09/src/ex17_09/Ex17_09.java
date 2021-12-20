/*
    Address book) Write a program that stores, retriehes, adds, and updates addresses
    as shown in Figure 17.20. Use a fixed-length string for storing each attribute in the
    address. Use random access file for reading and writing an address. Assume that
    the size of name, street, city, state, and zip is 32, 32, 20, 2, 5 bytes, respectihely.
 */
package ex17_09;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex17_09 extends Application {

    // Store the text fields of address
    TextField tfName = new TextField();
    TextField tfStreet = new TextField();
    TextField tfCity = new TextField();
    TextField tfState = new TextField();
    TextField tfZip = new TextField();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the address class object
        AddressClass file = new AddressClass(new File("Ex17_09.dat"));
        // Create Border Pane
        BorderPane pane = new BorderPane();
        // Create Grid Pane
        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        // Create text fields
        tfName.setPrefColumnCount(28);
        addTextLimiter(tfName, 32);
        tfStreet.setPrefColumnCount(28);
        addTextLimiter(tfStreet, 32);
        tfCity.setPrefColumnCount(10);
        addTextLimiter(tfCity, 20);
        tfState.setPrefColumnCount(2);
        addTextLimiter(tfState, 2);
        tfZip.setPrefColumnCount(7);
        addTextLimiter(tfZip, 5);

        // Create buttons
        Button btAdd = new Button("Add");
        Button btFirst = new Button("First");
        Button btNext = new Button("Next");
        Button btPrevious = new Button("Previous");
        Button btLast = new Button("Last");
        Button btUpdate = new Button("Update");

        // Set up the panes
        gridPane.add(new Label("Name "), 0, 0);
        gridPane.add(tfName, 1, 0);
        gridPane.add(new Label("Street "), 0, 1);
        gridPane.add(tfStreet, 1, 1);

        // Create hBox
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label(String.format("%-7s", "City")), tfCity,
                new Label("State "), tfState,
                new Label("Zip "), tfZip);

        // Create hBox for buttons
        HBox hBoxButtons = new HBox(5);
        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxButtons.getChildren().addAll(btAdd, btFirst, btNext, btPrevious, btLast, btUpdate);

        // Create event handlers for buttons
        btAdd.setOnAction(e -> {
            try {
                file.addAddress(getAddress());
            } catch (IOException ex) {
                Logger.getLogger(Ex17_09.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btFirst.setOnAction(e -> {
            try {
                fillTF(file.getFirstAddress());
            } catch (IOException ex) {
                Logger.getLogger(Ex17_09.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btNext.setOnAction(e -> {
            try {
                fillTF(file.getNextAddress());
            } catch (IOException ex) {
                Logger.getLogger(Ex17_09.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btPrevious.setOnAction(e -> {
            try {
                fillTF(file.getPreviousAddress());
            } catch (IOException ex) {
                Logger.getLogger(Ex17_09.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btLast.setOnAction(e -> {
            try {
                fillTF(file.getLastAddress());
            } catch (IOException ex) {
                Logger.getLogger(Ex17_09.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btUpdate.setOnAction(e -> {
            try {
                file.updateAddress(getAddress());
            } catch (IOException ex) {
                Logger.getLogger(Ex17_09.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        pane.setPadding(new Insets(10));
        pane.setTop(gridPane);
        pane.setCenter(hBox);
        pane.setBottom(hBoxButtons);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_17_09"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    // returns array of string containing current address values in the text fields
    private String[] getAddress() {
        String[] address = new String[5];
        address[0] = tfName.getText();
        address[1] = tfStreet.getText();
        address[2] = tfCity.getText();
        address[3] = tfState.getText();
        address[4] = tfZip.getText();

        return address;
    }

    // fills the text fields with given addres
    private void fillTF(String[] address) {
        tfName.setText(address[0]);
        tfStreet.setText(address[1]);
        tfCity.setText(address[2]);
        tfState.setText(address[3]);
        tfZip.setText(address[4]);
    }
    // set ups a max lenght for a text field
    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }
}
