import java.util.ArrayList;

/**
 * This class focuses on controlling aspects of a newly created game started by the player.
 * This includes what images will be used, the game's ID and score, and what state the 
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
	 * @return ID of the created game.
	 */
	public int getGameID() {
		return gameID;
	}

	/**
	 * Sets the ID of the game to a new value.
	 * @param gameID - New value to overwrite the game ID.
	 */
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	
	/**
	 * Indicates the Image objects used for the current game.
	 * @return Array of images used for the game.
	 */
	public ArrayList<Image> getImages() {
		return imgs;
	}
	
	/**
	 * Adds a new image for the ActiveGame structure to use.
	 * @param toAdd - New Image object to added to the game.
	 */
	public void addImage(Image toAdd) {
		imgs.add(toAdd);
	}

	/**
	 * Shows the current state of the game at the current moment.
	 * @return Current state of the game.
	 */
	public GameState getGameState() {
		return state;
	}

	/**
	 * Sets the game into one of the three states.
	 * @param state - Current state of the created game.
	 */
	public void setGameState(GameState state) {
		this.state = state;
	}
	
	/**
	 * Calculates a score value based on the distance of the user's guess.
	 * @param guess - Distance structure representing a users guess in the system.
	 */
	public void calculateScore(Distance guess) {
		double dis = (guess.getDistance());
		int result = 0;
		
		if ( (dis >= 1) && (dis <= 2) ) {
			result = 2;
		}
		
		else if (dis < 1) {
			result = 5;
		}
		
		score += result;
	}

	/**
	 * Returns the current score value recorded in this game.
	 * @return Value of the score obtained during this game.
	 */
	public int getScore() {
		return score;
	}
	
	public String displayScore() throws Exception {
		throw new Exception("Not implemented yet");
	};

	public Image loadImage() throws Exception {
		throw new Exception("Not implemented yet");
	};

	public void addUser(User user) throws Exception {
		throw new Exception("Not implemented yet");
	};
	
}
