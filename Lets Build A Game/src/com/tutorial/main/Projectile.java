package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject{

	Vector v = new Vector();
	Handler handler;
	Color color;
	int speed = 20;
	int width = 10;
	int height = 10;
	
	public Projectile(double x, double y, ID id, Color color, Handler handler) {
		super(x, y, id);
		this.color = color;
		this.handler = handler;
	}
	
	public void generateVector(double pX, double pY, int mX, int mY) {
		v.generateVector((int)pX, (int)pY, mX, mY, speed);
	}
	
	public Vector getVector() {
		return v;
	}

	@Override
	public void tick() {
		x = v.getNewX(x);
		y = v.getNewY(y);
		if(x <= 0 || x >= Game.WIDTH-80) {
			//handler.addObject(new Explosion(x, y, ID.Explosion, handler));
			handler.removeObject(this);}
		if(y <= 0 || y >= Game.FLOOR+30) {
			//handler.addObject(new Explosion(x, y, ID.Explosion, handler));
			handler.removeObject(this);
		}
	}
	

	
	public void render(Graphics g) {
		if(id == ID.Projectile) g.setColor(color);
		g.fillOval((int)x+16, (int)y+16, width, height);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
