package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	int width;
	int height;
	int speed = 10;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		width = 32;
		height = 32;
		this.handler = handler;
	}
	
		
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height); 
	}


	public void tick() {
		
		if(keys[5] == true) {
			/*******************************************************************************************/
			//Spawns a projectile and sets its vector depeenant on player location and mouse location
			GameObject tempObject = new Projectile(x, y, ID.Projectile, Color.blue, handler);
			handler.addObject(tempObject);
			((Projectile) tempObject).generateVector(x, y, mouseX, mouseY);
			keys[5] = false;
			/*******************************************************************************************/
		}
		
		if(y >= Game.FLOOR) {
			velY = 0;
			y = Game.FLOOR;
		} 
		if(velY < 0) {
			if(this.keys[4] == true) {
				velY++;
			}else {
				velY = velY/2;
			}
		}
		velY++;
		
		if(keys[0] == true && keys[3] == true) {}
		else if(keys[0] == true) {x = x-speed;}
		else if(keys[3] == true) {x = x+speed;}
		else {}
		
		y = y + velY;
		x += velX;
		if(velX>0) {velX--;}
		
		x = Game.clamp(getX(), 0, Game.WIDTH-45);
		
		collision();
		handler.addObject(new Trail(getX(), getY(), ID.Trail, width, height, 0.15f, Color.white, handler));
		HUD.health += 5; //health regen
	}

	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.BasicEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.health -= 500;
				}
			}
			if(tempObject.getId() == ID.Explosion) {
				if(getBounds().intersects(tempObject.getBounds())) {
					Vector v = new Vector();
					v.generateVector((int)tempObject.x - (((Explosion) tempObject).getMinRad()/2), (int)tempObject.y + (((Explosion) tempObject).getMinRad()/2)/2, (int)x, (int)y, 20);
					velY = velY + (int)v.YComp();
					velX = velX + (int)v.XComp();
				}
			}
			
		}
	}
	
	public void render(Graphics g) {
		if(id == ID.Player) g.setColor(Color.white);
		g.fillRect(getX(), getY(), width, height);
	}

}
