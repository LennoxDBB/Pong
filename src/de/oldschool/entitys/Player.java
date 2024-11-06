package de.oldschool.entitys;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import de.oldschool.main.Main;

//Lennox
public class Player {	
	
	private String name;
	
	private boolean isRunning;
	private Timer timer;
	
	private final int WIDTH;
	private int HEIGHT;
	
	private final int posX;
	private int posY;
	
	private boolean movingUp;
	private boolean movingDown;
	
	private int score;
	
	JFrame frame = Main.getInstance().getFrame();
	
	public Player(int posX, int posY, int score) {
		this.name = "";
		this.setRunning(false);
		this.WIDTH = 20;
		this.setHeight(100);
		this.posX = posX;
		this.setPosY(posY);
		this.setMovingUp(false);
		this.setMovingDown(false);
		this.setScore(score);
	}
	
	public void run() {
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				int y = getPosY();
				int speed = 5;
				
				
				if(isMovingUp() && y > speed + 1) {
					y-=speed;
				} else if(isMovingDown() && y + getHeight() < frame.getHeight() - 45) {
					y+=speed;
				}
				
				setPosY(y);
			}
			
		}, 0, 7);
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
	
	public boolean isMovingUp() {
		return movingUp;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public boolean isMovingDown() {
		return movingDown;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}
	
	public void setHeight(int height) {
		HEIGHT = height;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
