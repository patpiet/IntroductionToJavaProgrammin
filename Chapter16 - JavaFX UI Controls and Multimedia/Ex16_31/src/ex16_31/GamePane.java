/*
    (Game: connect four) Programming Exercise 8.20 enables two players to play
    the connect-four game on the console. Rewrite a GUI version for the program,
    as shown in Figure 16.49c. The program enables two players to place red and
    yellow discs in turn. To place a disk, the player needs to click an available cell.
    An available cell is unoccupied and its downward neighbor is occupied. The
    program flashes the four winning cells if a player wins and reports no winners if
    all cells are occupied with no winners.
 */
package ex16_31;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class GamePane extends VBox {

    private Circle[][] circles = new Circle[6][7];
    private FlowPane[] rows = new FlowPane[6];
    private char player;

    // No-arg constructor
    public GamePane() {
        // Create the Game board
        for (int i = 0; i < circles.length; i++) {
            //set up pane
            rows[i] = new FlowPane();
            rows[i].setHgap(5);
            rows[i].setAlignment(Pos.CENTER);
            for (int j = 0; j < circles[i].length; j++) {
                // set up circle
                circles[i][j] = new Circle(10);
                circles[i][j].setFill(Color.WHITE);
                circles[i][j].setStroke(Color.BLACK);
                rows[i].getChildren().add(circles[i][j]);
            }
        }
        // set up the pane
        setStyle("-fx-background-color: lightgray");
        setAlignment(Pos.CENTER);
        getChildren().addAll(rows);
        this.player = 'R';
        createHandlers();
    }

    private void createHandlers() {
        for (Circle[] rows : circles) {
            for (Circle circle : rows) {
                circle.setOnMouseClicked((e) -> {
                    if (isAvailable(circle) && !checkWinner() && !isDraw()) {
                        placeDisk(circle);
                        checkWinner();
                        isDraw();
                    }
                });
            }
        }
    }

    // returns true when the circle is available
    private boolean isAvailable(Circle circle) {
        // Find the cell of the circle
        int index = 0;
        int indexJ = 0;
        for (int i = 0; i < circles.length; i++) {
            for (int j = 0; j < circles[i].length; j++) {
                if (circles[i][j].equals(circle)) {
                    index = i;
                    indexJ = j;
                }
            }
        }

        // Return true if circle is available
        if (index == 5 && !circle.getFill().equals(Color.RED) && !circle.getFill().equals(Color.YELLOW)) {
            return true;
        } else {
            return circles[index + 1][indexJ].getFill() != Color.WHITE && !circle.getFill().equals(Color.RED) && !circle.getFill().equals(Color.YELLOW);
        }

    }

    // changes a color of disk to the player's color, also changes the turn
    private void placeDisk(Circle circle) {
        switch (player) {
            case 'R':
                circle.setFill(Color.RED);
                break;
            case 'Y':
                circle.setFill(Color.YELLOW);
        }

        player = (player == 'R') ? 'Y' : 'R';

    }

    // Finishes the game if winner is known or it is a draw
    public boolean checkWinner() {
        return isWinnerVertically() || isWinnerHorizontally()|| isWinnerDiagonally();
    }

    // return true and flashes winning circles if winner spot vertically
    public boolean isWinnerVertically() {
        // loop through each row
        for (int i = 0; i < circles.length; i++) {
            // set the  value to the first value from row
            Color value = (Color) circles[i][0].getFill();
            // reset counter
            int counter = 0;
            // loop through column of the row
            for (int j = 0; j < circles[i].length; j++) {
                if (value.equals(circles[i][j].getFill()) && !value.equals(Color.WHITE)) {
                    counter++;
                    if (counter == 4) {
                        // Create fade transition for one of the winning circles
                        FadeTransition tf = createFadeTransition(circles[i][j]);
                        // bind other circles with
                        circles[i][j-1].opacityProperty().bind(circles[i][j].opacityProperty());
                        circles[i][j-2].opacityProperty().bind(circles[i][j].opacityProperty());
                        circles[i][j-3].opacityProperty().bind(circles[i][j].opacityProperty());
                        return true;
                    }
                } else {
                    value = (Color) circles[i][j].getFill();
                    counter = 1;
                }
            }
        }
        return false;
    }
    // return true and flashes winning circles if winner spot horizontally
    public boolean isWinnerHorizontally(){
        // loop through each row 
        for (int i = 0; i < 7; i++) {
            // reset the counter
            int counter = 0;
            // Assign the value to the first value of the columns
            Color value = (Color) circles[0][i].getFill();
            // loop through circles horizontally
            for (int j = 0; j < 6; j++) {
                if(value.equals(circles[j][i].getFill()) && !value.equals(Color.WHITE)){
                    counter++;
                    if(counter == 4 ){
                        // Create fade transition for one of the winning circles
                        FadeTransition tf = createFadeTransition(circles[j][i]);
                        // bind other circles with
                        circles[j - 1][i].opacityProperty().bind(circles[j][i].opacityProperty());
                        circles[j - 2][i].opacityProperty().bind(circles[j][i].opacityProperty());
                        circles[j - 3][i].opacityProperty().bind(circles[j][i].opacityProperty());
                        return true;
                    }
                }else{
                    value = (Color) circles[j][i].getFill();
                    counter = 1;
                }
            }
        }
        return false;
    }    
    // return true and flashes winning circles if winner spot diagonally
    public boolean isWinnerDiagonally(){
        int[][] directions = {{1, 0}, {1, -1}, {1, 1}, {0, 1}};
        for(int[] d: directions){
            int dx = d[0];
            int dy = d[1];
            for (int x = 0;  x < 6; x++) {
                for (int y = 0; y < 7; y++) {
                    int lastx = x +3 * dx;
                    int lasty = y + 3* dy;
                    if(0 <= lastx && lastx < 6 && 0 <= lasty && lasty < 7){
                        Color value = (Color) circles[x][y].getFill();
                        if(value.equals(circles[x+dx][y+dy].getFill())
                           && value.equals(circles[x+2 *dx][y + 2 *dy].getFill())
                           && value.equals(circles[lastx][lasty].getFill())
                           && !value.equals(Color.WHITE)){
                            // Create fade transition animation for one of winner circles
                            FadeTransition ft = createFadeTransition(circles[x][y]);
                            // bind other circles with
                            circles[x + dx][y + dy].opacityProperty().bind(circles[x][y].opacityProperty());
                            circles[x + 2 *dx][y + 2 *dy].opacityProperty().bind(circles[x][y].opacityProperty());
                            circles[lastx][lasty].opacityProperty().bind(circles[x][y].opacityProperty());
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }    
    // return a flashing animation as FadeTransition object
    public FadeTransition createFadeTransition(Circle circle){
        // set up the animation
        FadeTransition ft = new FadeTransition(Duration.seconds(0.1), circle);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(Animation.INDEFINITE);
        ft.play();
        return ft;
    }
    
    // returns true if the game is finished by draw
    public  boolean isDraw(){
        for (Circle[] row : circles) {
            for (Circle circle : row) {
                // return false if any circle is white
                return !circle.getFill().equals(Color.WHITE);
            }
        }
        // Inform the players about the draw.
        getChildren().add(new Label("It is a draw."));
        // return true if no white circles found
        return true;
    }
}
