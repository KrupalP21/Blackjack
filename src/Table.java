public class Table {
	
	private double playerMoney;
	private double betAmount;
	private Hand playerHand = new Hand();
	private Hand dealerHand = new Hand();
	private Deck deck = new Deck();
	
	public Table(double playerMoney, double betAmount, Hand playerHand, Hand dealerHand, Deck deck) {
		this.playerMoney = playerMoney;
		this.betAmount = betAmount;
		this.playerHand = playerHand;
		this.dealerHand = dealerHand;
		this.deck = deck;
	}
	
	public static void initializeGame(Deck deck, Hand playerHand, Hand dealerHand) {	
	    // Create the Deck for new game and shuffle contents
		deck.createDeck();
		deck.shuffleDeck();
		// Deal a hand to the player and dealer
		playerHand.addCard(deck.pickCard());
		playerHand.addCard(deck.pickCard());
		dealerHand.addCard(deck.pickCard());
		dealerHand.addCard(deck.pickCard());
	}
 	
	public static void intro() {
		System.out.println("Welcome to Black Jack!");
		System.out.println();
		System.out.println("Rules:");
		System.out.println("- You start the game with $100 and play till you have no money to play a $10 game.");
		System.out.println("  Once you lose you will be given the option to restart!");
		System.out.println();
		System.out.println("- Follow the directions and use valid inputs that are allowed in Blackjack");
		System.out.println();
	}
	
	public static void continueOrNot() {
		System.out.println("Do you want to start a game/continue playing or exit?");
		System.out.println();
		System.out.println("Enter (0) to PLAY or (1) to EXIT");
	}
	
	public static void surrender(double betAmount, double playerMoney) {
		System.out.println();
		System.out.println("******************************************************************************************");
		System.out.println("You have surrendered, gotten back $" + betAmount/2 +" and have $" + playerMoney + " left");
		System.out.println("******************************************************************************************");
		System.out.println();
	}
	
	public static void bustRound(double betAmount, double playerMoney) {
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println("Bust, you have lost $" + betAmount +" and have $" + playerMoney + " left");
		System.out.println("*******************************************************");
		System.out.println();
	}
	
	public static void dealerBust(double betAmount, double playerMoney) {
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println("Dealer busted, you have won $" + betAmount + " and have $" + playerMoney + " left");
		System.out.println("*******************************************************");
		System.out.println();
	}
	
	public static void loseRound() {
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println("You have lost this round, but will be given $100 if you choose to restart");
		System.out.println("*******************************************************");
		System.out.println();
	}
	
	public static void win1(double betAmount, double playerMoney) {
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println("You have won $" + betAmount + ", you have $" + playerMoney + " left");
		System.out.println("*******************************************************");
		System.out.println();
	}
	
	public static void lose1(double betAmount, double playerMoney) {
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println("You have lost $" + betAmount + ", you have $" + playerMoney + " left");
		System.out.println("*******************************************************");
		System.out.println();
	}
	
	public static void cheatingDetect() {
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println("Cheating Detected, New Round");
		System.out.println("*******************************************************");
		System.out.println();
	}
	
	public static void pushTie(double playerMoney) {
		System.out.println("*******************************************************");
		System.out.println("Push/Tie has occurred");
		System.out.println("You still have $" + playerMoney);
		System.out.println("*******************************************************");
		System.out.println();
	}
	
	public static void menu() {
		System.out.println();
		System.out.println("Choose your next move: ");
		System.out.println("(1) for Hit");
		System.out.println("(2) for Stand");
		System.out.println("(3) for Double Down");
		System.out.println("(4) for Split");
		System.out.println("(5) for Surrender");
	}
	
	public static void miniMenu() {
		System.out.println("Choose your next move: ");
		System.out.println("(1) for Hit");
		System.out.println("(2) for Stand");
	}
	
	public static void printPlayerHand(Hand hand) {
		String str = "";
		for (int i = 0; i < hand.getHandSize(); i++) {
			if (i == hand.getHandSize() - 1) {
				str = str + hand.getCardValue(i) + " of " + hand.getCardSuit(i);	
			} else {
				str = str + hand.getCardValue(i) + " of " + hand.getCardSuit(i) + ", ";
			}
		}
		System.out.println(str);
	}	
	
	public static void printDealerHand(Hand hand) {
		Suit str1 = hand.getCardSuit(0);
		Rank str2 = hand.getCardValue(0);
		System.out.println(str2 + " of " + str1 + " , HIDDEN");
	}	
}

