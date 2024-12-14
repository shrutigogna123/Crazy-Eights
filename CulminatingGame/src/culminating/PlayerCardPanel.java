/*
 * Name: Shruti Gogna
 * Date: Thursday, December 28, 2023.
 * Course: ICS4U1
 * Description: update the player card panels with any change in order or number of cards
 */

package culminating;

import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PlayerCardPanel extends JPanel{
	JPanel pnl = new JPanel();
	JPanel main;
	static CardLayout nav;
	JButton scrollRight = new JButton ("➡");
	JButton scrollLeft = new JButton ("⬅");
	public PlayerCardPanel(int position, Hand hand) {
		scrollRight.setBackground(GameWindow.BLUEP);
		scrollRight.setForeground(GameWindow.WHITEP);
		scrollLeft.setBackground(GameWindow.BLUEP);
		scrollLeft.setForeground(GameWindow.WHITEP);
		setBackground(GameWindow.BLUEP);
		pnl.setBackground(GameWindow.BLUEP);
		//super (nav);
		main = new JPanel (GamePanel.playerC[position]);
		/*if (position == 0)
			main = new JPanel(GamePanel.userC);
		else if (position == 1)
			main = new JPanel(GamePanel.p2C);
		else if (position == 2)
			main = new JPanel(GamePanel.p3C);
		else
			main = new JPanel(GamePanel.p4C);*/
		//if (position == 0) {
			pnl.setBackground(GameWindow.BLUEP);
			if (position%2 == 0)
				pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
			else
				pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
			for (int i = 0; i < hand.getCardCount(); i++) {
				JLabel lbl = new JLabel();
				JPanel p = new JPanel();
				p.setSize(46, 64);
				p.setBackground(GameWindow.BLUEP);
				if (position == 0) {
					p = new CardImage(hand.get(i), 46, 64);
				}
				else if (position == 2)
					lbl = new JLabel (loadImageBack(46, 64));
				else
					lbl = new JLabel (loadRotatedImageBack(64, 46));
				if (position == 0)
					pnl.add(p);
				else
					pnl.add(lbl);
			}
			main.add(pnl, "initial");
			//nav.show(main, "initial");
			GamePanel.playerC[position].show(main, "initial");
			/*if (position == 0)
				GamePanel.userC.show(main, "initial");
			else if (position == 1)
				GamePanel.p2C.show(main, "initial");
			else if (position == 2)
				GamePanel.p3C.show(main, "initial");
			else
				GamePanel.p4C.show(main, "initial");*/
			add(main);
		//}
	}
	
	public PlayerCardPanel (JPanel pnl) {
		main = pnl;
		add(main);
	}
	
	/*
	 * Purpose: load back face of card based on width and height
	 * Pre: int width, int height
	 * Post: ImageIcon image
	 */
	public ImageIcon loadImageBack(int width, int height) {
		Image img = new ImageIcon("cards/Back.png").getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img);
		return image;
	}
	
	/*
	 * Purpose: load back face of card based on width and height. Is a rotated image of the back for players 2 and 4
	 * Pre: int width, int height
	 * Post: ImageIcon image
	 */
	public ImageIcon loadRotatedImageBack(int width, int height) {
		Image img = new ImageIcon("cards/CardBack.png").getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img);
		return image;
	}
	
	/*
	 * Purpose: update the panel and show it on CardLayout
	 * Pre: int position, Hand hand
	 * Post: none
	 */
	public void updatePanel (int position, Hand hand) {
		//System.out.println (position + " " + startIndex);
		//pnl.add(scrollRight);
		JPanel pnl = new JPanel();
		if (position%2 == 0)
			pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		else
			pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		for (int i = 0; i < hand.getCardCount(); i++) {
			JLabel lbl = new JLabel();
			JPanel p = new JPanel();
			p.setSize(46, 64);
			p.setBackground(GameWindow.BLUEP);
			/*if (hand.getCardCount() > 8 && startIndex > 0 && startIndex+8<=hand.getCardCount()) {
				pnl.add(scrollLeft);
				scrollLeft.setVisible(true);
				final int start = startIndex-1;
				if (start < 0)
					return;
				scrollLeft.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e) {
						updatePanel(position, hand, start);
					}
				});
			}
			else
				scrollLeft.setVisible(false);*/
			if (position == 0) {
				//for (int j = startIndex; j < 8+startIndex; j++) {
					//System.out.print(i + " ");
				if (hand.getCardCount() <= 14)
					p = new CardImage(hand.get(i), 46, 64);
				//}
					
				else if (hand.getCardCount() < 19)
					p = new CardImage(hand.get(i), 35, 48);
				else
					p = new CardImage(hand.get(i), 23, 32);
			}
			else if (position == 2)
				lbl = new JLabel (loadImageBack(46, 64));
			else
				lbl = new JLabel (loadRotatedImageBack(64, 46));
			if (position == 0)
				pnl.add(p);
			else
				pnl.add(lbl);
			/*if (hand.getCardCount() > 8 && startIndex<=hand.getCardCount()-8) {
				pnl.add(scrollRight);
				scrollRight.setVisible(true);
				final int start = startIndex+1;
				if (start > hand.getCardCount()-8)
					return;
				scrollRight.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e) {
						updatePanel(position, hand, start);
					}
				});
				
			}
			else
				scrollRight.setVisible(false);*/
		}
		
		//pnl.setBackground(GameWindow.BLUEP);
		main.add(pnl, "new" + GamePanel.round);
		//nav.show(main, "initial");
		GamePanel.playerC[position].show(main, "new" + GamePanel.round);
		/*if (position == 0)
			GamePanel.userC.show(main, "new" + GamePanel.round);
		else if (position == 1)
			GamePanel.p2C.show(main, "new" + GamePanel.round);
		else if (position == 2)
			GamePanel.p3C.show(main, "new" + GamePanel.round);
		else
			GamePanel.p4C.show(main, "new" + GamePanel.round);*/
		add(main);
		//PlayerCardPanel p = new PlayerCardPanel (main);
		//return p;
	}

}
