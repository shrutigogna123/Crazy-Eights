/*
 * Name: Shruti Gogna
 * Date: Thursday, December 21, 2023.
 * Course: ICS4U1
 * Description: menu/home screen for the game
 */
package culminating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel {
	//public static String userName = "Player 1";
	public MenuPanel() {
		super();
		setLayout(null);
		
		BackgroundPanel background = new BackgroundPanel("menu");
		background.setBounds(0, 0, 1000, 800);
		background.setLayout(null);
		add(background);
		
		JLabel title = new JLabel ("Crazy Eight's", JLabel.CENTER);
		title.setFont(new Font("Times New Roman", Font.BOLD|Font.ITALIC, 50));
		title.setForeground(GameWindow.WHITEP);
		title.setBounds(230, 325, 500, 100);
		background.add(title);
		
		//field for user to input name
		JButton two = new JButton("2");
		JButton three = new JButton ("3");
		JButton four = new JButton ("4");
		JTextField name = new JTextField(10);
		//name.setText("Player 1");
		JLabel askName = new JLabel ("Enter your name here: ", JLabel.RIGHT);
		name.setBackground(GameWindow.PINKP);
		askName.setForeground(GameWindow.PINKP);
		askName.setBackground(GameWindow.BLUEP);
		name.setForeground(GameWindow.WHITEP);
		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new BoxLayout(pnl1, BoxLayout.X_AXIS));
		pnl1.setBackground(GameWindow.BLUEP);
		pnl1.add(askName);
		pnl1.add(name);
		pnl1.setBounds(280, 235, 400, 20);
		background.add(pnl1);
		
		
		//buttons for choosing how many players to start the game
		JPanel pnl2 = new JPanel (new GridLayout(1, 3, 10, 2));
		pnl2.add(two);
		pnl2.add(three);
		pnl2.add(four);
		two.setBackground(GameWindow.GREENP);
		three.setBackground(GameWindow.GREENP);
		four.setBackground(GameWindow.GREENP);
		pnl2.setBounds(380, 475, 200, 75);
		pnl2.setBackground(GameWindow.BLUEP);
		background.add(pnl2);
		JLabel numOfChar = new JLabel ("Choose the number of computers below to start: ", JLabel.CENTER);
		numOfChar.setForeground(GameWindow.GREENP);
		numOfChar.setBounds(280, 455, 400, 20);
		background.add(numOfChar);
		two.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (!name.getText().toString().equals(""))
					GameWindow.userName = name.getText().toString();
				System.out.println("butt clicked");
				GameWindow.numOfPlayers = 2;
				GameWindow.centerPanel.add(new GamePanel(GameWindow.userName, GameWindow.numOfPlayers), "Game");
				GameWindow.navigation.show(GameWindow.centerPanel, "Game");
			}
		});
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (!name.getText().toString().equals(""))
					GameWindow.userName = name.getText().toString();
				GameWindow.numOfPlayers = 3;
				GameWindow.centerPanel.add(new GamePanel(GameWindow.userName, GameWindow.numOfPlayers), "Game");
				GameWindow.navigation.show(GameWindow.centerPanel, "Game");
			}
		});
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (!name.getText().toString().equals(""))
					GameWindow.userName = name.getText().toString();
				GameWindow.numOfPlayers = 4;
				GameWindow.centerPanel.add(new GamePanel(GameWindow.userName, GameWindow.numOfPlayers), "Game");
				GameWindow.navigation.show(GameWindow.centerPanel, "Game");
			}
		});
		
		//button to go to instruction panel
		JButton instructions = new JButton ("How to Play");
		instructions.setBounds(280, 600, 400, 50);
		instructions.setBackground(GameWindow.YELLOWP);
		instructions.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				GameWindow.navigation.show(GameWindow.centerPanel, "Instructions");
			}
		});
		background.add(instructions);
		/*JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(1, 2));
		pnl.add(but);
		pnl.add(hi);
		pnl.setBounds(500, 200, 100, 100);
		background.add(pnl);*/
	}
	
}
