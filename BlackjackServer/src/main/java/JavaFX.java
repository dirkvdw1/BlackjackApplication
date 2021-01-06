import javafx.application.Application;
        import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.Pane;
        import javafx.scene.layout.Region;
        import javafx.scene.layout.StackPane;
        import javafx.scene.layout.VBox;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
import models.PlayerCards;
import models.Stock;

/**
 * Game's logic and UI
 *
 * @author Almas Baimagambetov
 */
public class JavaFX extends Application {

    private Stock deck = new Stock();
    private PlayerCards player, dealer;
    private Text message = new Text();

    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

    private HBox Box2 = new HBox(20);
    private HBox Box1 = new HBox(20);

    private Parent createContent() {


        Pane root = new Pane();
        root.setPrefSize(800, 600);

        Region background = new Region();
        background.setPrefSize(800, 600);
        background.setStyle("-fx-background-color: rgba(0, 0, 0, 1)");

        HBox rootLayout = new HBox(5);
        rootLayout.setPadding(new Insets(5, 5, 5, 5));
        Rectangle leftBG = new Rectangle(550, 560);
        leftBG.setArcWidth(50);
        leftBG.setArcHeight(50);
        leftBG.setFill(Color.GREEN);
        Rectangle rightBG = new Rectangle(230, 560);
        rightBG.setArcWidth(50);
        rightBG.setArcHeight(50);
        rightBG.setFill(Color.ORANGE);

        // LEFT
        VBox leftVBox = new VBox(50);
        leftVBox.setAlignment(Pos.TOP_CENTER);

        Text dealerScore = new Text("Dealer: ");
        Text playerScore = new Text("Players: ");

        leftVBox.getChildren().addAll(dealerScore, Box1, message, Box2, playerScore);

        // RIGHT

        VBox rightVBox = new VBox(20);
        rightVBox.setAlignment(Pos.CENTER);

        final TextField bet = new TextField("BET");
        bet.setDisable(true);
        bet.setMaxWidth(50);
        Text money = new Text("MONEY");

        Button btnPlay = new Button("PLAY");
        Button btnHit = new Button("HIT");
        Button btnStand = new Button("STAND");

        HBox buttonsHBox = new HBox(15, btnHit, btnStand);
        buttonsHBox.setAlignment(Pos.CENTER);

        rightVBox.getChildren().addAll(bet, btnPlay, money, buttonsHBox);

        // ADD BOTH STACKS TO ROOT LAYOUT

        rootLayout.getChildren().addAll(new StackPane(leftBG, leftVBox), new StackPane(rightBG, rightVBox));
        root.getChildren().addAll(background, rootLayout);

        // BIND PROPERTIES

        btnPlay.disableProperty().bind(playable);
        btnHit.disableProperty().bind(playable.not());
        btnStand.disableProperty().bind(playable.not());

       // playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.getCardvalue()));
        //dealerScore.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(dealer.getCardvalue()));

      // player.addListener((obs, old, newValue) -> {
       //     if (/*newValue.intValue() */0>= 21) {
       //         player.setMessage("busted");
       //     }
       // });

   /*     dealer.valueProperty().addListener((obs, old, newValue) -> {
            if (/*newValue.intValue()0 >= 21) {
                endGame();
            }
        });*/

        // INIT BUTTONS

        btnPlay.setOnAction(event -> {
            startNewGame();
        });

        btnHit.setOnAction(event -> {
            player.takeCard(deck.drawCard());  //websockets
        });

        btnStand.setOnAction(event -> {
            dealer.getCards();
            endGame();
        });

        return root;
    }

    private void startNewGame() {
        playable.set(true);
        message.setText("");

    }

    private void endGame() {
        playable.set(false);

        int dealerValue = dealer.getCardvalue();
        int playerValue = player.getCardvalue();
        String winner = "Exceptional case: d: " + dealerValue + " p: " + playerValue;

        // the order of checking is important
        if (dealerValue == 21 || playerValue > 21 || dealerValue == playerValue
                || (dealerValue < 21 && dealerValue > playerValue)) {
            winner = "DEALER";
        }
        else if (playerValue == 21 || dealerValue > 21 || playerValue > dealerValue) {
            winner = "PLAYER";
        }

        message.setText(winner + " WON");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setTitle("BlackJack");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
