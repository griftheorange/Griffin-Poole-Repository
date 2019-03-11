package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int health = 10000;
	
	public void tick() {
		health = Game.clamp(health, 0, 10000);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, health/100*2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
	}
}
