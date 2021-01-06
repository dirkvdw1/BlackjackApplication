package models;

import Enums.Facename;
import Enums.Suit;



public class Card {

    public Facename facename;
    public Suit suit;


public Card(Suit suit, Facename facename){
    this.facename =facename;
    this.suit =suit;
}












    public Facename getFacename() {
        return facename;
    }

    public void setFacename(Facename facename) {
        this.facename = facename;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}
