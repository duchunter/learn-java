// DeckOfCardsTest.java - section 7.5
// Card shuffling and dealing

public class DeckOfCardsTest {
  public static void main(String[] args) {
    // Create a new deck and shuffle
    DeckOfCards myDeck = new DeckOfCards();
    myDeck.shuffle();

    // Deal all 52 cards
    for (int i = 1; i <= 52; i++) {
      System.out.printf("%-19s", myDeck.dealCard());

      // Line break every 4 cards
      if (i % 4 == 0) {
        System.out.println();
      }
    }
  }
}
