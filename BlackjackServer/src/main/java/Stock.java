import Enums.Facename;
import Enums.Suit;



public class Stock {
    public Card[] cards;
    int amount;

        public Stock() {
            refill();
        }

        public final void refill() {
            int i = 0;
            cards = new Card[amount*52];
            while(i != (amount*52))
            for (Suit suit : Suit.values()) {
                for (Facename rank : Facename.values()) {
                    cards[i++] = new Card(suit, rank);
                }
            }
        }

        public Card drawCard() {
            Card card = null;
            while (card == null) {
                int index = (int)(Math.random()*cards.length);
                card = cards[index];
                cards[index] = null;
            }
            return card;
        }
    }
