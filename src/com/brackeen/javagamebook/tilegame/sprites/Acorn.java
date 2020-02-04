package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * This is the projectile for the earth Elemental!
 */

public class Acorn extends Projectile{
	public Acorn(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// This is what determines what elemental subclass this projectile corresponds to
		numElement = 1;
		
		// what degree and speed the projectile is shot out at
		this.degree = 180;
		this.speed = .5f;
	}
	
}
