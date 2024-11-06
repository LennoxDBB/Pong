package de.oldschool.system;

//Lennox
public class GameHandler {

	private boolean isPaused;
	private int gameLength;
	private boolean winAfterTwo;
	//private boolean music; 
	private String gamemode = "HARDCORE";
	
	public GameHandler() {
		this.setPaused(true);
		this.setGameLength(3);
		this.setWinAfterTwo(false);
	}

	public int getGameLength() {
		return gameLength;
	}

	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}

	public boolean isWinAfterTwo() {
		return winAfterTwo;
	}

	public void setWinAfterTwo(boolean winAfterTwo) {
		this.winAfterTwo = winAfterTwo;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	public String getGamemode() {
		return gamemode;
	}

	public void setGamemode(String gamemode) {
		this.gamemode = gamemode;
	}
	
}
