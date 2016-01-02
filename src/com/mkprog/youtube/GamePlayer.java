package com.mkprog.youtube;

import static com.mkprog.youtube.Enums.*;

public class GamePlayer {
	public int exp = 1;
	public final String username;
	public double money = 1000;
	public Camera camera = Camera.camcorder;
	public EditingSoftware currentSoftware = EditingSoftware.movie_maker;
	public final User user;
	public double standardVideoQuality() {
		return camera.getQuality() * currentSoftware.getQuality();
	}
	public void giveMoney(double m) {
		this.money += m;
	}
	public GamePlayer(String username) {
		this.username = username;
		user = new User(username);
	}
	
}