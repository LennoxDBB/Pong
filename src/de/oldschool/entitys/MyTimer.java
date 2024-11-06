package de.oldschool.entitys;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import de.oldschool.main.Main;

//Lennox
public class MyTimer {
	
	private Timer timer;
	private boolean isRunning;
	
	private int speedTime;
	private int speedDelay;
	
	private int time;
	private int mins;
	
	public MyTimer(int time) {
		this.setRunning(false);
		this.setSpeedTime(0);
		this.setSpeedDelay(15);
		this.setTime(time);
		this.mins = 0;
	}
	
	private void run() {
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				setTime(getTime() + 1);
				setSpeedTime(getSpeedTime() + 1);
				
				if(getSpeedTime() % getSpeedDelay() == 0) {
					setSpeedTime(0);
					increaseSpeed();
				}
			}
			
		}, 0, 1000);
		
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
	
	public String getTimeString(int time) {
		
		if(time >= 60) {
			mins += (int) time / 60;
			setTime((int) time %- 60);
		}
		
		String minsString = mins < 10 ? "0" + mins : String.valueOf(mins);
		String secondsString = time < 10 ? "0" + time : String.valueOf(time);
		
		return String.valueOf(minsString + ":" + secondsString);
	}
	
	public void increaseSpeed() {
		Ball ball = Main.getInstance().getBall();
		Random random = new Random();
		int number = random.nextInt(0, 2); 
		
		ball.setSpeedMultiplierX(ball.getSpeedMultiplierX() + 1);
		if(number == 0) {
			ball.setSpeedMultiplierY(ball.getSpeedMultiplierY() + random.nextInt(1, 3));
		}
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public int getSpeedTime() {
		return speedTime;
	}

	public void setSpeedTime(int speedTime) {
		this.speedTime = speedTime;
	}
	
	public int getSpeedDelay() {
		return speedDelay;
	}

	public void setSpeedDelay(int speedDelay) {
		this.speedDelay = speedDelay;
	}
	
	public boolean isRunning() {
		return isRunning;
	}


	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
}
