package com.mkprog.youtube;

import java.util.LinkedList;

public class Channel {
	private String name = "cooljohn";
	
	private User user;
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
		for (Video v : videos) {
			v.potential += 2.5/v.potential;
		}
	}
}
