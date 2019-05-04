import java.util.*;

public class Game {	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in); 	
		
		boolean hit = false; 
		boolean currentGame = true;				
		boolean doubleDown = false; 			
		boolean split = false; 					 					
		boolean cheating = false;
		boolean roundOver = false; 
		
		double betAmount = 10; 					
		double playerMoney = 100; 				
		int splitHands = 3;						 
		
		Table.intro();	
		
		while (currentGame == true) { // Game Loop             
			
			if (cheating == false) { // Invalid Input
				Table.continueOrNot();
				if (s.nextInt() == 1) {
					break;
				}
			}
			
			// Reset all booleans and static amounts for new game
			cheating = false;
			roundOver = false;
			hit = false;
			split = false;
			betAmount = 10;
			splitHands = 3;
			
			// Create the Deck for new game and shuffle contents
			Deck deck = new Deck();
			deck.createDeck();
			deck.shuffleDeck();
			
			// Deal a hand to the player and dealer
			Hand playerHand = new Hand();
			Hand dealerHand = new Hand();
			playerHand.addCard(deck.pickCard());
			playerHand.addCard(deck.pickCard());
			dealerHand.addCard(deck.pickCard());
			dealerHand.addCard(deck.pickCard());
			
			
			System.out.println();
			System.out.println("Your Cards are: ");
			Table.printPlayerHand(playerHand); 
			System.out.println("Your Hand Total is " + playerHand.getHandTotal());
			System.out.println();
			System.out.println("Dealers Cards are: ");
			Table.printDealerHand(dealerHand); 
			
			Table.menu();
			int choice = s.nextInt();		
			
			if (choice == 4) { // Player chooses to SPLIT
				split = true;
				splitHands = 2;
				if (playerHand.getCardValue(0) == playerHand.getCardValue(1)) { // Player has SPLIT, add two cards to player's hand 
					playerHand.addCard(deck.pickCard());
					playerHand.addCard(deck.pickCard());
				} else { // Player does not have a SPLIT hand
					roundOver = true;
					cheating = true;
					Table.cheatingDetect();
				}
			}
			
			Hand tempHand1 = playerHand;
			Hand tempHand2 = playerHand;
			
			while (splitHands > 0 && roundOver == false) {	
				if (splitHands == 2 && split == true) {
					playerHand = tempHand1.getASplitHand(splitHands);
					System.out.println("Your First Split Hand is: "); 
					Table.printPlayerHand(playerHand);  
					System.out.println("Your First Split Hand Total is " + playerHand.getHandTotal());
					Table.menu();
					choice = s.nextInt();								
					splitHands--;	
				} else if (splitHands == 1 && split == true) {			
					playerHand.emptyHand();
					dealerHand.emptyHand();
					dealerHand.addCard(deck.pickCard());
					dealerHand.addCard(deck.pickCard());
					playerHand = tempHand2.getASplitHand(splitHands);
					System.out.println("Your Second Split Hand is: "); 
					Table.printPlayerHand(playerHand); 
					System.out.println("Your Second Split Hand Total is " + playerHand.getHandTotal());
					Table.menu();
					choice = s.nextInt();
					splitHands--;
				}
				if (choice == 5) {
					playerMoney = playerMoney - betAmount/2;
					if (split == true) {
						Table.surrender(betAmount, playerMoney);
					} else {
						roundOver = true;
						Table.surrender(betAmount, playerMoney);
					}
				}
				if (choice == 3) {
					betAmount = 20;
					doubleDown = true;
					choice = 1;
				}
				if (choice == 1) { // Hit
					hit = true;
					while (hit == true) { 
						playerHand.addCard(deck.pickCard());
						System.out.println("Your Cards are: ");
						Table.printPlayerHand(playerHand);
						System.out.println("Your Hand Total is " + playerHand.getHandTotal());
						if (playerHand.getHandTotal() > 21) {
							playerMoney = playerMoney - betAmount;
							hit = false;
							if (split == true) {
								Table.bustRound(betAmount, playerMoney);
								hit = false;
								continue;
							} else {
								roundOver = true;
								Table.bustRound(betAmount, playerMoney);
								hit = false;
								continue;
							}
						}
						if (doubleDown == true && playerHand.getHandTotal() < 22) {
							choice = 2;
							hit = false;	
						}
						if (doubleDown == false && playerHand.getHandTotal() < 22) {
							Table.miniMenu();
							choice = s.nextInt();
							if (choice == 1) {
								hit = true;
							} else {
								choice = 2;
								hit = false;
							}
						}
					}
					if (playerMoney < betAmount) { // Lost round, option to start again
						Table.loseRound();
						playerMoney = 100;
						break;
					}
				}
				
				if (choice == 2) { // Stand
					while (dealerHand.getHandTotal() < 17) {
						dealerHand.addCard(deck.pickCard());
					}
					
					System.out.println("Dealers Cards were: ");
					Table.printPlayerHand(dealerHand); 
					System.out.println("Dealers Hand Total was " + dealerHand.getHandTotal());
					System.out.println();
					
					if (dealerHand.getHandTotal() > 21) { // Dealer busted, player won
						playerMoney = playerMoney + betAmount;
						if (split == true) {
							Table.dealerBust(betAmount, playerMoney);
							continue;
						} else {
							roundOver = true;
							Table.dealerBust(betAmount, playerMoney);
							continue;
						}
					}
					
					int dealerTotal = dealerHand.getHandTotal();
					int playerTotal = playerHand.getHandTotal();
					
					if (dealerTotal > playerTotal) { // Player lost
						playerMoney = playerMoney - betAmount;
						if (split == true) {
							Table.lose1(betAmount, playerMoney);
						} else {
							roundOver = true;
							Table.lose1(betAmount, playerMoney);
						}
						
						if (playerMoney < betAmount) {
							playerMoney = 100;
							break;
						}
					}
					
					if (dealerTotal < playerTotal) { // Player won
						playerMoney = playerMoney + betAmount;
						if (split == true) {
							Table.win1(betAmount, playerMoney);
						} else {
							roundOver = true;
							Table.win1(betAmount, playerMoney);
						}
					}
					if (dealerTotal == playerTotal) { // Tie occurred
						if (split == true) {
							Table.pushTie(playerMoney);
						} else {
							roundOver = true;
							Table.pushTie(playerMoney);
						}
					}
				}			
			}	
		}
		s.close();
	}
}
