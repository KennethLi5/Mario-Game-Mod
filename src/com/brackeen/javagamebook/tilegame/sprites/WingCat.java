package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * Flies around in a sine like pattern.
 */

public class WingCat extends GCConsule{
	public WingCat(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left, right, deadLeft, deadRight);
		
		// timeAdd is how much time is added to the time variable
		// that is used to determine the sine wave
		timeAdd = .1f;
		
		// base speed of how much it moves around
		baseSpeed = .5f;
	}
	
	public float getMaxSpeed() {
		return .3f * enemySpeedMultiplier;
	}
	
}
