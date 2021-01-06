package models;

import models.Card;
import models.Stock;

import java.util.List;

public class Dealercards extends PlayerCards {
    public List<Card> cards;
    public int value;
    public int Timer;
    private Stock stock;


    public void TakecardsFordealer(){
        while(value <= 17){
            takeCard(stock.drawCard());
        }
        stock.refill();
    }






    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getTimer() {
        return Timer;
    }

    public void setTimer(int timer) {
        Timer = timer;
    }
}
