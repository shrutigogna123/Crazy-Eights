/*
 * purpose: test class to test objects. WILL DELETE BEFORE PROJECT IS OVER
 */

package culminating;

import javax.swing.*;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Test extends JFrame{
//JPanel pnl = new JPanel();
	ArrayList <Hand> playerHand;
	String [] playerNames;
	Deck deck = new Deck();
	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck.cardsInDeck);
		deck.reset();
		System.out.println(deck.cardsInDeck);
deck.shuffle();
Test test = new Test();

	}
	
	public Test (){
		deck.reset();
		deck.shuffle();
		playerHand = new ArrayList<Hand>();
		playerNames = new String [4];
		playerNames[0] = "hi";
		for (int i = 1; i < playerNames.length; i++)
			playerNames[i] = "Player " + (i+1);
		for (int i = 0; i < playerNames.length; i++) {
			Hand hand;
			Card [] hand1 = new Card [8]; //array to hold how many cards are being drawn from deck
			for (int j = 0; j < 8; j++) {
				hand1[j] = deck.draw(); //draw 8 cards
			}
			ArrayList<Card> h = new ArrayList<Card> (Arrays.asList(hand1));
			hand = new Hand(h);
			playerHand.add(hand);
			
		}
		for (int i = 0; i < playerHand.get(0).getCardCount(); i++) {
			System.out.print(playerHand.get(0).get(i) + " ");
		}
		System.out.println();
		playerHand.set(0, playerHand.get(0).sortBySuit());
		for (int i = 0; i < playerHand.get(0).getCardCount(); i++) {
			System.out.print(playerHand.get(0).get(i) + " ");
		}
		System.out.println();
		setSize (92, 200);
		Card card = new Card(Card.Suit.Heart, Card.Value.Queen);
		/*CardImage card1 = new CardImage(card);
		JLabel img = new JLabel (card1);
		pnl.add(img);*/
		CardImage pnl = new CardImage(card, 92, 128);
		setLayout(new BorderLayout());
		add(pnl, "Center");
		/*Image i = createImage(pnl);
		ImageIcon img = new ImageIcon (i);
		JLabel lbl = new JLabel (img);
		add(lbl, "Center");*/
		setVisible(true);
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Card.Suit.Spade, Card.Value.Four));
		cards.add(new Card(Card.Suit.Club, Card.Value.Four));
		cards.add(new Card(Card.Suit.Heart, Card.Value.Four));
		cards.add(new Card(Card.Suit.Diamond, Card.Value.Four));
		cards.add(new Card(Card.Suit.Diamond, Card.Value.Five));
		cards.add(new Card(Card.Suit.Diamond, Card.Value.Ace));
		cards.add(new Card(Card.Suit.Diamond, Card.Value.Six));
		Hand hand = new Hand(cards);
		for (int i = 0; i < hand.getCardCount(); i++) {
			System.out.print(hand.get(i) + " ");
		}
		System.out.println();
		hand = hand.sortBySuit();
		for (int i = 0; i < hand.getCardCount(); i++) {
			System.out.print(hand.get(i) + " ");
		}
		System.out.println();
	}
	
	/*public BufferedImage createImage(JPanel pnl) {
		int w = pnl.getWidth();
	    int h = pnl.getHeight();
	    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = bi.createGraphics();
	    pnl.print(g);
	    g.dispose();
	    return bi;
	}*/

}
