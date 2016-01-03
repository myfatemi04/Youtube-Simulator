package com.mkprog.youtube;

import java.util.LinkedList;

public class Playlist {
	private String name;
	LinkedList<Video> videos = new LinkedList<Video>();
	@SuppressWarnings("unchecked")
	public LinkedList<Video> getVideos() {
		return (LinkedList<Video>)videos.clone();
	}
	public Playlist(LinkedList<Video> videos, String name) {
		this.videos = videos;
		this.name = name;
	}
	public void addVideo(Video video) {
		videos.addLast(video);
		video.addToPlaylist(this);
	}
	public void removeVideo(Video video) {
		videos.remove(video);
		video.removeFromPlaylist(this);
	}
	public String getName() {
		return name;
	}
}
