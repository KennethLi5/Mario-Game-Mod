package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class Seed extends Projectile{
	
	/*
	 * The seed class is the projectile for the flower. 
	 * It will shoot in a direction depending on where the player is in relation.
	 */
	
	public Seed(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		// This is what determines what projectile subclass this elemental subclass corresponds to
		this.numElement = 6;
		
		// speed of the projectile
		speed = .5f;
	}
	
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		
		if(Math.abs(Player.x - Elemental.x[getIndex()][0]) < 100 && Player.y < Elemental.y[getIndex()][0]) {
			// above the player
			degree = 270;
		}
		
		if(Player.x < Elemental.x[getIndex()][0] && !(Player.y < Elemental.y[getIndex()][0])) {
			//left of the player
			degree = 145;
		}
		
		if(Elemental.x[getIndex()][0] < Player.x && !(Player.y < Elemental.y[getIndex()][0])) {
			//right of the player
			degree = 35;
		}
		
		
	}
	
}
