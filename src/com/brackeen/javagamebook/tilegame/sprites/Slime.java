package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * The slime class will shoot a projectile a short distance
 */

public class Slime extends Elemental{
	public Slime(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// This is what determines what projectile subclass this elemental subclass corresponds to
		this.elemNum = 9;
		
		// does not fly or shimmy(move sinouosly)
		flying = false;
		shimmy = false;
		
		// tracks the player
		this.trackPlayer = true;
		
		// how much to shift the starting location of the projectile
		shiftX = 70;
	}
	
	public float getMaxSpeed() {
		return .01f * enemySpeedMultiplier;
	}
	
}
