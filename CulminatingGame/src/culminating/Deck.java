/*
 * Name: Shruti Gogna
 * Date: Tuesday, December 19, 2023.
 * Course: ICS4U1
 * Description: Create a deck with cards
 */
package culminating;

import java.util.ArrayList;

public class Deck {
	private Card [] cards;
	 int cardsInDeck;
	
	public Deck () {
		cards = new Card[52];
		reset();
	}
	
	/*
	 * Purpose: reset the deck with 52 new cards
	 * Pre: none
	 * Post: none
	 */
	public void reset() {
		Card.Suit[] suits = Card.Suit.values(); //create an array with the enumeration of Suits and filling it in with the Suit values (Spade, Heart, Club, Diamond)
		cardsInDeck = 0;
		
		for (int i = 0; i < suits.length; i++) { //loop for suits
			Card.Suit suit = suits[i]; //create just one Suit that is the suit at the position of the counter
			for (int j = 0; j < 13; j++) //loop for card value
				cards[cardsInDeck++] = new Card(suit, Card.Value.getValue(j)); //create a card with the suit[i] and the value of the enum of Values at the position j
		}
	}
	
	/*
	 * Purpose: replace current deck with new deck of cards
	 * Pre: ArrayList <Card> newCards
	 * Post: none
	 */
	public void replace (ArrayList <Card> newCards) {
		this.cards = newCards.toArray(new Card[newCards.size()]); //convert ArrayList of newCards into an array with the number of Cards in the deck being the same size as the newCards size
		this.cardsInDeck = this.cards.length;
	}
	
	/*
	 * Purpose: check if deck is empty
	 * Pre: none
	 * Post: boolean
	 */
	public boolean isEmpty() {
		if (cardsInDeck <= 0)
			return true;
		else
			return false;
	}
	
	/*
	 * Purpose: shuffle the current deck
	 * Pre: none
	 * Post: none
	 */
	public void shuffle() {
		int num = cards.length;
		for (int i = 0; i < num; i++) {//choose a random Card of the deck and swap it with the Card at i
			int randomIndex = (int) (Math.random()* (num-i-1)+ i); //subtract i from num to account for the number of cards already sorted; add i at the end to check the current position of the array onwards
			Card randomCard = cards[randomIndex];
			cards[randomIndex] = cards[i];
			cards[i] = randomCard;
		}
	}
	
	/*
	 * Purpose: draw a card from the deck
	 * Pre: none
	 * Post: Card
	 */
	public Card draw() throws IllegalArgumentException {
		if (isEmpty() == true) {
			//FIGURE OUT HOW TO DO THIS ; change discard pile into draw pile
			//video uses throws illegal argument ...
			//get method that changes discard pile into draw and then recursively call this one
			throw new IllegalArgumentException("Unable to draw a card for now"); 
		}
		return cards[--cardsInDeck];

			
	}

}
