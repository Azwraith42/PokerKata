package main.java;

public class PokerKata {

	public static String compareHands(String playerOne, String playerTwo){
		
		
		PokerHand playerOneHand = new PokerHand(playerOne);
		PokerHand playerTwoHand = new PokerHand(playerTwo);
		
		final String winner;
		final String hand;
		final String cards;
		
		if(playerOneHand.getScore() == playerTwoHand.getScore()){
			return "tie";
		}else if(playerOneHand.getScore() > playerTwoHand.getScore()){
			winner = playerOneHand.getOwner();
			hand = "high card: ";
			cards = playerOneHand.getBestHand();
		}else{
			winner = playerTwoHand.getOwner();
			hand = "";
			cards = "";
		}
		
		return (winner + " wins. - with " + hand + cards);
	}
	
}
