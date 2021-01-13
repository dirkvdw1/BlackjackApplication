package Client;

import models.Dealercards;
import models.PlayerCards;
import models.Table;

import java.util.List;

public interface IblackjackServer {


    PlayerCards startNewGame(PlayerCards player,Dealercards dealercards);

    Dealercards GiveDealer2cards(Dealercards dealer);

    PlayerCards hitHand(PlayerCards player);

    PlayerCards standHand(PlayerCards player);

    Dealercards startDealer(Dealercards dealer);

    Table endGame(List<PlayerCards> players,Dealercards dealer);
}
