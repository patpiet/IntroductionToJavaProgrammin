/*
    Write a program to perform addition, subtraction,
    multiplication, and division, as shown in Figure 15.25a
 */
package ex15_04;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ex15_04 extends Application{
        private TextField tfNumber1 = new TextField();
        private TextField tfNumber2 = new TextField();
        private TextField tfResult = new TextField();


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create top Pane with text fields
        HBox tfHbox = new HBox();
        tfHbox.setSpacing(10);
        
        Font font = new Font("Arial", 22);
        
        Label number1 = new Label("Number 1:");
        number1.setFont(font);
        
        Label number2 = new Label("Number 2:");
        number2.setFont(font);
        
        Label result = new Label("Result:");
        result.setFont(font);
        
        tfHbox.getChildren().addAll(number1, tfNumber1, number2, tfNumber2, result, tfResult);
        
        // Create bottom Pane with buttons and its handlers
        HBox btHbox = new HBox();
        btHbox.setAlignment(Pos.CENTER);
        btHbox.setSpacing(8);
        
        Button btAdd = new Button("Add");
        btAdd.setOnAction(e -> add());
        Button btSubstract = new Button("Substract");
        btSubstract.setOnAction(e -> substract());
        Button btMultiply = new Button("Multiply");
        btMultiply.setOnAction(e -> multiply());
        Button btDivide = new Button("Divide");
        btDivide.setOnAction(e -> divide());
        
        btHbox.getChildren().addAll(btAdd, btSubstract, btMultiply, btDivide);
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tfHbox, btHbox);
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Exercise_15_04"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    // Add number1 and number2
    private void add(){
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        
        tfResult.setText( (number1 + number2) + "");
    }
    // substract number1 and number2
    private void substract(){
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        
        tfResult.setText(number1 - number2 + "");
    }
    // multiply number1 and number2
    private void multiply(){
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        
        tfResult.setText(number1 * number2 + "");
    }
    // divide number1 and number2
    private void divide(){
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        
        tfResult.setText((double) (number1 / number2) + "");
    }
    
}
