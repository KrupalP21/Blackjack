import java.util.*;

public class Deck {
	
	private ArrayList<Card> Deck;
	private int numCards = 51;

	public void createDeck() { 
		Deck = new ArrayList<Card>();
		int numCards = 0; // 51 due to indices
		for (Suit cardSuit : Suit.values()) {
			for (Rank cardValue : Rank.values()) {
				this.Deck.add(new Card(cardSuit, cardValue));
				numCards = numCards + 1;
			}
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(Deck);
	}
	
	public Card pickCard() {
		Card picked = Deck.get(numCards);
		Deck.remove(numCards);
		numCards = numCards - 1;
		return picked;
	}
}



