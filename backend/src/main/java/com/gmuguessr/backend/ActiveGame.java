package com.gmuguessr.backend;

import java.util.ArrayList;
import com.gmuguessr.backend.User;

/**
 * This class focuses on controlling aspects of a newly created game started by
 * the player.
 * This includes what images will be used, the game's ID and score, and what
 * state the
 * game is currently running in.
 */
public class ActiveGame {

	private ArrayList<Image> imgs;
	private int gameID;
	private GameState state;
	private int score;
	private ArrayList<User> users;

	/**
	 * Main constructor, sets all other fields to default values.
	 * 
	 * @param id - The ID indicator of the currently running game.
	 */
	public ActiveGame(int id) {
		this.gameID = id;
		this.imgs = new ArrayList<>();
		this.state = GameState.READY;
		this.score = 0;
		this.users = new ArrayList<>();
	}

	/**
	 * Indicates the ID of the current game created.
	 * 
	 * @return ID of the created game.
	 */
	public int getGameID() {
		return gameID;
	}

	/**
	 * Sets the ID of the game to a new value.
	 * 
	 * @param gameID - New value to overwrite the game ID.
	 */
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	/**
	 * Indicates the Image objects used for the current game.
	 * 
	 * @return Array of images used for the game.
	 */
	public ArrayList<Image> getImages() {
		return imgs;
	}

	/**
	 * Adds a new image for the ActiveGame structure to use.
	 * 
	 * @param toAdd - New Image object to added to the game.
	 */
	public void addImage(Image toAdd) {
		imgs.add(toAdd);
	}

	/**
	 * Shows the current state of the game at the current moment.
	 * 
	 * @return Current state of the game.
	 */
	public GameState getGameState() {
		return state;
	}

	/**
	 * Sets the game into one of the three states.
	 * 
	 * @param state - Current state of the created game.
	 */
	public void setGameState(GameState state) {
		this.state = state;
	}

	/**
	 * Calculates a score value based on the distance of the user's guess.
	 * 
	 * @param guess - Distance structure representing a users guess in the system.
	 */
	public void calculateScore(Distance guess) {
		double dis = (guess.getDistance());
		int result = 0;

		if ((dis >= 1) && (dis <= 2)) {
			result = 2;
		}

		else if (dis < 1) {
			result = 5;
		}

		score += result;
	}

	/**
	 * Returns the current score value recorded in this game.
	 * 
	 * @return Value of the score obtained during this game.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Displays the current scores of all players in the game.
	 * 
	 * @return String representation of the current scores of all players.
	 */
	public String displayScore() {
		StringBuilder sb = new StringBuilder();

		for (User user : users) {
			sb.append(user.getName() + ": " + score + "\n");
		}

		return sb.toString();
	};

	/**
	 * Gets the next image for active game.
	 * 
	 * @return Gets image for specific game.
	 * @throws Exception (Not implemented yet)
	 */
	public Image loadImage() throws Exception {
		throw new Exception("Not implemented yet");
	};

	/**
	 * Adds a new user to the game.
	 * 
	 * @param user - New user to be added to the game.
	 */
	public void addUser(User user) {
;
		arrayUsers.add(user);
	};

	/**
	 * Returns the current users in the game.
	 * 
	 * @return Array of users in the game.
	 */
	public User[] getCurrentUsers() {
		User[] userArray = new User[users.size()];
		userArray = users.toArray(userArray);
		return userArray;
	};
	/**
	 * @param game
	 * @return Diffuclty of a given game 
	 */
	public ActiveGame getDifficutlty(ActiveGame game){

		return game.getDifficutlty();

	}
}
