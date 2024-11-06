package de.oldschool.system;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.oldschool.entitys.Player;
import de.oldschool.main.Main;

//Lennox
public class KeyHandler implements KeyListener {
	
	Main main = Main.getInstance();
	GameHandler game = main.getGameHandler();
	Player player1 = main.getPlayer1();
	Player player2 = main.getPlayer2();
		
	private boolean isPressedOnce;
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
				
		switch(key) {
		
		case KeyEvent.VK_W:
			player1.setMovingUp(true);
			break;
		case KeyEvent.VK_S:
			player1.setMovingDown(true);
			break;
		case KeyEvent.VK_UP:
			player2.setMovingUp(true);
			break;
		case KeyEvent.VK_DOWN:
			player2.setMovingDown(true);
			break;
		case KeyEvent.VK_ESCAPE:
			
			if(isPressedOnce) {
				return;
			}
			
			if(game.isPaused()) {
				resumeGame();
			} else {
				pauseGame();
			}
			
			isPressedOnce = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key) {
		case KeyEvent.VK_W:
			player1.setMovingUp(false);
			break;
		case KeyEvent.VK_S:
			player1.setMovingDown(false);
			break;
		case KeyEvent.VK_UP:
			player2.setMovingUp(false);
			break;
		case KeyEvent.VK_DOWN:
			player2.setMovingDown(false);
			break;
		case KeyEvent.VK_ESCAPE:
			isPressedOnce = false;
			break;
		}
	}
	
	private void pauseGame() {
		main.getBall().disable();
		main.getPlayer1().disable();
		main.getPlayer2().disable();
		main.getCollisionChecker().disable();
		main.getTimer().disable();
		
		game.setPaused(true);
	}
	
	private void resumeGame() {		
		main.getBall().enable();
		main.getPlayer1().enable();
		main.getPlayer2().enable();
		main.getCollisionChecker().enable();
		main.getTimer().enable();
		
		game.setPaused(false);
	}

}
