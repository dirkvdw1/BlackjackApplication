package Client;





import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameContainer {

    private final Stage window;
    private GraphicsContext graphicsContext;
    private Canvas canvas;

    private String guessWord;
    private String drawWord;

    private boolean yourTurn;
    private boolean started;
    private int points;

    private Client client;
    private Font impact;


    public GameContainer(Stage primaryStage) {
        this.window = primaryStage;
        this.initVar();
    }

    /**
     * Call all the initializers.
     */
    public void start() {
        this.initWindow();
        this.initStartScreen();

    }

    /**
     * initialising variables.
     */
    public void initVar() {
        this.yourTurn = false;
        this.started = false;
        this.guessWord = "";
        this.drawWord = "";
        this.points = -1;
        this.impact = new Font("Impact", 60);
    }

    /**
     * init javafx graphicContext and canvas onto the stage.
     */
    private void initWindow() {
        this.canvas = new Canvas();

        this.graphicsContext = canvas.getGraphicsContext2D();
        this.getGraphicsContext().setFont(impact);

        this.window.setResizable(false);

        this.canvas.widthProperty().bind(this.window.widthProperty());
        this.canvas.heightProperty().bind(this.window.heightProperty());

        BorderPane mainPane = new BorderPane();
        mainPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        mainPane.setCenter(this.canvas);

        this.window.setScene(new Scene(mainPane, 1200, 600));
        this.window.show();
    }

    /**
     * init screen view for StartScreen.
     */
    private void initStartScreen() {
        this.updateGuess("Wachten op andere spelers!");
    }

    /**
     * init the toolbar.
     */


    /**
     * init the bar to type your guess.
     */
    private void initGuessBar() {
        this.guessWord = "";
        this.updateGuess("");
        this.graphicsContext.strokeLine(0, 100, this.canvas.getWidth(), 100);
    }

    /**
     * init the callbacks from mouse and key pressed, these callbacks will update
     * the game.
     */




    /**
     * this method will init a thread which will update the timer each second.
     */

    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * This method will set the turn, it will call the right toolbar after.
     * @param yourTurn true = your turn, false = not your turn.
     */


    /**
     * This method is called whenever the client receives the disconnect msg.
     */
    public void onDisconnect() {
        this.points = -1;
        this.yourTurn = false;
        this.started = false;

        updateGuess("Tegenstander heeft het spel verlaten!");
    }

    public void onServerStop(){
        this.points = -1;
        this.yourTurn = false;
        this.started = false;

        updateGuess("De server is gestopt!");
    }



    /**
     * This methode will clear the toolbar, it will determine the right coords
     * to place the text in the middle of the x from canvas.
     * @param word the current guess.
     */
    private void updateGuess(String word) {
        this.graphicsContext.clearRect(0, 0, canvas.getWidth() - 100, 90);
        Text guess = new Text(word);
        guess.setFont(impact);
        this.getGraphicsContext().fillText(word, (canvas.getWidth() / 2.0) - (guess.getLayoutBounds().getWidth() / 2.0), 80);
    }


    /**
     * This method is called when the GameTimer is out of seconds.
     */

    /**
     * This method generates a button in the center of the canvas.
     * @param msg message to come with the button.
     * @param color collor of the button.
     */


    /**
     * This method will pull a random word from the words json.
     * @param jsonFileLocation location of the .json.
     * @return random word to draw.
     */
    private String getRandomWord(String jsonFileLocation) {
        JsonReader reader = Json.createReader(getClass().getResourceAsStream(jsonFileLocation));
        JsonObject jsonObject = reader.readObject();
        JsonArray jsonValues = jsonObject.getJsonArray("words");
        return jsonValues.get(new Random().nextInt(jsonValues.size() - 1)).toString();
    }

    public String getDrawWord() {
        return drawWord;
    }



    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }
}
