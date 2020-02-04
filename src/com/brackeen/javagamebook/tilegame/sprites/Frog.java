package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class Frog extends GCController{
	
	/*
	 * The frog is an enemy that is always jumping towards the player.
	 */
	
	public Frog(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// set health
		this.setHealth(1);
	}
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		
		jump();
		
	}
	
	public float getMaxSpeed() {
		return .3f * enemySpeedMultiplier;
	}
	
	
}
