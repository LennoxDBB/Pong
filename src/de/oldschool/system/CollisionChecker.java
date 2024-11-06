package de.oldschool.system;

import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import de.oldschool.entitys.Ball;
import de.oldschool.entitys.MyTimer;
import de.oldschool.entitys.Player;
import de.oldschool.main.Main;
import de.oldschool.panels.EndPanel;

//Lennox
public class CollisionChecker {

	Main main = Main.getInstance();
	
	Ball ball = main.getBall();
	Player player1 = main.getPlayer1();
	Player player2 = main.getPlayer2();
	MyTimer myTimer = main.getTimer();
	MyFrame frame = main.getFrame();	
	GameHandler game = main.getGameHandler();
	AudioManager audioManager = main.getAudioManager();
	DataManager dataManager = main.getDataManager();
	
	private Timer timer;
	private boolean isRunning;
	private String winner;
	
	public CollisionChecker() {
		this.setRunning(false);
		this.setWinner(null);
	}
	
	private void run() {
	
		File bounceFile = new File("bounce.wav");
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				//Überprüfe Kollision mit unterer/oberer Spielfeldseite
				if(ball.getPosY() >= frame.getHeight() - 55) {
					ball.setDirY(-1);
					audioManager.playSound(bounceFile);
				}
				
				if(ball.getPosY() <= 0) {
					ball.setDirY(1);
					audioManager.playSound(bounceFile);
				}
				
				//Überprüfe Kollision mit rechter/linker Spielfeldseite
				if(ball.getPosX() >= frame.getWidth() - 40) {
					setToDefault(-1);
					player1.setScore(player1.getScore() + 1);
					checkForWin();
				}
				
				if(ball.getPosX() <= 0) {
					setToDefault(1);
					player2.setScore(player2.getScore() + 1);
					checkForWin();
				}
				
				//Überprüfe Kollision mit Schlägern
				if(ball.getPosX() >= player1.getPosX() &&
				   ball.getPosX() <= player1.getPosX() + player1.getWidth() &&
				   player1.getPosY() - ball.getSize() <= ball.getPosY() &&
				   player1.getPosY() + player1.getHeight() >= ball.getPosY()) {
						ball.setDirX(1);
						if(ball.getDirY() == 0) ball.setFirstYDirection();
						audioManager.playSound(bounceFile);
				}
				
				if(ball.getPosX() + ball.getSize() <= player2.getPosX() + player2.getWidth() &&
				   ball.getPosX() + ball.getSize() >= player2.getPosX() &&
				   player2.getPosY() - ball.getSize() <= ball.getPosY() &&
				   player2.getPosY() + player2.getHeight() >= ball.getPosY()) {
						ball.setDirX(-1);
						if(ball.getDirY() == 0) ball.setFirstYDirection();
						audioManager.playSound(bounceFile);
				}
			}
			
		}, 0, 5);
	}
	
	private void checkForWin() {		
		if(player1.getScore() >= game.getGameLength()) { 
			if(hasSamePoints()) return;
			
			setWinner(player1.getName());
			endGame();
		} else if(player2.getScore() >= game.getGameLength()){
			if(hasSamePoints()) return;
			
			setWinner(player2.getName());
			endGame();
		} else {
			return;
		}
	}
	
	private void endGame() {
		Random random = new Random();
		
		ball.disable();
		player1.disable();
		player2.disable();
		myTimer.disable();
		this.disable();
		
		setToDefault(random.nextInt(0, 2));
		
		frame.setPanel(new EndPanel());
	}

	private boolean hasSamePoints() {
		if(!game.isWinAfterTwo()) return false;
		
		if(player1.getScore() - player2.getScore() == -1 || player1.getScore() - player2.getScore() == 1 || player1.getScore() - player2.getScore() == 0) {
			return true;
		}
		return false;
	}
	
	private void setToDefault(int startDirection) {
		//Setze Spielfeld nach Punkt zurück
		ball.setPosX(frame.getWidth() / 2 - ball.getSize() / 2);
		ball.setPosY(frame.getHeight() / 2 - ball.getSize() / 2);
		ball.setDirX(startDirection);
		ball.setDirY(0);
		ball.setSpeedMultiplierX(1);
		ball.setSpeedMultiplierY(1);
		myTimer.setSpeedTime(0);
		player1.setPosY(frame.getHeight() / 2 - player1.getHeight() / 2);
		player2.setPosY(frame.getHeight() / 2 - player2.getHeight() / 2);
	}
	
	public void enable() {
		if(isRunning) {
			return;
		}
		
		run();
		
		setRunning(true);
	}
	
	public void disable() {
		if(!isRunning) {
			return;
		}
		
		timer.cancel();
		timer.purge();
		
		setRunning(false);
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

}
