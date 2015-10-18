package cz.cvut.fit.pavelpat.home.poker.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck = new ArrayList<>(52);

	public Deck() {
		init();
		shuffle();
	}

	@Override
	public String toString() {
		String result = "";
		for (Card card : deck) {
			result += card + "\n";
		}
		return result;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card takeCard() {
		return deck.remove(0);
	}
	
	private void init() {
		CardColour[] colours = CardColour.values();
		CardValue[] values = CardValue.values();

		for (int col = 0; col < colours.length; col++) {
			for (int val = 0; val < values.length; val++) {
				deck.add(new Card(colours[col], values[val]));
			}
		}
	}

}
