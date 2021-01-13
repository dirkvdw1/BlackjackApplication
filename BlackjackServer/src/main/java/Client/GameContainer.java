package Client;






import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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



//    private Stock deck = new Stock();
//    private PlayerCards player;
//    private Dealercards dealer;
//    private Text message = new Text();
//    private Logic logic = new Logic();
//    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);
//
//    private HBox Box2 = new HBox(20);
//    private HBox Box1 = new HBox(20);



    public GameContainer(Stage primaryStage) {
        this.window = primaryStage;
        this.initVar();
    }


    public void start() {
        //start het spel
        this.initWindow();
        this.initStartScreen();
        this.initHandlers();
    }


    public void initVar() {
        this.yourTurn = false;
        this.started = false;
        this.guessWord = "";
        this.drawWord = "";
        this.points = -1;
        this.impact = new Font("Impact", 60);
    }

    private void initWindow() {



        this.window.setResizable(false);


        BorderPane mainPane = new BorderPane();
        mainPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        mainPane.setCenter(this.canvas);

        this.window.setScene(new Scene(mainPane, 1200, 600));
        this.window.show();
    }
    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
        this.points++;
        this.started = false;
    }

    private void initStartScreen() {
       // this.updateGuess("Wachten op andere spelers!");
        makeButtonStartEnd("Spel starten", Color.GREEN);
    }
    private void makeButtonStartEnd(String msg, Color color) {
        Text text = new Text(msg);
        text.setFont(impact);
        this.graphicsContext.setFill(color);
        this.graphicsContext.fillRect(((this.canvas.getWidth() / 2.0) - ((text.getLayoutBounds().getWidth() / 2.0) + 20)),
                (this.canvas.getHeight() / 2.0) - 55,
                text.getLayoutBounds().getWidth() + 40,
                80);

        this.graphicsContext.setFill(Color.WHITE);
        this.graphicsContext.fillText(msg, (this.canvas.getWidth() / 2.0) - (text.getLayoutBounds().getWidth() / 2.0),
                (this.canvas.getHeight() / 2.0) + 10);
        this.graphicsContext.setFill(Color.BLACK);
        this.graphicsContext.strokeRect(((this.canvas.getWidth() / 2.0) - ((text.getLayoutBounds().getWidth() / 2.0) + 20)),
                (this.canvas.getHeight() / 2.0) - 55,
                text.getLayoutBounds().getWidth() + 40,
                80);
    }

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

        //updateGuess("Tegenstander heeft het spel verlaten!");
    }

    public void onServerStop(){
        this.points = -1;
        this.yourTurn = false;
        this.started = false;

       // updateGuess("De server is gestopt!");
    }








    private void initHandlers() {
        canvas.setOnMouseDragged((event -> {
//            if (yourTurn) {
//                if (event.getY() > 100) {
//                    this.pen.update(event.getX(), event.getY());
//                    this.pen.draw(graphicsContext);
//                    this.client.sendPackage(this.pen);
//                }
//            }
        }));

        canvas.setOnMouseMoved((event -> {
//            if (yourTurn) {
//                if (event.getY() < 100) {
//                    for (Button button : this.buttons) {
//                        if (button.contains(new Point2D(event.getX(), event.getY())) && !button.isSelected()) {
//                            button.clear(this.graphicsContext);
//                            button.setHighlighted(true);
//                            button.draw(this.graphicsContext);
//                        } else if (button.isHighlighted() && !button.isSelected()) {
//                            button.clear(this.graphicsContext);
//                            button.setHighlighted(false);
//                            button.draw(this.graphicsContext);
//                        }
//                    }
//                }
//            }
        }));

        canvas.setOnMouseClicked((event -> {
            if (yourTurn) {


                if (!started) {
                    if (points == -1) {
                        client.stop(false);
                        StartScreen startScreen = new StartScreen();
                        startScreen.setVar(false, "");
                        startScreen.start(window);
                    }
                    else {
                        StartScreen startScreen = new StartScreen();
                        startScreen.setVar(true, this.client.getIp());
                        startScreen.start(window);

                        started = true;
                    }
                }
            }
        }));

        canvas.setOnScroll((event -> {
            if (yourTurn) {

                this.graphicsContext.clearRect(700, 0, 96, 96);

//                if (event.getDeltaY() < 40) {
//                    if (this.pen.getWidth() > 4) {
//                        this.pen.setWidth(this.pen.getWidth() - 2);
//                    }
//                } else {
//                    if (this.pen.getWidth() < 90) {
//                        this.pen.setWidth(this.pen.getWidth() + 2);
//                    }
//                }
//
//                this.graphicsContext.strokeOval(750 - (this.pen.getWidth() / 2.0),
//                        50 - (this.pen.getWidth() / 2.0),
//                        this.pen.getWidth(),
//                        this.pen.getWidth());
//            }
            }
        }));

        window.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (!yourTurn && started) {
                if (event.getCode() == KeyCode.BACK_SPACE && guessWord.length() != 0) {
                    guessWord = guessWord.substring(0, guessWord.length() - 1);
                 //   updateGuess(guessWord);
                } else if (event.getCode() == KeyCode.ENTER && guessWord.length() > 0) {

                    this.client.sendGuess(guessWord);

                } else if (guessWord.length() < 15) {
                    if (guessWord.length() > 0) {
                        guessWord = guessWord + event.getText();
                    } else {
                        guessWord = event.getText();
                    }
                  //  updateGuess(guessWord);
                }
            }
        });

        window.setOnCloseRequest((event -> client.stop(true)));
    }

    public String getDrawWord() {
        return drawWord;
    }



    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }
}

