package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.codereflection.*;

/**
    The Player.
*/
public class Player extends Creature {
	
//    private Throwable e = new Throwable();
	
	// only one player character, static don't matter
    public static float x;
    public static float y;
	public static boolean direction;
    
	public int consecutiveHits=0;
	
	public static float playerJumpSpeedMultiplier = 1.0f;
	
    public Player(Animation left, Animation right,
        Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=1)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
    	
    	//System.out.println("player constructor");
    	
    	
    	
    }

    public void jump(boolean forceJump) {
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=3)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
        if ((onGround || forceJump) && isAlive()) {
            onGround = false;
            setVelocityY(jumpSpeed * playerJumpSpeedMultiplier);
        }
    }

    public void collideHorizontal() {
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=3)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
        setVelocityX(0);
    }




    public void wakeUp() {
    	if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=3)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
    	//Elemental.numOfElementals = 0;
    }

    public void update(long elapsedTime) {
    	super.update(elapsedTime);
    	
    	x = this.getX();
    	y = this.getY();
    	
    	if(this.getVelocityX() > 0) {
    		direction = true;
    	}else if(this.getVelocityX() < 0){
    		direction = false;
    	}
    	
    	
    }

    public void setState(int state) {
    	super.setState(state);
    	
    	Elemental.numOfElementals = 0;
    	
    }
    
    
    public float getMaxSpeed() {
        return 0.5f;
    }

}
