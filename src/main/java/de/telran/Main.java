package de.telran;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int cardsForPlayer = 5;
        int players;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final String [] suits = {"CLUBS", "DIAMONDS", "HARTS", "SPADES"};
        final String [] rank = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};
        final int numberOfCards = suits.length * rank.length;
        System.out.println("Number of cards = " + numberOfCards);

        while (true) {
            System.out.println("enter number of players:");
            if (scanner.hasNextInt()) {
                players = scanner.nextInt();
                if (cardsForPlayer * players <= numberOfCards) {
                    break;

                } else {
                    if (players == 0) {
                        System.out.println("The Game has been terminated");
                        break;
                    } else if (players<0) {
                        System.out.println("The number of players should be more than 0");
                        break;

                    } else {
                        System.out.println("Too many players");
                    }
                }
            } else {
                System.out.println("U have not entered the number");
            }
        }
        String [] deck = new String[numberOfCards];
        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck[suits.length * i + j] = rank[i] + " " + suits[j];
            }
        }
        for (int i = 0; i < numberOfCards; i++) {
            int card = i + random.nextInt(numberOfCards - i);
            String temp = deck[card];
            deck[card] = deck[i];
            deck[i] = temp;
        }
        for (int i = 0; i < players*cardsForPlayer; i++){
            System.out.println(deck[i] + ", ");
            if (i%cardsForPlayer == cardsForPlayer - 1) {
                System.out.println();
            }
        }
    }
}