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
	public Video param;
	public Video getParam() {
		return param;
	}
	public static Button MENUBUTTON = new Button(1110,0,170,100,1,"youtube-play-backwards.png") {
		public void action(int i) {
			YoutubeSimulator.state = GameState.MENU;
		}
	};
	public static Button VIDEOBUTTON = new Button(1110,0,170,100,1,"youtube-play-forwards.png") {
		Video param = YoutubeSimulator.getGamePlayer().user.channels.get(YoutubeSimulator.currentChannelIndex).getVideos().get(YoutubeSimulator.currentVideoIndex);
		public Video getParam() {
			return param;
		}
		public void action(int i) {
			YoutubeSimulator.state = GameState.VIDSTATS;
		}
	};
	public void action(int i) {
		
	}
	double x,y,width,height,s;
	Texture t;
	public Button(double x, double y, double width, double height, double scale, String fsrc) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.s = scale;
		try {
			t = TextureLoader.getTexture("PNG", new FileInputStream(new File(fsrc)));
			t.setTextureFilter(GL_NEAREST);
		} catch (IOException e) {
		
		}
	}
	public void draw(double x, double y, double w, double h, double s) {
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
		while(Mouse.next()) {
			if (((x > this.x && x < this.width + this.x) && (y > this.y && y < this.height + this.y)) && (Mouse.isButtonDown(0))) {
				return true;
			}
		}
		return false;
	}
	public void update(int i) {
		t.bind();
		draw(x, y, width, height, s);
		if (buttonClicked()) {
			action(i);
		}
	}
}
