package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * This is the projectile for the fire elemental. The fire Elemental is the fast elemental.
 */


public class FireBall extends Projectile{
	public FireBall(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// degree to start at (basically will shoot in front of the Fire Elemental)
		degree = 180f;
		speed = .5f;
		
		// This is what determines what elemental subclass this projectile corresponds to
		numElement = 4;
		
		
	}
	

	
}
