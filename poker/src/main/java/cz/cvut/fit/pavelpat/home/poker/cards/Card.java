package cz.cvut.fit.pavelpat.home.poker.cards;

public class Card {

	private CardColour colour;
	private CardValue value;

	public Card(CardColour colour, CardValue value) {
		super();
		this.colour = colour;
		this.value = value;
	}

	public CardColour getColour() {
		return colour;
	}

	public void setColour(CardColour colour) {
		this.colour = colour;
	}

	public CardValue getValue() {
		return value;
	}

	public void setValue(CardValue value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value.name() + " of " + colour.name();
	}
	
}
