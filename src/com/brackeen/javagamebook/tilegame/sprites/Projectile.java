
package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class Projectile extends Creature{
	
	/*
	 * The projectile class is meant to be the parent class for all other projectiles.
	 * It works with the elemental parent class to get x and y values.
	 */
	
	// true if first update hasn't happened.
	public boolean firstRun = true;
	
	// x and y values of the projectile
	public float x;
	public float y;
	
	// how long it takes for the projectile to shoot again
	protected long time = 2000;
	
	// This is what determines what projectile subclass this elemental subclass corresponds to
	protected float numElement;
	
	// the time that is added to
	private long timeAdd;
	
	// the index of the projectile in the several arrays
	private int index;
	
	// taken indexes to ensure that each projectile only goes to on elemental
	public static boolean takenIndexes[];
	
	// degree and speed of shot projectile
	public float degree;
	public float speed;
	
	// whether the projectile will shoot
	public boolean aggression = true;
	
	public Projectile (Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		setHealth(5);
		
		flying = true;
		
		timeAdd = 4000;
	}
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		//System.out.println(totalElapsedTime);
		if(totalElapsedTime < time) {
			x = this.getX();
			y = this.getY();
			
			//System.out.println("x: " + x);
			
			//System.out.println("index " + index);
			
			takenIndexes = new boolean[Elemental.numOfElementals];
			
			//System.out.println("x: " + Elemental.x[index][1] + "y: " + y);
			
			
			
		}else if(firstRun) {
			firstRun = false;
			
			for(int i = 0; i < Elemental.numOfElementals; i++) {
				if(Math.abs(Elemental.x[i][1] - numElement) < .001 && !takenIndexes[i]) {
					index = i;
					
					
					takenIndexes[index] = true;
					
					
					break;
					
				}
				//System.out.print(takenIndexes[i] + " ");
			}
			
		}
		//System.out.println("working " + time);
		if(totalElapsedTime > timeAdd) {
			timeAdd += time;
			Elemental.numOfElementals = 0; // resets for future uses
			// shoot Projectile
			//System.out.println(Elemental.x[index][0] + " " + Elemental.y[index][0]);
			if(!(Elemental.x[index][0] == 0 && Elemental.y[index][0] == 0 )) {
				//System.out.println("index = 0");
				if(aggression)
					shootProjectile();
				 // the projectile actually shooting
			}else
				this.setState(STATE_DEAD);
			
			
			
			//System.out.println("working " + time);
			
		}
		
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setAggression(boolean attacks) {
		aggression = attacks;
	}
	
	public void shootProjectile() {
		this.setX(Elemental.x[index][0]);
		this.setY(Elemental.y[index][0]);
		
		if(Elemental.direction[index]) {
			this.setDirection(Math.toRadians(degree - 180), speed);
		}else {
			this.setDirection(Math.toRadians(degree), speed);
		}
		
	}
	
	public float getMaxSpeed() {
		return .5f * enemySpeedMultiplier;
	}
	
	public void setState(int state)
	    {
	    	//Call setState 
	    	super.setState(state);
	    	
	    	//and override the y velocity if hurt
	    	if (state == STATE_HURT) {
	    		
	    		this.setHealth(5);
	    		this.setX(x);
	    		this.setY(y);
	    		this.setDirection(0,0);
	    	}
	    }
	
	
	
	public void setDirection(double degree, float speed) {
		this.setVelocityX(speed * (float)Math.cos(degree) * enemySpeedMultiplier);
		this.setVelocityY(speed * (float)Math.sin(degree) * enemySpeedMultiplier);
	}
	
	public void collideHorizontal() {
		this.setX(x);
		this.setY(y);
		this.setDirection(0,0);
		
	}
	
	public void collideVertical() {
		this.setX(x);
		this.setY(y);
		this.setDirection(0,0);
	}
}

