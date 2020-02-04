package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;

public class Ghost extends GCConsule{
	
	/*
	 * The chost class is similar to the GCConsule in that it floats sinuously.
	 * It will float in a direction and will pace around, turning around at walls.
	 */
	
	public Ghost(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
	}
	
	public float getMaxSpeed() {
		
		if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=2)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
		
		return .1f * enemySpeedMultiplier;
		
	}
	
	public boolean isFlying() {
		if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=1)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}

		return isAlive() && super.isFlying();
		
	}
	
    public void setState(int state)
    {
    	//Call setState 
    	super.setState(state);
    	
    	//and override the y velocity if hurt
    	if (state == STATE_HURT)
    		this.setVelocityY(0.2f);
    }
	
}
