package models;

import models.PlayerCards;

import java.util.List;

public class Player {
    public int id;
    public String Name;
    public String password;
    public int chips;
    public List<PlayerCards> hand;

     public Player(int id,String name,String password){
        this.id = id;
        this.Name = name;
        this.password = password;
    }
    public Player(){

    }




















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
