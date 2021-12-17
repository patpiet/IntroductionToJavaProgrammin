/*
    (Pattern recognition: consecutive four equal numbers) Write a GUI program for
    Programming Exercise 8.19, as shown in Figure 16.49a–b. Let the user enter the
    numbers in the text fields in a grid of 6 rows and 7 columns. The user can click
    the Solve button to highlight a sequence of four equal numbers, if it exists. Initially,
    the values in the text fields are filled with numbers from 0 to 9 randomly.
 */
package ex16_30;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex16_30 extends Application{
    TextField[][] cells = new TextField[6][7];
    FlowPane[] rows = new FlowPane[6];
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Fill the cells randomly
        fillCells();

        // Create border pane
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        
        // Create main label
        Label lbMessage = new Label("LOOK FOR CONSECUTIVE FOUR");
        // Create vbox for rows
        VBox vBox = new VBox();
        vBox.getChildren().addAll(rows);
        
        // Create button
        Button btSolve = new Button("Solve");
        pane.setTop(new StackPane(lbMessage));
        pane.setCenter(vBox);
        pane.setBottom(new StackPane(btSolve));
        
        // Action handler for button
        btSolve.setOnAction(e ->{
            if(isConsecutive()){
                lbMessage.setText("A consecutive four found.");
            }else{
                lbMessage.setText("A consecutive four not found.");
            }
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 210, 210);
        primaryStage.setTitle("Exercise_16_30"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    // Fills the cells with random 0-9 values
    public void fillCells(){
        for (int i = 0; i < 6; i++) {
            rows[i] = new FlowPane();
            for (int j = 0; j < 7; j++) {
                cells[i][j] = new TextField();
                cells[i][j].setText((int) (Math.random() * 10) + "");
                cells[i][j].setPrefColumnCount(1);
                rows[i].getChildren().add(cells[i][j]);
            }
        }
    }
    
    // Returns true if four consectuive found
    public boolean isConsecutive(){
        // Reset color of border of each cell to default
        resetBorders();
        // Fire the methods to change colors
        isConsecutiveVertically();
        isConsecutiveHorizontally();
        isConsecutiveDiagonally();
        // return true if any method returns true
        return isConsecutiveVertically()
                || isConsecutiveHorizontally()
                ||isConsecutiveDiagonally();
    }
    // Check consecutive diagonally
    public boolean isConsecutiveVertically(){
        // loop through each row
        for (int i = 0; i < cells.length; i++) {
            // set the  value to the first value from row
            String value = cells[i][0].getText();
            // reset counter
            int counter = 0;
            // loop through column of the row
            for (int j = 0; j < cells[i].length; j++) {
                if(value.equals(cells[i][j].getText())){
                    counter++;
                    if(counter == 4){
                        cells[i][j].setStyle("-fx-border-color: black");
                        cells[i][j-1].setStyle("-fx-border-color: black");
                        cells[i][j-2].setStyle("-fx-border-color: black");
                        cells[i][j-3].setStyle("-fx-border-color: black");
                        return true;
                    }
                }else{
                    value = cells[i][j].getText();
                    counter = 1;
                }
            }
        }
        return false;
    }
    // Check consecutive diagonally
    public boolean isConsecutiveHorizontally(){
        // loop through each row 
        for (int i = 0; i < 7; i++) {
            // reset the counter
            int counter = 0;
            // Assign the value to the first value of the columns
            String value = cells[0][i].getText();
            // loop through cells horizontally
            for (int j = 0; j < 6; j++) {
                if(value.equals(cells[j][i].getText())){
                    counter++;
                    if(counter == 4 ){
                        cells[j][i].setStyle("-fx-border-color: black");
                        cells[j - 1][i].setStyle("-fx-border-color: black");
                        cells[j - 2][i].setStyle("-fx-border-color: black");
                        cells[j - 3][i].setStyle("-fx-border-color: black");
                        return true;
                    }
                }else{
                    value = cells[j][i].getText();
                    counter = 1;
                }
            }
        }
        return false;
    }
    // Check consecutive diagonally
    public boolean isConsecutiveDiagonally(){
        int[][] directions = {{1, 0}, {1, -1}, {1, 1}, {0, 1}};
        for(int[] d: directions){
            int dx = d[0];
            int dy = d[1];
            for (int x = 0;  x < 6; x++) {
                for (int y = 0; y < 7; y++) {
                    int lastx = x +3 * dx;
                    int lasty = y + 3* dy;
                    if(0 <= lastx && lastx < 6 && 0 <= lasty && lasty < 7){
                        String value = cells[x][y].getText();
                        if(value.equals(cells[x+dx][y+dy].getText())
                           && value.equals(cells[x+2 *dx][y + 2 *dy].getText())
                           && value.equals(cells[lastx][lasty].getText())){
                            cells[x][y].setStyle("-fx-border-color: black");
                            cells[x + dx][y + dy].setStyle("-fx-border-color: black");
                            cells[x + 2 * dx][y + 2 * dy].setStyle("-fx-border-color: black");
                            cells[lastx][lasty].setStyle("-fx-border-color: black");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    // Resets borders of all text fields to its default
    public void resetBorders(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].setStyle(null);
            }
        }
    }
}
