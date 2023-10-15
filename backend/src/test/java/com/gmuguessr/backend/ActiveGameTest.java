package com.gmuguessr.backend;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ActiveGameTest {

	@Test
	public void testGetter() {
		ActiveGame game = new ActiveGame(1);
		ActiveGame game2 = new ActiveGame(1);

		int a = game.getGameID();

		assertSame(game, game);
	}

	@Test
	public void testUserList() {
		ActiveGame game = new ActiveGame(1);
		assertEquals(game.getCurrentUsers().length, 0);

		game.addUser(new User("Bob", UserType.newOnCampusStudent, 1));
		assertEquals(game.getCurrentUsers().length, 1);
		assertEquals(game.getCurrentUsers()[0].getName(), "Bob");
	}

	@Test
	public void testScoreDisplay() {
		ActiveGame game = new ActiveGame(1);
		game.addUser(new User("Bob", UserType.newOnCampusStudent, 1));

		assertEquals(game.displayScore(), "Bob: 0");
	}

	@Test
	public void testLoadImage() {
		ActiveGame game = new ActiveGame(1);

		Image image = game.loadImage();
		assertEquals(image.getGameID(), 1);
	}

	@Test
	public void testCalculateScore() {
		Distance r = new Distance(45.6789, -123.4567, 45.6780, -123.4570);
		Distance p = new Distance(38.6789, -112.4567, 38.6780, -112.4300);
		Distance g = new Distance(38.6789, -112.4567, 38.6780, -112.4400);

		ActiveGame game = new ActiveGame(1);
		
		game.calculateScore(r);
		assertEquals(5, game.getScore());
		
		game.calculateScore(p);
		assertEquals(5, game.getScore());
		
		game.calculateScore(g);
		assertEquals(7, game.getScore());
	}
	
	@Test
	public void testGetImages() {
		Image img1 = new Image("12", "abc", 123, 456);
		Image img2 = new Image("24", "def", 789, 123);
		Image img3 = new Image("36", "ghi", 456, 789);
		
		ActiveGame game = new ActiveGame(1);
		game.addImage(img1);
		game.addImage(img2);
		game.addImage(img3);
		
		assertTrue(game.getImages().get(0).getImageId().equals("12"));
		assertTrue(game.getImages().get(1).getImageId().equals("24"));
		assertTrue(game.getImages().get(2).getImageId().equals("36"));
	}
	
	@Test
	public void testGetState() {
		ActiveGame game = new ActiveGame(1);
		game.setGameState(GameState.RUNNING);
		
		assertEquals(GameState.RUNNING, game.getGameState());
	}
	
	@Test
	public void testSetID() {
		ActiveGame game = new ActiveGame(1);
		game.setGameID(420);
		
		assertEquals(420, game.getGameID());
	}
}
