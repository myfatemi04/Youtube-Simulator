package com.mkprog.youtube;

import java.util.ArrayList;
import java.util.Random;

public class Youtube {
	Random r = new Random();
	int day = 1;
	ArrayList<Channel> channels = new ArrayList<Channel>();
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Video> top = new ArrayList<Video>();
	ArrayList<Video> videos = new ArrayList<Video>();
	private boolean chance(double n, double d) {
		return r.nextDouble() < (n/d);
	}
	public void tick() {
		try {
			Thread.sleep(3);
		} catch (Exception e) {
			
		}
		for (Video curr : videos) {
			curr.setType(Enums.VideoType.gaming);
			if (chance(curr.viewChance * (curr.getLvratio() + 0.015), 100*(Math.sqrt(curr.viewChance)))) {
				curr.view();
			//	System.out.println("Views : " + curr.getViews());
				if (chance(1,20)) {
					curr.share();
					YoutubeSimulator.gui.sh = true;
				//	System.out.println("Shared!");
				}
				if (chance(1,20)) {
					curr.like();
					
				//	System.out.println("Liked!");
				}
				if (chance(1,75)) {
					curr.getChannel().subscribe();
				//	System.out.println("You have gained a subscriber!");
				}
			}
			
			
		}
		
		
	}
}