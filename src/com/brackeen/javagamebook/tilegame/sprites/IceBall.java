package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * The iceball is the projectile for the Ice Elemental
 */


public class IceBall extends Projectile{
	public IceBall(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// degree of the projectile to be shot at( will shoot in front of the elemental )
		degree = 180f;
		speed = .5f;
		
		// This is what determines what elemental subclass this projectile corresponds to
		numElement = 3;
		
		
		
	}
	
	
	
}
