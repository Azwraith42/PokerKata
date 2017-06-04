package test.java;

import org.junit.Test;
import static org.junit.Assert.*;
import main.java.PokerKata;

public class PokerKataTest {

	@Test
	public void emptyHandsIsATie() {
		//given
		final String black = "";
		final String white = "";
		
		//when
		final String output = PokerKata.compareHands(black, white);
		
		//then
		assertEquals("tie", output);
	}
	
	@Test
	public void blackWinsWhenWhiteHasNothing(){
		//given
		final String black = "Black: KD";
		final String white = "";
		
		//when
		final String output = PokerKata.compareHands(black, white);
		
		//then
		assertEquals("Black wins. - with high card: King", output);
	}
}
