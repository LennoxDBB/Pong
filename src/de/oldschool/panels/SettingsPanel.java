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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import de.oldschool.entitys.Ball;
import de.oldschool.entitys.MyTimer;
import de.oldschool.entitys.Player;
import de.oldschool.main.Main;
import de.oldschool.system.CollisionChecker;
import de.oldschool.system.GameHandler;
import de.oldschool.system.MyFrame;


//Justin
@SuppressWarnings("serial")
public class SettingsPanel extends JPanel {

	Main main = Main.getInstance();
	MyFrame frame = main.getFrame();
	GameHandler game = main.getGameHandler();
	Ball ball = main.getBall();
	Player player1 = main.getPlayer1();
	Player player2 = main.getPlayer2();
	MyTimer timer = main.getTimer();
	CollisionChecker cc = main.getCollisionChecker();
	
	public SettingsPanel() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
		
		JLabel title = new JLabel("Einstellungen",SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD,100));
		title.setForeground(Color.white);
		setBackground(Color.black);
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,10,10,10);
		gbc.gridwidth=2;
		gbc.gridx=0;
		gbc.gridy=0;
		add(title, gbc);
		
		JPanel Labels = new JPanel();
		Labels.setLayout(new GridLayout(5,1,0,50));
		Labels.setBackground(Color.black);
		JLabel[] Label = new JLabel[5];
		for(int i = 0; i < 5; i++) {
			Label[i] = new JLabel("i",SwingConstants.RIGHT);
			Label[i].setBackground(Color.black);
			Label[i].setForeground(Color.white);
			Label[i].setFont(new Font("Arial", Font.BOLD, 24));
			Labels.add(Label[i]);
		}
		Label[0].setText("Spiellänge");
		Label[1].setText("2-Punkte Vorsprung");
		Label[2].setText("Schlägergröße");
		Label[3].setText("Ballgröße");
		Label[4].setText("Geschwindigkeitsmultiplikator");

		gbc.gridwidth=1;
		gbc.gridx=0;
		gbc.gridy=1;
		add(Labels, gbc);
		
		JPanel Selections = new JPanel();
		Selections.setSize(300,100);
		Selections.setLayout(new GridLayout(5,1,0,53));
		Selections.setBackground(Color.black);
		
		//Wie viele Punkte zum Sieg
		String rounds[] = {"3 Punkte", "5 Punkte", "7 Punkte", "11 Punkte"};
		JComboBox<String> selectRound = new JComboBox<String>(rounds);
		selectRound.setBackground(Color.black);
		selectRound.setForeground(Color.white);
		Selections.add(selectRound);
		
		//2-Punkte Vorsprung?
		JCheckBox selectPointLead = new JCheckBox("");
		selectPointLead.setBackground(Color.black);
		selectPointLead.setBorderPaintedFlat(true); 
		Selections.add(selectPointLead);
		
		String size[] = {"Klein","Normal","Groß"};
		JComboBox<String> selectSizePaddle = new JComboBox<String>(size);
		selectSizePaddle.setSelectedIndex(1);
		selectSizePaddle.setBackground(Color.black);
		selectSizePaddle.setForeground(Color.white);
		Selections.add(selectSizePaddle);
		
		JComboBox<String> selectSizeBall = new JComboBox<String>(size);
		//An Lennox: Könnte man mit dem unteren Code vorherige Wahlen speichern?
		selectSizeBall.setSelectedIndex(1);
		selectSizeBall.setBackground(Color.black);
		selectSizeBall.setForeground(Color.white);
		Selections.add(selectSizeBall);
		//Um die Modifiers in einer Zeile hinzufügen und das man nur einen auswählen
		ButtonGroup Speedmods = new ButtonGroup();
		JPanel Modifiers = new JPanel();
		Modifiers.setBackground(Color.black);
		Modifiers.setLayout(new GridLayout(1,2,30,0));
		
		JRadioButton Speedmodifier1 = new JRadioButton("1");
		Speedmodifier1.setBackground(Color.black);
		Speedmodifier1.setForeground(Color.white);
		Speedmodifier1.setSelected(true);
		
		JRadioButton Speedmodifier2 = new JRadioButton("2");
		Speedmodifier2.setBackground(Color.black);
		Speedmodifier2.setForeground(Color.white);
		
		Speedmods.add(Speedmodifier1);
		Speedmods.add(Speedmodifier2);
		
		Modifiers.add(Speedmodifier1);
		Modifiers.add(Speedmodifier2);
		Selections.add(Modifiers);
		
		gbc.gridx=1;
		gbc.gridy=1;
		add(Selections, gbc);
		
		JButton saveButton = new JButton("Speichern");
		saveButton.setBackground(Color.black);
		saveButton.setForeground(Color.white);
		saveButton.setPreferredSize(new Dimension(100,100));
		saveButton.setFont(new Font("Arial", Font.BOLD, 24));
		saveButton.setBorder(BorderFactory.createLineBorder(Color.white, 10));
		
		gbc.gridwidth=2;
		gbc.gridx=0;
		gbc.gridy=2;
		add(saveButton, gbc);
		
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int gameLength = 3;
				if(selectRound.getSelectedItem().equals("3 Punkte")) {
					gameLength = 3;
				} else if(selectRound.getSelectedItem().equals("5 Punkte")) {
					gameLength = 5;
				} else if(selectRound.getSelectedItem().equals("7 Punkte")) {
					gameLength = 7;
				} else {
					gameLength = 11;
				}
				
				int ballSpeedMultiplier = Speedmodifier1.isSelected() ? 1 : 2;
				
				int paddleHeight = 100;
				if(selectSizePaddle.getSelectedItem().equals("Klein")) {
					paddleHeight = 100;
				} else if(selectSizePaddle.getSelectedItem().equals("Normal")) {
					paddleHeight = 125;
				} else {
					paddleHeight = 150;
				}
				
				int ballSize = 20;
				if(selectSizeBall.getSelectedItem().equals("Klein")) {
					ballSize = 15;
				} else if(selectSizeBall.getSelectedItem().equals("Normal")) {
					ballSize = 20;
				} else {
					ballSize = 25;
				}
				
				Main.getInstance().getFrame().setPanel(Main.getInstance().getDefaultPanel());
				
				game.setPaused(false);
				game.setGameLength(gameLength);
				game.setWinAfterTwo(selectPointLead.isSelected());
				
				ball.setSize(ballSize);
				ball.setSpeedMultiplierX(ball.getSpeedMultiplierX() * ballSpeedMultiplier);
				ball.setSpeedMultiplierY(ball.getSpeedMultiplierY() * ballSpeedMultiplier);
				
				player1.setHeight(paddleHeight);
				player2.setHeight(paddleHeight);
				
				frame.setPanel(main.getStartPanel());
				
			}
			
		});
	}
	
}
