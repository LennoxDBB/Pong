package de.oldschool.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.oldschool.entitys.MyTimer;
import de.oldschool.entitys.Player;
import de.oldschool.main.Main;
import de.oldschool.system.CollisionChecker;
import de.oldschool.system.MyFrame;


@SuppressWarnings("serial")
public class EndPanel extends JPanel {
	MyTimer timer = Main.getInstance().getTimer();
	Player player1 = Main.getInstance().getPlayer1();
	Player player2 = Main.getInstance().getPlayer2();
	CollisionChecker cc = Main.getInstance().getCollisionChecker();
	MyFrame frame = Main.getInstance().getFrame();
	public EndPanel() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
		
		JLabel title = new JLabel("Game Over",SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD,100));
		title.setForeground(Color.white);
		setBackground(Color.black);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,85,10,80);
		gbc.gridwidth=3;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(title,gbc);
		
		JLabel player1Score = new JLabel("" + player1.getScore());
		player1Score.setFont(new Font("Arial", Font.BOLD,70));
		player1Score.setForeground(Color.white);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth=1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(player1Score,gbc);
		
		JLabel finalTime = new JLabel("" + timer.getTimeString(timer.getTime()));
		finalTime.setFont(new Font("Arial", Font.BOLD,70));
		finalTime.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(finalTime,gbc);
		
		JLabel player2Score = new JLabel("" + player2.getScore());
		player2Score.setFont(new Font("Arial", Font.BOLD,70));
		player2Score.setForeground(Color.white);
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(player2Score,gbc);
		
		JLabel voidLabel = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(voidLabel,gbc);
		
		JPanel winStatus = new JPanel();
		winStatus.setLayout(new GridLayout(2,1));
		winStatus.setBackground(Color.black);
		
		
		String winPlayer = cc.getWinner(); 
		JLabel winner = new JLabel("" + winPlayer, SwingConstants.CENTER);
		winner.setFont(new Font("Arial", Font.BOLD,50));
		winner.setForeground(Color.white);
		winStatus.add(winner);
		
		JLabel winnerAnnouncement = new JLabel("gewinnt",SwingConstants.CENTER);
		winnerAnnouncement.setFont(new Font("Arial", Font.BOLD,50));
		winnerAnnouncement.setForeground(Color.white);
		winStatus.add(winnerAnnouncement);
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(winStatus,gbc);
		
		JButton returnButton = new JButton("Zurück");
		returnButton.setBackground(Color.black);
		returnButton.setFont(new Font("Arial", Font.BOLD,24));
		returnButton.setForeground(Color.white);
		returnButton.setPreferredSize(new Dimension(100,100));
		returnButton.setBorder(BorderFactory.createLineBorder(Color.white, 10));
		gbc.insets = new Insets(10,10,10,10);
		gbc.gridwidth=3;
		gbc.gridx=0;
		gbc.gridy=4;
		add(returnButton, gbc);
		
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setPanel(Main.getInstance().getStartPanel());
				
			}
			
		});
				
	}

}
