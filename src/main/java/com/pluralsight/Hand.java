package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int score = 0;

        for (Card card : cards) {
            score += card.getPointValue();
        }

        return score;
    }

    public String toString() {
        return cards.toString();
    }
}