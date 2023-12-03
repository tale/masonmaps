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

        // Create a new game
        int gameId = gameManager.createNewGame(GameDifficulty.EASY, user);

        // Get the active game
        ActiveGame activeGame = gameManager.getActiveGame(gameId);

        // Check the initial state of the game
        assertEquals(GameState.READY, activeGame.getGameState(), "Initial state should be READY");

        // Start the game
        activeGame.startGame();

        // Check if the game state is now RUNNING
        assertEquals(GameState.RUNNING, activeGame.getGameState(), "Game should be in RUNNING state");

        // Simulate playing the game
        // ...

        // Finish the game
        activeGame.endGame();

        // Check if the game state is now ENDED
        assertEquals(GameState.ENDED, activeGame.getGameState(), "Game should be in ENDED state");
    }
}

