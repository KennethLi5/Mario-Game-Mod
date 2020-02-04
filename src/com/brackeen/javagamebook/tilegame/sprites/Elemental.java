package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class Elemental extends GCConsule{
	
	/*
	 * The elemental class is meant to create a subclass that will be able to shoot a projectile.
	 * The projectile must be a subclass of the Projectile class.
	 */
	
	// Array of location values
	public static float x[][];
	public static float y[][];
	
	//direction of where the character of facing so the projectile will shoot out correctly
	public static boolean direction[];
	
	// index of current class and total elemental subclasses
	public static int numOfElementals = 0;
	public int index =0;
	
	// how much to shift the projectiles starting location.
	public float shiftX;
	public float shiftY;
	
	// This is what determines what projectile subclass this elemental subclass corresponds to
	protected float elemNum;
	
	public Elemental(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		flying = true;
		
		
		index = numOfElementals;
		numOfElementals++;
		
		float tempX[][] = new float[numOfElementals][2];
		float tempY[][] = new float[numOfElementals][2];
		
		direction = new boolean[numOfElementals];
		
 		try {
 			for(int i = 0; i < index; i++) {
 				tempX[i][0] = x[i][0];
 				tempY[i][0] = y[i][0];
 				tempX[i][1] = x[i][1];
 				tempY[i][1] = y[i][1];
 			}
 			
 			x = tempX;
 			y = tempY;
 			
 			
 			
 		}catch(Exception e) {
 			System.out.println("error occured at Elemental.java");
 			System.out.println(e);
 		}
		
		
 		
	}
	
	public int getIndex() {
		return index;
	}
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
					
		if(isAlive()) {
			x[index][0] = this.getX() + shiftX;
			y[index][0] = this.getY() + shiftY;
			
			x[index][1] = elemNum;
			y[index][1] = elemNum;
			
			if(this.getVelocityX()> 0) {
				direction[index] = true;
			}else {
				direction[index] = false;
			}
			
			
			
		}
				
	}
	
	public void setState(int state) {
		super.setState(state);
		
		if(state == STATE_DEAD) {
			y[index][0] = x[index][0] = 0;
			
			
		}
				
	}
	
	
	
}
