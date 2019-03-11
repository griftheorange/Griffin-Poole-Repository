package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject{
	
	private Handler handler;
	private int speed = 10;
	private int width = 16;
	private int height = 16;
	Vector vector = new Vector();
	
	Random r = new Random();
	Color color;

	public BasicEnemy(int x, int y, ID id, Color color, Handler handler) {
		super(x, y, id);
		this.color = color;
		this.handler = handler;
		
		vector.setRandVect(speed);		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height); 
	}
	
	public void tick() {
		x = vector.getNewX(x);
		y = vector.getNewY(y);
		if(x <= 0 || x >= Game.WIDTH-20) {vector.reflectX();}
		if(y <= 0 || y >= Game.HEIGHT-47) {vector.reflectY();}
		
		handler.addObject(new Trail(getX(), getY(), ID.Trail, width, height, 0.03f, color, handler));
	}

	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
	}

}
