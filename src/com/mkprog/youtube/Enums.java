package com.mkprog.youtube;

import java.util.Random;

public class Enums {
	public enum Camera {
		camcorder(1,0), phone(3,300), video_camera(4,200), hd_video_camera(6,400), gopro(10,500), movie_camera(15,1000);
		private double quality;
		private Camera(double quality, double cost) {
			this.quality = quality;
		}
		double getQuality() {
			return quality;
		}
	}
	public enum EditingSoftware {
		movie_maker(3), sony_vegas(3), adobe_premiere(10);
		private double quality;
		private EditingSoftware(double quality) {
			this.quality = quality;
		}
		double getQuality() {
			return quality;
		}
	}
	public enum VideoType {
		
		education(7),music(10),comedy(13),adventure(12),list(10),hobby(10),random(10),gaming(15),vlogs(14);
		private int quality = 0;
		VideoType(int quality) {
			this.quality = quality;
		}
		int quality() {
			return new Random().nextInt(quality - 5) + 5;
		}
	}
}
