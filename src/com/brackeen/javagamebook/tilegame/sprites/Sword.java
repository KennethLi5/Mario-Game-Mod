package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;

public class Sword extends Creature{
	
	/*
	 * The sword class will swap with the AngrySword class when the player gets within
	 * a range. It will swap back when out of range.
	 */
	
	public float x;
	public float y;
	
	// whether is has been swapped yet
	public boolean swapped = false;
	
	// saving the velocity for when it swaps back
	public float velocity;
	
	// index sword
	public int indexSword = 0;
	
	// total swords
	public static int totalSwords = 0;
	
	public Sword(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		indexSword = totalSwords;
		totalSwords++;
		this.trackPlayer=false;
		this.flying = true;
		this.setHealth(1);
	}
	
	public float getMaxSpeed() {
		return .05f * enemySpeedMultiplier;
	}	
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		
        	if(Math.abs(Player.x - this.getX()) <= 250 && !swapped) {
    			
    			x = this.getX();
    			y = this.getY();
    			velocity = this.getVelocityX();
    			//System.out.println(AngrySword.teleX);
    			AngrySword.teleX[indexSword] = this.getX();
    			AngrySword.teleY[indexSword] = this.getY();
    			//System.out.println(this.getX());
    			this.setX(AngrySword.startingX[indexSword]);
    			this.setY(AngrySword.startingY[indexSword]);
    			swapped = !swapped;
    		}else if(swapped && AngrySword.teleX[indexSword] == AngrySword.startingX[indexSword]) {
    			//System.out.println("swapping back");
    			this.setX(x);
    			this.setY(y);
    			this.setVelocityX(velocity);
    			swapped = !swapped;
    		}
    		
    		if(swapped) {
    			this.setVelocityX(0f);
    			this.setVelocityY(0f);
    		}
		
	}
	
	
	public boolean isFlying() {
		return isAlive();
		
	}
	
    public void setState(int state)
    {
    	super.setState(state);
       	if (state == STATE_HURT)
    		this.setVelocityY(0.2f);
    }

}
