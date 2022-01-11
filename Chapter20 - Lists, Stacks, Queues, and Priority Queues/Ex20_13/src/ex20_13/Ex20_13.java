/*
    (Game: the 24-point card game) The 24-point game is to pick any 4 cards
    from 52 cards, as shown in Figure 20.19. Note that the Jokers are excluded.
    Each card represents a number. An Ace, King, Queen, and Jack represent 1,
    13, 12, and 11, respectively. You can click the Shuffle button to get four new
    cards. Enter an expression that uses the four numbers from the four selected
    cards. Each number must be used once and only once. You can use the operators
    (addition, subtraction, multiplication, and division) and parentheses in the
    expression. The expression must evaluate to 24. After entering the expression,
    click the Verify button to check whether the numbers in the expression are currently
    selected and whether the result of the expression is correct. Display the
    verification in a label before the Shuffle button. Assume that images are stored
    in files named 1.png, 2.png, . . . , 52.png, in the order of spades, hearts, diamonds,
    and clubs. So, the first 13 images are for spades 1, 2, 3, . . . , and 13.
 */
package ex20_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.script.ScriptException;

/**
 *
 * @author patpiet
 */
public class Ex20_13 extends Application {

    // Create informative label
    private TextField tfExpression;
    private Label lbInfo = new Label("");
    private ObservableList<Node> images;
    private ArrayList<Integer> cards = new ArrayList<>();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set the cards list
        setCards();

        // GUI CREATION
        // Create BorderPane
        BorderPane pane = new BorderPane();

        // Create TOP PANE
        HBox topPane = new HBox(5);
        Button btShuffle = new Button("Shuffle");
        topPane.getChildren().addAll(lbInfo, btShuffle);
        topPane.setAlignment(Pos.CENTER_RIGHT);
        topPane.setPadding(new Insets(5, 5, 0, 0));

        // Create CENTER PANE
        HBox centerPane = new HBox(5);
        images = centerPane.getChildren();
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setPadding(new Insets(5, 30, 5, 30));
        shuffle();

        // Crete BOTTOM PANE
        HBox bottomPane = new HBox(5);
        tfExpression = new TextField();
        tfExpression.setPrefColumnCount(15);
        Button btVerify = new Button("Verify");
        bottomPane.setPadding(new Insets(5));
        bottomPane.getChildren().addAll(new Label("Enter an expression: "),
                tfExpression, btVerify);

        // Set up panes
        pane.setTop(topPane);
        pane.setCenter(centerPane);
        pane.setBottom(bottomPane);

        // EVENT HANDLERS FOR BUTTONS
        btShuffle.setOnAction(e -> {
            shuffle();
        });
        btVerify.setOnAction(e -> {
            try {
                verify();
            } catch (ScriptException ex) {
                Logger.getLogger(Ex20_13.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_20_13"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    // Shuffle the cards
    private void shuffle() {
        images.clear();
        Collections.shuffle(cards);

        for (int i = 0; i < 4; i++) {
            Image img = new Image("image/" + cards.get(i) + ".png");
            images.add(new ImageView(img));
        }
    }

    // Initialize the cards array
    private void setCards() {
        for (int i = 1; i < 53; i++) {
            cards.add(i);
        }
    }

    // Verifies whether the expression is correct
    private void verify() throws ScriptException {
        if (!checkNumbers()) {
            lbInfo.setText("The numbers in the expression do not match the numbers in the set.");
        }else if(eval(tfExpression.getText()) == 24.0){
            lbInfo.setText("Correct");
        }else
            lbInfo.setText("Incorrect");
    }
    // Returns false when the number do not match
    private boolean checkNumbers() {
        int counter = 0;    // Count the numbers read
        String expression = tfExpression.getText();
        // Loop through the expression
        for (int i = 0; i < expression.length(); i++) {
            // 1 Digit number case
            if ((expression.charAt(i) >= 48 && expression.charAt(i) <= 57)
                    && i != expression.length() - 1
                    && expression.charAt(i + 1) >= 48 && expression.charAt(i + 1) <= 57){
                int number = Integer.parseInt(expression.charAt(i) + "" + expression.charAt(i + 1));
                i++;
                if (number % 13 != cards.get(counter) % 13) {
                    return false;
                }
                counter++;
                // 2 Digit number case
            } else if (expression.charAt(i) >= 48 && expression.charAt(i) <= 57) {
                int number = Integer.parseInt(expression.charAt(i) + "");
                if (number != cards.get(counter) % 13) {
                    return false;
                }
                counter++;
            }
        }
        return counter == 4;
    }
    // Returns the evaulation of the expression 
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') {
                    nextChar();
                }
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) {
                        x += parseTerm(); // addition
                    } else if (eat('-')) {
                        x -= parseTerm(); // subtraction
                    } else {
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) {
                        x *= parseFactor(); // multiplication
                    } else if (eat('/')) {
                        x /= parseFactor(); // division
                    } else {
                        return x;
                    }
                }
            }

            double parseFactor() {
                if (eat('+')) {
                    return parseFactor(); // unary plus
                }
                if (eat('-')) {
                    return -parseFactor(); // unary minus
                }
                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        nextChar();
                    }
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') {
                        nextChar();
                    }
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) {
                        x = Math.sqrt(x);
                    } else if (func.equals("sin")) {
                        x = Math.sin(Math.toRadians(x));
                    } else if (func.equals("cos")) {
                        x = Math.cos(Math.toRadians(x));
                    } else if (func.equals("tan")) {
                        x = Math.tan(Math.toRadians(x));
                    } else {
                        throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) {
                    x = Math.pow(x, parseFactor()); // exponentiation
                }
                return x;
            }
        }.parse();
    }

}
