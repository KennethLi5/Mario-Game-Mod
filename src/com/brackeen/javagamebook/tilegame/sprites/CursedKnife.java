package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.codereflection.CodeReflection;
import com.brackeen.javagamebook.graphics.Animation;

public class CursedKnife extends Creature{
	
	/*
	 * The cursed knife class will swap with the cursedAngryKnife class when the player gets within
	 * a range. It will swap back when out of range.
	 */
	
	public float x;
	public float y;
	
	// whether is has been swapped yet
	public boolean swapped = false;
	
	// saving the velocity for when it swaps back
	public float velocity;
	
	// index knife
	public int indexKnife = 0;
	
	// total knives
	public static int totalKnivesNum = 0;
	
	
	
	public CursedKnife(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);
		if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=1)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
		
		indexKnife = totalKnivesNum;
		totalKnivesNum++;
		//identifier = new int[totalKnivesNum];
		this.trackPlayer=false;
		this.flying = true;
		this.setHealth(1);
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
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		//System.out.println(totalElapsedTime);
		if(CodeReflection.isTracing() && SpritesPackageTracingEnabled.getSpritesPackageTracingEnabledInstance().isEnabled()) {
        	if(CodeReflection.getAbstactionLevel()>=2)
        	{//check to make sure it's this level of abstraction
        		e.fillInStackTrace();		
        		CodeReflection.registerMethod(e.getStackTrace()[0].getClassName(),
        								e.getStackTrace()[0].getMethodName());
        	}
    	}
        try {
        	if(Math.abs(Player.x - this.getX()) <= 250 && !swapped) {
    			
    			x = this.getX();
    			y = this.getY();
    			velocity = this.getVelocityX();
    			
    			CursedAngryKnife.teleX[indexKnife] = this.getX();
    			CursedAngryKnife.teleY[indexKnife] = this.getY();
    			//System.out.println(this.getX());
    			this.setX(CursedAngryKnife.startingX[indexKnife]);
    			this.setY(CursedAngryKnife.startingY[indexKnife]);
    			swapped = !swapped;
    		}else if(swapped && CursedAngryKnife.teleX[indexKnife] == CursedAngryKnife.startingX[indexKnife]) {
    			System.out.println("swapping back");
    			this.setX(x);
    			this.setY(y);
    			this.setVelocityX(velocity);
    			swapped = !swapped;
    		}
    		
    		if(swapped) {
    			this.setVelocityX(0f);
    			this.setVelocityY(0f);
    		}
        }catch(Exception e) {
        	System.out.println("Error in update of cursed knife");
        	System.out.println(e);
        	this.setX(x);
        	this.setY(y);
        }
		
		
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

		return isAlive();
		
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
