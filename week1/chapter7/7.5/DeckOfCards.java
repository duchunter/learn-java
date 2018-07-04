// DeckOfCards.java - section 7.5
// DeckOfCards class represents a deck of playing cards

import java.util.Random;

public class DeckOfCards {
  // Const number of cards
  private static final int NUMBER_OF_CARDS = 52;

  // Deck that contains cards
  private Card[] deck = new Card[NUMBER_OF_CARDS];

  // Index of the current card
  private int currentCard;

  // Random number generator
  private static final Random randomNumbers = new Random();

  // Constructor fills deck with cards
  public DeckOfCards() {
    String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    String[] faces = {
      "Ace", "Deuce", "Three", "Four", "Five", "Six",
      "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"
    };

    // Populate deck with Card
    for (int i = 0; i < NUMBER_OF_CARDS; i++)
    deck[i] = new Card(faces[i % 13], suits[i / 13]);
  }

  // Shuffle deck
  public void shuffle() {
    // For each card, pick another random card (0-51) and swap
    for (int first = 0; first < NUMBER_OF_CARDS; first++) {
      // Select a random number between 0 and 51
      int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

      // Swap 2 cards
      Card temp = deck[first];
      deck[first] = deck[second];
      deck[second] = temp;
    }

    // After shuffling, return to the top card
    currentCard = 0;
  }

  // Deal a card
  public Card dealCard() {
    // if there're cards remain, return it and move currentCard to next index
    // if not return null
    return (currentCard < NUMBER_OF_CARDS) ? deck[currentCard++] : null;
  }
}
