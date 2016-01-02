package com.mkprog.youtube;

import java.util.LinkedList;

public class User {
	private final String username;
	
	public User(String username) {
		this.username = username;
	}
	public String getUsername() {
		return this.username;
	}
	public LinkedList<Channel> channels = new LinkedList<Channel>();
	
	public void createNewChannel() {
		
	}
}
