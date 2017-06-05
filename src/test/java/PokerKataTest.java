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
	
	@Test
	public void whiteWinsWithBetterHighCard(){
		//given
		final String black = "Black: JH";
		final String white = "White: AD";
		
		//when
		final String output = PokerKata.compareHands(black, white);
		
		//then
		assertEquals("White wins. - with high card: Ace", output);
	}
	
	@Test
	public void whiteBeatsBlackWithPair(){
		//given
		final String black = "Black: AC";
		final String white = "White: 2H 2D";
		
		//when
		final String output = PokerKata.compareHands(black, white);
		
		//then
		assertEquals("White wins. - with pair: 2", output);
	}
}
