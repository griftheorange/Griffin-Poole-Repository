package com.tutorial.main;

import java.util.Random;

public class Vector {
	
	private double xComp; //x component of vector, estimated to integers
	private double yComp; //y component of vector calculated in each method, estimated to integers
	private double angle; //angle of the vector in degrees
	Random r = new Random();
	
	public Vector() {
		xComp = 0;
		yComp = 0;	
	}
	
	public void setRandVect(int speed) {
		angle = r.nextDouble()*360;
		if (Math.round(angle) == 0 || Math.round(angle) == 90 || Math.round(angle) == 180 || Math.round(angle) == 270 || Math.round(angle) == 360) {
			angle += 15;
		}
		while(angle > 360) {
			angle -= 360;
		}
		xComp = ((Math.cos(Math.toRadians(angle))*(speed)));
		yComp = ((Math.sin(Math.toRadians(angle))*(speed)));
		while(angle > 360) {
			angle -= 360;
		}
	}
	
	public void setFixedVect(int speed, double angle) {
		this.angle = angle;
		angle = Math.toRadians(angle);
		xComp = (speed*(Math.cos(angle)));
		yComp = (Math.round(speed*(Math.sin(angle))));
		while (angle > 360) {
			angle -= 360;
		}
	}
	
	public void generateVector(int pX, int pY, int mX, int mY, int speed) {
		xComp = mX - pX;
		yComp = mY - pY;
		double angle = Math.toDegrees(Math.atan2(yComp, xComp));
		setFixedVect(speed, angle);
	}
	
	public double getAngleDegrees() {
		return angle;
	}
	
	public double getAngleRadians() {
		return Math.toRadians(angle);
	}
	
	public void reflectX() {
		xComp = -xComp;
		double angIn; //angle of incidence with the wall
		if(angle > 0 && angle <= 90) {
			angIn = 90 - angle;
			angle = 90 + angIn;
		}else if(angle < 180 && angle > 90) {
			angIn = (angle - 90);
			angle = 90 - angIn;
		}else if(angle > 180 && angle <= 270) {
			angIn = 270-angle;
			angle = 270+angIn;
		}else if(angle > 270 && angle < 360) {
			angIn = angle-270;
			angle = 270-angIn;
		}
	}
	
	public void reflectY() {
		yComp = -yComp;
		double angIn; //angle of incidence with the wall
		if(angle > 0 && angle <= 90) {
			angIn = angle;
			angle = 360 - angIn;
		}else if(angle < 180 && angle > 90) {
			angIn = 90 - (angle - 90);
			angle = 180 + angIn;
		}else if(angle > 180 && angle <= 270) {
			angIn = angle - 180;
			angle = 180 - angIn;
		}else if(angle > 270 && angle < 360) {
			angIn = 360 - angle;
			angle = angIn;
		}
	}
	
	public void reflectRandX(int speed, double var) {  //var is variance requested
		int i;
		reflectX();
		if(r.nextBoolean()) {i = 1;}else {i = -1;}
		double newAngle = ((i)*(var)) + angle;
		if (angle > 175 && angle <= 180) {angle = 170;}
		if(angle < 185 && angle > 180) {angle = 190;}
		if(angle >= 0 && angle < 5) {angle = 10;}
		if(angle < 0 && angle > 355) {angle = 350;}
		setFixedVect(speed, newAngle);
	}
	
	public void reflectRandY(int speed, double var) {
		int i;
		reflectY();
		if(r.nextBoolean()) {i = 1;}else {i = -1;}
		double newAngle = ((i)*(var)) + angle;
		if (angle > 85 && angle <= 90) {angle = 80;}
		if(angle < 95 && angle > 90) {angle = 100;}
		if(angle > 265 && angle <= 270) {angle = 260;}
		if(angle < 275 && angle > 270) {angle = 280;}
		setFixedVect(speed, newAngle);
	}
	
	public double getNewX(double x) {
		x = x + xComp;
		return x;
	}
	
	public double getNewY(double y) {
		y = y + yComp;
		return y;
	}
	
	public void stop() {
		xComp = 0;
		yComp = 0;
	}
	
	
	
	
	
	public double XComp() {
		return xComp;
	}
	public double YComp() {
		return yComp;
	}
	public void setX(int x) {
		xComp = x;
	}
	public void setY(int y) {
		yComp = y;
	}

}
