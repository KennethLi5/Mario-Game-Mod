package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/*
 * A wizard NPC that is meant to resemble the one and only, Brandon Wetzel.
 */

public class Wizard extends Creature{
	public Wizard(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left, right, deadLeft, deadRight);
		helper = true;
	}
}
