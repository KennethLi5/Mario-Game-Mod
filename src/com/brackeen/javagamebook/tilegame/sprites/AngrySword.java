package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

public class AngrySword extends Creature{
	
	/*
	 * The angry sword class is used to give the appearance of the sword sprite changing its animation
	 * when the player comes into range. It will switch the location values with the sword class. 
	 * When out of range, the angry sword will go back to the x value that it teleported to, then will switch again.
	 * This is different than the CursedAngryKnife class because it has more health slightly.
	 */
	
	// static array of the initial x values
	public static float startingX[];
	public static float startingY[];
	
	// static array of the x values to teleport to
	public static float teleX[];
	public static float teleY[];
	
	
	// index in the array
	public int indexSword = 0;
	
	// total swords
	public static int totalSwords = 0;
	
	// first update and whether is swapped yet.
	private boolean firstUpdate = true;
	private boolean swapped = false;
	
	public AngrySword(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left,right,deadLeft,deadRight);

		// setting health
		this.setHealth(3);
		
		flying = true;
		
		indexSword = totalSwords;
		totalSwords++;
		float tempStartingX[] = new float[totalSwords];
		float tempStartingY[] = new float[totalSwords];
		float tempTeleX[] = new float[totalSwords];
		float tempTeleY[] = new float[totalSwords];
		
		for(int i = 0; i < indexSword; i++) {
			
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
			startingX[indexSword] = teleX[indexSword] = this.getX();
			startingY[indexSword] = teleY[indexSword] = this.getY();
			firstUpdate = false;
			//System.out.println("first update + " + startingX + " " +  teleX);
		}else
		
		if(teleX[indexSword] != this.getX() && !swapped) {		
			this.setX(teleX[indexSword]);
			this.setY(teleY[indexSword]);
			swapped = true;
		}else 
		if(Math.abs(Player.x - this.getX()) >= 250 && swapped) {
			if(teleX[indexSword] - this.getX() > 0 ) {
				//System.out.println("working");
				this.trackPlayer = false;
				setVelocityX(.05f * enemySpeedMultiplier);
				this.setVelocityY(0f);
			}
			else if (teleX[indexSword] - this.getX() < 0){
				//System.out.println("working");
				setVelocityX(-.05f * enemySpeedMultiplier);
				this.trackPlayer = false;
				this.setVelocityY(0f);
			}
			
			if(Math.abs(teleX[indexSword] - this.getX()) < .2f) {
				//System.out.println("wokring 2");
				this.setVelocityX(0f);
				this.setX(startingX[indexSword]);
				this.setY(startingY[indexSword]);
				teleX[indexSword] = startingX[indexSword];
				teleY[indexSword] = startingY[indexSword];
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