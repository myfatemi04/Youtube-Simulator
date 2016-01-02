package com.mkprog.youtube;

import com.mkprog.youtube.Enums.*;

public class Steps {
	public static void buyCamera(Camera camera, GamePlayer player) {
		if (camera.getCost() <= player.money) {
			player.camera = camera;
			player.money -= camera.getCost();
		}
	}
	public static void buyEditingSoftware(EditingSoftware software, GamePlayer player) {
		if (software.getCost() <= player.money) {
			player.currentSoftware = software;
			player.money -= software.getCost();
		}
	}
}
