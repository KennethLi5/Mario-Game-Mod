package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class SlimeShot extends Projectile{
	public SlimeShot(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left, right, deadLeft, deadRight);
		
		// This is what determines what projectile subclass this elemental subclass corresponds to
		this.numElement = 9;
		
		// degree and speed of shot projectile
		degree = 245f;
		speed = .7f;
		
		// does track player and does not fly
		this.trackPlayer = true;
		this.flying =false;
	}
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		
		if(Player.x < Elemental.x[getIndex()][0]) {
			//left of the player
			degree = 245;
		} 
		if(Elemental.x[getIndex()][0] < Player.x) {
			//right of the player
			degree = 425;
		} 
		
	}
	
	
}
