package de.oldschool.panels;

import java.awt.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class HighscorePanel extends JPanel{

	public HighscorePanel() {
		
			GridBagLayout gbl = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			setLayout(gbl);
			
			JLabel title = new JLabel("Statistik",SwingConstants.CENTER);
			title.setFont(new Font("Arial", Font.BOLD,100));
			title.setForeground(Color.white);
			setBackground(Color.black);
			
			gbc.fill=GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(10,30,30,30);
			gbc.gridwidth=2;
			gbc.gridx=0;
			gbc.gridy=0;
			add(title, gbc);
			
			JPanel firstplayer = new JPanel();
			firstplayer.setLayout(new GridLayout(3,1,0,30));
			JLabel namePlayer1 = new JLabel("[player1 name here]");
			namePlayer1.setFont(new Font("Arial", Font.BOLD,30));
			namePlayer1.setForeground(Color.white);
			JLabel timePlayed1 = new JLabel("Zeit: " + "[insert variable]");
			timePlayed1.setFont(new Font("Arial", Font.BOLD,20));
			timePlayed1.setForeground(Color.white);
			JLabel goalsScored1 = new JLabel("Punkte: " + "[insert variable]");
			goalsScored1.setFont(new Font("Arial", Font.BOLD,20));
			goalsScored1.setForeground(Color.white);
			firstplayer.setBackground(Color.black);
			firstplayer.add(namePlayer1);
			firstplayer.add(timePlayed1);
			firstplayer.add(goalsScored1);
			gbc.gridwidth=1;
			gbc.gridx=0;
			gbc.gridy=1;
			add(firstplayer, gbc);
			
			JPanel secondplayer = new JPanel();
			secondplayer.setLayout(new GridLayout(3,1,0,30));
			JLabel namePlayer2 = new JLabel("[player2 name here]");
			namePlayer2.setFont(new Font("Arial", Font.BOLD,30));
			namePlayer2.setForeground(Color.white);
			JLabel timePlayed2 = new JLabel("Zeit: " + "[insert variable]");
			timePlayed2.setFont(new Font("Arial", Font.BOLD,20));
			timePlayed2.setForeground(Color.white);
			JLabel goalsScored2 = new JLabel("Punkte: " + "[insert variable]");
			goalsScored2.setFont(new Font("Arial", Font.BOLD,20));
			goalsScored2.setForeground(Color.white);
			secondplayer.setBackground(Color.black);
			secondplayer.add(namePlayer2);
			secondplayer.add(timePlayed2);
			secondplayer.add(goalsScored2);
			gbc.gridx=1;
			gbc.gridy=1;
			add(secondplayer, gbc);
			
			JButton returnButton = new JButton("Zurück");
			returnButton.setBackground(Color.black);
			returnButton.setFont(new Font("Arial", Font.BOLD,24));
			returnButton.setForeground(Color.white);
			returnButton.setPreferredSize(new Dimension(100,100));
			returnButton.setBorder(BorderFactory.createLineBorder(Color.white, 10));
			gbc.gridwidth=2;
			gbc.gridx=0;
			gbc.gridy=2;
			add(returnButton, gbc);
			
	}
	

}
