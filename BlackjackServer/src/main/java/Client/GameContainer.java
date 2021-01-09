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
    private Client client;


    public GameContainer(Stage primaryStage) {
        this.window = primaryStage;
    }

    public void start() {
        this.initStartScreen();

    }

    private void initStartScreen() {
        this.updateGuess("Wachten op andere spelers!");
        makeButtonStartEnd("Opnieuw invoeren?", Color.GREEN);
    }


    public void setClient(Client client) {
        this.client = client;
    }


    public void onDisconnect() {
        this.clearScreen();
        updateGuess("Tegenstander heeft het spel verlaten!");
        makeButtonStartEnd("klik op het scherm om terug te gaan.", Color.BLUE);
    }

    public void onServerStop(){
        this.clearScreen();
        updateGuess("De server is gestopt!");
        makeButtonStartEnd("klik op het scherm om terug te gaan.", Color.BLUE);
    }

    private void clearScreen() {
        this.graphicsContext.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
    }
}
