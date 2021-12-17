/*
    (Compare loans with various interest rates) Rewrite Programming Exercise
    5.21 to create a GUI, as shown in Figure 16.41b. Your program should let the
    user enter the loan amount and loan period in the number of years from text
    fields, and it should display the monthly and total payments for each interest
    rate starting from 5 percent to 8 percent, with increments of one-eighth, in a
    text area.
 */
package ex16_13;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex16_13 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Border Pane
        BorderPane pane = new BorderPane();
        
        // Create text area
        TextArea ta = new TextArea();
        ta.setEditable(false);
        ta.setPrefColumnCount(35);
        ta.setPrefRowCount(50);
        // Creat Scroll Pane
        ScrollPane scrollPane = new ScrollPane(ta);
        
        // Create HBox for menu
        HBox hBox = new HBox(5);
        
        // Create elements of menu
        Label lbAmount = new Label("Loan Amount");
        TextField tfAmount = new TextField();
        tfAmount.setPrefColumnCount(5);
        Label lbYears = new Label("Number Of Years");
        TextField tfYears = new TextField();
        tfYears.setPrefColumnCount(2);
        Button btShow = new Button("Show Table");
        
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lbAmount, tfAmount, lbYears, tfYears, btShow);
        
        pane.setCenter(scrollPane);
        pane.setTop(hBox);
        
        // Create handler for showing the table
        btShow.setOnAction(e ->{
            double amount = Double.parseDouble(tfAmount.getText());
            int years = Integer.parseInt(tfYears.getText());
            
            showTable(amount, years, ta);
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Exercise_16_13"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    // Prints the table in the textArea
    private void showTable(double amount, int years, TextArea ta){
        String table = String.format("%-25s%-25s%-25s\n", "InterestRate", "Monthly Payment", "Total Payment");

        int months = years * 12;
        double monthlyPayment, totalPayment;
        
        // add each row to the table string
        for (double rate = 0.05; rate < 0.08; rate+= 0.00125) {
            
            double rateMonth = rate / 12.0;
            
            monthlyPayment = (amount * rateMonth) / (1 - (1.0 / (Math.pow(1 + rateMonth, months))));
            totalPayment = monthlyPayment * months;
            
            table += String.format("%-25.3f%-25.2f%-25.2f\n", rate * 100, monthlyPayment, totalPayment);
        }
        // Print the table
        ta.setText(table);
    }
    
}
