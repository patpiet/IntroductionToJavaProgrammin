/*
 */
package ex14_28;

/**
 *
 * @author User
 */

import java.util.Calendar; 
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;
  private boolean hourHandVisible;
  private boolean minuteHandVisible;
  private boolean secondHandVisible;
  
  /** Construct a default clock with the current time*/
  public ClockPane() {
    setCurrentTime();
    this.hourHandVisible = true;
    this.minuteHandVisible = true;
    this.secondHandVisible = true;
  }

  /** Construct a clock with specified hour, minute, and second */
  public ClockPane(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    this.hourHandVisible = true;
    this.minuteHandVisible = true;
    this.secondHandVisible = true;
  }

  /** Return hour hand visible */
  public boolean getHourHandVisible() {
    return hourHandVisible;
  }

  /** Set a new hour visibility */
  public void setHourHandVisible(boolean visibility) {
    this.hourHandVisible = visibility;
    paintClock();
  }
  
  /** Return minute hand visible */
  public boolean getMinuteHandVisible() {
    return minuteHandVisible;
  }

  /** Set a new minute visibility */
  public void setMinuteHandVisible(boolean visibility) {
    this.minuteHandVisible = visibility;
    paintClock();
  }
  
  /** Return second hand visible */
  public boolean getSecondHandVisible() {
    return secondHandVisible;
  }

  /** Set a new second visibility */
  public void setSecondHandVisible(boolean visibility) {
    this.secondHandVisible = visibility;
    paintClock();
  }
  
    // return hour
  public int getHour(){
    return hour;
  }

  /** Set a new hour */
  public void setHour(int hour) {
    this.hour = hour;
    paintClock();
  }

  /** Return minute */
  public int getMinute() {
    return minute;
  }

  /** Set a new minute */
  public void setMinute(int minute) {
    this.minute = minute;
    paintClock();
  }

  /** Return second */
  public int getSecond() {
    return second;
  }

  /** Set a new second */
  public void setSecond(int second) {
    this.second = second;
    paintClock();
  }
  
  /* Set the current time for the clock */
  public void setCurrentTime() {
    // Construct a calendar for the current date and time
    Calendar calendar = new GregorianCalendar();

    // Set current hour, minute and second
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);
    
    paintClock(); // Repaint the clock
  }
  
  /** Paint the clock */
  private void paintClock() {
    // Initialize clock parameters
    double clockRadius = 
      Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
    double centerX = getWidth() / 2;
    double centerY = getHeight() / 2;

    // Draw circle
    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
    Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
    Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
    Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
    
    
    // Draw second hand
    Line sLine = new Line();
    if(this.secondHandVisible){
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * 
          Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength * 
          Math.cos(second * (2 * Math.PI / 60));
        sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);
    }

    // Draw minute hand
    Line mLine = new Line();
    if(this.minuteHandVisible){
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength * 
          Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength * 
          Math.cos(minute * (2 * Math.PI / 60));
        mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);
    }
    
    // Draw hour hand
    Line hLine = new Line();
    if(this.hourHandVisible){
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength * 
          Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
          Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);
    }
    
    getChildren().clear(); // Clear the pane
    getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
  }
  
  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paintClock();
  }
  
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paintClock();
  }
}
