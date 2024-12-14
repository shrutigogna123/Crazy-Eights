/*
 * Name: Shruti Gogna
 * Date: Thursday, December 21, 2023.
 * Course: ICS4U1
 * Description: import the background images for the game
 */
package culminating;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel{
	Image background;
	
	public BackgroundPanel(String screen) {
    	super();
    	Toolkit kit = Toolkit.getDefaultToolkit();
    	if (screen.equals("menu"))
    		background = kit.getImage("backgrounds/titlePage.png");
    	else if (screen.equals("instructions") || screen.equals("leaderboard"))
    		background = kit.getImage("backgrounds/instructionAndLeaderboard.png");
    	else 
    		background = kit.getImage("backgrounds/game.png");
	}
	
	public void paintComponent(Graphics comp) {
    	 Graphics2D comp2D = (Graphics2D) comp;
    	 comp2D.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}
}
