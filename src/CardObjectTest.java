import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class CardObjectTest {


	@Test
	void test1() {
		Suit cardSuit = Suit.Heart;
		Rank cardRank = Rank.Two;
		Assert.assertEquals(Suit.valueOf("Heart"), cardSuit);
		Assert.assertEquals(Rank.valueOf("Two"), cardRank);
	}
	
	@Test
	void test2() {
		Suit cardSuit = Suit.Diamond;
		Rank cardRank = Rank.Three;
		Assert.assertEquals(Suit.valueOf("Diamond"), cardSuit);
		Assert.assertEquals(Rank.valueOf("Three"), cardRank);
	}
	
	@Test
	void test3() {
		Suit cardSuit = Suit.Spade;
		Rank cardRank = Rank.Ace;
		Assert.assertEquals(Suit.valueOf("Spade"), cardSuit);
		Assert.assertEquals(Rank.valueOf("Ace"), cardRank);
	}
	
	@Test
	void test4() {
		Suit cardSuit = Suit.Club;
		Rank cardRank = Rank.Queen;
		Assert.assertEquals(Suit.valueOf("Club"), cardSuit);
		Assert.assertEquals(Rank.valueOf("Queen"), cardRank);
	}


}
