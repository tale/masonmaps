package com.gmuguessr.backend;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class focuses on controlling aspects of a newly created game started by
 * the player.
 * This includes what images will be used, the game's ID and score, and what
 * state the
 * game is currently running in.
 */
public class ActiveGame implements Comparable<ActiveGame> {

	private ArrayList<Image> imgs;
	private int gameID;
	private GameState state;
	private int score;
	private ArrayList<User> users;
	private GameDifficulty setting;
	private Iterator<Image> iter;

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
		this.setting = GameDifficulty.EASY;
		this.iter = imgs.listIterator();
	}
	
	/**
	 * Alternate constructor, sets id to the unique id of the user and allows 
	 * for modification of the game's difficulty directly.
	 * 
	 * @param setting - The difficulty to set the game to.
	 * @param user - The first user to add and use for the game's ID.
	 */
	public ActiveGame(GameDifficulty setting, User user) {
		this(user.getUserID());
		this.users.add(user);
		this.setting = setting;
		this.iter = imgs.listIterator();
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
		this.resetIter();
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
	 * @param guess - Distance structure representing a user's guess in the system.
	 */
	public void calculateScore(Distance guess, int difficulty) {
		double dis = guess.getDistance();
		int result = 0;

		if (difficulty == 1) { // Difficulty: Easy
			if (dis <= 0.1) {
				result = 10; // Highest score for extremely close guesses
			} else if (dis <= 0.5) {
				result = 7; // High score for close guesses
			} else if (dis <= 0.75) {
				result = 5; // Medium score for somewhat close guesses
			} else if (dis <= 1.5) {
				result = 3; // Low-medium score for moderately close guesses
			} else if (dis <= 3) {
				result = 1; // Lower score for distances between 1.5 and 3
			}
		} else if (difficulty == 2) { // Difficulty: Medium
			if (dis <= 0.05) {
				result = 10; // Highest score for extremely close guesses
			} else if (dis <= 0.1) {
				result = 9; // Very high score for very close guesses
			} else if (dis <= 0.2) {
				result = 7; // High score for close guesses
			} else if (dis <= 0.5) {
				result = 5; // Medium-high score for somewhat close guesses
			} else if (dis <= 1) {
				result = 3; // Medium score for moderately close guesses
			} else if (dis <= 2) {
				result = 1; // Lower score for distances between 1 and 2
			}
		} else { // Difficulty: Hard
			if (dis <= 0.02) {
				result = 10; // Highest score for extremely close guesses
			} else if (dis <= 0.05) {
				result = 9; // Very high score for very close guesses
			} else if (dis <= 0.1) {
				result = 7; // High score for close guesses
			} else if (dis <= 0.25) {
				result = 5; // Medium-high score for somewhat close guesses
			} else if (dis <= 0.5) {
				result = 3; // Medium score for moderately close guesses
			} else if (dis <= 1) {
				result = 1; // Lower score for distances between 0.5 and 1
			}
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
	 * @throws Exception Thrown if the iterator reached the end or the list is empty.
	 */
	public Image loadImage() throws Exception  {
		
		if (iter.hasNext() == false) {
			this.resetIter();
			throw new Exception("No other elements present.");
		}
		
		else {
			return iter.next();
		}
		
	}
	
	/**
	 * Resets list iterator back to its original state.
	 */
	public void resetIter() {
		this.iter = imgs.listIterator();
	};

	/**
	 * Adds a new user to the game.
	 * 
	 * @param user - New user to be added to the game.
	 */
	public void addUser(User user) {
		users.add(user);
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
	
	public User getUser(int index) {
		return users.get(index);
	}
	
	/**
	 * @param game - Current ActiveGame instance to be examined.
	 * @return Difficulty of the ActiveGame.
	 */
	public GameDifficulty getDifficulty() {
		return setting;
	}

	/**
	 * Sets the ActiveGame instance's difficulty to Easy, Medium, or Hard.
	 * @param string - The new difficulty to be set.
	 */
	public void setDifficulty(GameDifficulty diff) {
		this.setting = diff;
	}

	/**
	 * Starts an active game by modifying its state from READY to RUNNING.
	 * @throws Exception - Thrown if game has ended or is running.
	 */
	public void startGame() throws Exception {
		
		if(this.state == GameState.RUNNING) {
			throw new Exception("Error - Game is already running");
		}
		
		else if (this.state == GameState.ENDED) {
			throw new Exception("Error - Game has already ended");
		}
		
		this.setGameState(GameState.RUNNING);
		
	}

	/**
	 * Ends an active game by modifying its state from RUNNING to ENDED.
	 * @throws Exception - Thrown if game has ended or hasn't begun.
	 */
	public void endGame() throws Exception {
		
		if(this.state == GameState.READY) {
			throw new Exception("Error - Game has not been started");
		}
		
		else if (this.state == GameState.ENDED) {
			throw new Exception("Error - Game has already ended");
		}
		
		this.setGameState(GameState.ENDED);
		
	}

	/**
	 * Increases the score based on parameters.
	 * 
	 * @param i - Value to be added to the score.
	 */
	public void increaseScore(int i) {
		this.score += i;
	}

	/**
	 * Compares with another instance and returns an integer value based on 
	 * comparing their scores.
	 * 
	 * @param o - Other ActiveGame Instance
	 * @return 0 if scores are equal, 1 if this has a greater score, -1 otherwise.
	 */
	@Override
	public int compareTo(ActiveGame o) {
		
		return (this.score - o.score);
	}
}