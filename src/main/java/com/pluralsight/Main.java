package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Blackjack!");

        System.out.print("Enter player 1 name: ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter player 2 name: ");
        String player2Name = scanner.nextLine();

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        Deck deck = new Deck();
        deck.shuffle();

        player1.getHand().addCard(deck.dealCard());
        player1.getHand().addCard(deck.dealCard());

        player2.getHand().addCard(deck.dealCard());
        player2.getHand().addCard(deck.dealCard());

        System.out.println();
        System.out.println(player1.getName() + "'s hand: " + player1.getHand());
        System.out.println("Score: " + player1.getHand().getScore());

        System.out.println();

        System.out.println(player2.getName() + "'s hand: " + player2.getHand());
        System.out.println("Score: " + player2.getHand().getScore());

        int score1 = player1.getHand().getScore();
        int score2 = player2.getHand().getScore();

        System.out.println();

        if (score1 > 21 && score2 > 21) {
            System.out.println("Both players busted. No winner.");
        } else if (score1 > 21) {
            System.out.println(player2.getName() + " wins!");
        } else if (score2 > 21) {
            System.out.println(player1.getName() + " wins!");
        } else if (score1 > score2) {
            System.out.println(player1.getName() + " wins!");
        } else if (score2 > score1) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}