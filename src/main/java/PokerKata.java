package main.java;

public class PokerKata {
	
	static String winner;
	static String hand;
	static String cards;

	public static String compareHands(String playerOne, String playerTwo){
		
		PokerHand playerOneHand = new PokerHand(playerOne);
		PokerHand playerTwoHand = new PokerHand(playerTwo);
		
		if(playerOneHand.getScore() == playerTwoHand.getScore()){
			sameTypeOfHand(playerOneHand, playerTwoHand);
		}else if(playerOneHand.getScore() > playerTwoHand.getScore()){
			playerOneWins(playerOneHand);
		}else{
			playerTwoWins(playerTwoHand);
		}
		
		if(winner == "tie"){
			return "tie";
		}else{
			return (winner + " wins. - with " + hand + cards);
		}
	}
	
	private static void sameTypeOfHand(PokerHand playerOneHand, PokerHand playerTwoHand) {
		if(playerOneHand.highCardScore() == playerTwoHand.highCardScore()){
			winner = "tie";
		}else if(playerOneHand.highCardScore() > playerTwoHand.highCardScore()){
			playerOneWins(playerOneHand);
		}else{
			playerTwoWins(playerTwoHand);
		}
	}

	private static void playerOneWins(PokerHand playerOneHand){
		winner = playerOneHand.getOwner();
		hand = playerOneHand.getBestHand();
		cards = playerOneHand.getBestCard();
	}
	
	private static void playerTwoWins(PokerHand playerTwoHand){
		winner = playerTwoHand.getOwner();
		hand = playerTwoHand.getBestHand();
		cards = playerTwoHand.getBestCard();
	}
}
