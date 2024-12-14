/*
 * Name: Shruti Gogna
 * Date: Monday, December 18, 2023.
 * Course: ICS4U1
 * Description: set the game panel
 */

package culminating;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class GamePanel extends JPanel implements Runnable, KeyListener, ItemListener{
	private static Card.Suit validSuit;
	private static Card.Value validValue;
	String [] playerNames;
	int currentPlayer;
	Deck deck = new Deck();
	ArrayList <Hand> playerHand;
	ArrayList<Card> discardPile;

	//JLabel message;
	
	PlayerCardPanel [] playerCards;
	JLabel [] playerLabels;
	/*JLabel userLabel;
	//JPanel userCards;
	//PlayerCardPanel userCards;
	JLabel player2Label;
	PlayerCardPanel player2Cards;
	//JPanel player2Cards;
	JLabel player3Label;
	PlayerCardPanel player3Cards;
	//JPanel player3Cards;
	JLabel player4Label;
	PlayerCardPanel player4Cards;*/
	public static JTextArea userMessage = new JTextArea();
	public final CardLayout choices = new CardLayout();
	JPanel userChoices = new JPanel(choices);
	ArrayList<JCheckBox> userChecks = new ArrayList<JCheckBox>();
	public static final CardLayout [] playerC = new CardLayout[4];
	/*public static final CardLayout userC = new CardLayout();
	public static final CardLayout p2C = new CardLayout();
	public static final CardLayout p3C = new CardLayout();
	public static final CardLayout p4C = new CardLayout();*/
	public static final CardLayout discardPileC = new CardLayout();
	public static int round = 0;
	BackgroundPanel background;
	JButton drawCard;
	JPanel throwPile = new JPanel (discardPileC);
	JButton doneTurn = new JButton ("Done turn");
	JButton shuffle = new JButton ("Shuffle cards");
	
	public GamePanel(String userName, int numOfPlayers) {
		super();
		//System.out.println("Entered game panel");
		setLayout(null);
		
		//initialize variables for player names
		playerNames = new String [numOfPlayers];
		playerCards = new PlayerCardPanel [numOfPlayers];
		playerLabels = new JLabel[numOfPlayers];
		playerNames[0] = userName;
		for (int i = 1; i < playerNames.length; i++)
			playerNames[i] = "Player " + (i+1);
		for (int i = 0; i < playerC.length; i++)
			playerC[i] = new CardLayout();
		
		//initialize variables for the deck, player hands, and discard pile
		deck.shuffle();
		playerHand = new ArrayList<Hand>(); //an arraylist of each player's arraylist of their hand
		discardPile = new ArrayList<Card>();
		
		//fill up each player's hand
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
		background = new BackgroundPanel("game");
		background.setBounds(0, 0, 1000, 800);
		background.setLayout(null);
		add(background);
		
		for (int i = 0; i < numOfPlayers; i++) {
			if (i == 1)
				playerLabels[i] = new JLabel (playerNames[i], JLabel.LEFT);
			else if (i == 3)
				playerLabels[i] = new JLabel (playerNames[i], JLabel.RIGHT);
			else
				playerLabels[i] = new JLabel (playerNames[i], JLabel.CENTER);
			playerLabels[i].setForeground(GameWindow.WHITEP);
			playerCards[i] = new PlayerCardPanel (i, playerHand.get(i));
			if (i == 0) {
				playerLabels[i].setBounds(280, 735, 400, 20);
				playerCards[i].setBounds(75, 655, 800, 74);
			}
			else if (i == 1) {
				playerLabels[i].setBounds(0, 700, 50, 100);
				playerCards[i].setBounds(0, 50, 64, 400);
			}
			else if (i == 2) {
				playerLabels[i].setBounds(280, 35, 400, 20);
				playerCards[i].setBounds(75, 60, 500, 74);
			}
			else {
				playerLabels[i].setBounds(900, 700, 50, 100);
				playerCards[i].setBounds(920, 50, 64, 400);
			}
			background.add(playerLabels[i]);
			background.add(playerCards[i]);
		}
		
		//add user's name and cards
		/*userLabel = new JLabel (playerNames[0], JLabel.CENTER);
		userLabel.setForeground(GameWindow.WHITEP);
		playerCards[0] = new PlayerCardPanel(0, playerHand.get(0));
		userLabel.setBounds(280, 735, 400, 20);
		playerCards[0].setBounds(75, 655, 800, 74);
		//userCards.add(displayCards(0), "initial");
		//userC.show(userCards, "initial");
		background.add(playerCards[0]);
		background.add(userLabel);
		
		player2Label = new JLabel (playerNames[1], JLabel.LEFT);
		player2Label.setForeground(GameWindow.WHITEP);
		player2Cards = new PlayerCardPanel (1, playerHand.get(1));
		//player2Cards = new JPanel();
		//player2Cards = displayCards(1);
		player2Label.setBounds(0, 700, 50, 100);
		player2Cards.setBounds(0, 200, 64, 400);
		background.add(player2Cards);
		background.add(player2Label);
		if (playerNames.length > 2) {
			player3Label = new JLabel (playerNames[2], JLabel.CENTER);
			player3Label.setForeground(GameWindow.WHITEP);
			//player3Cards = new JPanel();
			//player3Cards = displayCards(2);
			player3Cards = new PlayerCardPanel(2, playerHand.get(2));
			player3Label.setBounds(280, 35, 400, 20);
			player3Cards.setBounds(200, 60, 500, 74);
			background.add(player3Cards);
			background.add(player3Label);
			if (playerNames.length>3) {
				player4Label = new JLabel (playerNames[3], JLabel.RIGHT);
				player4Label.setForeground(GameWindow.WHITEP);
				//player4Cards = new JPanel();
				//player4Cards = displayCards(3);
				player4Cards = new PlayerCardPanel(3, playerHand.get(3));
				player4Label.setBounds(900, 700, 50, 100);
				player4Cards.setBounds(920, 200, 64, 400);
				background.add(player4Cards);
				background.add(player4Label);
			}
		}*/
		
		//JCheckBox[] userChoices = new JCheckBox[playerHand.get(0).getCardCount()];
		/*JPanel user = new JPanel();
		user.setLayout(new GridLayout(6, 3));
		for (int i = 0; i < playerHand.get(0).getCardCount(); i++) {
			userChecks.add(new JCheckBox(playerHand.get(0).get(i).toString()));
			user.add(userChecks.get(i));
		}
		userChoices.add(user, "initial");
		
		choices.show(userChoices, "initial");*/
		background.add(userChoices);
		userChoices.setVisible(false);
		userChoices.setBackground(GameWindow.PINKP);
		userChoices.setBounds(100, 475, 450, 150);
		
		throwPile.setBounds(454, 336, 92, 128);
		background.add(throwPile);
		//throwPile.setVisible(false);
		
		userMessage.setBackground(GameWindow.GREENP);
		userMessage.setBounds(550, 336, 350, 300);
		background.add(userMessage);
		
		doneTurn.setBackground(GameWindow.YELLOWP);
		doneTurn.setBounds(250, 336, 92, 128);
		background.add(doneTurn);
		doneTurn.setVisible(false);
		doneTurn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//System.out.println(e.getActionCommand());
				//System.out.println ("Done turn: " + currentPlayer);
				/*currentPlayer++;
				if (currentPlayer >= playerNames.length)
					currentPlayer = 0;*/
				//doneTurn.setEnabled(false);
				doneTurn.setSelected(false);
				
				turn();
				
			}
		});

		drawCard = new JButton(loadImageBack(92, 128));
		drawCard.setBounds(352, 336, 92, 128);
		background.add(drawCard);
		drawCard.setVisible(false);
		drawCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("User card is drawn");
				playerHand.get(0).addCard(deck.draw());
				/*for (int i = 0; i < playerHand.get(0).getCardCount(); i++) {
					System.out.print(playerHand.get(0).get(i) + ", ");
				}
				System.out.println();*/
				playerCards[0].updatePanel(0, playerHand.get(0));
				/*for (int i = 0; i < playerHand.get(0).getCardCount(); i++) {
					System.out.print(playerHand.get(0).get(i) + ",\t");
				}*/
				updateChoices(false, playerHand.get(0));
				/*userCards.add(displayCards(0), "second");
				userC.show(userCards, "second");*/
				//userCards = displayCards(0);
//				/repaint();
				drawCard.setEnabled(false);
			}
		});
		
		shuffle.setBackground(GameWindow.YELLOWP);
		shuffle.setBounds(875, 655, 115, 74);
		background.add(shuffle);
		shuffle.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String [] options = {"By Suit", "By Value", "Cancel"};
				int n = (int)JOptionPane.showOptionDialog (null, "Sort cards", "Sort by: ", 0, 0, null, options, options[2]);
				switch (n) {
				case 0:
					playerHand.get(0).sortBySuit();
					playerCards[0].updatePanel(0, playerHand.get(0));
					updateChoices(false, playerHand.get(0));
					break;
				case 1:
					playerHand.get(0).sortByValue();
					playerCards[0].updatePanel(0, playerHand.get(0));
					updateChoices(false, playerHand.get(0));
					break;
				case 2:
					break;
				}
			}
		});
		start(this);
		
		if (!gameOver()) {
			//System.out.println ("Round " + round);
			round++;
			userMessage.setText("Round #" + round);
			round();
		}
//		while (gameOver() == false) {
//			round++;
//			round();
//		}
		/*
		playerHand.set(0, playerHand.get(0).sortBySuit());
		userCards.add(displayCards(0), "sorted");
		userC.show(userCards, "sorted");*/
		
//		/playerHand.get(0) = playerHand.get(0).sortBySuit();
		
	}
	
	/*
	 * Purpose: play one round of the game (each player gets one turn)
	 * Pre: none
	 * Post: none
	 */
	public void round() {
		if (gameOver() == false) {
			System.out.println("Round method called");
			turn();
			
		}
		else {
			return;
		}
	}
	
	/*
	 * Purpose: play one turn of the game
	 * Pre: none
	 * Post: none
	 */
	public void turn () {
		shuffle.setEnabled(true);
		doneTurn.setSelected(false);
		doneTurn.setEnabled(false);
		currentPlayer++;
		//System.out.println ("Turn - current player: " + currentPlayer);
		if (currentPlayer >= playerNames.length) {
			currentPlayer = 0;
		}
			
		playerCards[currentPlayer].updatePanel(currentPlayer, playerHand.get(currentPlayer));
		if (gameOver() == true)
			return;
		
		//System.out.printf("Player:%d\n", currentPlayer);
		
		if (currentPlayer == 0) {
			drawCard.setEnabled(true);
			userChoices.setVisible(true);
			doneTurn.setVisible(true);
			doneTurn.setText("Done turn");
			doneTurn.setEnabled(true);
			updateChoices(false, playerHand.get(0));
			//userMessage.append(playerNames[0]+ " choose your cards!");
			userMessage.setText(playerNames[0]+ " choose your cards!");
			/*for (int i = 0; i < playerHand.get(0).getCardCount(); i++)
				playerHand.get(0).get(i);*/
		}
		else {
			doneTurn.setEnabled(false);
			doneTurn.setText("Next turn");
			//userMessage.append(playerNames[currentPlayer] + "'s turn!");
			userMessage.setText(playerNames[currentPlayer] + "'s turn!");
			drawCard.setEnabled(false);
			userChoices.setVisible(false);
			compTurn(playerHand.get(currentPlayer), currentPlayer);
			doneTurn.setEnabled(true);
			//doneTurn.setVisible(t);
			
		}
	}
	
	/*
	 * Purpose: update and control the computer player's turn
	 * Pre: Hand hand, int player
	 * Post: none
	 */
	public void compTurn (Hand hand, int player) {
		playerHand.get(player).sortByValue();
		int [] numOfSuit = new int [4];
		for (int i = 0; i < hand.getCardCount(); i++){
			if (hand.get(i).getSuit() == Card.Suit.Spade){
				numOfSuit[0]++;
			}
			else if (hand.get(i).getSuit() == Card.Suit.Heart)
				numOfSuit[1]++;
			else if (hand.get(i).getSuit() == Card.Suit.Club)
				numOfSuit[2]++;
			else
				numOfSuit[3]++;
			System.out.println (i + ", " + hand.get(i));
		}
		int maxIndexOfSuit = 0; //the index in the numOfSuit array which is the greatest
		int maxNumOfSuit = 0; //the maximum number of same suits
		for (int i = 0; i < 4; i++){
			System.out.println ("Number of cards with the suit at " + i + " is " + numOfSuit[i]);
			if (numOfSuit[i] > maxNumOfSuit){
				maxNumOfSuit = numOfSuit[i];
				maxIndexOfSuit = i;
			}
		}
		boolean multiCard = false; //checks if a card in the hand can stack cards
		int indexOfMultiCard = 0; //the index which has the most cards with the same value
		boolean possibleCardNotEight = false;
		boolean eight = false;
		int [] numThatMatchesCurrent = new int [hand.getCardCount()]; //checks how many cards has the same value as the card at the current index
		for (int i = 0; i < hand.getCardCount(); i++) {
			if (validCardPlay(hand.get(i))) {
				if (hand.get(i).getValue() != Card.Value.Eight){
					possibleCardNotEight = true;
				}
				else {
					eight = true;
				}
				for (int j = 0; j < hand.getCardCount(); j++) {
					if (hand.get(i).getValue() == hand.get(j).getValue() && !hand.get(i).equals(hand.get(j))){
						System.out.println (hand.get(j) + " matches with " + hand.get(i));
						numThatMatchesCurrent[i]++;
						multiCard = true;
					}	
				}
				if (numThatMatchesCurrent[i] > numThatMatchesCurrent[indexOfMultiCard]){
					indexOfMultiCard = i;
				}
				// /System.out.println ("CurrentPlayer" + currentPlayer);
				/*updateTopCard(hand.get(i), false);
				playerHand.get(player).removeCard(getTopCard());
				playerCards[player].updatePanel(player, playerHand.get(player));
				userMessage.append("\n"+playerNames[player] + " dropped a " + getTopCard() + "!");
				return;*/
			}
			System.out.println ("index " + i + " + num of multi " + numThatMatchesCurrent[i]);
		}
		System.out.println ("index of multi card " + indexOfMultiCard);
		System.out.println ("multicard " + multiCard);
		System.out.println ("possible card not eight " + possibleCardNotEight);
		System.out.println (" eight " + eight);
		if (multiCard && playerHand.get(player).get(indexOfMultiCard).getValue() != Card.Value.Eight){
			System.out.println ("Dropping card which has multiple: " + indexOfMultiCard + " " + playerHand.get(player).get(indexOfMultiCard));
			updateTopCard(hand.get(indexOfMultiCard), false);
			playerHand.get(player).removeCard(getTopCard());
			playerCards[player].updatePanel(player, playerHand.get(player));
			userMessage.append("\n"+playerNames[player] + " dropped a " + getTopCard() + "!");
			for (int i = 0; i < playerHand.get(player).getCardCount(); i++){
				//System.out.println (playerHand.get(player).get(i));
				if (playerHand.get(player).get(i).getValue() == validValue){
					System.out.print(validValue + " ");
					System.out.println ("Dropping matching card: " + i + " " + playerHand.get(player).get(i)); 
					updateTopCard(playerHand.get(player).get(i), false);
					//System.out.println (validValue + " ");
					System.out.println ("top card: " + getTopCard());
					playerHand.get(player).removeCard(getTopCard());
					playerCards[player].updatePanel(player, playerHand.get(player));
					userMessage.append("\n"+playerNames[player] + " dropped a " + getTopCard() + "!");
					i = 0;
					System.out.println ("card count " + playerHand.get(player).getCardCount());
					for (int j = 0; j < playerHand.get(player).getCardCount(); j++) {
						System.out.println(i + " " + j + "(in loop): " + playerHand.get(player).get(j));
					}
				}
			}
			for (int i = 0; i < playerHand.get(player).getCardCount(); i++) {
				System.out.println(i + ": " + playerHand.get(player).get(i));
			}
			return;
		}
		
		
		 if ((possibleCardNotEight == true /*&& eight == false) || (possibleCardNotEight == true && eight == true*/)){ // if the player can drop only 1 card
			for (int i = 0; i < playerHand.get(player).getCardCount(); i++){
				if (validCardPlay(playerHand.get(player).get(i)) && playerHand.get(player).get(i).getValue() != Card.Value.Eight){
					System.out.println ("Dropping card: " + i + " " + playerHand.get(player).get(i)); 
					updateTopCard(playerHand.get(player).get(i), false);
					playerHand.get(player).removeCard(getTopCard());
					playerCards[player].updatePanel(player, playerHand.get(player));
					userMessage.append("\n"+playerNames[player] + " dropped a " + getTopCard() + "!");
					return;
				}
			}
		}
		else if (eight == true){ //only can drop an eight
			for (int i = 0; i < playerHand.get(player).getCardCount(); i++){
				if (playerHand.get(player).get(i).getValue() == Card.Value.Eight){
					System.out.println ("Dropping eight: " + i + " " + playerHand.get(player).get(i)); 
					updateTopCard(playerHand.get(player).get(i), false);
					playerHand.get(player).removeCard(getTopCard());
					playerCards[player].updatePanel(player, playerHand.get(player));
					userMessage.append("\n"+playerNames[player] + " dropped a " + getTopCard() + "!");
					validSuit = Card.Suit.getSuit(maxIndexOfSuit);
					userMessage.append("\nValid suit is now " + validSuit);
					return;
				}
			}
		}
		
		else /*(possibleCardNotEight == false && eight == false)*/{ // if the player has no possible card to drop
			playerHand.get(player).addCard(deck.draw());
			userMessage.append ("\n" + playerNames[player] + " picked up a card!");
			if  (validCardPlay(playerHand.get(player).get(playerHand.get(player).getCardCount()-1))){
				System.out.println ("Dropping card picked up: " + (playerHand.get(player).getCardCount()-1) + " " + playerHand.get(player).get(playerHand.get(player).getCardCount()-1));
				updateTopCard(playerHand.get(player).get(hand.getCardCount( )-1), false);
				playerHand.get(player).removeCard(getTopCard());
				playerCards[player].updatePanel(player, playerHand.get(player));
				userMessage.append("\n"+playerNames[player] + " dropped a " + getTopCard() + "!");
				if (getTopCard().getValue() == Card.Value.Eight) {
					validSuit = Card.Suit.getSuit(maxIndexOfSuit);
					userMessage.append("\nValid suit is now " + validSuit);
				}
				
				return;
			}
			else{
				playerCards[player].updatePanel(player, playerHand.get(player));
				userMessage.append("\n"+playerNames[player] + " picked up a card!");
				return;
			}
		}
		
		/**/
		
	}
	
	/*
	 * Purpose: update the user's choices / the user's turn
	 * Pre: boolean multiCard (if the player has already dropped one card)
	 * Post: none
	 */
	public void updateChoices(boolean multiCard, Hand hand) {
		userChecks.clear();
		//JCheckBox[] uC = new JCheckBox[playerHand.get(0).getCardCount()];
		JPanel user = new JPanel();
		user.setBackground(GameWindow.PINKP);
		//System.out.println("User checkboxes");
		user.setLayout(new GridLayout(6, 3));
		for (int i = 0; i < hand.getCardCount(); i++) {
			userChecks.add(new JCheckBox(hand.get(i).toString()));
			userChecks.get(i).setBackground(GameWindow.PINKP);
			userChecks.get(i).setForeground(GameWindow.BLUEP);
			user.add(userChecks.get(i));
			//final int index = i;
			//System.out.println("Index is " + index);
			if (validCardPlay(playerHand.get(0).get(i)) == false) {
				//System.out.println(playerHand.get(0).get(i) + " is not valid with " + getTopCard());
				userChecks.get(i).setEnabled(false);
			}
			if (multiCard) {
				if (playerHand.get(0).get(i).getValue() != validValue) {
					//System.out.println(playerHand.get(0).get(i) + " is not valid value with " + validValue);
					userChecks.get(i).setEnabled(false);
				}
				else {
					userChecks.get(i).setEnabled(true);
				}
				
			}
			userChecks.get(i).addItemListener(this);
			/*userChecks.get(i).addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					shuffle.setEnabled(false);
					if (validCardPlay(playerHand.get(0).get(index))){
						updateTopCard(playerHand.get(0).get(index), false);
//						JOptionPane.showMessageDialog(null,
//							    "updated");
//						System.out.println("test");
//						System.out.println(e.getID());
//						System.out.printf("%d\n",index);
						userMessage.append("\n"+playerNames[0] + " dropped a " + getTopCard() + "!");
						if (getTopCard().value == Card.Value.Eight) {
							//System.out.println("EIGHT CHOSEN");
							Card.Suit [] suits = {Card.Suit.Spade, Card.Suit.Heart, Card.Suit.Club, Card.Suit.Diamond};
							ImageIcon cardBack = new ImageIcon("cards/Back.png");
							Card.Suit n = (Card.Suit)JOptionPane.showInputDialog(null, "Pick the valid suit", "Special Eight", JOptionPane.QUESTION_MESSAGE, cardBack, suits, suits[0]);
							validSuit = n;
							userMessage.append("\nValid suit is now " + validSuit);
						}
						playerHand.get(0).removeCard(getTopCard());
//						JOptionPane.showMessageDialog(null,
//							    "removed");
						drawCard.setEnabled(false);
						//updateTopCard();
						playerCards[0].updatePanel(0, playerHand.get(0));
//						updateChoices(true, hand);
					}
					else {
						//userChecks.get(index).setSelected(false);
						userChecks.get(index).setEnabled(false);
						userMessage.append("\n"+playerHand.get(0).get(index) + " is not a valid card. Try again or skip your turn.");
						
					}
					//final int index = i;
					
					//discardPile.add(playerHand.get(0).get(index));
					//throwPile = new CardImage(discardPile.get(discardPile.size()-1), 92, 128);
					//System.out.println("Top card: " + getTopCard());
					
					/*for (int i = 0; i < playerHand.get(0).getCardCount(); i++)
						System.out.print(playerHand.get(0).get(i) + ", ");
					System.out.println();*/
				/* }});*/
			
		}
		userChoices.add(user, "new" + round);
		//userChoices.setBounds(100, 475, 450, 150);
		choices.show(userChoices, "new" + round);
	}

	/*
	 * Purpose: implement itemStateChanged method
	 * Pre: ItemEvent e
	 * Post: none
	 */
	public void itemStateChanged (ItemEvent e){
		Hand hand = playerHand.get(0);
		for (int i = 0; i < userChecks.size(); i++){
			if (e.getItem() == userChecks.get(i) && e.getStateChange() == ItemEvent.SELECTED){
				shuffle.setEnabled(false);
				if (validCardPlay(playerHand.get(0).get(i))){
					updateTopCard(playerHand.get(0).get(i), false);
		//						JOptionPane.showMessageDialog(null,
		//							    "updated");
		//						System.out.println("test");
		//						System.out.println(e.getID());
		//						System.out.printf("%d\n",index);
					userMessage.append("\n"+playerNames[0] + " dropped a " + getTopCard() + "!");
					if (getTopCard().value == Card.Value.Eight) {
						
						//System.out.println("EIGHT CHOSEN");
						Card.Suit [] suits = {Card.Suit.Spade, Card.Suit.Heart, Card.Suit.Club, Card.Suit.Diamond};
						ImageIcon cardBack = new ImageIcon("cards/Back.png");
						Card.Suit n = (Card.Suit)JOptionPane.showInputDialog(null, "Pick the valid suit", "Special Eight", JOptionPane.QUESTION_MESSAGE, cardBack, suits, suits[0]);
						if (n == null){
							n = validSuit;
						}
						validSuit = n;
						userMessage.append("\nValid suit is now " + validSuit);
						System.out.println ("user card" + playerHand.get(0).get(i));
					}
					System.out.println ("top card" + getTopCard());
					playerHand.get(0).removeCard(playerHand.get(0).get(i));
		//						JOptionPane.showMessageDialog(null,
		//							    "removed");
					drawCard.setEnabled(false);
					//updateTopCard();
					playerCards[0].updatePanel(0, playerHand.get(0));
					for (int j = 0; j < playerHand.get(0).getCardCount(); j++) {
						System.out.println (j + ", " + playerHand.get(0).get(j));
					}
					updateChoices(true, hand);
				}
				else {
					//userChecks.get(index).setSelected(false);
					userChecks.get(i).setEnabled(false);
					userMessage.append("\n"+playerHand.get(0).get(i) + " is not a valid card. Try again or skip your turn.");
					
				}
					//final int index = i;
					
					//discardPile.add(playerHand.get(0).get(index));
					//throwPile = new CardImage(discardPile.get(discardPile.size()-1), 92, 128);
					//System.out.println("Top card: " + getTopCard());
					
					/*for (int i = 0; i < playerHand.get(0).getCardCount(); i++)
						System.out.print(playerHand.get(0).get(i) + ", ");
					System.out.println();*/
			}
		}
	}
	


	
	/*
	 * Purpose: display player's hand and cards
	 * Pre: int position (0 = bottom, 1 = left, 2 = top, 3 = right)
	 * Post: JPanel
	 */
	/*public JPanel displayCards(int position) {
		JPanel pnl = new JPanel();
		pnl.setBackground(GameWindow.BLUEP);
		if (position%2 == 0)
			pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		else
			pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		for (int i = 0; i < playerHand.get(position).getCardCount(); i++) {
			JLabel lbl = new JLabel();
			JPanel p = new JPanel();
			p.setSize(46, 64);
			p.setBackground(GameWindow.BLUEP);
			if (position == 0) {
				p = new CardImage(playerHand.get(0).get(i), 46, 64);
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
		pnl.setBackground(GameWindow.BLUEP);
		return pnl;	
	}*/
	
	/*
	 * Purpose: start the game and initialize the board
	 * Pre: GamePanel game
	 * Post: none
	 */
	public void start (GamePanel game) {
		Card card = deck.draw();
		updateTopCard(card, true);
		updateChoices(false, playerHand.get(0));
		/*validSuit = card.getSuit();
		validValue = card.getValue();
		discardPile.add(card);
		throwPile = new CardImage(card, 92, 128);*/
		//throwPile.setVisible(true);
		
		currentPlayer = -1;
		drawCard.setVisible(true);
		
		
	}
	
	/*
	 * Purpose: update the topCard image, validSuit, and validValue
	 * Pre: Card card, boolean start
	 * Post: none
	 */
	public void updateTopCard (Card card, boolean start) {
		//JPanel pnl = new JPanel (discardPileC);
		//System.out.println("updateTopCard");
		discardPile.add(card);
		JPanel pile = new CardImage (card, 92, 128);
		throwPile.add(pile, "new " + round);
		discardPileC.show(throwPile, "new " + round);
		//throwPile.add(pnl);
		validSuit = card.getSuit();
		validValue = card.getValue();
		int nextPlayer = currentPlayer+1;
		if (nextPlayer >= playerNames.length)
			nextPlayer = 0;
		if (!start) {
			if (getTopCard().equals(new Card(Card.Suit.Spade, Card.Value.Queen))) {
				for (int i = 0; i < 5; i++) {
					playerHand.get(nextPlayer).addCard(deck.draw());
					playerCards[nextPlayer].updatePanel(nextPlayer, playerHand.get(nextPlayer));
				}	
				userMessage.append("\n"+ playerNames[nextPlayer] + " just got five cards!");
			}
			else if (getTopCard().value == Card.Value.Two) {
				for (int i = 0; i < 2; i++) {
					playerHand.get(nextPlayer).addCard(deck.draw());
					playerCards[nextPlayer].updatePanel(nextPlayer, playerHand.get(nextPlayer));
					
				}
				userMessage.append("\n" + playerNames[nextPlayer] + " just got two cards!");
			}
			else if (getTopCard().value == Card.Value.Jack) {
				userMessage.append("\n" + playerNames[nextPlayer] + "'s turn is skipped!");
				currentPlayer++;
				if (currentPlayer >= playerNames.length)
					currentPlayer = 0;
				
			}
		}
		
		//System.out.println(validValue + " " + validSuit);
		//System.out.println(discardPile.get(discardPile.size()-1));
	}
	
	/*
	 * Purpose: determine which card is at the top of the discard pile
	 * Pre: none
	 * Post: Card
	 */
	public Card getTopCard() {
		return new Card(validSuit, validValue);
	}
	
	/*
	 * Purpose: determine if game has ended
	 * Pre: none
	 * Post: boolean
	 */
	public boolean gameOver() {
		for (int i = 0; i < playerNames.length; i++) {
			if (playerHand.get(i).getCardCount() == 0)
				return true;
		}
		return false;
	}
	
	/*
	 * Purpose: determine which player's turn it is
	 * Pre: none
	 * Post: String
	 */
	public String getCurrentPlayer() {
		return this.playerNames[this.currentPlayer];
	}
	
	/*
	 * Purpose: determine if the card chosen is valid
	 * Pre: Card card
	 * Post: boolean
	 */
	public static boolean validCardPlay (Card card) {
		//System.out.print(validValue + ", " + validSuit);
		if (card.getValue()!=Card.Value.Eight) {
			//System.out.print (card + "\t");
			if (card.getSuit() == validSuit) {
				//System.out.println ("true");
				return true;
			}
				//return true;
			else if (card.getValue() == validValue) {
				//System.out.println("true");
				return true;
				
			}
				//return true;
			else {
				//System.out.println("false");
				return false;
			}
//				/return false;
			//return card.getSuit() == validSuit || card.getValue() == validValue;
		}
		else
			return true;
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
     * Purpose: change appearance of JPanel
     * Pre: Graphics comp
     * Post: none
     */
	/*public void paintComponent (Graphics c) {
		Graphics2D comp = (Graphics2D) c;
		
		//comp.draw();
	}*/

	/*
	 * Purpose: override the actionPerformed method for ActionListener
	 * Pre: ActionEvent event
	 * Post: none
	 */
	public void actionPerformed(ActionEvent event) {
		/*if (event.getSource() == userCards.getChoose())
		if (GamePanel.validCardPlay(CardImage.c) == true)
			GamePanel.userMessage.append("\n"+CardImage.c.toString());
		else
			GamePanel.userMessage.append("\nInvalid option!");
		CardImage.choose.setEnabled(false);*/
		
	}

	/*
	 * Purpose: override the keyTyped method for KeyListener
	 * Pre: KeyEvent event
	 * Post: none
	 */
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Purpose: override the keyPressed method for KeyListener
	 * Pre: KeyEvent event
	 * Post: none
	 */
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Purpose: override the keyReleased method for KeyListener
	 * Pre: KeyEvent event
	 * Post: none
	 */
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	/*
     * Purpose: override run method for Runnable interface
     * Pre: none
     * Post: none
     */
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
