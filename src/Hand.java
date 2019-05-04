import java.util.*;

public class Hand {
	
	private ArrayList<Card> hand = new ArrayList<Card>();
 
	public void addCard(Card card) {
		hand.add(card);
		
	}
	
	public void emptyHand() {
		for (int i = hand.size() - 1; i > 0; i--) {
			hand.remove(i);
		}
	}
	
	public int getHandSize() {
		return hand.size();
	}
	
	public Hand getASplitHand(int index) {
		Hand splitHand = new Hand();
		if (index == 2) {
			for (int i = 0; i < hand.size(); i = i + 2) {
				splitHand.addCard(hand.get(i));
			}
		}
		if (index == 1) {
			for (int i = 1; i < hand.size(); i = i + 2) {
				splitHand.addCard(hand.get(i));
			}
		}
		return splitHand;
	}
	
	public Rank getCardValue(int index) {
		return hand.get(index).getCardValue();
	}
	
	public Suit getCardSuit(int index) {
		return hand.get(index).getCardSuit();
	}
	
	public int getHandTotal() {
		int numAces = 0;
		int total = 0;
		for (Card currCard : this.hand) {
			switch(currCard.getCardValue()) {
			case Two: total = total + 2; break;
			case Three: total = total + 3; break;
			case Four: total = total + 4; break;
			case Five: total = total + 5; break;
			case Six: total = total + 6; break;
			case Seven: total = total + 7; break;
			case Eight: total = total + 8; break;
			case Nine: total = total + 9; break;
			case Ten: total = total + 10; break;
			case Jack: total = total + 10; break;
			case Queen: total = total + 10; break;
			case King: total = total + 10; break;
			case Ace : numAces = numAces + 1; break;
			}
		}
		for (int i = 0; i < numAces; i++) {
			if (total > 10) {
				total = total + 1;
			} else {
				total = total + 11;
			}
		}
		return total;
	}
}
