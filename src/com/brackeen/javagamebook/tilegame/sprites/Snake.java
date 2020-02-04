package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * The snake class will fly around with a similar motion to the ghost but faster.
 */

public class Snake extends Ghost{
	public Snake(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
	}
	
	public float getMaxSpeed() {
		return .4f * enemySpeedMultiplier;
	}
}
