package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Explosion extends GameObject{
	
	private int maxRad = 200;
	protected int minRad = 100;
	Color color = Color.ORANGE;
	Handler handler;
	
	public Explosion(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
	}

	@Override
	public void tick() {
		if(minRad<maxRad) {
			minRad += 10;
			y-= 2;
			x -= 1;
		}else {handler.removeObject(this);}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int)x, (int)y, minRad, minRad/2);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, minRad, minRad/2); 
	}
	
	public int getMinRad() {
		return (int) minRad;
	}

}
