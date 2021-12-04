/*
    Write a program that calculates the
    future value of an investment at a given interest rate for a specified number of
    years. Use text fields for the investment amount, number of years, and annual interest
    rate. Display the future amount in a text field when the user clicks the Calculate
    button, as shown in Figure 15.25b.
 */
package ex15_05;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ex15_05 extends Application{
    private TextField tfAmount = new TextField();
    private TextField tfYears = new TextField();
    private TextField tfRate = new TextField();
    private TextField tfFutureValue = new TextField();
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create GridPane
        GridPane pane = new GridPane();
        pane.setVgap(5);
        
        // Create font
        Font font = new Font("Arial", 15);
        
        // Aling the text entered in textFields to the right
        tfAmount.setAlignment(Pos.CENTER_RIGHT);
        tfYears.setAlignment(Pos.CENTER_RIGHT);
        tfRate.setAlignment(Pos.CENTER_RIGHT);
        tfFutureValue.setAlignment(Pos.CENTER_RIGHT);
        
        // Create labels and set its fonts
        Label lbAmount = new Label("Investment Amount: ");
        lbAmount.setFont(font);
        
        Label lbYears = new Label("Number of years: ");
        lbYears.setFont(font);
        
        Label lbRate = new Label("Annual Interest Rate: ");
        lbRate.setFont(font);
        
        Label lbFutureValue = new Label("Future value: ");
        lbFutureValue.setFont(font);
        
        // Create button and its handler
        Button btCalculate = new Button("Calculate");
        btCalculate.setOnAction(e -> CalculateFutureValue());
        
        // Add the nodes to the grid pane
        pane.add(lbAmount, 0, 0);
        pane.add(tfAmount, 1, 0);
        pane.add(lbYears, 0, 1);
        pane.add(tfYears, 1, 1);
        pane.add(lbRate, 0, 2);
        pane.add(tfRate, 1, 2);
        pane.add(lbFutureValue, 0, 3);
        pane.add(tfFutureValue, 1, 3);
        pane.add(btCalculate, 1, 4);
        // Move the button to the right
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_15_05"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    // calculates and sets the text in Future Value textField 
    private void CalculateFutureValue(){
        double amount = Double.parseDouble(tfAmount.getText());
        int years = Integer.parseInt(tfYears.getText());
        double rate = Double.parseDouble(tfRate.getText()) / 12 / 100;
        System.out.println(amount);
        System.out.println(years);
        System.out.println(rate);
        
        double futureValue = amount * Math.pow((1 + rate), years * 12);
        
        tfFutureValue.setText(String.format("$%.2f", futureValue));
        
    }
    
}
