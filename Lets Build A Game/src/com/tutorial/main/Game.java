package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1550691097823471818L;

	public static final int WIDTH = 1500, HEIGHT = WIDTH/20*11;
	
	public static final int FLOOR = HEIGHT-32-100;
	public int numBasicEnemies = 5;
	
	private Thread thread;
	private boolean running = false;
	private HUD hud;
	
	private Handler handler;
	
	public Game() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput(handler));
		
		new Window(WIDTH, HEIGHT, "Hehehehehehehehe", this);
		hud = new HUD();
		
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
		
		for(int i = 0; i < numBasicEnemies; i++) {
			handler.addObject(new BasicEnemy(WIDTH/2-32, HEIGHT/2-32, ID.BasicEnemy, Color.RED, handler));
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) 
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//wwsadawdswSystem.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var >= max) {
			return var = max;
		}
		else {
			if(var <= min) {
				return var = min;
			}
			else {return var;
		}}
	}
	
	public static int randomX() {
		Random r = new Random();
		int x = r.nextInt(WIDTH);
		return x;
	}
	
	public static int randomY() {
		Random r = new Random();
		int y = r.nextInt(HEIGHT-47);
		return y;
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
