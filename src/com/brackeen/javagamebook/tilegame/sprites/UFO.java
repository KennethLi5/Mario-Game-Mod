package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class UFO extends Elemental{
	
	// when the player goes in range of UFO, the UFO will start to track the player.
	// The UFO will move faster vertically if the player is close.
	// The UFO will shoot the EnergyBlast projectile
	
	
	// time used to determine the sine wave
	private float time;
	
	public UFO(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
    	trackPlayer = false;
		flying = true;
		time = 0;
		
		// This is what determines what projectile subclass this elemental subclass corresponds to
		this.elemNum = 5;
		
		// how much to shift the projectile
		shiftY = 50;
		shiftX = 50;
		
	}
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		time += .1;
		// once it notices you you can't lose it.
		if(Math.abs(Player.x - this.getX()) < 250 && Math.abs(Player.y - this.getY()) < 300) {
			//shimmy = false;
			
			float difference = (float)Math.toRadians(Player.y - this.getY());
			
			if(difference > Math.PI) {
				difference = (float)Math.PI;
			}
			
			this.trackPlayer = true;
			//if(tempDifference);
			
			// as temp difference decreases, the speed will increase.
			this.setVelocityY( .05f + (float)Math.abs(Math.cos(difference)) / 5 );
			this.setVelocityX(.1f + this.getVelocityY());
			
		}
		
        if (isAlive()) 
        {
            setVelocityY((float)Math.sin(time) * enemySpeedMultiplier * .05f);
        }
        
        if(time >= 2* Math.PI) {
        	time = 0;
        }
        
		
	}

	public float getMaxSpeed() {
		
		return .1f * enemySpeedMultiplier;
		
	}
	
	public boolean isFlying() {

		return isAlive() && super.isFlying();
		
	}
	
    public void setState(int state)
    {
    	//Call setState 
    	super.setState(state);
    	
    	//and override the y velocity if hurt
    	if (state == STATE_HURT)
    		this.setVelocityY(0.2f);
    		//this.setHealth(2);
    }
	
}


/*
 * jelly fish that goes up and down 
 */
