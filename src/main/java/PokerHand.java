package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PokerHand {
	
	private final String owner;
	private final int score;
	private String bestCard;
	private String bestHand;
	private final String[] hand = new String[5];
	private int highCardScore = 0;

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
		
		Map<Character, Integer> handValues = new HashMap<>();
		for(String card : playerHand){
			if(card == null){continue;}
			if(handValues.containsKey(card.charAt(0))){
				handValues.put(card.charAt(0), handValues.get(card.charAt(0))+1);
			}else{
				handValues.put(card.charAt(0), 1);
			}
		}
		
		System.out.println(handValues);
		System.out.println(handValues.size());
		
		if(handValues.size() == 0){
			return 0;
		}
		
		int bestCardValue = 0;
		String bestCardName = "";
		int mostOfACard = 0;
		String mostOfACardName = "";
		
		for(Map.Entry<Character, Integer> entry : handValues.entrySet()){
			char key = entry.getKey();
			int value = entry.getValue();
			
			if(cardValue(key) > bestCardValue){
				bestCardValue = cardValue(key);
				bestCardName = cardName(key);
			}
			if(value > mostOfACard){
				mostOfACard = value;
				mostOfACardName = cardName(key);
			}
		}
		
		if(mostOfACard == 2){
			this.bestCard = mostOfACardName;
			this.bestHand = "pair: ";
			return 2;
		}
		
		if(mostOfACard == 1){
			this.bestCard = bestCardName;
			this.highCardScore = bestCardValue;
			this.bestHand = "high card: ";
			return 1;
		}
		
		return 0;
		
//		if(playerHand[0] != null){
//			
//			switch(playerHand[0].charAt(0)){
//			case 'A':
//				this.bestCard = "Ace";
//				this.highCardScore = 14;
//				this.bestHand = "high card: ";
//				break;
//			case 'K':
//				this.bestCard = "King";
//				this.highCardScore = 13;
//				this.bestHand = "high card: ";
//				break;
//			case 'Q':
//				this.bestCard = "Queen";
//				this.highCardScore = 12;
//				this.bestHand = "high card: ";
//				break;
//			case 'J':
//				this.bestCard = "Jack";
//				this.highCardScore = 11;
//				this.bestHand = "high card: ";
//				break;
//			case 'T':
//				this.bestCard = "10";
//				this.highCardScore = 10;
//				this.bestHand = "high card: ";
//				break;
//			case '9':
//				this.bestCard = "9";
//				this.highCardScore = 9;
//				this.bestHand = "high card: ";
//				break;
//			case '8':
//				this.bestCard = "8";
//				this.highCardScore = 8;
//				this.bestHand = "high card: ";
//				break;
//			case '7':
//				this.bestCard = "7";
//				this.highCardScore = 7;
//				this.bestHand = "high card: ";
//				break;
//			case '6':
//				this.bestCard = "6";
//				this.highCardScore = 6;
//				this.bestHand = "high card: ";
//				break;
//			case '5':
//				this.bestCard = "5";
//				this.highCardScore = 5;
//				this.bestHand = "high card: ";
//				break;
//			case '4':
//				this.bestCard = "4";
//				this.highCardScore = 4;
//				this.bestHand = "high card: ";
//				break;
//			case '3':
//				this.bestCard = "3";
//				this.highCardScore = 3;
//				this.bestHand = "high card: ";
//				break;
//			case '2':
//				this.bestCard = "2";
//				this.highCardScore = 2;
//				this.bestHand = "high card: ";
//				break;
//			}
//			return 1;
//		}
	}
	
	private int cardValue(char card){
		switch(card){
		case 'A':
			return 14;
		case 'K':
			return 13;
		case 'Q':
			return 12;
		case 'J':
			return 11;
		case 'T':
			return 10;
		case '9':
			return 9;
		case '8':
			return 8;
		case '7':
			return 7;
		case '6':
			return 6;
		case '5':
			return 5;
		case '4':
			return 4;
		case '3':
			return 3;
		case '2':
			return 2;
		default:
			return 0;
		}
	}
	
	private String cardName(char card){
		switch(card){
		case 'A':
			return "Ace";
		case 'K':
			return "King";
		case 'Q':
			return "Queen";
		case 'J':
			return "Jack";
		case 'T':
			return "10";
		case '9':
			return "9";
		case '8':
			return "8";
		case '7':
			return "7";
		case '6':
			return "6";
		case '5':
			return "5";
		case '4':
			return "4";
		case '3':
			return "3";
		case '2':
			return "2";
		default:
			return "error";
		}
	}
	
	public int highCardScore(){
		return this.highCardScore;
	}
	
	public int getScore(){
		return this.score;
	}

	public String getOwner() {
		return this.owner;
	}

	public String getBestCard() {
		return this.bestCard;
	}
	
	public String getBestHand(){
		return this.bestHand;
	}
	
}
