package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * is the projectile for the storm cloud.
 */

public class Lightning extends Projectile{
	public Lightning(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// This is what determines what projectile subclass this elemental subclass corresponds to
		this.numElement = 2;
		
		// what direcion the projectile shoots at (this will shoot directly down).
		this.degree = 90;
		this.speed = .5f;
	}
}
