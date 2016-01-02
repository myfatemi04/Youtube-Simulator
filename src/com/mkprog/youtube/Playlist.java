package com.mkprog.youtube;

import java.util.LinkedList;

public class Playlist {
	LinkedList<Video> videos = new LinkedList<Video>();
	@SuppressWarnings("unchecked")
	public LinkedList<Video> getVideos() {
		return (LinkedList<Video>)videos.clone();
	}
	public Playlist(LinkedList<Video> videos) {
		this.videos = videos;
	}
	public void addVideo(Video video) {
		videos.addLast(video);
	}
	public void removeVideo(Video video) {
		videos.remove(video);
	}
}
