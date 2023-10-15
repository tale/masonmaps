package com.gmuguessr.backend;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.gmuguessr.backend.User;

/**
 * The Game Manager class manages the creation and control game.
 */
public class GameManager {
	private List<ActiveGame> activeGames;
	private Map<ActiveGame, Integer> scoresMap;

	public GameManager() {
		activeGames = new ArrayList<>();
		scoresMap = new HashMap<>();
	}

	// Defines the diffculty levels of an active game.
	private enum Difficulty {
		EASY,
		MEDIUM,
		HARD
	}

	/**
	 * Creates a new game.
	 * 
	 * @param difficulty The games diffiutly level (easy,medium,hard).
	 * @param newUserId  Unique id for user associated with a new game.
	 * @return A unique id for new game.
	 */
	public int createNewGame(Difficulty difficulty, User newUserId) {
		// New instance of ActiveGame
		ActiveGame newGame = new ActiveGame(difficulty, newUserId);

		// Add game to list of active games
		activeGames.add(newGame);

		// Create a game with initial score of 0
		scoresMap.put(newGame, 0);

		return newGame.getGameId();
	}

	/**
	 * Gets the active game based on given game id.
	 *
	 * @param gameId Unique id for game.
	 * @return ActiveGame object.
	 */
	public ActiveGame getActiveGame(int gameId) {
		for (ActiveGame game : activeGames) {
			if (game.getGameId() == gameId) {
				return game;
			}
		}

		return null; // Not found
	}

	/**
	 * Gets the map coordinates based on given latitude and longitude
	 * 
	 * @param latitude  Latitude of chosen location.
	 * @param longitude Longitude of chosen location.
	 * @return LocationEntry representing the coordinates.
	 */
	public GeoCoordinates getMapCoordinates(int latitude, int longitude) {
		return new GeoCoordinates(latitude, longitude);
	}

	/**
	 * Gets the next image for active game.
	 * 
	 * @param gameId Identifies active game to get Image.
	 * @return Gets image for specific game.
	 */
	public Image getNextImage(int gameId) {
		ActiveGame game = getActiveGame(gameId);
		if (game.isValid()) {
			return game.loadImage();
		}

		return null; // Not found
	}

	/**
	 * Gets list of current active games.
	 * 
	 * @return List of active games.
	 */
	public List<ActiveGame> getActiveGames() {
		return activeGames;
	}

	/**
	 * Gets the scoreboards for different games.
	 * 
	 * @return List of scores from current active games.
	 */
	public Map<ActiveGame, Integer> getAllScoreBoards() {
		for (ActiveGame game : activeGames) {
			scoresMap.put(game, game.calculateScore());
		}

		return scoresMap;
	}
}
