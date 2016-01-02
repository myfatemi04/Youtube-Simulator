package com.mkprog.youtube;

import org.lwjgl.input.Keyboard;

public class KeyboardInput {
	private int key = 0;
	KeyboardInput(int key) {
		this.key = key;
	}
	public void action() {
		
	}
	public boolean KeyPressed() {
		return Keyboard.isKeyDown(key);
	}
	public void update() {
		if (KeyPressed()) {
			action();
		}
	}
}
