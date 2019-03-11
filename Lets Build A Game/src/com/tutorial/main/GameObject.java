package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected double x, y;
	protected ID id;
	protected boolean spacePressed;
	int velX = 0;
	int velY = 0;
	protected boolean[] keys = new boolean[6];
	protected int mouseX;
	protected int mouseY;
	
	public GameObject(double x, double y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
		spacePressed = false;
		for(int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getX() {
		return (int)Math.round(x);
	}
	public int getY() {
		return (int)Math.round(y);
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
	public void spaceIsPressed(boolean space) {
		spacePressed = space;
	}
	
}
