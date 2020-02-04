package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class Meteor extends Creature{
	
	/*
	 * Will drop down from where it is placed then will go left upon hitting the ground
	 * Will continue until it hits a wall or is stepped on, and then it will teleport
	 * back to starting location and go again.
	 */
	
	float x;
	float y;
	boolean wakeUp;
	
	public Meteor(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		this.setVelocityX(0f);
		this.setHealth(2);
	}

	public void setState(int state) {
		super.setState(state);
		if(state == STATE_HURT) {
			this.setX(x);
			this.setY(y);
			this.setHealth(2);
		}
	}
	
	public void wakeUp() {
		
		
		super.wakeUp();
		
		if(!wakeUp) {
			x = this.getX();
			y = this.getY();
			wakeUp = !wakeUp;
		}
		
	}
	
	public void collideHorizontal() {
		this.setX(x);
		this.setY(y);
		this.setVelocityX(0f);
		this.setVelocityY(0f);
	}
	
	public void collideVertical() {
		this.setVelocityX(-.3f * enemySpeedMultiplier);
	}
}
