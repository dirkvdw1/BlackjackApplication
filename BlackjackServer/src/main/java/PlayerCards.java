import Enums.Suit;

import java.util.List;

public class PlayerCards {
    public List<Card> cards;
    public int cardvalue;
    public int betvalue;
    public boolean finished;
    private int aces;


    public void takeCard(Card card) {
        cards.add(card);

        if (card.suit == Suit.Ace) {
            aces++;
        }

        if (cardvalue + card.suit.getValue() > 21 && aces > 0) {
            cardvalue = cardvalue + card.suit.getValue() -10;
            aces--;
        }
        else {
            cardvalue = cardvalue + card.suit.getValue();
        }
    }

    public void reset() {
        cards.clear();
        cardvalue = 0;
        aces = 0;
        betvalue = 0;
    }


    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getCardvalue() {
        return cardvalue;
    }

    public void setCardvalue(int cardvalue) {
        this.cardvalue = cardvalue;
    }

    public int getBetvalue() {
        return betvalue;
    }

    public void setBetvalue(int betvalue) {
        this.betvalue = betvalue;
    }
}
