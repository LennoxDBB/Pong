package de.oldschool.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.oldschool.entitys.Ball;
import de.oldschool.entitys.MyTimer;
import de.oldschool.entitys.Player;
import de.oldschool.main.Main;
import de.oldschool.system.CollisionChecker;
import de.oldschool.system.MyFrame;

//Justin
@SuppressWarnings("serial")
public class StartPanel extends JPanel{
		
	Main main = Main.getInstance();
	MyFrame frame = main.getFrame();
	Ball ball = main.getBall();
	Player player1 = main.getPlayer1();
	Player player2 = main.getPlayer2();
	CollisionChecker cc = main.getCollisionChecker();
	MyTimer timer = main.getTimer();
	
	public StartPanel() {
		setLayout(new BorderLayout());
		
		//Titel
		JLabel title = new JLabel("PONG",SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD,200));
		title.setForeground(Color.white);
		setBackground(Color.black);
		
		//Untere Buttons
		JPanel LowerButtons = new JPanel();
		LowerButtons.setLayout(new GridLayout(2,2,50,50));
		LowerButtons.setBackground(Color.black);
		
		JButton[] Buttons = new JButton[4];
		for(int i = 0; i < 4; i++) {
			Buttons[i] = new JButton("i");
			Buttons[i].setBackground(Color.black);
			Buttons[i].setForeground(Color.white);
			Buttons[i].setPreferredSize(new Dimension(100,100));
			Buttons[i].setFont(new Font("Arial", Font.BOLD, 24));
			Buttons[i].setBorder(BorderFactory.createLineBorder(Color.white, 10));
			LowerButtons.add(Buttons[i]);
		}
		Buttons[0].setText("Start");
		Buttons[1].setText("Einstellungen");
		Buttons[2].setText("Highscore");
		Buttons[3].setText("Regeln");
		
		add(title, BorderLayout.NORTH);
		add(LowerButtons, BorderLayout.SOUTH);
		
		Buttons[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setPanel(main.getDefaultPanel());
				
				ball.enable();
				player1.enable();
				player2.enable();
				cc.enable();
				timer.enable();
			}
			
		});
		
		Buttons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setPanel(main.getSettingsPanel());
			}
			
		});
	}

}
