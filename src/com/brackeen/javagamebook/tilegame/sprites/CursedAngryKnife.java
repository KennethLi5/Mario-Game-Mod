package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class CursedAngryKnife extends Creature{
	
	/*
	 * The cursed angry knife class is used to give the appearance of the knife sprite changing its animation
	 * when the player comes into range. It will switch the location values with the CursedKnife class. 
	 * When out of range, the angry sword will go back to the x value that it teleported to, then will switch again.
	 * This is different than the Angry Sword class because it only has one health.
	 */
	
	// static array of the initial x values
	public static float startingX[];
	public static float startingY[];
	
	// static array of the x values to teleport to
	public static float teleX[];
	public static float teleY[];
	
	// index in the array
	public int knivesCount = 0;
	
	// total knives
	public static int totalKnivesCount = 0;
	
	// first update and whether is swapped yet.
	private boolean firstUpdate = true;
	private boolean swapped = false;
	
	public CursedAngryKnife(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);

		flying = true;
		
		knivesCount = totalKnivesCount;
		totalKnivesCount++;
		float tempStartingX[] = new float[totalKnivesCount];
		float tempStartingY[] = new float[totalKnivesCount];
		float tempTeleX[] = new float[totalKnivesCount];
		float tempTeleY[] = new float[totalKnivesCount];
		
		for(int i = 0; i < knivesCount; i++) {
			
			tempStartingX[i] = startingX[i];
			tempStartingY[i] = startingY[i];
			tempTeleX[i] = tempTeleX[i];
			tempTeleY[i] = tempTeleY[i];
			
		}
		
		startingX = tempStartingX;
		startingY = tempStartingY;
		teleX = tempTeleX;
		teleY = tempTeleY;
		
		
		
	}
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		
		if(firstUpdate) {
			startingX[knivesCount] = teleX[knivesCount] = this.getX();
			startingY[knivesCount] = teleY[knivesCount] = this.getY();
			firstUpdate = false;
			//System.out.println("first update + " + startingX + " " +  teleX);
		}else
		
		if(teleX[knivesCount] != this.getX() && !swapped) {		
			this.setX(teleX[knivesCount]);
			this.setY(teleY[knivesCount]);
			swapped = true;
		}else 
		if(Math.abs(Player.x - this.getX()) >= 250 && swapped) {
			if(teleX[knivesCount] - this.getX() > 0 ) {
				//System.out.println("working");
				this.trackPlayer = false;
				setVelocityX(.05f * enemySpeedMultiplier);
				this.setVelocityY(0f);
			}
			else if (teleX[knivesCount] - this.getX() < 0){
				//System.out.println("working");
				setVelocityX(-.05f * enemySpeedMultiplier);
				this.trackPlayer = false;
				this.setVelocityY(0f);
			}
			
			if(Math.abs(teleX[knivesCount] - this.getX()) < .2f) {
				//System.out.println("wokring 2");
				this.setVelocityX(0f);
				this.setX(startingX[knivesCount]);
				this.setY(startingY[knivesCount]);
				teleX[knivesCount] = startingX[knivesCount];
				teleY[knivesCount] = startingY[knivesCount];
				swapped = false;
			}
		}else
		if(Math.abs(Player.x - this.getX()) <= 250 && swapped) {
			this.trackPlayer = true;
			this.setVelocityX(getMaxSpeed());
			
			if(Player.y - this.getY() > 0) {
				this.setVelocityY(.05f);
			}else if(Player.y - this.getY() < 0) {
				this.setVelocityY(-.05f);
			}
			
		}
		
	}
	
	public float getMaxSpeed() {
		return .4f * enemySpeedMultiplier;
	}
	
	public boolean isFlying() {
		return isAlive();
	}
	
}
