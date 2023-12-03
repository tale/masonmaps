package com.gmuguessr.backend;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

public class GameManagerTest {
    private GameManager gameManager;
    private User user;

    @Before
    public void setUp() {
        gameManager = new GameManager();
        user = new User("Alice");
    }

    @Test
    public void testCreateNewGame(){
        int gameId = gameManager.createNewGame(GameDifficulty.EASY, user);
        assertNotNull(gameId);
    }

    @Test
    public void testGetMapCoordinates(){
        GeoCoordinates location = gameManager.getMapCoordinates(42, -73);
        assertNotNull(location);
        assertEquals(42,location.getLatitude(), 0);
        assertEquals(-73,location.getLongitude(), 0);
    }

    @Test
    public void testGetNextImage(){
        int gameId = gameManager.createNewGame(GameDifficulty.MEDIUM, user);
        
        assertNull(gameManager.getNextImage(gameId));
        
        Image toAdd = new Image("123", "x.com", 420.69, 1337.42);
        gameManager.getActiveGame(gameId).addImage(toAdd);
        
        Image image = gameManager.getNextImage(gameId);
        assertNotNull(image);
    }

    @Test
    public void testGetActiveGames(){
    	gameManager.createNewGame(GameDifficulty.HARD, user);
        List<ActiveGame> activeGames = gameManager.getActiveGames();
        assertNotNull(activeGames);
        assertTrue(activeGames.get(0).getUser(0).equals(user));
    }
    
    @Test
    public void testGetActiveGame() {
    	assertNull(gameManager.getActiveGame(1));
    	int id = gameManager.createNewGame(GameDifficulty.HARD, user);
    	
    	assertNull(gameManager.getActiveGame(id + 1));
    	assertNotNull(gameManager.getActiveGame(id));
    	assertTrue(gameManager.getActiveGame(id).getUser(0).equals(user));
    }

    @Test
    public void testGameAllScoreBoards(){
        int gameId1 = gameManager.createNewGame(GameDifficulty.HARD, user);
        int gameId2 = gameManager.createNewGame(GameDifficulty.EASY, user);
        
        Image image = new Image("12345", "jc-gmu.jpg", 45.6789, -123.4567);
        
        gameManager.getActiveGame(gameId1).addImage(image);
        gameManager.getActiveGame(gameId2).addImage(image);
        
        Distance r = new Distance(45.6789, -123.4567, 45.6780, -123.4570);
        Distance g = new Distance(38.6789, -112.4567, 38.6780, -112.4400);
        
        gameManager.getActiveGame(gameId1).calculateScore(r);
        gameManager.getActiveGame(gameId2).calculateScore(g);
        
        Map<ActiveGame, Integer> scoreBoards = gameManager.getAllScoreBoards();

        assertNotNull(scoreBoards);
        
        assertTrue(scoreBoards.containsKey(gameManager.getActiveGame(gameId1)));
        assertTrue(scoreBoards.containsKey(gameManager.getActiveGame(gameId2)));
        
        assertTrue(scoreBoards.containsValue(gameManager.getActiveGame(gameId1).getScore()));
        assertTrue(scoreBoards.containsValue(gameManager.getActiveGame(gameId2).getScore()));
    }
}