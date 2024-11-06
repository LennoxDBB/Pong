package de.oldschool.system;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Lennox
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	
	private final int WIDTH;
	private final int HEIGHT;
	
	public MyFrame() {
		this.WIDTH = 1600;
		this.HEIGHT = 900;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Pong");
	}
	
	public void setPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		panel.addKeyListener(new KeyHandler());
		
		this.revalidate();
		this.repaint();
		
		this.setVisible(true);
	}
	
	

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}
	
	
	
	
	
}