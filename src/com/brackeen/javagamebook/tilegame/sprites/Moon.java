package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class Moon extends GCConsule{
	
	/*
	 * The Moon class will float similar to the GCConsule, and will move towards the player
	 * when the player is not looking in the moons direction.
	 */
	
	// max speed
	public float maxSpeed;
	
	// whether the moon is to the right of the player.
	boolean rightOfPlayer;
	
	public Moon(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left, right, deadLeft, deadRight);
		this.setHealth(2);
	}
	
	
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		
		rightOfPlayer = this.getX() > Player.x;
		
		if((Player.direction && !rightOfPlayer) || (!Player.direction && rightOfPlayer)) {
			maxSpeed = .4f * enemySpeedMultiplier;
			trackPlayer = true;
		}else {
			trackPlayer = false;
			maxSpeed = 0;
			this.setVelocityX(0);
		}		
		
	}
	
	public float getMaxSpeed() {
		return maxSpeed;
	}
	
}
