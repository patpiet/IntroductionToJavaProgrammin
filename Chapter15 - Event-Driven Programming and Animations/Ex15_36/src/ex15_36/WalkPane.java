/*

 */
package ex15_36;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class WalkPane extends Pane{
    private ArrayList<Line> lines = new ArrayList<>();
    private double x = 80;
    private double y = 80;
    private Rectangle rectangle = new Rectangle(1, 1, 160, 160);
    private boolean outOfBounds = false;
    private Timeline animation;
    private int size = 16;
    private int counter = 0;
    
    // Constructor with given lettice size
    WalkPane(int size){
        createLattice(size);
        rectangle.setWidth(size * 10  - 1);
        rectangle.setHeight(size * 10  - 1);
        this.x = size * 10 / 2;
        this.y = size * 10 / 2;
    }
    
    // Creates the board / lattice
    private void createLattice(int size){
        for (int i = 0; i < size * 10; i+= 10) {
            Line line = new Line(i, 0, i, size * 10);
            line.setStroke(Color.GRAY);
            Line line2 = new Line(0, i, size * 10, i);
            line2.setStroke(Color.GRAY);
            getChildren().addAll(line, line2);
        }
    }
    // Creates random walk
    public void createWalk(){
        // Reset the values
        reset();
        
        for (int i = 0; i < 30000; i++) {
            if(outOfBounds){
                return;
            }else{
            makeMove(getDirection());
            }
        }
        
    }
    // Returns one of the directions
    private String getDirection(){
        String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};
        return directions[(int) (Math.random() * 4)];
    }
    
    // Creates a new line if possible
    private void makeMove(String direction){
        Line line = null;
        
        switch(direction){
            case "UP":{
                line = new Line(x, y, x, y - 10);
                break;
            }
            case "DOWN":{
                line = new Line(x, y, x, y + 10);
                break;
            }
            case "LEFT":{
                line = new Line(x, y, x - 10, y);
                break;
            }
            case "RIGHT":{
                line = new Line(x, y, x + 10, y);
                break;
            }
        }
        // Check whether new line is inside the bands
        checkBands(line);
        
        // Print the line if it is withing bounds and does not intersect with other lines
        if(!checkIntersection(line) && !outOfBounds ){
            lines.add(line);
            getChildren().add(line);
            x = line.getEndX();
            y = line.getEndY();
            counter = 0;
        }else{
            counter++;
        }
    }
    
    // Returns true when the line intersects with any line on the board
    private boolean checkIntersection(Line givenLine){
        for(Line line: lines){
            if(givenLine.getEndX() == line.getStartX() && givenLine.getEndY() == line.getStartY()){
                return true;
            }
        }
        return false;
    }
    // assigns true to outOfBounds if the new line is out of bounds
    private void checkBands(Line line){
        if(!rectangle.contains(line.getStartX(), line.getStartY())){
           outOfBounds = true;
        }
    }
    // resets all the values needed to create new path
    private void reset(){
        getChildren().clear();
        createLattice(size);
        lines.clear();
        x = size * 10 / 2 ;
        y = size * 10 / 2 ;
        outOfBounds = false;
    }
    // returns true if the current walk is dead end
    public boolean isDeadEnd(){
        return counter >= 0;
    }
}
