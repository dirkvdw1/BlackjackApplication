package Enums;

public enum Suit {
    Ace(11),
    King(10),
    Queen(10),
    Jack(10),
    Ten(10),
    Nine(9),
    Eight(8),
    Seven(7),
    Six(6),
    Five(5),
    Four(4),
    Three(3),
    Two(2);

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

     Suit(int value){
        this.value = value;
    }
}
