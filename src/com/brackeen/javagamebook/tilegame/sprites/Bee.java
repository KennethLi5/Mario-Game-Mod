package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * The bee will fly around until it comes into range of a player that is below them,
 * and then will dive down and sting them.
 */


public class Bee extends Ghost{
	public Bee(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
	}
	
	public float getMaxSpeed() {
		return .3f * enemySpeedMultiplier;
	}
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		
		if(Player.y > this.getY() && Math.abs(Player.x - this.getX()) < 200) {
			this.setVelocityY(.3f);
		}else {
			this.setVelocityY(0f);
		}
	}
	
}
