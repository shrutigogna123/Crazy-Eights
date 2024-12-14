/*
 * Name: Shruti Gogna
 * Date: Monday, December 18, 2023.
 * Course: ICS4U1
 * Description: gameWindow class; frame that holds all the panels of the game
 */

package culminating;

import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame{
	public static final int WINDOW_WIDTH = 1000, WINDOW_HEIGHT = 800;
	public static final CardLayout navigation = new CardLayout();
	public static JFrame frame;
	public static JPanel centerPanel;
	public static String userName = "Player 1";
	public static int numOfPlayers = 2;
	public static final Color WHITEP = new Color (253, 251, 255);
	public static final Color PINKP = new Color (251, 146, 155);
	public static final Color BLUEP = new Color (15, 15, 113);
	public static final Color YELLOWP = new Color (253, 216, 68);
	public static final Color GREENP = new Color (138, 239, 29);
	public static void main(String[] args) {
		frame = new JFrame ("Crazy Eight's Game");
		frame.setLayout(new BorderLayout());
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		centerPanel = new JPanel(navigation);
		frame.add(centerPanel, BorderLayout.CENTER);
		//centerPanel.add(new GamePanel(userName, numOfPlayers), "Game");
		centerPanel.add(new MenuPanel(), "Menu");
		centerPanel.add(new InstructionsPanel(), "Instructions");
		centerPanel.add(new LeaderboardPanel(), "Leaderboard");
		navigation.show(centerPanel, "Menu");
		frame.setVisible(true);
		//gameWindow frame = new gameWindow();
	}
	
	/*public gameWindow(){
		super ("Crazy Eights");
		setSize (1000, 800);
		setLayout (new BorderLayout());
		gamePanel scene = new gamePanel();
		add(scene, BorderLayout.CENTER);
		setVisible(true);
	}*/

}
