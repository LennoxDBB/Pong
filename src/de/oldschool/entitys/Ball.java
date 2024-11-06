package de.oldschool.entitys;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import de.oldschool.main.Main;
import de.oldschool.system.MyFrame;

//Lennox
public class Ball {

	private int SIZE;
	
	private int posX;
	private int posY;
	
	private int dirX;
	private int dirY;
	
	private int speedMultiplierX;
	private int speedMultiplierY;
	
	private boolean isRunning;
	private Timer timer;
		
	MyFrame frame = Main.getInstance().getFrame();
	
	public Ball() {
		this.setSize(20);
		this.setPosX(frame.getWidth() / 2 - SIZE / 2);
		this.setPosY(frame.getHeight() / 2 - SIZE / 2);
		this.setDirY(0);
		this.setSpeedMultiplierX(1);
		this.setSpeedMultiplierY(1);
		this.setRunning(false);
		startDirection();
	}
	
	private void run() {
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				setPosX(getPosX() + getDirX() * getSpeedMultiplierX());
				setPosY(getPosY() + getDirY() * getSpeedMultiplierY());
			}
			
		}, 0, 5);
	}
	
	private void startDirection() {
		Random random = new Random();
		this.dirX = random.nextInt(0, 2) == 0 ? -1 : 1;
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
	
	public void setFirstYDirection() {
		Random random = new Random();
		this.dirY = random.nextInt(0, 2) == 0 ? -1 : 1;
	}

	public int getSize() {
		return SIZE;
	}
	
	public void setSize(int size) {
		this.SIZE = size;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getDirX() {
		return dirX;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

	public int getSpeedMultiplierX() {
		return speedMultiplierX;
	}

	public void setSpeedMultiplierX(int speedMultiplierX) {
		this.speedMultiplierX = speedMultiplierX;
	}

	public int getSpeedMultiplierY() {
		return speedMultiplierY;
	}

	public void setSpeedMultiplierY(int speedMultiplierY) {
		this.speedMultiplierY = speedMultiplierY;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	
}
