package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.codereflection.CodeReflection;


public class GCConsule extends Creature{
	
	/*
	 * The GCConsule class will stand still and float up and down sinuously. 
	 */
	
	// this is the time to start at.
	protected float time; 
	
	// shimmy is whether it will float up and down sinuously
	boolean shimmy = true;
	// how much is added to time each update
	float timeAdd = .1f;
	
	// baseSpeed
	float baseSpeed = .05f;
	
	public GCConsule(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		
		setHealth(1);
		
		if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=1)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
    	trackPlayer = false;
		flying = true;
		time = 0;
		
	}
	
	
	public boolean isFlying() 
    {
    	
    	//Code Tracing
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=4)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
   	
    	//I want it to always think it is flying, even if place it on the ground.
        return isAlive();
    }
	
	public void update(long elapsedTime) 
    {//Override the call to update
    	
		// Call super to maintain animation behavior
		super.update(elapsedTime);
		
		time += timeAdd;
		
		//Code Tracing
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=4)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
    	
        if (isAlive() && shimmy) 
        {
            setVelocityY((float)Math.sin(time) * enemySpeedMultiplier * baseSpeed * getBase());
        }
        
        if(time >= 2* Math.PI) {
        	time = 0;
        }
        
        
      
	}
	
	public float getBase() {
		// get base is incase the developer wants to change how the GCConsule will float with a method
		return 1f;
	}
	
	public void setState(int state)
    {
    	//Call setState 
    	super.setState(state);
    	//and override the y velocity if hurt
    	if (state == STATE_HURT) {
    		
    		this.setVelocityY(this.getVelocityY() + .2f);
    		
    	}
    	
    	
    }
	
	

	
	
	
	
	
	
	
	// I want the animations to make it look like this is floating stationary.
	// IT can whip out whatever at whatever IDK ill decide when the drawings are done.
	
	
	
	
	
}
