package com.pluralsight;

public class Card {
    private String suit;
    private String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public int getPointValue() {
        if (value.equals("Jack") || value.equals("Queen") || value.equals("King")) {
            return 10;
        } else if (value.equals("Ace")) {
            return 11;
        } else {
            return Integer.parseInt(value);
        }
    }

    public String toString() {
        return value + " of " + suit;
    }
}
