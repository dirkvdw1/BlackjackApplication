package Client;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class is used to show the start screen of the application,
 * this screen will allow the user to put in the IP adress that he wants to connect to and press the play button to start the game.
 */

public class StartScreen extends Application {

    private boolean replay;
    private String ip;

    public void setVar(boolean replay, String ip){
        this.replay = replay;
        if(replay){
            this.ip = ip;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        if(replay){     //skipt ie in begin
            GameContainer gameContainer = new GameContainer(primaryStage);
            Client client = new Client(JavaFX.port, ip, gameContainer);         //aan t eind van het spel
            gameContainer.setClient(client);
            new Thread(client).start();
            return;
        }

        HBox hBox = new HBox();
        Label ip = new Label("IP:");
        TextField inputIP = new TextField();

        hBox.getChildren().addAll(ip, inputIP);                 //hier moet de inlog pagina

        VBox vBox = new VBox();

        javafx.scene.control.Button connectButton = new javafx.scene.control.Button();

        connectButton.setText("Play!");

        connectButton.setOnAction((event -> {
            GameContainer gameContainer = new GameContainer(primaryStage);
            Client client = new Client(BlackjackClient.port, inputIP.getText(), gameContainer);     //Hier start het spel/
            gameContainer.setClient(client);
            new Thread(client).start();     //start denk ik     //scherm van t wachten
        }));

        vBox.getChildren().addAll(hBox, connectButton);

        BorderPane mainPane = new BorderPane();

        mainPane.setCenter(vBox);               //kleine connectie scherm //ip enzo

        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }
}
