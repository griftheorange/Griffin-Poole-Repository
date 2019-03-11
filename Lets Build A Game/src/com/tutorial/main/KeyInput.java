package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) {tempObject.keys[1] = true;}
				if(key == KeyEvent.VK_S) {tempObject.keys[2] = true;}
				if(key == KeyEvent.VK_D) {tempObject.keys[3] = true;}
				if(key == KeyEvent.VK_A) {tempObject.keys[0] = true;}
				if(key == KeyEvent.VK_SPACE && tempObject.getY() >= Game.FLOOR) {
					tempObject.keys[4] = true;
					tempObject.setY(Game.FLOOR - 1); 
					tempObject.setVelY(-40);
				}
			}   
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) {tempObject.keys[1] = false;}
				if(key == KeyEvent.VK_S) {tempObject.keys[2] = false;}
				if(key == KeyEvent.VK_D) {tempObject.keys[3] = false;}
				if(key == KeyEvent.VK_A) {tempObject.keys[0] = false;}
				if(key == KeyEvent.VK_SPACE) {
					tempObject.keys[4] = false;
				}
			}
		}
	}
}
