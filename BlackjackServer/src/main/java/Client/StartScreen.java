package Client;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private Login login = new Login();

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
            Client client = new Client(BlackjackClient.port, ip, gameContainer);         //aan t eind van het spel
            gameContainer.setClient(client);
            new Thread(client).start();
            return;
        }

        HBox hBox = new HBox();
        HBox hBox2 = new HBox();
        VBox vBox2 = new VBox();
        Label username = new Label("Username:");
        Label password = new Label("Password:");
        TextField inputUsername = new TextField();
        TextField inputPassword = new TextField();

        hBox.getChildren().addAll(username, inputUsername);
        hBox2.getChildren().addAll(password, inputPassword);  //hier moet de inlog pagina
        vBox2.getChildren().addAll(hBox,hBox2);
        VBox vBox = new VBox();

        javafx.scene.control.Button connectButton = new javafx.scene.control.Button();

        connectButton.setText("Play!");

        connectButton.setOnAction((event -> {
            String usernamevalue = inputUsername.getText();
            String passwordvalue = inputPassword.getText();

            if(login.registerPlayer(usernamevalue,passwordvalue)) {

                GameContainer gameContainer = new GameContainer(primaryStage);
                Client client = new Client(BlackjackClient.port, "Localhost", gameContainer);     //Hier start het spel/
                gameContainer.setClient(client);
                new Thread(client).start(); //start denk ik
            }
             else{
                  Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Error");
                  alert.setHeaderText("Wrong login information");
                  alert.setContentText("idioot");
                  alert.showAndWait();
            }
        }));

        vBox.getChildren().addAll(vBox2, connectButton);

        BorderPane mainPane = new BorderPane();

        mainPane.setCenter(vBox);               //kleine connectie scherm //ip enzo

        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }
}
