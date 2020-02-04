package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class EnergyBlast extends Projectile{
	
	/*
	 * This is the projectile for the UFO class. It will only fire when the play is within a certain
	 * range of the UFO.
	 */
	
	
	public EnergyBlast(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		// This is what determines what elemental subclass this projectile corresponds to
		this.numElement = 5;
		
		// whether it is shooting a projectile or not
		aggression = false;
		
		// degree and speed to start at (basically will shoot in front of the UFO)
		speed = .5f;
		degree = 180;
	}
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		
		if(Math.abs(Elemental.x[this.getIndex()][0] - Player.x) < 350 
				&& Math.abs(Elemental.y[this.getIndex()][0] - Player.y) < 75) {
			aggression = true;
		}else {
			aggression = false;
		}
		
		
	}
	
}
