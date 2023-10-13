package com.gmuguessr.backend;

import java.util.ArrayList;
import com.gmuguessr.backend.Image;

public class ActiveGame {
	private int gameID;
	private ArrayList<User> users;

	public ActiveGame(int id) {
		this.gameID = id;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String displayScore() {
		throw new Exception("Not implemented yet");
	};

	public Image loadImage() {
		throw new Exception("Not implemented yet");
	};

	public void addUser(User user) {
		throw new Exception("Not implemented yet");
	};
}
