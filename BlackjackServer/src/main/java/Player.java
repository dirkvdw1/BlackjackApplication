import java.util.List;

public class Player {
    public String Name;
    public String password;
    public int chips;
    public List<PlayerCards> hand;




















    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public List<PlayerCards> getHand() {
        return hand;
    }

    public void setHand(List<PlayerCards> hand) {
        this.hand = hand;
    }
}
