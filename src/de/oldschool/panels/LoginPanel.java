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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.oldschool.entitys.Player;
import de.oldschool.main.Main;
import de.oldschool.system.MyFrame;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel{
	
	Main main = Main.getInstance();
		
	Player player1 = main.getPlayer1();
	Player player2 = main.getPlayer2();
	MyFrame frame = main.getFrame();
	
	public LoginPanel() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
		
		JLabel title = new JLabel("Log in",SwingConstants.CENTER);
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
		JLabel player1 = new JLabel("Player 1");
		player1.setFont(new Font("Arial", Font.BOLD,30));
		player1.setForeground(Color.white);
		JTextField namePlayer1 = new JTextField("Player1");
		namePlayer1.setFont(new Font("Arial", Font.BOLD,20));
		namePlayer1.setForeground(Color.white);
		namePlayer1.setBackground(Color.black);
		firstplayer.setBackground(Color.black);
		firstplayer.add(player1);
		firstplayer.add(namePlayer1);
		gbc.gridwidth=1;
		gbc.gridx=0;
		gbc.gridy=1;
		add(firstplayer, gbc);
		
		JPanel secondplayer = new JPanel();
		secondplayer.setLayout(new GridLayout(3,1,20,30));
		JLabel player2 = new JLabel("Player 2");
		player2.setFont(new Font("Arial", Font.BOLD,30));
		player2.setForeground(Color.white);
		JTextField namePlayer2 = new JTextField("Player2");
		namePlayer2.setFont(new Font("Arial", Font.BOLD,20));
		namePlayer2.setForeground(Color.white);
		namePlayer2.setBackground(Color.black);
		secondplayer.setBackground(Color.black);
		secondplayer.add(player2);
		secondplayer.add(namePlayer2);
		gbc.gridx=1;
		gbc.gridy=1;
		add(secondplayer, gbc);
		
		JButton saveButton = new JButton("Speichern & Fortfahren");
		saveButton.setBackground(Color.black);
		saveButton.setFont(new Font("Arial", Font.BOLD,24));
		saveButton.setForeground(Color.white);
		saveButton.setPreferredSize(new Dimension(100,100));
		saveButton.setBorder(BorderFactory.createLineBorder(Color.white, 10));
		gbc.gridwidth=2;
		gbc.gridx=0;
		gbc.gridy=2;
		add(saveButton, gbc);
		
		
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				player1.setName(namePlayer1.getText());
				player2.setName(namePlayer2.getText());
								
				frame.setPanel(main.getStartPanel());
			}
			
		});
		
	}

}
