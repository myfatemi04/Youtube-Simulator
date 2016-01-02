package com.mkprog.youtube;

import static org.lwjgl.opengl.GL11.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.opengl.TextureImpl;

public class GUI extends Thread {
	
	DecimalFormat format = new DecimalFormat("0.00");
	UnicodeFont uf = null;
	boolean fading = false;
	boolean sh = false;
	float fade = 0;
	public void run() {
		format.setRoundingMode(RoundingMode.HALF_UP);
		setup();
		while(!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT);
			glColor4f(1,1,1,0);
			if (YoutubeSimulator.state == GameState.VIDSTATS)
				videoScreen((Video)Button.VIDEOBUTTON.getParam());
			else if (YoutubeSimulator.state == GameState.MENU) {
				menu();
			}
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		System.exit(0);
	}
	TrueTypeFont ttf;
	public void menu() {
		glClear(GL_COLOR_BUFFER_BIT);
		
		Button.VIDEOBUTTON.update(0);
	}
	public void setup() {
		try {
			Display.setDisplayMode(new DisplayMode(1280,720));
			Display.setTitle("Youtube Simulator");
			Display.setResizable(false);
			Display.create();
		} catch (LWJGLException e) {
			System.err.println("Error while creating display.");
		}
		
		glMatrixMode(GL_PROJECTION);
		glEnable(GL_TEXTURE_2D);
		glLoadIdentity();
		glOrtho(0, 1280, 720, 0, 1, -1);
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
		glMatrixMode(GL_MODELVIEW);
		
		try {
			uf = new UnicodeFont("ps2p.ttf",20,false,false);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	public double ddiv(int a, int b) {
		return ((double)a) / b;
	}
	public float fdiv(int a, int b) {
		return ((float)a) / b;
	}
	public float col(float a) {
		return a/256;
	}
	@SuppressWarnings("unchecked")
	public void videoScreen(Video video) {
		glClearColor(col(210),col(33),col(33),0);
		
		
		try {
			uf.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
			uf.addAsciiGlyphs();
			uf.loadGlyphs();
		} catch (SlickException e) {
			
		}
		if (sh) {
			fading = true;
			sh = false;
		}
		glEnable(GL_TEXTURE_2D);
		glColor3f(1,1,1);
 		glClear(GL_COLOR_BUFFER_BIT);
 		/**
 		 * BUTTON UPDATES GO HERE
 		 */
 		Button.MENUBUTTON.update(0);
 		
 		/**
 		 * FONTS GO HERE
 		 * 
 		 */
		glEnable(GL_BLEND);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			uf.drawString(10, 10, "CHANNEL : " + YoutubeSimulator.getGamePlayer().user.channels.get(YoutubeSimulator.currentChannelIndex).getChannelName());
			uf.drawString(10, 40, "VIDEO : " + YoutubeSimulator.getGamePlayer().user.channels.get(YoutubeSimulator.currentChannelIndex).getVideos().get(YoutubeSimulator.currentVideoIndex).getTitle());
			uf.drawString(10, 70, "VIEWS    : " + YoutubeSimulator.getGamePlayer().user.channels.get(YoutubeSimulator.currentChannelIndex).getVideos().get(YoutubeSimulator.currentVideoIndex).getViews());
			uf.drawString(10, 100, "DAY      : " + YoutubeSimulator.y.day);
			uf.drawString(10, 130, "EARNINGS : $" + format.format(video.getEarnings()));
			uf.drawString(10, 160, "SHARES : " + video.shares);
			uf.drawString(10, 190, "LIKES : " + video.getLikes());
			uf.drawString(10, 220, "SUBSCRIBERS : " + YoutubeSimulator.getGamePlayer().user.channels.get(0).getSubs());
			if (fading) {
				uf.drawString(10, 250, "Shared!");
				glColor4f(col(210),col(33),col(33),col(fade));
				TextureImpl.bindNone();
				glRectd(10,250,10 + uf.getWidth("Shared!"), 250 + uf.getLineHeight());
				if (fade < 256) {
					fade+=((float)256)/50;
				} else {
					fade = 0;
					fading = false;
				}
			}
		glDisable(GL_BLEND);
		
		
	}
}
