package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class WiiConsule extends Creature{
	
	/*
	 * will slowly pace around. Moves slowly, and has higher health than every other enemy.
	 */
	
	public WiiConsule(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		this.setHealth(5);
	}
	
	public float getMaxSpeed() {
		return .1f * enemySpeedMultiplier;
	}
	
}
