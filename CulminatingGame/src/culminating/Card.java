/*
 * Name: Shruti Gogna
 * Date: Tuesday, December 19, 2023.
 * Course: ICS4U1
 * Description: create card class to hold the class
 */

package culminating;

public class Card {
	 final Suit suit;
	 final Value value;
	
	public Card (Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	/*
	 * Purpose: initialize the suits of the cards
	 */
	enum Suit {
		Spade, Heart, Club, Diamond;
		
		private static final Suit [] suits = Suit.values();
		 static Suit getSuit (int i) {
			return Suit.suits[i];
		}
			/*
			 * Purpose: return the suit value of the card
			 * Pre: Suit suit
			 * Post: int
			 */
			public int getSuitRank(Suit suit) {
				if (suit == Suit.Spade)
					return 1;
				else if (suit == Suit.Heart)
					return 2;
				else if (suit == Suit.Club)
					return 3;
				else
					return 4;
			}
	}
	
	/*
	 * Purpose: initialize the value of the cards
	 */
	enum Value {
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;
		
		private static final Value [] values = Value.values();
		 static Value getValue (int i) {
			return Value.values[i];
		}
	}
	
	/*
	 * Purpose: return the suit of the card
	 * Pre: none
	 * Post: Suit suit
	 */
	public Suit getSuit() {
		return this.suit;
	}
	
	/*
	 * Purpose: return the value of the card
	 * Pre: none
	 * Post: Value value
	 */
	public Value getValue() {
		return this.value;
	}
	
	/*
	 * Purpose: return the suit value of the card
	 * Pre: Suit suit
	 * Post: int
	 */
	public int getSuitRank() {
		if (suit == Suit.Spade)
			return 1;
		else if (suit == Suit.Heart)
			return 2;
		else if (suit == Suit.Club)
			return 3;
		else
			return 4;
	}
	
	
	
	/*
	 * Purpose: override toString method to return all instance variables (suit and value) of each card
	 * Pre: none
	 * Post: String
	 */
	public String toString () {
		return suit + "_" + value;
	}
	
	/*
	 * Purpose: check if two cards are equal
	 * Pre: Card c
	 * Post: boolean
	 */
	public boolean equals (Card c) {
		Card check = (Card)c;
		if (check.suit == this.suit && check.value == this.value) {
			return true;
			
		}
			
		else
			return false;
	}

}
