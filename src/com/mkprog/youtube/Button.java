package com.mkprog.youtube;

import static org.lwjgl.opengl.GL11.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Button {
	public static final float RATIO = 1.7f;
	private static GameState oldGameState;
	private static boolean oldState;
	public static Button uploadButton = new Button(500, 100, 653, 303, "uploadbutton.png") {
		public void action(int i) {
			this.setOldGameState(YoutubeSimulator.state);
			YoutubeSimulator.state = GameState.UPLOAD;
		}
	};
	public static Button backButton = new Button(1110, 0, 170, 100, "youtube-play-backwards.png") {
		public void action(int i) {
			if (YoutubeSimulator.state == GameState.VIDSTATS) {
				YoutubeSimulator.state = GameState.MENU;
				this.setOldGameState(GameState.VIDSTATS);
			} else if (YoutubeSimulator.state == GameState.UPLOAD) {
				YoutubeSimulator.state = this.getOldGameState();
				this.setOldGameState(GameState.UPLOAD);
			}
		}
	};
	public static Button forwardButton = new Button(1110, 0, 170, 100, "youtube-play-forwards.png") {
		public void action(int i) {
			this.setOldGameState(YoutubeSimulator.state);
			YoutubeSimulator.state = GameState.VIDSTATS;
		}
	};
	public void action(int i) {
		
	}
	public double x,y,width,height,s;
	Texture t;
	public Button(double x, double y, double width, double height, String fsrc) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		try {
			t = TextureLoader.getTexture("PNG", new FileInputStream(new File(fsrc)));
			t.setTextureFilter(GL_NEAREST);
		} catch (IOException e) {
		
		}
	}
	public void draw(double x, double y, double w, double h) {
		double fx, fy;
		fx = t.getWidth();
		fy = t.getHeight();
		glBegin(GL_QUADS);
		
		glTexCoord2d(0, 0);
		glVertex2d(x,y);
		
		glTexCoord2d(fx, 0);
		glVertex2d(x + w, y);
		
		glTexCoord2d(fx, fy);
		glVertex2d(x + w, y + h);
		
		glTexCoord2d(0, fy);
		glVertex2d(x, y + h);
		
		glEnd();
	}
	public boolean buttonClicked() {
		int x,y;
		x = Mouse.getX();
		y = 720 - Mouse.getY() - 1;
		if (((x > this.x && x < this.width + this.x) && (y > this.y && y < this.height + this.y)) && (Mouse.isButtonDown(0)) && oldState == false) {
			return true;
		}
		return false;
	}
	public void update(int i) {
		t.bind();
		draw(x, y, width, height);
		if (buttonClicked()) {
			action(i);
		}
		oldState = Mouse.isButtonDown(0);
	}
	public void setOldGameState(GameState newState) {
		oldGameState = newState;
	}
	public GameState getOldGameState() {
		return oldGameState;
	}
}
