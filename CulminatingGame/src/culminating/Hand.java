/*
 * Name: Shruti Gogna
 * Date: Wednesday, December 27, 2023.
 * Course: ICS4U1
 * Description: create a hand of cards for a player
 */

package culminating;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private ArrayList<Card> hand;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public Hand(ArrayList<Card> list) {
		hand = list;
	}
	
	/*
	 * Purpose: sort the hand by suit
	 * Pre: none
	 * Post: Hand
	 */
	public Hand sortBySuit() {
		/*ArrayList<Card> newHand = new ArrayList<Card>();
		while (hand.size() > 0) {
			int minIndex = 0;
			
		}*/
		ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Card c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if ( c1.getSuitRank() < c.getSuitRank() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue().compareTo(c.getValue()) < 0) ) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
        Hand h = new Hand (hand);
        return h;
		/*for (int i = 1; i < hand.size(); ++i) {
			Card key = hand.get(i);
			int j = i-1;
			while (j >= 0 && hand.get(j).getSuitRank(hand.get(j).getSuit()) > key.getSuitRank(key.getSuit())) {
				//int num = j+1;
				hand.set(j+1, hand.get(j));
				j = j-1;
			}
			hand.set(j+1, key);
			//hand.get((j+1)) = key;
		}
		Hand h = new Hand (hand);*/
	}
	
	/*
	 * Purpose: sort the hand by values
	 * Pre: none
	 * Post: Hand
	 */
	public Hand sortByValue() {
		ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Card c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if ( c1.getValue().compareTo(c.getValue()) < 0 ||
                        (c1.getValue() == c.getValue() && c1.getSuit().compareTo(c.getSuit()) < 0) ) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
        Hand h = new Hand (hand);
        return h;
	}
	
	/*
	 * Purpose: set a card in a hand
	 * Pre: int i, Card card
	 * Post: none
	 */
	private void set(int i, Card card) {
		hand.set(i, card);	
	}

	/*
	 * Purpose: determine how many cards are in this hand
	 * Pre: none
	 * Post: int
	 */
	public int getCardCount() {
		return hand.size();
	}
	
	/*
	 * Purpose: add a card to this player's hand
	 * Pre: Card c
	 * Post: Hand h
	 */
	public Hand addCard(Card c) {
		hand.add(c);
		Hand h = new Hand (hand);
		return h;
	}
	
	/*
	 * Purpose: remove a card from this player's hand
	 * Pre: Card c
	 * Post: Hand h
	 */
	public Hand removeCard (Card c) {
		//System.out.print("Index of: " + hand.indexOf(c) + "\t");
		//hand.remove(c);
		
		//System.out.print(c.toString() + "IN HAND: ");
		for (int i = 0; i < hand.size(); i++) {
			//System.out.print(hand.get(i) + ", ");
			if (hand.get(i).equals(c)) {
				hand.remove(i);
				break;
			}
		}
			
		/*System.out.println("new");
		for (int i = 0; i < hand.size(); i++) {
			System.out.print(hand.get(i) + ", ");
			
		}*/
		Hand h = new Hand (hand);
		return h;
	}
	
	/*
	 * Purpose: return the card at a specific position
	 * Pre: int index
	 * Post: Card
	 */
	public Card get(int index) {
		return hand.get(index);
	}
}
