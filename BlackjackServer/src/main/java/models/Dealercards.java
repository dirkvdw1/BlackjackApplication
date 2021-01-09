package models;

import Enums.Suit;
import models.Card;
import models.Stock;

import java.util.ArrayList;
import java.util.List;

public class Dealercards {
    public List<Card> cards;
    public int value;
    public int Timer;
    private Stock stock;
    private int aces;

    public Dealercards(){
        stock = new Stock();
        cards = new ArrayList<>();
    }

    public void TakecardsFordealer(){
        while(value <= 17){
           takeCard(stock.drawCard());
        }
        //stock.refill();
    }
    public void takeCard(Card card) {
        cards.add(card);

        if (card.suit == Suit.Ace) {
            aces++;
        }

        if (value + card.suit.getValue() > 21 && aces > 0) {
            value = value + card.suit.getValue() -10;
            aces--;
        }
        else {
            value = value + card.suit.getValue();
        }
    }






    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getvalue() {
        if(value != 0)
            return value;
        else
            return 0;
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
