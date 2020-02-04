package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * The fire elemental will shoot a fire ball projectile where the enemy is facing. 
 * Is the fastest of the elementals.
 */


public class FireElemental extends Elemental{
	public FireElemental(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// This is what determines what projectile subclass this elemental subclass corresponds to
		elemNum = 4;
		
		// how much to shift the location of where the projectile shows up.
		shiftX = 50;
		shiftY = 50;
	}
	
	public float getMaxSpeed() {
		return .2f * enemySpeedMultiplier;
	}

}
