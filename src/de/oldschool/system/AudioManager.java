package de.oldschool.system;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;


public class AudioManager {
	
	private final float decibel;
	
	public AudioManager() {
		this.decibel = -10.0f;
	}
	
	public void playSound(File file) {
		
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			
			clip.addLineListener(new LineListener() {

				@Override
				public void update(LineEvent e) {
					if(e.getType() == LineEvent.Type.STOP) {
						clip.close();
						try {
							stream.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}
				}
				
			});
			
			FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			control.setValue(decibel);
			
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
