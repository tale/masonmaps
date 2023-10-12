import static org.junit.Assert.*;

import org.junit.Test;

public class ActiveGameTest {
	
	@Test
	public void testGetter() {
		ActiveGame game = new ActiveGame(1);
		ActiveGame game2 = new ActiveGame(1);
		
		int a = game.getGameID();
		
		assertSame(game, game);
	}

}
