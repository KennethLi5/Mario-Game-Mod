package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * the Earth Elemental class is the second slowest of the elementals, and will shoot a singe projectile
 * where it is pointing.
 */

public class EarthElemental extends Elemental{
	public EarthElemental(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		// This is what determines what projectile subclass this elemental subclass corresponds to
		elemNum = 1;
		
		// shifting where the projectile where the projectile will show up
		shiftX = 30;
		shiftY = 40;
		
	}
	
	public float getMaxSpeed() {
		return .1f * enemySpeedMultiplier;
	}
	
	
}
