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
}
