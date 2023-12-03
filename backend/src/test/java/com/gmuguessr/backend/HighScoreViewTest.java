package com.gmuguessr.backend;

import com.gmuguessr.backend.GameDifficulty;
import com.gmuguessr.backend.GameManager;
import com.gmuguessr.backend.User;
import com.gmuguessr.backend.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighScoreViewTest {

    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        // Initialize or inject the GameManager before each test
        gameManager = new GameManager();
    }

    @Test
    void testViewHighScore() {
        // Test the "view high score" feature

        // Create users for testing
        User user1 = new User("Alice", UserType.newOnCampusStudent, 1);
        User user2 = new User("Bob", UserType.newOffCampusStudent, 2);

        // Create new games with different scores
        int gameId1 = gameManager.createNewGame(GameDifficulty.EASY, user1);
        int gameId2 = gameManager.createNewGame(GameDifficulty.MEDIUM, user2);

        // Simulate scoring for the games
        gameManager.getActiveGame(gameId1).increaseScore(100);
        gameManager.getActiveGame(gameId2).increaseScore(150);

        // Get the high scores
        Map<ActiveGame, Integer> highScores = gameManager.getAllScoreBoards();

        // Check if the high scores are correctly displayed
        assertEquals(2, highScores.size(), "Incorrect number of high scores");

        // Assuming the scores are displayed in descending order
        // The first game should have a higher score
        assertEquals(150, highScores.get(0), "Incorrect high score for the first game");

        // The second game should have a lower score
        assertEquals(100, highScores.get(1), "Incorrect high score for the second game");
    }
}

