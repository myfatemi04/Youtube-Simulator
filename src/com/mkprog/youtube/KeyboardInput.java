package com.mkprog.youtube;

import org.lwjgl.input.Keyboard;

public class KeyboardInput {
	private boolean oldState;
	private int key = 0;
	KeyboardInput(int key) {
		this.key = key;
	}
	public void action() {
		
	}
	public boolean KeyPressed() {
		if (oldState == false && Keyboard.isKeyDown(key) == true) {
			return true;
		}
		return false;
	}
	public void update() {
		if (KeyPressed()) {
			action();
		}
		oldState = Keyboard.isKeyDown(key);
	}
}
