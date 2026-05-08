package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Blackjack!");

        System.out.print("How many players? ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter player " + i + " name: ");
            String name = scanner.nextLine();

            Player player = new Player(name);
            players.add(player);
        }

        Deck deck = new Deck();
        deck.shuffle();

        for (Player player : players) {
            player.getHand().addCard(deck.dealCard());
            player.getHand().addCard(deck.dealCard());
        }

        Player winner = null;
        int bestScore = 0;

        System.out.println();

        for (Player player : players) {
            int score = player.getHand().getScore();

            System.out.println(player.getName() + "'s hand: " + player.getHand());
            System.out.println("Score: " + score);
            System.out.println();

            if (score <= 21 && score > bestScore) {
                bestScore = score;
                winner = player;
            }
        }

        if (winner == null) {
            System.out.println("Everyone busted. No winner.");
        } else {
            System.out.println(winner.getName() + " wins with " + bestScore + " points!");
        }

        scanner.close();
    }
}