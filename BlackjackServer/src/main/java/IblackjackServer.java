import models.Dealercards;
import models.PlayerCards;
import models.Table;

import java.util.List;

public interface IblackjackServer {

    Table startNewGame(List<PlayerCards> playerList, Dealercards dealer);

    PlayerCards hitHand(PlayerCards player);

    PlayerCards standHand(PlayerCards player);

    Dealercards startDealer(Dealercards dealer);

    Table endGame(List<PlayerCards> players,Dealercards dealer);
}
