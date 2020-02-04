package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * The ice cream is projectile for the ice Cream cat
 * This will change to a different flavor of ice cream each shot.
 */


public class IceCream extends Projectile{
	public IceCream(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// This is what determines what elemental subclass this projectile corresponds to
		this.numElement = 8;
	}
}
