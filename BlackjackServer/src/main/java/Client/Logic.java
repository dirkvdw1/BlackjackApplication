package Client;

import Client.IblackjackServer;
import models.Dealercards;
import models.PlayerCards;
import models.Stock;
import models.Table;

import java.util.List;

public class Logic implements IblackjackServer {

    private Stock stock;
    int ready;
    public Logic(){
        stock = new Stock();
    }
    public PlayerCards startNewGame(PlayerCards player,Dealercards dealer){
        player.takeCard(stock.drawCard());
        player.takeCard(stock.drawCard());
        ready++;
        if(ready == 2){
            GiveDealer2cards(dealer);               //Jorn?     zo ja reset aanpassen
        }
        return player;
        }
//    public Table startNewGame(List<PlayerCards> playerList, Dealercards dealer){
//        for(PlayerCards p : playerList){
//            p.takeCard(stock.drawCard());
//            p.takeCard(stock.drawCard());
//        }
//        dealer.takeCard(stock.drawCard());
//        dealer.takeCard(stock.drawCard());
//        return new Table(playerList,dealer);
//    }
    public Dealercards GiveDealer2cards(Dealercards dealer){
        dealer.takeCard(stock.drawCard());
        dealer.takeCard(stock.drawCard());
        ready = 0;
        return dealer;
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
        return player;
    }

    public Dealercards startDealer(Dealercards dealer) {
        dealer.TakecardsFordealer();
            return dealer;
    }

    public Table endGame(List<PlayerCards> players,Dealercards dealer){
        for(PlayerCards p: players){
            if(p.getCardvalue() > dealer.getvalue() && p.getCardvalue() <= 21){
                p.setMessage("Winner");
            }
            else if(p.getCardvalue() == dealer.getvalue() && p.getCardvalue() < 21){
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
