/*
 * Name: Shruti Gogna
 * Date: Thursday, December 21, 2023.
 * Course: ICS4U1
 * Description: display the instructions of the game
 */
package culminating;

import javax.swing.*;
import java.awt.*;

public class InstructionsPanel extends JPanel{
	public InstructionsPanel() {
		super();
		setLayout(null);
		
		BackgroundPanel background = new BackgroundPanel("instructions");
		background.setBounds(0, 0, 1000, 800);
		background.setLayout(null);
		add(background);
		
		JLabel title = new JLabel ("How to Play", JLabel.CENTER);
		title.setFont(new Font("Times New Roman", Font.BOLD, 50));
		title.setForeground(GameWindow.WHITEP);
		title.setBounds(230, 10, 500, 100);
		background.add(title);
	}
}
