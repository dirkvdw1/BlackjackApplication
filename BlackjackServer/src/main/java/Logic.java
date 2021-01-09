import models.Dealercards;
import models.PlayerCards;
import models.Stock;
import models.Table;

import java.util.List;

public class Logic implements IblackjackServer {

    private List<PlayerCards> players;
    private Dealercards dealer;
    private Stock stock;


    public Table startNewGame(List<PlayerCards> playerList, Dealercards dealer){
        for(PlayerCards p : playerList){
            p.takeCard(stock.drawCard());
            p.takeCard(stock.drawCard());
        }
        dealer.takeCard(stock.drawCard());
        dealer.takeCard(stock.drawCard());
        return new Table(players,dealer);
    }

    public PlayerCards hitHand(PlayerCards player){
        player.takeCard(stock.drawCard());
        if(player.getCardvalue() > 21){
            player.setMessage("Busted");
        }
        return player;
    }
    

    public PlayerCards standHand(PlayerCards player){
        player.setMessage("Stands on" + player.getCardvalue());
        return player;}

    public Dealercards startDealer(Dealercards dealer) {
        dealer.TakecardsFordealer();
            return dealer;
    }

    public Table endGame(List<PlayerCards> players,Dealercards dealer){
        for(PlayerCards p: players){
            if(p.getCardvalue() > dealer.getvalue() && p.getCardvalue() <= 21){
                p.setMessage("Winner");
            }
            else if(p.getCardvalue() == dealer.getCardvalue() && p.getCardvalue() < 21){
                p.setMessage("Draw");
            }
            else{
                p.setMessage("Lost");
            }
        }
        return new Table(players,dealer);
    }




//    public boolean ready() {
//        for (models.PlayerCards player : players) {
//            if (player.getFinished() == false) {
//                return false;
//            }
//        }
//        dealer.Takecards();
//        return true;
//    }
}
