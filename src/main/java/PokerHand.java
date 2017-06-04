package main.java;

import java.util.Scanner;

public class PokerHand {
	
	private final String owner;
	private final int score;
	private String bestHand;
	private final String[] hand = new String[5];

	public PokerHand(String player){
		Scanner playerScanner = new Scanner(player);
		
		if(playerScanner.hasNext()){
			if(playerScanner.next().charAt(0) == 'B'){
				this.owner = "Black";
			}else{
				this.owner = "White";
			}
		}else{
			this.owner = "Black";
		}
		
		int counter = 0;
		while(playerScanner.hasNext()){
			this.hand[counter++] = playerScanner.next();
		}
		
		this.score = scoreHand(hand);
		
		
		playerScanner.close();
	}

	private int scoreHand(String[] playerHand){
		
		if(playerHand[0] != null){
			if(playerHand[0].charAt(0) == 'K'){
				this.bestHand = "King";
			}
			return 1;
		}
		
		return 0;
	}
	
	public int getScore(){
		return this.score;
	}

	public String getOwner() {
		return this.owner;
	}

	public String getBestHand() {
		
		
		
		return this.bestHand;
	}
	
}
