// Card.java - section 7.5
// Card class represents a playing card

public class Card {
  // Fields
  private String face; // ("Ace", "Deuce", ...)
  private String suit; // ("Hearts", "Diamonds", ...)

  // Constructor
  public Card (String cardFace, String cardSuit) {
    face = cardFace;
    suit = cardSuit;
  }

  // return String representation of Card
  public String toString() {
    return face + " of " + suit;
  }
}
