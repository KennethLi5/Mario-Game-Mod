package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * Ice elemental will shoot an ice ball projectiel where the enemy is facing.
 * is the slowest of the elementals
 */

public class IceElemental extends Elemental{
	public IceElemental(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// This is what determines what projectile subclass this elemental subclass corresponds to
		elemNum = 3;
		
		// how much to shift the location of where the projectile shows up.
		shiftX = 50;
		shiftY = 50;
	}
	
	public float getMaxSpeed() {
		return .05f * enemySpeedMultiplier;
	}
}
