package com.gmuguessr.backend;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.List;

import javax.tools.JavaFileManager.Location;

public class GameManagerTest {
    private GameManager gameManager;
    private User user;

    @Before
    void setUp() {
        gameManager = new GameManager();
        user = new User("Alice");
    }

    @Test
    public void testCreateNewGame(){
        int gameId = gameManager.createNewGame(GameManager.Difficulty.EASY, user);
        assertNotNull(gameId);
    }

    @Test
    public void testGetMapCoordinates(){
        GeoCoordinates location = gameManager.getMapCoordinates(42, -73);
        assertNotNull(location);
        assertEquals(42,location.getLatitude());
        assertEquals(-73,location.getLongitude());
    }

    @Test
    public void testGetNextImage(){
        int gameId = gameManager.createNewGame(GameManager.Difficulty.Medijum, user);
        Image image = gameManager.getNextImage(gameId);
        assertNotNull(image);
    }

    @Test
    public void testGetActiveGames(){
        List<ActiveGame> activeGames = gameManager.getActiveGames();
        assertNotNull(activeGames);
    }

    @Test
    public void testGameAllScoreBoards(){
        int gameId1 = gameManager.createNewGame(GameManager.Difficulty.HARD, user);
        int gameId2 = gameManager.createNewGame(GameManager.Difficulty.EASY, user);
        
        List<ActiveGame, Integer> scoreBoards = gameManager.getAllScoreBoards();

        assertNotNull(scoreBoards);
        assertTrue(scoreBoards.containsKey(gameId1));
        assertTrue(scoreBoards.containsKey(gameId2));
    }
}