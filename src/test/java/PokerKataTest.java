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
	
//	@Test
//	public void blackWinsWhenWhiteHasNothing(){
//		
//	}
}
