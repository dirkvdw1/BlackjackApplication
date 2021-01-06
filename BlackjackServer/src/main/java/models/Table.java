package models;

import Enums.Suit;
import javafx.collections.ObservableList;
import java.util.List;


public class Table  {

    private List<PlayerCards> players;
    private Dealercards dealer;

    public Table(List<PlayerCards> players, Dealercards dealer) {
        this.players = players;
        this.dealer = dealer;
    }

}


