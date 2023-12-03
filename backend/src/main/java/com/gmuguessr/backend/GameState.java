package com.gmuguessr.backend;

/**
 * Enum class meant to signify the current state of the game.
 */
public enum GameState {
	
	/**
	 * Game is in a starting state ready to begin.
	 */
	READY, 
	
	/**
	 * Game is currently running.
	 */
	RUNNING, 
	
	/**
	 * Game has ended.
	 */
	ENDED;
}