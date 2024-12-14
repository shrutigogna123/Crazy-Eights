/*
 * Name: Shruti Gogna
 * Date: Tuesday, December 19, 2023.
 * Course: ICS4U1
 * Description: create a card image
 */

package culminating;

import javax.swing.*;
/*import java.awt.event.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;*/


import java.awt.*;

public class CardImage extends JPanel {
	JPanel panel = new JPanel();
	//public JButton choose = new JButton("");
	JLabel b1 = new JLabel("");
	JLabel block2 = new JLabel("");
	JLabel suit, num;
	Card c;

	//card image to be ground, width, height
	public CardImage(Card card, int w, int h) {
		//super(img);
		setSize(w, h);
		panel.setSize(w, h);
		c = card;
		setBackground(GameWindow.BLUEP);
		//panel.setSize(92, 128);
		panel.setLayout(new GridLayout(2, 2));
		panel.setBackground(GameWindow.WHITEP);
		b1.setBackground(GameWindow.WHITEP);
		//choose.addActionListener(this);
		panel.add(b1);
		ImageIcon iconSuit;
		ImageIcon iconNum;
		if (card.getSuit().equals(Card.Suit.Spade)) {
			
			iconSuit = loadImage("cards/Spade.png", w/2, h/2);
		}
		else if (card.getSuit().equals(Card.Suit.Club))
			iconSuit = loadImage("cards/Club.png", w/2, h/2);
		else if (card.getSuit().equals(Card.Suit.Heart))
			iconSuit = loadImage("cards/Heart.png", w/2, h/2);
		else
			iconSuit = loadImage("cards/Diamond.png", w/2, h/2);
		suit = new JLabel (iconSuit);
		panel.add(suit);
		
		if (card.getValue().equals(Card.Value.Ace)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B1.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R1.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Two)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B2.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R2.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Three)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B3.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R3.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Four)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B4.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R4.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Five)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B5.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R5.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Six)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B6.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R6.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Seven)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B7.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R7.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Eight)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B8.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R8.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Nine)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B9.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R9.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Ten)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B10.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R10.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Jack)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B11.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R11.png", w/2, h/2);
		}
		else if (card.getValue().equals(Card.Value.Queen)) {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B12.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R12.png", w/2, h/2);
		}
		else {
			if (card.getSuit().equals(Card.Suit.Spade) || card.getSuit().equals(Card.Suit.Club))
				iconNum = loadImage("cards/B13.png", w/2, h/2);
			else
				iconNum = loadImage("cards/R13.png", w/2, h/2);
		}
		num = new JLabel (iconNum);
		panel.add(num);
		panel.add(block2);
		add(panel);
	}

	/*public static void main(String[] args) {
		CardImage img = new CardImage(new Card (Suit.Spade, Value.Jack));
	}*/

	/*
	 * Purpose: load image based on name, width and height
	 * Pre: String name, int width, int height
	 * Post: ImageIcon image
	 */
	public ImageIcon loadImage(String name, int width, int height) {
		Image img = new ImageIcon(name).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img);
		return image;
	}
	

	/*
	 * Purpose: override actionPerformed method for ActionListener inferface
	 * Pre: ActionEvent e
	 * Post: none
	 */
	/*public void actionPerformed(ActionEvent e) {
		if (GamePanel.validCardPlay(c) == true)
			GamePanel.userMessage.append("\n"+c.toString());
		else
			GamePanel.userMessage.append("\nInvalid option!");
		choose.setEnabled(false);
		
	}*/
	
	/*
	 * Purpose: return jbutton of choose
	 * Pre: none
	 * Post: JButton
	 */
	/*public JButton getChoose() {
		return choose;
	}*/
	
	/*
	 * Purpose: convert JPanel into a BufferedImage
	 * Pre: JPanel pnl
	 * Post: BufferedImage
	 */
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
