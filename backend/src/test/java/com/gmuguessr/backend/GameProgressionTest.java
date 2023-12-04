package com.gmuguessr.backend;

import com.gmuguessr.backend.ActiveGame;
import com.gmuguessr.backend.GameDifficulty;
import com.gmuguessr.backend.GameManager;
import com.gmuguessr.backend.User;
import com.gmuguessr.backend.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameProgressionTest {

    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        // Initialize or inject the GameManager before each test
        gameManager = new GameManager();
    }

    @Test
    void testGameProgression() {
        // Test the progression of a game

        // Create a user for testing
        User user = new User("Alice", UserType.newOnCampusStudent, 1);
        User user2 = new User("Bob", UserType.newOnCampusStudent, 2);
        User user3 = new User("Mike", UserType.newOnCampusStudent, 3);

        // Create new games
        int gameId = gameManager.createNewGame(GameDifficulty.EASY, user);
        int gameId2 = gameManager.createNewGame(GameDifficulty.MEDIUM, user2);
        int gameId3 = gameManager.createNewGame(GameDifficulty.HARD, user3);

        // Get the active games
        ActiveGame activeGame = gameManager.getActiveGame(gameId);
        ActiveGame activeGame2 = gameManager.getActiveGame(gameId2);
        ActiveGame activeGame3 = gameManager.getActiveGame(gameId3);

        // Check the initial states of the games
        assertEquals(GameState.READY, activeGame.getGameState(), "Initial state should be READY");
        assertEquals(GameState.READY, activeGame2.getGameState(), "Initial state should be READY");
        assertEquals(GameState.READY, activeGame3.getGameState(), "Initial state should be READY");
        
        //Set other 2 games into different states to test error detection.
        activeGame2.setGameState(GameState.RUNNING);
        activeGame3.setGameState(GameState.ENDED);

        // Try to start the games
        try {
			activeGame.startGame();
			activeGame2.startGame();
		} 
        
        catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
        try {
        	activeGame3.startGame();
        }
        
        catch (Exception e) {
        	System.out.println(e.getMessage());
        }

        // Check if the game state is now RUNNING
        assertEquals(GameState.RUNNING, activeGame.getGameState(), "Game should be in RUNNING state");

        // Simulate playing the game
        // ...
        
        // Set game 2 to READY to check error detection.
        activeGame2.setGameState(GameState.READY);

        // Finish the games
        try {
			activeGame.endGame();
			activeGame2.endGame();
		} 
        
        catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println(e.getMessage());
		}
        
        try {
        	activeGame3.endGame();
        }
        
        catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println(e.getMessage());
		}

        // Check if the game state is now ENDED
        assertEquals(GameState.ENDED, activeGame.getGameState(), "Game should be in ENDED state");
    }
}
