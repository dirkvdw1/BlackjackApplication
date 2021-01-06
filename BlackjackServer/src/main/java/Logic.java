import java.util.List;

public class Logic {

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

    public Dealercards startDealer(Dealercards dealer){
        return null;}

    public Table endGame(){
        return null;
    }




    public boolean ready() {
        for (PlayerCards player : players) {
            if (player.getFinished() == false) {
                return false;
            }
        }
        dealer.Takecards();
        return true;
    }
}
