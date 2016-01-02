package com.mkprog.youtube;

import java.util.LinkedList;

public class Channel {
	private String name = "cooljohn";
	
	private User user;
	private int subs = 0;
	private LinkedList<Playlist> playlists = new LinkedList<Playlist>();
//	private String url = "http://goo.gl/NLDnhk";
	private LinkedList<Video> videos = new LinkedList<Video>();
	public LinkedList<Video> getVideos() {
		return videos;
	}
	public LinkedList<Playlist> getPlaylists() {
		return playlists;
	}
	public String getChannelName() {
		return name;
	}
	public Channel(String name, User user) {
		this.name = name;
		this.user = user;
	}
	public User head() {
		return user;
	}
	public void subscribe() {
		subs++;
		for (Video v : videos) {
			v.potential += 2.5/v.potential;
		}
	}
	public int getSubs() {
		return subs;
	}
	public void upload(Video video) {
		videos.add(video);
	}
}
