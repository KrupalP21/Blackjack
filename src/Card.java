
public class Card {
	
	private Suit cardSuit;
	private Rank cardValue;
	
	public Card(Suit cardSuit, Rank cardValue) {
		this.cardSuit = cardSuit;
		this.cardValue = cardValue;
	}
	
	public void setCardSuit(Suit cardSuit) {
		this.cardSuit = cardSuit;
	}
	
	public void getCardValue(Rank cardValue) {
		this.cardValue = cardValue;
	}
	
	public Suit getCardSuit() {
		return cardSuit;
	}
	
	public Rank getCardValue() {
		return cardValue;
	}
}