package de.oldschool.panels;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import de.oldschool.entitys.Ball;
import de.oldschool.entitys.MyTimer;
import de.oldschool.entitys.Player;
import de.oldschool.main.Main;
import de.oldschool.system.MyFrame;

//Lennox
@SuppressWarnings("serial")
public class DefaultPanel extends JPanel {
			
	public DefaultPanel() {
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Main main = Main.getInstance();
		Player player1 = main.getPlayer1();
		Player player2 = main.getPlayer2();
		Ball ball = main.getBall();
		MyTimer timer = main.getTimer();
		MyFrame frame = main.getFrame();
		
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);
		
		//Zeichne Hintergrund
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());
	
		//Zeichne Schläger
		g2d.setColor(Color.WHITE);
		g2d.fillRect(player1.getPosX(), player1.getPosY(), player1.getWidth(), player1.getHeight());
		g2d.fillRect(player2.getPosX(), player2.getPosY(), player2.getWidth(), player2.getHeight());
		
		//Zeichne Score
		g2d.setFont(new Font("Consolas", Font.PLAIN, 100));
		g2d.drawString("" + player1.getScore(), frame.getWidth() / 2 - 550, 100);
		g2d.drawString("" + player2.getScore(), frame.getWidth() / 2 + 475, 100);
		
		//Zeichne Timer
		g2d.drawString("" + timer.getTimeString(timer.getTime()), frame.getWidth() / 2 - 138, 100);
		g2d.setFont(new Font("Consolas", Font.PLAIN, 25));
		g2d.drawString("" + (timer.getSpeedDelay() - timer.getSpeedTime()), frame.getWidth() / 2 - 15, 25);
		
		//Zeichne ball
		g2d.fillRect(ball.getPosX(), ball.getPosY(), ball.getSize(), ball.getSize());
		
		this.repaint();
		
	}
	
}
