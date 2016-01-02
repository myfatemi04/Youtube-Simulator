package com.mkprog.youtube;

import java.util.Random;

public class Enums {
	public enum Camera {
		camcorder(1,0), phone(3,300), video_camera(4,200), hd_video_camera(6,400), gopro(10,500), movie_camera(15,1000);
		private double quality;
		private double cost;
		private Camera(double quality, double cost) {
			this.quality = quality;
			this.cost = cost;
		}
		double getQuality() {
			return quality;
		}
		double getCost() {
			return cost;
		}
	}
	public enum EditingSoftware {
		raw_video(0.5, 0), movie_maker(3, 15), imovie(4, 50), final_cut(8, 300), adobe_premiere(9, 400), sony_vegas(11, 800);
		private double quality;
		private double cost;
		private EditingSoftware(double quality, double cost) {
			this.quality = quality;
			this.cost = cost;
		}
		double getQuality() {
			return quality;
		}
		double getCost() {
			return cost;
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
