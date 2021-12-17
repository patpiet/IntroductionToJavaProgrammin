/*
    (Convert numbers) Write a program that converts between decimal, hex, and binary
    numbers, as shown in Figure 16.37c. When you enter a decimal value in the decimalvalue
    text field and press the Enter key, its corresponding hex and binary numbers are
    displayed in the other two text fields. Likewise, you can enter values in the other fields
    and convert them accordingly. (Hint: Use the Integer.parseInt(s, radix)
    method to parse a string to a decimal and use Integer.toHexString(decimal)
    and Integer.toBinaryString(decimal) to obtain a hex number or a binary
    number from a decimal.)
 */
package ex16_05;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ex16_05 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create pane
        GridPane pane = new GridPane();
        
        // Create text fields and labels
        Label lbDecimal = new Label("Decimal");
        TextField tfDecimal = new TextField();
        tfDecimal.setAlignment(Pos.CENTER_RIGHT);
        Label lbHex = new Label("Hex");
        TextField tfHex = new TextField();
        tfHex.setAlignment(Pos.CENTER_RIGHT);
        Label lbBinary = new Label("Binary");
        TextField tfBinary = new TextField();
        tfBinary.setAlignment(Pos.CENTER_RIGHT);
        
        // Add node to the pane
        pane.add(lbDecimal, 0, 0);
        pane.add(tfDecimal, 1, 0);
        pane.add(lbHex, 0, 1);
        pane.add(tfHex, 1, 1);
        pane.add(lbBinary, 0, 2);
        pane.add(tfBinary, 1, 2);
        
        // Decimal text field action handler
        tfDecimal.setOnAction(e ->{
            int decimal = Integer.parseInt(tfDecimal.getText());
            tfHex.setText(Integer.toHexString(decimal));
            tfBinary.setText(Integer.toBinaryString(decimal));
        });
        
        // Hexadecimal text field action handler
        tfHex.setOnAction(e ->{
            int decimal = Integer.parseInt(tfHex.getText(), 16);
            tfDecimal.setText(decimal + "");
            tfBinary.setText(Integer.toBinaryString(decimal));
        });
        
        // Binary text field action handler
        tfBinary.setOnAction(e ->{
            int decimal = Integer.parseInt(tfBinary.getText(), 2);
            tfDecimal.setText(decimal + "");
            tfHex.setText(Integer.toHexString(decimal));
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_05"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
