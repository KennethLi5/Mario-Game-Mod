package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * The jelly fish will go up and down vertically
 *  and will turn around when hitting the ceiling or the floor.
 * 
 */

public class JellyFish extends Creature{
	public JellyFish(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left, right, deadLeft, deadRight);
		
		flying = true;
		
		this.setVelocityY(.3f * enemySpeedMultiplier);
		
	}
	
	public void collideVertical() {
		this.setVelocityY( -this.getVelocityY() );
	}
	
	
}
