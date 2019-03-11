package com.tutorial.main;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
	
	private Handler handler;
	private int speed = 10;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
	}

	public void MousePressed(MouseEvent e) {

	}

	
	public void mouseClicked(MouseEvent e) {
		
	}

	
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent e) {
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		/*handler.getPlayer().keys[5] = true;
		handler.getPlayer().mouseX = e.getX();
		handler.getPlayer().mouseY = e.getY();*/
		/*******************************************************************************************/
		//Spawns a projectile and sets its vector depeenant on player location and mouse location
		int x = handler.getPlayer().getX();
		int y = handler.getPlayer().getY();
		GameObject tempObject = new Projectile(x, y, ID.Projectile, Color.blue, handler);
		handler.addObject(tempObject);
		((Projectile) tempObject).generateVector(x, y, e.getX(), e.getY());
		/*******************************************************************************************/
		
	}
}
