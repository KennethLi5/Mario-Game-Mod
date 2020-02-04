package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * The cat will float and not move and fire a different ice cream flavor each time. 
 */

public class IceCreamCat extends Elemental{
	public IceCreamCat(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// This is what determines what projectile subclass this elemental subclass corresponds to
		this.elemNum = 8;
		
		// how much to shift the location of where the projectile shows up.
		this.shiftX = 30;
		this.shiftY = 30;
	}
}
