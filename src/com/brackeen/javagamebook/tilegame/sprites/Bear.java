package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * THe bear will slowly walk around the level. 
 * health is 1 and the speed is .1.
 * This is different from the wii consule because it has only one health.
 */


public class Bear extends GCController{
	public Bear(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		this.trackPlayer = false;
		this.setHealth(1);
	}
	
	public float getMaxSpeed() {
		return .1f * enemySpeedMultiplier;
	}
	
}
