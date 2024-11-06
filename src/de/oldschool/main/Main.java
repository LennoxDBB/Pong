package de.oldschool.main;

import de.oldschool.entitys.Ball;
import de.oldschool.entitys.MyTimer;
import de.oldschool.entitys.Player;
import de.oldschool.panels.DefaultPanel;
import de.oldschool.panels.HighscorePanel;
import de.oldschool.panels.LoginPanel;
import de.oldschool.panels.SettingsPanel;
import de.oldschool.panels.StartPanel;
import de.oldschool.system.AudioManager;
import de.oldschool.system.CollisionChecker;
import de.oldschool.system.DataManager;
import de.oldschool.system.GameHandler;
import de.oldschool.system.MyFrame;

//Lennox
public class Main {
	
	private static Main instance;
	
	private static Player player1;
	private static Player player2;
	private static Ball ball;
	private static MyTimer timer;
	
	private static CollisionChecker cc;
	private static MyFrame frame;
	private static GameHandler game;
	private static AudioManager audioManager;
	private static DataManager dataManager;
	
	private static StartPanel startPanel;
	private static DefaultPanel defaultPanel;
	private static SettingsPanel settingsPanel;
	private static HighscorePanel highscorePanel;
	private static LoginPanel loginPanel;
	
	
	public static void main(String[] args) {
		
		instance = new Main();
		audioManager = new AudioManager();
		dataManager = new DataManager();
		
		frame =  new MyFrame();
		
		ball = new Ball();
		game = new GameHandler();
		timer = new MyTimer(0);
		
		
		player1 = new Player(10, 400, 0);
		player2 = new Player(1555, 400, 2);
		
		cc = new CollisionChecker();
		
		startPanel = new StartPanel();
		defaultPanel = new DefaultPanel();
		settingsPanel = new SettingsPanel();
		highscorePanel = new HighscorePanel();
		loginPanel = new LoginPanel();
		
		Main.getInstance().getFrame().setPanel(new LoginPanel());
		
	}

	
	public static Main getInstance() {
		return instance;
	}
	
	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
	
	public Ball getBall() {
		return ball;
	}
	
	public MyTimer getTimer() {
		return timer;
	}
	
	public GameHandler getGameHandler() {
		return game;
	}
	
	public MyFrame getFrame() {
		return frame;
	}
	
	public CollisionChecker getCollisionChecker() {
		return cc;
	}

	public DefaultPanel getDefaultPanel() {
		return defaultPanel;
	}
	
	public SettingsPanel getSettingsPanel() {
		return settingsPanel;
	}


	public AudioManager getAudioManager() {
		return audioManager;
	}


	public StartPanel getStartPanel() {
		return startPanel;
	}
	
	public DataManager getDataManager() {
		return dataManager;
		
	}


	public HighscorePanel getHighscorePanel() {
		return highscorePanel;
	}


	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	
}
