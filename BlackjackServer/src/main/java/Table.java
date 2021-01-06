import Enums.Suit;
import javafx.collections.ObservableList;
import java.util.List;


public class Table {

    private List<PlayerCards> players;
    private Dealercards dealer;


    public Table(List<PlayerCards> players) {
        players = players;
        this.dealer = new Dealercards();
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


