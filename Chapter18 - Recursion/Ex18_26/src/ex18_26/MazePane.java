/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex18_26;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author patpiet
 */
public class MazePane extends VBox {
    private RectanglePane[][] cells = new RectanglePane[8][8];
    private FlowPane[] rows = new FlowPane[8];
    private boolean isPath = false;
    
    // constructor
    public MazePane() {
        // display the board
        displayBoard();
        
        // add handler for marking the cell
        this.setOnMouseClicked(e ->{
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    if(cells[i][j].isHover() 
                       && cells[i][j] != cells[0][0]        // Prevent from marking the first cell
                       && cells[i][j] != cells[7][7]){      // Prevent from markin the last cell
                        cells[i][j].mark();
                    }
                }
            }
        });
        
//        findPath();
    }

    private void displayBoard() {
        // loop through each cell and set up board
        for (int i = 0; i < cells.length; i++) {
            // set up each flow pane
            rows[i] = new FlowPane();
            rows[i].setPrefWrapLength(256);
            for (int j = 0; j < cells[i].length; j++) {
                // set up rectangles
                cells[i][j] = new RectanglePane();
                rows[i].getChildren().add(cells[i][j]);
            }
            getChildren().add(rows[i]);
        }
    }
    
    public void findPath(){
        findPath( 0, 0);
    }

    private void findPath(int i, int j) {
        if(cells[i][j] == cells[7][7]){     // base case
            isPath = true;
            cells[i][j].setMarked(true);
            cells[i][j].markColor();
        }else{
            
        }
    }

}
