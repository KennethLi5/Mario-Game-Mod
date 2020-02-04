package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class Flower extends Elemental{	

	/*
	 * The flower class shoots a projectile in direction depending on where the player is in relation.
	 * It will shoot up if above, left if to the left, and right if to the right.
	 * The flower Elemental can not die.
	 */
	
	public Flower(Animation left, Animation right, Animation deadLeft, Animation deadRight) {

		super(left, right, deadLeft, deadRight);
		
		// This is what determines what projectile subclass this elemental subclass corresponds to
		this.elemNum = 6;
		
		// on ground, does not fly
		flying = false;
		
		// how much to shift where the projectile shows up
		shiftX = 100;
		shiftY = 50;
		
		// shimmy is boolean variable from the GGConsule class, which means it will not float up and down
		shimmy = false;
	}
	
	public boolean isFlying() {
		// should never be flying
		return false;
	}
	
	public void setState(int state) {
		// do nothing
	}
	
}
