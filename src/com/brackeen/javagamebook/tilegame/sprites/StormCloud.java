package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * The storm cloud does not move and will shoot lightning bolts downwards.
 */

public class StormCloud extends Elemental{
	public StormCloud(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// This is what determines what projectile subclass this elemental subclass corresponds to
		this.elemNum = 2;
		
		// how much to shift the location of where the projectile shows up.
		this.shiftX = 100;
		this.shiftY = 50;
	}
	
	
	
}