package com.mkprog.youtube;

import java.util.LinkedList;

public class Video {
	private Enums.VideoType vtype = Enums.VideoType.random;
	public double potential = vtype.quality() * YoutubeSimulator.getGamePlayer().standardVideoQuality();
	private double earnings = 0;
	private int id;
	private String title;
	private String desc;
	private double lvratio;
	private long views;
	private int viewsToday = 0;
	private int likes;
	public int viewChance = 1;
	public int time = 0;
	private double commentFeedback;
	private boolean ads = true;
	double popularity = 0;
	private Channel channel;
	int shares = 0;
	private LinkedList<Integer> viewsPerDay = new LinkedList<Integer>();
	public void share() {
		viewChance += 0.005;
		shares++;
	}
	public void setType(Enums.VideoType vtype) {
		this.vtype = vtype;
		potential = vtype.quality() * YoutubeSimulator.getGamePlayer().standardVideoQuality();
	}
	public void like() {
		likes++;
	}
	public double getPotential() {
		return potential;
	}
	public double getEarnings() {
		return earnings;
	}
	public void dayComplete() {
		views += viewsToday;
		viewsPerDay.addFirst(viewsToday);
		if (ads) {
			earnings += viewsToday/1000;
		}
		viewsToday = 0;
		
	}
	public int getId() {
		return id;
	}
	public double getLvratio() {
		return lvratio;
	}
	public int getViewsToday() {
		return viewsToday;
	}
	public boolean usesAds() {
		return ads;
	}
	public Channel getChannel() {
		return channel;
	}
	public LinkedList<Integer> getViewsPerDay() {
		return viewsPerDay;
	}
	public long recentViews() {
		int check = 30;
		long recent = 0;
		if (viewsPerDay.size() < 30) {
			check = viewsPerDay.size();
		}
		for (int i = 0; i < check; i++) {
			recent += viewsPerDay.get(i);
		}
		return recent;
	}
	public void upload(Channel channel) {
		YoutubeSimulator.getGamePlayer().user.channels.get(YoutubeSimulator.getGamePlayer().user.channels.indexOf(channel)).upload(this);
	}
	public void monetize() {
		ads = true;
	}
	public void view() {
		views++;
		viewsToday++;
		this.earnings += 0.001;
		YoutubeSimulator.getGamePlayer().money+=0.001;
	}
	public void addViews(int views) {
		viewsToday += views;
		YoutubeSimulator.getGamePlayer().giveMoney(views/1000);
	}
	
	public void syncLVRatio() {
		lvratio = likes/(Math.sqrt(views));
	}
	public Video(String name, String desc, Channel channel, Enums.VideoType vtype) {
		this.title = name;
		this.desc = desc;
		this.channel = channel;
		this.vtype = vtype;
		this.potential = vtype.quality() * YoutubeSimulator.getGamePlayer().standardVideoQuality();
		viewChance += potential/2;
	}
	
	public String getTitle() {
		return title;
	}
	public String getDesc() {
		return desc;
	}
	public double getScore() {
		return lvratio;
	}
	public long getViews() {
		return views;
	}
	public int getLikes() {
		return likes;
	}
	public double getCommentFeedback() {
		return commentFeedback;
	}
}
